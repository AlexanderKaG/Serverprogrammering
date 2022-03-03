package se.yrgo.test;

import java.util.Map;
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

//		Tutor newTutor = new Tutor("ABC234", "Natalie Woodward", 387787);
//		Student student1 = new Student("Patrik Howard", "1-HOW-2017");
//		Student student2 = new Student("Marie Sani", "2-SAN-2018");
//		Student student3 = new Student("Tom Nikson", "3-NIK-2019");
//
//		newTutor.addStudentToTeachingGroup(student1);
//		newTutor.addStudentToTeachingGroup(student2);
//		newTutor.addStudentToTeachingGroup(student3);
//
//		session.save(student1);
//		session.save(student2);
//		session.save(student3);
//		session.save(newTutor);

		Tutor myTutor = (Tutor) session.get(Tutor.class, 1);
		Map<String, Student> students = myTutor.getTeachingGroup();

		for (Student student : students.values()) {
			System.out.println(student);
		}

		Student s = students.get("3-NIK-2019");
		System.out.println("found the student  " + s);
//		Set<Student> students = newTutor.getTeachingGroup();
//		for (Student student : students) {
//			System.out.println(student);
//		}
//		Tutor myTutor = (Tutor) session.get(Tutor.class, 1);
//		Set<Student> students = myTutor.getTeachingGroup();
//		for (Student s : students) {
//			System.out.println(s);
//		}
//
//		Student student4 = new Student("Julia Ericcson");
//		session.save(student4);
//		myTutor.addStudentToTeachingGroup(student4);

		tx.commit();
		session.close();

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
