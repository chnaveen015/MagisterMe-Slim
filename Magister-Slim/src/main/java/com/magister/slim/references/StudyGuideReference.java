package com.magister.slim.references;

import org.springframework.data.annotation.Id;
public class StudyGuideReference {
	
	@Id
	private String studyGuideId;
	private String studyGuideName;
	private boolean isActive;
	
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	public String getStudyGuideId() {
		return studyGuideId;
	}
	public void setStudyGuideId(String studyGuideId) {
		this.studyGuideId = studyGuideId;
	}
	public String getStudyGuideName() {
		return studyGuideName;
	}
	public void setStudyGuideName(String studyGuideName) {
		this.studyGuideName = studyGuideName;
	}

}
