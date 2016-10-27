package com.hibernate.chapter2;
//Creating two tables from one class program

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name="Customer")
@SecondaryTable(name="CustomerDetail")
public class Customer {
	private int customerId;
	private String customerName;
	private String customerAddress;
	private int creditScore;
	private int rewardPoints;
	
	@Id
	@TableGenerator(name="custid",table="custpktb",pkColumnName="custkey",
	pkColumnValue="custValue",allocationSize=2)
	@GeneratedValue(strategy=GenerationType.TABLE,generator="custid")
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	@Column(table="CustomerDetail")
	public String getCustomerAddress() {
		return customerAddress;
	}
	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}
	@Column(table="CustomerDetail")
	public int getCreditScore() {
		return creditScore;
	}
	@Column(table="CustomerDetail")
	public void setCreditScore(int creditScore) {
		this.creditScore = creditScore;
	}
	@Column(table="CustomerDetail")
	public int getRewardPoints() {
		return rewardPoints;
	}
	public void setRewardPoints(int rewardPoints) {
		this.rewardPoints = rewardPoints;
	}
	
	
	
}
