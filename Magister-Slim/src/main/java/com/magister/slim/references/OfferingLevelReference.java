package com.magister.slim.references;

import org.springframework.data.annotation.Id;

public class OfferingLevelReference {

	@Id
	private int offeringLevelId;
	private String offeringLevelName;
	private boolean isActive;

	public String getOfferingLevelName() {
		return offeringLevelName;
	}

	public void setOfferingLevelName(String offeringLevelName) {
		this.offeringLevelName = offeringLevelName;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	@Override
	public String toString() {
		return "OfferingLevelReference [offeringLevelId=" + offeringLevelId + ", offeringLevelName=" + offeringLevelName
				+ ", isActive=" + isActive + "]";
	}

	public OfferingLevelReference(int offeringLevelId, String offeringLevelName, boolean isActive) {
		super();
		this.offeringLevelId = offeringLevelId;
		this.offeringLevelName = offeringLevelName;
		this.isActive = isActive;
	}

	public int getOfferingLevelId() {
		return offeringLevelId;
	}

	public void setOfferingLevelId(int offeringLevelId) {
		this.offeringLevelId = offeringLevelId;
	}

	public OfferingLevelReference() {

	}

}
