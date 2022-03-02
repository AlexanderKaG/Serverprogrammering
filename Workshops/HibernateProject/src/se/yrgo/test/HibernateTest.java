package se.yrgo.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import se.yrgo.domain.Student;

public class HibernateTest {

	private static SessionFactory sessionFactory = null;
	
	public static void main(String[] args) {
		
		SessionFactory sf = getSessionFactory();
		Session session = sf.openSession();
		
		Student newStudent= new Student("Nick Fame", "Diamond Cameron");
		session.save(newStudent); 
		
		Transaction tx = session.beginTransaction();
		
		tx.commit();
		session.close();
		
	}

	private static SessionFactory getSessionFactory() {
		   if(sessionFactory ==null) {
			Configuration configuration = new Configuration();
			configuration.configure();
			ServiceRegistry serviceRegistry = new ServiceRegistryBuilder()
				.applySettings(configuration.getProperties())
				.buildServiceRegistry();
			sessionFactory = 
		             configuration.buildSessionFactory(serviceRegistry);
		   }
		   return sessionFactory;
		}
}
