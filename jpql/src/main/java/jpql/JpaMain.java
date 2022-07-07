package jpql;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {

//            for (int i = 0; i < 100; i++) {
//                Member member = new Member();
//                member.setUsername("member" + i);
//                member.setAge(i);
//
//                em.persist(member);
//            }

//            Team team = new Team();
//            team.setName("teamA");
//            em.persist(team);

//            Member member = new Member();
//            member.setUsername("teamA");
//            member.setUsername(null);
//            member.setUsername("관리자");
//            member.setAge(10);
//            member.setType(MemberType.ADMIN);
//
//            member.setTeam(team);
//
//            em.persist(member);

//            TypedQuery<Member> query1 = em.createQuery("select m from Member m", Member.class); // 반환 타입이 명확
//            List<Member> resultList = query1.getResultList();
//            for (Member member1 : resultList) {
//                System.out.println("member1 = " + member1);
//            }
//            TypedQuery<String> query2 = em.createQuery("select m.username from Member m", String.class); // 반환 타입이 명확
//            Query query3 = em.createQuery("select m.username, m.age from Member m"); // 반환 타입이 명확하지 않음
//
//            Member result = em.createQuery("select m from Member m where m.username = :username", Member.class)
//                    .setParameter("username", "member1")
//                    .getSingleResult();
//            System.out.println("singleResult = " + result.getUsername());

            Team team = new Team();
            em.persist(team);

            Member member1 = new Member();
            member1.setUsername("관리자1");
            member1.setTeam(team);
            em.persist(member1);

            Member member2 = new Member();
            member2.setUsername("관리자2");
            member2.setTeam(team);
            em.persist(member2);

            em.flush();
            em.clear();

//            List resultList = em.createQuery("select m.username, m.age from Member m")
//                    .getResultList();
//            Object o = resultList.get(0);
//            Object[] result = (Object[]) o;
//            System.out.println("username = " + result[0]);
//            System.out.println("age = " + result[1]);

//            // DTO의 생성자를 활용하는 방법
//            List<MemberDTO> result = em.createQuery("select new jpql.MemberDTO(m.username, m.age) from Member m", MemberDTO.class)
//                    .getResultList();
//
//            MemberDTO memberDTO = result.get(0);
//            System.out.println("memberDTO = " + memberDTO.getUsername());
//            System.out.println("memberDTO = " + memberDTO.getAge());

            // 페이징 API
//            List<Member> result = em.createQuery("select m from Member m order by m.age desc", Member.class)
//                    .setFirstResult(1)
//                    .setMaxResults(10)
//                    .getResultList();
//
//            System.out.println("result.size = " + result.size());
//            for (Member member1 : result) {
//                System.out.println("member1 = " + member1);
//            }

//            String query = "select m from Member m join m.team t"; // inner join
//            String query = "select m from Member m left join m.team t"; // left outer join
//            String query = "select m from Member m, Team t where m.username = t.name"; // seta join
//            String query = "select m from Member m left join m.team t on t.name = 'teamA'"; // on 절 - 조인 대상 필터링
//            String query = "select m from Member m left join Team t on m.username = t.name"; // on 절 - 연관관계 없는 엔티티 외부 조인
//            List<Member> result = em.createQuery(query, Member.class)
//                    .getResultList();

//            String query = "select m.username, 'HELLO', true from Member m " +
//                    "where m.type = :userType";
//            List<Object[]> result = em.createQuery(query)
//                    .setParameter("userType", MemberType.ADMIN)
//                    .getResultList();
//
//            for (Object[] objects : result) {
//                System.out.println("objects[0] = " + objects[0]);
//                System.out.println("objects[0] = " + objects[1]);
//                System.out.println("objects[0] = " + objects[2]);
//            }

//            String query = "select " +
//                                "case when m.age <= 10 then '학생요금'" +
//                                    "when m.age >= 60 then '경로요금'" +
//                                    "else '일반요금' " +
//                                "end " +
//                    "from Member m";
//            String query = "select coalesce(m.username, '이름 없는 회원') from Member m";
//            String query = "select nullif(m.username, '관리자') as username " +
//                    "from Member m";
//            String query = "select concat('a', 'b') from Member m";
//            String query = "select locate('de', 'abcdef') from Member m";
//            String query = "select size(t.members) from Team t";
            String query = "select t.members from Team t";
            Collection result = em.createQuery(query, Collection.class)
                    .getResultList();

            System.out.println("result = " + result);


            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}
