package com.hibernate.chapter3;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.classic.Session;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class TestSchool {

	public static void main(String[] args) {
		AnnotationConfiguration config = new AnnotationConfiguration();
		config.addAnnotatedClass(School.class);
		config.configure();
		
		new SchemaExport(config).create(true, true);

		SessionFactory factory = config.buildSessionFactory();
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		SchoolDetail annsDetail = new SchoolDetail();
		
		annsDetail.setPublicSchool(true);
		annsDetail.setSchoolAddress("101 Witbank, Mpumalanga");
		annsDetail.setStudentCount(350);
		School dm = new School();
		
		dm.setShoolName("D.M Motsaosele Sec. School");
		dm.setSchoolDetail(annsDetail);
		
		session.save(dm);
		session.getTransaction().commit();
	}

}
