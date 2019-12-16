package com.magister.slim.entity;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.magister.slim.references.GroupReference;
import com.magister.slim.references.OfferingReference;

@Document
public class OfferingLevel {
	
	@Id
	private int offeringLevelId;
	private String offeringLevelName;
	private OfferingReference offeringReference;
	private List<GroupReference> groupReferences;
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
		return "OfferingLevel [offeringLevelId=" + offeringLevelId + ", offeringLevelName=" + offeringLevelName
				+ ", offeringReference=" + offeringReference + ", groupReferences=" + groupReferences + ", isActive="
				+ isActive + "]";
	}
	public OfferingLevel(int offeringLevelId, String offeringLevelName, OfferingReference offeringReference,
			List<GroupReference> groupReferences, boolean isActive) {
		super();
		this.offeringLevelId = offeringLevelId;
		this.offeringLevelName = offeringLevelName;
		this.offeringReference = offeringReference;
		this.groupReferences = groupReferences;
		this.isActive = isActive;
	}
	public List<GroupReference> getGroupReferences() {
		return groupReferences;
	}
	public void setGroupReferences(List<GroupReference> groupReferences) {
		this.groupReferences = groupReferences;
	}
	public OfferingLevel()
	{
		
	}

}
