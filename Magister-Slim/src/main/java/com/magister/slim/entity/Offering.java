package com.magister.slim.entity;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.magister.slim.references.OfferingLevelReference;

@Document
public class Offering {
	@Id
	private int offeringid;
	private String offeringName;
	private List<OfferingLevelReference> offeringLevels;
	private boolean isActive;
	public int getOfferingid() {
		return offeringid;
	}
	public void setOfferingid(int offeringid) {
		this.offeringid = offeringid;
	}
	public String getOfferingName() {
		return offeringName;
	}
	public void setOfferingName(String offeringName) {
		this.offeringName = offeringName;
	}
	public List<OfferingLevelReference> getOfferingLevels() {
		return offeringLevels;
	}
	public void setOfferingLevels(List<OfferingLevelReference> list) {
		this.offeringLevels = list;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	@Override
	public String toString() {
		return "Offering [offeringid=" + offeringid + ", offeringName=" + offeringName + ", offeringLevels="
				+ offeringLevels + ", isActive=" + isActive + "]";
	}
	public Offering(int offeringid, String offeringName, List<OfferingLevelReference> offeringLevels,
			boolean isActive) {
		super();
		this.offeringid = offeringid;
		this.offeringName = offeringName;
		this.offeringLevels = offeringLevels;
		this.isActive = isActive;
	}
	public Offering()
	{
		
	}
}
