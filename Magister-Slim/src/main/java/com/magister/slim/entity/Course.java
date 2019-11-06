package com.magister.slim.entity;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.magister.slim.references.GroupReference;
import com.magister.slim.references.StudyGuideReference;

@Document
public class Course {

	@Id
	private int courseId;
	private String courseName;
	private List<StudyGuideReference> studyGuideReferences;
	private List<GroupReference> groupReferencs;
	private boolean isActive;

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public List<StudyGuideReference> getStudyGuideReferences() {
		return studyGuideReferences;
	}

	public void setStudyGuideReferences(List<StudyGuideReference> studyGuideReferences) {
		this.studyGuideReferences = studyGuideReferences;
	}

	public List<GroupReference> getGroupReferencs() {
		return groupReferencs;
	}

	public void setGroupReferencs(List<GroupReference> groupReferencs) {
		this.groupReferencs = groupReferencs;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	@Override
	public String toString() {
		return "Course [courseId=" + courseId + ", courseName=" + courseName + ", studyGuideReferences="
				+ studyGuideReferences + ", groupReferencs=" + groupReferencs + ", isActive=" + isActive + "]";
	}

	public Course(int courseId, String courseName, List<StudyGuideReference> studyGuideReferences,
			List<GroupReference> groupReferencs, boolean isActive) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.studyGuideReferences = studyGuideReferences;
		this.groupReferencs = groupReferencs;
		this.isActive = isActive;
	}
	public Course()
	{
		
	}

}
