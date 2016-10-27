package com.hibernate.jointable;

import javax.persistence.Entity;

@Entity
public class TwoWheeler extends Vihicle{

	private String steeringHandler;

	public String getSteeringHandler() {
		return steeringHandler;
	}

	public void setSteeringHandler(String steeringHandler) {
		this.steeringHandler = steeringHandler;
	}
	
	
}
