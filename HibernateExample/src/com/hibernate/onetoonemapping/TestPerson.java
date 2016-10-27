package com.hibernate.onetoonemapping;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.classic.Session;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class TestPerson {

	public static void main(String[] args) {
		AnnotationConfiguration config = new AnnotationConfiguration();
		config.addAnnotatedClass(Person.class);
		config.addAnnotatedClass(PersonDetail.class);
		config.configure();
		
		new SchemaExport(config).create(true, true);
		
		SessionFactory factory = config.buildSessionFactory();
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		PersonDetail koketsoDetail = new PersonDetail();
		koketsoDetail.setIncome(6863.75);
		koketsoDetail.setJob("Programmer");
		koketsoDetail.setZipCode("2001");
		
		Person koketso = new Person();
		koketso.setPersonDetail(koketsoDetail);
		koketso.setPersonName("Koketso Seopela");
		//session.save(koketsoDetail);
		session.save(koketso);
		session.getTransaction().commit();
	}

}
