package se.yrgo.test;

import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import se.yrgo.domain.Student;
import se.yrgo.domain.Tutor;

public class HibernateTest {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("databaseConfig");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();

		tx.begin();

		Tutor t1 = new Tutor("ABC123", "Teacher 1", 290000);

		t1.createStudentAndAddtoTeachingGroup("Eva  Sands", "1-SAN-2019", "street-1", "London", "4455");
		t1.createStudentAndAddtoTeachingGroup("Sam Everest", "2-EVE-2018", "street-2", "Paris", "6767");

		em.persist(t1);

		tx.commit();
		em.close();
	}
}
