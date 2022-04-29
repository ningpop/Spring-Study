package jpql;

import javax.persistence.*;
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

            Team team = new Team();
            team.setName("teamA");
            em.persist(team);

            Member member = new Member();
            member.setUsername("teamA");
            member.setAge(10);
            member.setType(MemberType.ADMIN);

            member.setTeam(team);

            em.persist(member);

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

            String query = "select m.username, 'HELLO', true from Member m " +
                    "where m.type = :userType";
            List<Object[]> result = em.createQuery(query)
                    .setParameter("userType", MemberType.ADMIN)
                    .getResultList();

            for (Object[] objects : result) {
                System.out.println("objects[0] = " + objects[0]);
                System.out.println("objects[0] = " + objects[1]);
                System.out.println("objects[0] = " + objects[2]);
            }


            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}
