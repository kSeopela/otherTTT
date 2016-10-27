package com.hibernate.chapter2;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.classic.Session;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class TestCustomer {

	public static void main(String[] args) {
		AnnotationConfiguration config = new AnnotationConfiguration();
		config.addAnnotatedClass(Customer.class);
		config.configure();

		new SchemaExport(config).create(true, true);
		Customer klaas = new Customer();
		SessionFactory factory = config.buildSessionFactory();
		Session session= factory.getCurrentSession();
		session.beginTransaction();
		{
			klaas.setCustomerName("Klaas Seopela");
			klaas.setCustomerAddress("Room0412 YorkHous Kerk street Johannesburg 2001");
			klaas.setCreditScore(780);
			klaas.setRewardPoints(12000);
			session.save(klaas);
		}
			session.getTransaction().commit();
		
	}
}
