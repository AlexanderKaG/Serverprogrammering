
package se.yrgo.test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
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

		t1.createStudentAndAddtoTeachingGroup("Jimi Hendriks", "1-HEN-2019", "Street 1", "city 1", "1212");
		t1.createStudentAndAddtoTeachingGroup("Bruce Lee", "2-LEE-2019", "Street 2", "city 2", "2323");
		t3.createStudentAndAddtoTeachingGroup("Roger Waters", "3-WAT-2018", "Street 3", "city 3", "34343");

		em.persist(t1);
		em.persist(t2);
		em.persist(t3);

		TypedQuery<Student> q = em.createQuery("from Student as student where student.name = 'Jimi Hendriks'",
				Student.class);
		List<Student> students = q.getResultList();
		for (Student student : students) {
			System.out.println(student);
		}

		q = em.createQuery("FROM Student as student WHERE student.enrollmentID ='1-HEN-2019' ", Student.class);
		Student theStudent = (Student) q.getSingleResult();
		System.out.println(theStudent);

		q = em.createQuery("FROM Student as student WHERE lower(student.name) ='jimi hendriks'", Student.class);
		Student st = (Student) q.getSingleResult();
		System.out.println(st);

		String requiredName = "Bruce Lee";
		q = em.createQuery("FROM Student as student WHERE student.name=:name", Student.class);
		q.setParameter("name", requiredName);
		List<Student> QueryResult = q.getResultList();
		for (Student st1 : QueryResult) {
			System.out.println(st1);
		}

		tx.commit();
		em.close();
	}

}