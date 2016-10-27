package com.hibernate.onetoonemapping;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class PersonDetail {
	private int personDetailID;
	private String zipCode;
	private String job;
	private double income;
	private Person person;
	
	@OneToOne(mappedBy="personDetail",cascade=CascadeType.ALL)
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	@Id
	@GeneratedValue
	@Column(name="detailId_PK")
	public int getPersonDetailID() {
		return personDetailID;
	}
	public void setPersonDetailID(int personDetailID) {
		this.personDetailID = personDetailID;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public double getIncome() {
		return income;
	}
	public void setIncome(double income) {
		this.income = income;
	}
}
