package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try{
            // 데이터베이스 초기화
            Member member = new Member();
            member.setUsername("hello");

            em.persist(member);
            em.flush();
            em.clear();

            // em.find() : 쿼리문 전달(조인 쿼리문으로 객체를 가져옴) > id와 username 데이터 출력
//            Member findMember = em.find(Member.class, member.getId());
//            System.out.println("findMember.id = " + findMember.getId());
//            System.out.println("findMember.username = " + findMember.getUsername());

            // em.getReference() : username을 가져오고자 할 때 쿼리문을 날림
            Member referenceMember = em.getReference(Member.class, member.getId());
            System.out.println("referenceMember = " + referenceMember.getClass());
            System.out.println("referenceMember.id = " + referenceMember.getId());
            System.out.println("referenceMember.username = " + referenceMember.getUsername());

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();

    }
}
