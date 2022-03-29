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
            List<Member> result = em.createQuery("select m from Member as m", Member.class)
                    .setFirstResult(1)
                    .setMaxResults(10)
                    .getResultList();
            for (Member member : result) {
                System.out.println("member.name = " + member.getName());
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
