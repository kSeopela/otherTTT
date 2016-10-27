package com.hibernate.tableperclass;

import javax.persistence.Entity;

@Entity
public class FourWheeler extends Vihicle {
	
	private String steeringWheel;

	public String getSteeringWheel() {
		return steeringWheel;
	}

	public void setSteeringWheel(String steeringWheel) {
		this.steeringWheel = steeringWheel;
	}
	
}
