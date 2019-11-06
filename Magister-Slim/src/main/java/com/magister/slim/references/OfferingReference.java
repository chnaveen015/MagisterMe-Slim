package com.magister.slim.references;

import org.springframework.data.annotation.Id;

public class OfferingReference {

	@Id
	private int offeringId;
	private String offeringName;

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

	@Override
	public String toString() {
		return "OfferingReference [offeringId=" + offeringId + ", offeringName=" + offeringName + "]";
	}

}
