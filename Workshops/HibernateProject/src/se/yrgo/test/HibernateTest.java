
package se.yrgo.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import se.yrgo.domain.Student;
import se.yrgo.domain.Tutor;

public class HibernateTest {
	public static EntityManagerFactory emf = Persistence.createEntityManagerFactory("databaseConfig");

	public static void main(String[] args) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		Student newStudent = new Student("Eva Svensson","1-SVE-2019", "4th Street","Berlin","1010");
		Tutor newTutor = new Tutor("3333", "Sara Reeves", 30000);
				
		em.persist(newStudent);
		em.persist(newTutor);
		
		tx.commit();
		em.close();
	}
}