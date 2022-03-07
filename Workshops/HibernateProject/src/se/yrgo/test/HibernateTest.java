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

//		Tutor t1 = new Tutor("ABC123", "Teacher 1", 290000);
//		Student s1 = new Student("Student1", "1-STU-2019");
//		Student s2 = new Student("Student2", "2-STU-2018");
//		Student s3 = new Student("Student3", "3-STU-2017");
//
//		t1.addStudentToTeachingGroup(s1);
//		t1.addStudentToTeachingGroup(s2);
//		t1.addStudentToTeachingGroup(s3);
//		t1.createStudentAndAddtoTeachingGroup("Student1", "1-STU-2019");
//		t1.createStudentAndAddtoTeachingGroup("Student2", "2-STU-2018");
//		t1.createStudentAndAddtoTeachingGroup("Student3", "3-STU-2017");
//
//		em.persist(t1);
//		em.persist(s1);
//		em.persist(s2);
//		em.persist(s3);

		Tutor t1 = em.find(Tutor.class, 1);
		em.remove(t1);

		tx.commit();
		em.close();
	}
}
