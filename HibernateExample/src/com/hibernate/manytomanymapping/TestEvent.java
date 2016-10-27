package com.hibernate.manytomanymapping;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.classic.Session;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class TestEvent {

	public static void main(String[] args) {
		AnnotationConfiguration config = new AnnotationConfiguration();
		config.addAnnotatedClass(Delegate.class);
		config.addAnnotatedClass(Event.class);
		config.configure();
		
		new SchemaExport(config).create(true, true);
		
		SessionFactory factory = config.buildSessionFactory();
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		Delegate d1 = new Delegate();
		d1.setDelegateName("Koketso Seopela");
		Delegate d2 = new Delegate();
		d2.setDelegateName("Mthokozisi Mtsweni");
		Delegate d3 = new Delegate();
		d3.setDelegateName("Kgeru Phetla");
		Delegate d4 = new Delegate();
		d4.setDelegateName("Nelson Mandela");
		
		Event java101 = new Event();
		java101.setEventName("Java-101");
		Event cplus101 = new Event();
		cplus101.setEventName("Cplus-101");
		Event math101 = new Event();
		math101.setEventName("Math-101");
		
		java101.getDelegates().add(d1);
		java101.getDelegates().add(d2);
		java101.getDelegates().add(d3);
		
		cplus101.getDelegates().add(d2);
		cplus101.getDelegates().add(d3);
		cplus101.getDelegates().add(d4);
		
		math101.getDelegates().add(d3);
		math101.getDelegates().add(d4);
		
		session.save(d1);
		session.save(d2);
		session.save(d3);
		session.save(d4);
		
		session.save(java101);
		session.save(cplus101);
		session.save(math101);
		
		session.getTransaction().commit();

	}

}
