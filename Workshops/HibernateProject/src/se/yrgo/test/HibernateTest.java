
package se.yrgo.test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import se.yrgo.domain.Student;
import se.yrgo.domain.Subject;
import se.yrgo.domain.Tutor;

public class HibernateTest {
	public static EntityManagerFactory emf = Persistence.createEntityManagerFactory("databaseConfig");

	public static void main(String[] args) {
		setUpData();
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		tx.commit();
		em.close();
	}

	public static void setUpData() {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		Subject mathematics = new Subject("Mathematics", 2);
		Subject science = new Subject("Science", 2);
		Subject programming = new Subject("Programming", 3);
		em.persist(mathematics);
		em.persist(science);
		em.persist(programming);

		Tutor t1 = new Tutor("ABC123", "Johan Smith", 40000);
		t1.addSubjectsToTeach(mathematics);
		t1.addSubjectsToTeach(science);

		Tutor t2 = new Tutor("DEF456", "Sara Svensson", 20000);
		t2.addSubjectsToTeach(mathematics);
		t2.addSubjectsToTeach(science);

		// This tutor is the only tutor who can teach History
		Tutor t3 = new Tutor("GHI678", "Karin Lindberg", 0);
		t3.addSubjectsToTeach(programming);

		t1.createStudentAndAddtoTeachingGroup("Jimi Hendriks", "1-HEN-2019", "Street 1", "city 2", "1212");
		t1.createStudentAndAddtoTeachingGroup("Bruce Lee", "2-LEE-2019", "Street 2", "city 2", "2323");
		t3.createStudentAndAddtoTeachingGroup("Roger Waters", "3-WAT-2018", "Street 3", "city 3", "34343");

		em.persist(t1);
		em.persist(t2);
		em.persist(t3);

//		Query query = em
//				.createQuery("from Tutor tutor join tutor.teachingGroup student where student.address.city = 'city 2'");
//		List<Object[]> results = query.getResultList();
//		for (Object[] item : results) {
//			System.out.println(item[0] + " --------- " + item[1]);
//		}
//
//		Query query1 = em.createQuery(
//				"select distinct tutor from Tutor as tutor join tutor.teachingGroup as student where student.address.city = 'city 2'");
//		List<Tutor> results1 = query1.getResultList();
//		for (Tutor t : results1) {
//			System.out.println(t);
//		}

		String city = "city 2";
		List<Tutor> results2 = em.createQuery(
				"select distinct tutor from Tutor tutor join tutor.teachingGroup student where student.address.city = :city")
				.setParameter("city", city)
				.getResultList();
		for (Tutor tutor : results2) {
			System.out.println(tutor);
		}

		tx.commit();
		em.close();
	}

}