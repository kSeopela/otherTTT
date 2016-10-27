package com.hibernate.onetomany;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.classic.Session;
import org.hibernate.tool.hbm2ddl.SchemaExport;

import com.hibernate.onetoonemapping.Person;

public class TestStudent {

	public static void main(String[] args) {
		AnnotationConfiguration config = new AnnotationConfiguration();
		config.addAnnotatedClass(College.class);
		config.addAnnotatedClass(Student.class);
		config.configure();
		
		new SchemaExport(config).create(true, true);
		
		SessionFactory factory = config.buildSessionFactory();
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		College college1 = new College();
		college1.setCollegeName("Tswane South Colledge");
		
		Student s1 = new Student();
		s1.setStudentName("Alex Rod");
		
		Student s2 = new Student();
		s2.setStudentName("Phindi Mabawa");
		
		s1.setCollege(college1);
		s2.setCollege(college1);
		
		session.save(college1);
		session.save(s1);
		session.save(s2);
		session.getTransaction().commit();

	}

}
