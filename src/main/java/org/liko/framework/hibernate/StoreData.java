package org.liko.framework.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class StoreData {
	public static void main(String[] args) {
		//creating configuration object
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		
		//creating session object
		SessionFactory factory = cfg.buildSessionFactory();
		
		//creating session object
		Session session = factory.openSession();
		
		//creating transaction object
		Transaction transaction = session.beginTransaction();
		
		Employee e1 = new Employee();
		e1.setId(100);
		e1.setFirstName("Liko");
		e1.setLastName("Li");
		
		session.persist(e1);//persisting the object
		
		transaction.commit();
		
		session.close();
		System.out.println("Successfully saved!");
	}
}
