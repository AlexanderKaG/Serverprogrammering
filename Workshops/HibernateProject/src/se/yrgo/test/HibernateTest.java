package se.yrgo.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import se.yrgo.domain.Student;
import se.yrgo.domain.Subject;
import se.yrgo.domain.Tutor;

public class HibernateTest {

	private static SessionFactory sessionFactory = null;

	public static void main(String[] args) {

		SessionFactory sf = getSessionFactory();
		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();

		Tutor newTutor = new Tutor("ABC234", "Natalie Woodward", 387787);
		Student student1 = new Student("Patrik Howard");
		Student student2 = new Student("Marie Sani");
		Student student3 = new Student("Tom Nikson");

		newTutor.addStudentToTeachingGroup(student1);
		newTutor.addStudentToTeachingGroup(student2);
		newTutor.addStudentToTeachingGroup(student3);

		session.save(student1);
		session.save(student2);
		session.save(student3);
		session.save(newTutor);

		Subject subject1 = new Subject("Math", 3);
		Subject subject2 = new Subject("Science", 6);

		session.save(subject1);
		session.save(subject2);

		newTutor.addSubjectsToTeach(subject1);
		newTutor.addSubjectsToTeach(subject2);

		Tutor secondTutor = new Tutor("FJK", "Ben Aflek", 3585895);
		session.save(secondTutor);

		secondTutor.addSubjectsToTeach(subject2);
		subject2.addTutorToSubject(secondTutor);

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
