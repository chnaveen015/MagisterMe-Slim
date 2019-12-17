package com.magister.slim.references;

import org.springframework.data.annotation.Id;

public class OfferingReference {

	@Id
	private int offeringId;
	private String offeringName;
	private boolean isActive;
	

	public int getOfferingId() {
		return offeringId;
	}

	public void setOfferingId(int offeringId) {
		this.offeringId = offeringId;
	}

	public String getOfferingName() {
		return offeringName;
	}

	public void setOfferingName(String offeringName) {
		this.offeringName = offeringName;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public OfferingReference(int offeringId, String offeringName, boolean isActive) {
		super();
		this.offeringId = offeringId;
		this.offeringName = offeringName;
		this.isActive = isActive;
	}

	@Override
	public String toString() {
		return "OfferingReference [offeringId=" + offeringId + ", offeringName=" + offeringName + ", isActive="
				+ isActive + "]";
	}

	public OfferingReference()
	{
		
	}
}
