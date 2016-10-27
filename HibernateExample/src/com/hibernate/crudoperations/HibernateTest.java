package com.hibernate.crudoperations;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class HibernateTest {

	public static void main(String[] args) {

		AnnotationConfiguration config = new AnnotationConfiguration();
		config.addAnnotatedClass(UserDetails.class);
		config.configure();
		
		new SchemaExport(config).create(true, true);
		
		SessionFactory factory = config.buildSessionFactory();
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		/*for (int i = 0 ; i < 10 ; i++){
			UserDetails uDetails = new UserDetails();
			uDetails.setUserName("User" + i);
			session.save(uDetails);
		}*/
		
		// read a single record in a database
		//UserDetails user = (UserDetails)session.get(UserDetails.class, 6);
		//System.out.print("User name pulled up is: " + user.getUserName());
		// delete a record(s) in a database
		//session.delete(user);
		
	
		//Updating a record in a database
		UserDetails user = (UserDetails)session.get(UserDetails.class, 3);
		user.setUserName("Updated User");
		session.update(user);
		session.getTransaction().commit();
	}

}
