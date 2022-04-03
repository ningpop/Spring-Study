package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            // 회원 등록
//            Member member = new Member();
//            member.setId(2L);
//            member.setName("HelloB");
//            em.persist(member);

            // 회원 조회
//            Member findMember = em.find(Member.class, 1L);
//            System.out.println("findMember = " + findMember.getId());
//            System.out.println("findMember = " + findMember.getName());

            // 회원 삭제
//            Member findMember = em.find(Member.class, 1L);
//            em.remove(findMember);

            // 회원 수정
//            Member findMember = em.find(Member.class, 1L);
//            findMember.setName("HelloJPA");
            // 저장 코드를 작성하지 않아도 됨.(update 쿼리를 만들어줌)

            // 전체 회원 조회 (페이징)
//            List<Member> result = em.createQuery("select m from Member as m", Member.class)
//                    .setFirstResult(1)
//                    .setMaxResults(10)
//                    .getResultList();
//            for (Member member : result) {
//                System.out.println("member.name = " + member.getName());
//            }

            // 비영속
//            Member member = new Member();
//            member.setId(101L);
//            member.setName("HelloJPA");

            // 영속
//            System.out.println("=== BEFORE ===");
//            em.persist(member);
//            System.out.println("=== AFTER ===");

//            Member findMember = em.find(Member.class, 101L); // 1차 캐시에서 조회하기 때문에 select문 쿼리를 날리지 않음
//            System.out.println("findMember.id = " + findMember.getId());
//            System.out.println("findMember.name = " + findMember.getName());

//            Member findMember1 = em.find(Member.class, 101L);
//            Member findMember2 = em.find(Member.class, 101L);
//            System.out.println("result = " + (findMember1 == findMember2));

//            Member member1 = new Member(150L, "A");
//            Member member2 = new Member(160L, "B");
//            em.persist(member1);
//            em.persist(member2);
//            System.out.println("===============");

//            Member member = em.find(Member.class, 150L);
//            member.setName("ZZZZZ");
//            //em.persist(member); // 사용 X
//            System.out.println("===============");

//            Member member = new Member(200L, "member200");
//            em.persist(member);
//            em.flush();

//            Member member = em.find(Member.class, 150L);
//            member.setName("AAAAA");
//            //em.detach(member);
//            em.clear();
//            Member member2 = em.find(Member.class, 150L);
//            System.out.println("===============");

//            Member member = new Member();
//            member.setId(1L);
//            member.setUsername("A");
//            member.setRoleType(RoleType.USER);
//            em.persist(member);

//            Member member = new Member();
//            member.setId(2L);
//            member.setUsername("B");
//            member.setRoleType(RoleType.ADMIN);
//            em.persist(member);

//            Member member = new Member();
//            member.setId(3L);
//            member.setUsername("C");
//            member.setRoleType(RoleType.GUEST);
//            em.persist(member);

//            Member member = new Member();
//            member.setId("ID_A");
//            member.setUsername("C");
//            em.persist(member);

//            Member member = new Member();
//            member.setUsername("C");
//            System.out.println("==================");
//            em.persist(member);
//            System.out.println("member.id = " + member.getId());
//            System.out.println("==================");

            Member member1 = new Member();
            member1.setUsername("A");
            Member member2 = new Member();
            member2.setUsername("B");
            Member member3 = new Member();
            member3.setUsername("C");
            System.out.println("==================");
            em.persist(member1); // 1, 51
            em.persist(member2); // MEM
            em.persist(member3); // MEM
            System.out.println("member1 = " + member1.getId());
            System.out.println("member2 = " + member2.getId());
            System.out.println("member3 = " + member3.getId());
            System.out.println("==================");



            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}
