package com.hibernate.chapter4;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.classic.Session;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class TestAccounts {

	public static void main(String[] args) {
		AnnotationConfiguration config = new AnnotationConfiguration();
		config.addAnnotatedClass(Accounts.class);
		config.configure();

		new SchemaExport(config).create(true, true);

		SessionFactory factory = config.buildSessionFactory();
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		{
			CompoundKey key1 = new CompoundKey(100, 10001);
			Accounts savings = new Accounts();
			savings.setAcountBalance(10000);
			savings.setCompoundKey(key1);
			session.save(savings);
		}{
			CompoundKey key2 = new CompoundKey(100, 10002);
			Accounts checking = new Accounts();
			checking.setAcountBalance(2500);
			checking.setCompoundKey(key2);
			session.save(checking);
		}



		session.getTransaction().commit();
	}

}
