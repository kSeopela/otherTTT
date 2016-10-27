package com.hibernate.chapter4;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Accounts {
	private CompoundKey compoundKey;
	private int acountBalance;
	
	public int getAcountBalance() {
		return acountBalance;
	}
	@Id
	public CompoundKey getCompoundKey() {
		return compoundKey;
	}
	public void setCompoundKey(CompoundKey compoundKey) {
		this.compoundKey = compoundKey;
	}
	public void setAcountBalance(int acountBalance) {
		this.acountBalance = acountBalance;
	}
	
	
}
