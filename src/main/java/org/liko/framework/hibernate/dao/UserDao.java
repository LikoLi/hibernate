package org.liko.framework.hibernate.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.liko.framework.hibernate.po.User;

public class UserDao {
	public static int save(User u) {
		int i = 0;
		
		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure("hibernate.hbm.xml").build();
		SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
		
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();
		i = (Integer) session.save(u);
		t.commit();
		session.close();
		System.out.println(u.getName());
		return i;
	}
}
