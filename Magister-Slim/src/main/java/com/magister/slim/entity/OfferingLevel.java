package com.magister.slim.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import com.magister.slim.references.OfferingReference;

@Document
public class OfferingLevel {
	
	@Id
	private int offeringLevelId;
	private String offeringLevelName;
	private OfferingReference offeringReference;
	private boolean isActive;
	public int getOfferingLevelId() {
		return offeringLevelId;
	}
	public void setOfferingLevelId(int offeringLevelId) {
		this.offeringLevelId = offeringLevelId;
	}
	public String getOfferingLevelName() {
		return offeringLevelName;
	}
	public void setOfferingLevelName(String offeringLevelName) {
		this.offeringLevelName = offeringLevelName;
	}
	public OfferingReference getOfferingReference() {
		return offeringReference;
	}
	public void setOfferingReference(OfferingReference offeringReference) {
		this.offeringReference = offeringReference;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	@Override
	public String toString() {
		return "Offering [offeringLevelId=" + offeringLevelId + ", offeringLevelName=" + offeringLevelName + ", offeringReference="
				+ offeringReference +", isActive=" + isActive + "]";
	}
	public OfferingLevel(int offeringLevelId, String offeringLevelName, OfferingReference offeringReference,
			boolean isActive) {
		super();
		this.offeringLevelId = offeringLevelId;
		this.offeringLevelName = offeringLevelName;
		this.offeringReference = offeringReference;
		this.isActive = isActive;
	}
	public OfferingLevel()
	{
		
	}

}
