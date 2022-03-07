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

		Tutor tutor = new Tutor("ABD", "Bengt Haglund", 40000);
		Student student = new Student(" Christopher Bail", "1-BAI-2018");

		tutor.addStudentToTeachingGroup(student);
		session.save(student);
		session.save(tutor);

		Set<Student> students = tutor.getTeachingGroup();
		for (Student index : students) {
			System.out.println(index);
		}

		tx.commit();
		session.close();
		/*
		 * session = sf.openSession(); tx = session.beginTransaction();
		 * 
		 * Tutor tutor1 = (Tutor) session.get(Tutor.class, 1); Set<Student> students =
		 * tutor1.getTeachingGroup(); for (Student s : students) {
		 * System.out.println(s); } tx.commit(); session.close();
		 */
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
