package com.hibernate.chapter1;

import java.sql.Date;
import java.util.GregorianCalendar;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class testEmployee {

	public static void main(String[] args) {
		
		//connection to the database
		AnnotationConfiguration config = new AnnotationConfiguration();
		config.addAnnotatedClass(Employee.class);
		config.configure("hibernate.cfg.xml");
		
		//for creating or re-creating the table
		new SchemaExport(config).create(true, false);
		
		//populating a table
		SessionFactory factory = config.buildSessionFactory();
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		Employee koketso = new Employee();
		Employee sibongle = new Employee();
		Employee thabiso= new Employee();
		Employee mthokozisi = new Employee();
		{
			koketso.setEmpPassword("koketso");
			koketso.setEmpName("Koketso Seopela");
			koketso.setEmpEmailAddress("koketso@bbd.co.za");
			koketso.setPermanent(true);
			koketso.setEmpJoinDate(new GregorianCalendar(2016,02,12));
			koketso.setEmpLoginTime(Date.valueOf("2016-02-12"));
		
			session.save(koketso);
		}
		{
			sibongle.setEmpPassword("sbo");
			sibongle.setEmpName("Sibongile Mbewe");
			sibongle.setEmpEmailAddress("sibongile@bbd.co.za");
			sibongle.setPermanent(true);
			sibongle.setEmpJoinDate(new GregorianCalendar(2016,02,12));
			sibongle.setEmpLoginTime(Date.valueOf("2016-02-12"));
		
			session.save(sibongle);
		}
		{
			thabiso.setEmpPassword("kgeru");
			thabiso.setEmpName("Thabiso Phetla");
			thabiso.setEmpEmailAddress("thabisop@bbd.co.za");
			thabiso.setPermanent(true);
			thabiso.setEmpJoinDate(new GregorianCalendar(2016,02,12));
			thabiso.setEmpLoginTime(Date.valueOf("2016-02-12"));
		
			session.save(thabiso);
		}
		{
			mthokozisi.setEmpPassword("sydney");
			mthokozisi.setEmpName("Mthokozisi Mtsweni");
			mthokozisi.setEmpEmailAddress("mthokozisi@bbd.co.za");
			mthokozisi.setPermanent(true);
			mthokozisi.setEmpJoinDate(new GregorianCalendar(2016,02,12));
			mthokozisi.setEmpLoginTime(Date.valueOf("2016-02-12"));
		
			session.save(mthokozisi);
		}
		
		session.getTransaction().commit();
	}
}
