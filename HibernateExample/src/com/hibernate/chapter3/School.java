package com.hibernate.chapter3;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class School {
	
	private int schoolId;
	private String ShoolName;
	private SchoolDetail schoolDetail;
	
	@Embedded
	public SchoolDetail getSchoolDetail() {
		return schoolDetail;
	}
	public void setSchoolDetail(SchoolDetail schoolDetail) {
		this.schoolDetail = schoolDetail;
	}
	@Id
	@GeneratedValue
	public int getSchoolId() {
		return schoolId;
	}
	public void setSchoolId(int schoolId) {
		this.schoolId = schoolId;
	}
	public String getShoolName() {
		return ShoolName;
	}
	public void setShoolName(String shoolName) {
		ShoolName = shoolName;
	}
	
}
