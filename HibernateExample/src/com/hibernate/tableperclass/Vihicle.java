package com.hibernate.tableperclass;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public class Vihicle {

	private int vehicleiId;
	private String vehicleName;

	@Id
	@GeneratedValue
	public int getVehicleiId() {
		return vehicleiId;
	}
	public void setVehicleiId(int vehicleiId) {
		this.vehicleiId = vehicleiId;
	}
	public String getVehicleName() {
		return vehicleName;
	}
	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}
}
