package com.hibernate.hql;



import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.Query;
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
		
		//new SchemaExpo rt(config).create(true, true);
		
		SessionFactory factory = config.buildSessionFactory();
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		Query query = session.createQuery("select new map(userId,userName) from UserDetails");
		query.setFirstResult(5);
		query.setMaxResults(3);
		Map<Integer,String> users =(Map<Integer, String>)query.list();
		session.getTransaction().commit();
		Set<Integer> key = users.keySet();
		Iterator<Integer> ite = key.iterator();
		while (ite.hasNext()){
			System.out.println(ite +" "+ users.get(ite));
		}
	}

}
