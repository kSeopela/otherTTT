package com.hibernate.jointable;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class HibernateTest {

	public static void main(String[] args) {
		AnnotationConfiguration config = new AnnotationConfiguration();
		config.addAnnotatedClass(Vihicle.class);
		config.addAnnotatedClass(TwoWheeler.class);
		config.addAnnotatedClass(FourWheeler.class);
		config.configure();
		new SchemaExport(config).create(true, true); 
		
		SessionFactory factory = config.buildSessionFactory();
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		
		Vihicle vehicle = new Vihicle();
		vehicle.setVehicleName("Car");

		TwoWheeler bike = new TwoWheeler();
		bike.setVehicleName("Bike");
		bike.setSteeringHandler("Bike Steering Handler");

		FourWheeler car = new FourWheeler();
		car.setVehicleName("Porsche");
		car.setSteeringWheel("Porsche Steering Wheel");

		session.save(vehicle);
		session.save(car);
		session.save(bike);
		session.getTransaction().commit();
	}

}
