package com.magister.slim.references;

import org.springframework.data.annotation.Id;
public class StudyGuideReference {
	
	@Id
	private int studyGuideId;
	private String studyGuideName;
	public int getStudyGuideId() {
		return studyGuideId;
	}
	public void setStudyGuideId(int studyGuideId) {
		this.studyGuideId = studyGuideId;
	}
	public String getStudyGuideName() {
		return studyGuideName;
	}
	public void setStudyGuideName(String studyGuideName) {
		this.studyGuideName = studyGuideName;
	}

}
