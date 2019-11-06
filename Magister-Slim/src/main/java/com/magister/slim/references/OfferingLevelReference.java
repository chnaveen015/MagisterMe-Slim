package com.magister.slim.references;

import org.springframework.data.annotation.Id;

public class OfferingLevelReference {

	@Id
	private int offeringLevelid;
	private String offeringLevelName;

	public int getOfferingLevelid() {
		return offeringLevelid;
	}

	public void setOfferingLevelid(int offeringLevelid) {
		this.offeringLevelid = offeringLevelid;
	}

	public String getOfferingLevelName() {
		return offeringLevelName;
	}

	public void setOfferingLevelName(String offeringLevelName) {
		this.offeringLevelName = offeringLevelName;
	}

	@Override
	public String toString() {
		return "OfferingLevelReference [offeringLevelid=" + offeringLevelid + ", offeringLevelName=" + offeringLevelName
				+ "]";
	}

}
