package com.hibernate.chapter4;

import java.io.Serializable;
import javax.persistence.Embeddable;

@Embeddable
public class CompoundKey implements Serializable {
	private int userId;
	private int acountId;
	
	
	public CompoundKey(int userId, int acountId) {
		this.userId = userId;
		this.acountId = acountId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getAcountId() {
		return acountId;
	}
	public void setAcountId(int acountId) {
		this.acountId = acountId;
	}
}
