package org.liko.framework.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class AnnotationTest {
	public static void main(String[] args) {
		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure("hibernate_annotation.cfg.xml").build();
		//2. 根据服务注册类创建一个元数据资源集, 同时构建元数据并生产应用一般唯一的session工厂
		SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
		
		//操作数据库
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();
		
		Order order = new Order();
		order.setId(3);
		order.setOrderName("Vicky");
		
		session.persist(order);
		
		t.commit();
		session.close();
		System.out.println("Successfully saved!");
	}
}
