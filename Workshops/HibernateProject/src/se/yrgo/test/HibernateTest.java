package se.yrgo.test;

import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import se.yrgo.domain.Student;
import se.yrgo.domain.Tutor;

public class HibernateTest {

	private static SessionFactory sessionFactory = null;

	public static void main(String[] args) {

		SessionFactory sf = getSessionFactory();

		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();

//		Tutor tutor = new Tutor("ABD", "Bengt Haglund", 40000);
//		Student student = new Student(" Christopher Bail", "1-BAI-2018");
//
//		tutor.addStudentToTeachingGroup(student);
//
//		session.save(tutor);
//		session.save(student);

		Tutor t1 = new Tutor("ABC123", "Teacher 1", 290000);

		Student s1 = new Student("Student1", "1-STU-2019");
		t1.addStudentToTeachingGroup(s1);

		Student s2 = new Student("Student2", "2-STU-2018");
		t1.addStudentToTeachingGroup(s2);

		Student s3 = new Student("Student3", "3-STU-2017");
		t1.addStudentToTeachingGroup(s3);

		session.save(t1);
		session.save(s1);
		session.save(s2);
		session.save(s3);

		Set<Student> allStudents = t1.getTeachingGroup();
		System.out.println("This size is: " + allStudents.size());

		Set<Student> students = t1.getTeachingGroup();
		for (Student s : students) {
			System.out.println(s);
		}

		tx.commit();
		session.close();

//		session = sf.openSession();
//		tx = session.beginTransaction();
//
//		Tutor tutor1 = (Tutor) session.get(Tutor.class, 1);
//		Set<Student> students = tutor1.getTeachingGroup();
////		for (Student s : students) {
////			System.out.println(s);
////		}
//		boolean isChrisInTeachingGroup = students.contains(student);
//		System.out.println(isChrisInTeachingGroup);
//		tx.commit();
//		session.close();
	}

	private static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			Configuration configuration = new Configuration();
			configuration.configure();
			ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties())
					.buildServiceRegistry();
			sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		}
		return sessionFactory;
	}
}
