package com.magister.slim.entity;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.magister.slim.references.CourseReference;
import com.magister.slim.references.OfferingLevelReference;
import com.magister.slim.references.OfferingReference;
import com.magister.slim.references.StudentReference;
import com.magister.slim.references.TeacherReference;
import com.magister.slim.references.ThemeReference;
import com.magister.slim.references.UnitReference;

@Document
public class StudyGuide {

	@Id
	private int studyGuideId;
	private String studyGuideName;
	private TeacherReference teacherReference;
	private List<ThemeReference> themes;
	private List<UnitReference> units;
	private List<StudentReference> students;
	private CourseReference courseReference;
	private OfferingReference offeringReference;
	private OfferingLevelReference offeringLevelReference;
	private String validOnwards;
	private String validUpto;
	private boolean isDeleted;
	private boolean active;
	
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public StudyGuide(int studyGuideId, String studyGuideName, TeacherReference teacherReference,
			List<ThemeReference> themes, List<UnitReference> units, List<StudentReference> students,
			CourseReference courseReference, OfferingReference offeringReference,
			OfferingLevelReference offeringLevelReference, String validOnwards, String validUpto, boolean isDeleted,
			boolean active) {
		super();
		this.studyGuideId = studyGuideId;
		this.studyGuideName = studyGuideName;
		this.teacherReference = teacherReference;
		this.themes = themes;
		this.units = units;
		this.students = students;
		this.courseReference = courseReference;
		this.offeringReference = offeringReference;
		this.offeringLevelReference = offeringLevelReference;
		this.validOnwards = validOnwards;
		this.validUpto = validUpto;
		this.isDeleted = isDeleted;
		this.active = active;
	}
	public int getStudyGuideIdId() {
		return studyGuideId;
	}
	public void setStudyGuideId(int studyGuideId) {
		this.studyGuideId= studyGuideId;
	}
	public String getStudyGuideName() {
		return studyGuideName;
	}
	public void setStudyGuideName(String studyGuideName) {
		this.studyGuideName = studyGuideName;
	}
	public TeacherReference getTeacherReference() {
		return teacherReference;
	}
	public void setTeacherReference(TeacherReference teacherReference) {
		this.teacherReference = teacherReference;
	}
	public List<ThemeReference> getThemes() {
		return themes;
	}
	public void setThemes(List<ThemeReference> themes) {
		this.themes = themes;
	}
	public List<UnitReference> getUnits() {
		return units;
	}
	public void setUnits(List<UnitReference> units) {
		this.units = units;
	}
	public List<StudentReference> getStudents() {
		return students;
	}
	public void setStudents(List<StudentReference> students) {
		this.students = students;
	}
	public CourseReference getCourseReference() {
		return courseReference;
	}
	public void setCourseReference(CourseReference courseReference) {
		this.courseReference = courseReference;
	}
	public OfferingReference getOfferingReference() {
		return offeringReference;
	}
	public void setOfferingReference(OfferingReference offeringReference) {
		this.offeringReference = offeringReference;
	}
	public OfferingLevelReference getOfferingLevelReference() {
		return offeringLevelReference;
	}
	public void setOfferingLevelReference(OfferingLevelReference offeringLevelReference) {
		this.offeringLevelReference = offeringLevelReference;
	}
	public String getValidOnwards() {
		return validOnwards;
	}
	public void setValidOnwards(String validOnwards) {
		this.validOnwards = validOnwards;
	}
	public String getValidUpto() {
		return validUpto;
	}
	public void setValidUpto(String validUpto) {
		this.validUpto = validUpto;
	}
	public boolean isDeleted() {
		return isDeleted;
	}
	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}
	
	public int getStudyGuideId() {
		return studyGuideId;
	}
	
	@Override
	public String toString() {
		return "StudyGuide [studyGuideId=" + studyGuideId + ", studyGuideName=" + studyGuideName + ", teacherReference="
				+ teacherReference + ", themes=" + themes + ", units=" + units + ", students=" + students
				+ ", courseReference=" + courseReference + ", offeringReference=" + offeringReference
				+ ", offeringLevelReference=" + offeringLevelReference + ", validOnwards=" + validOnwards
				+ ", validUpto=" + validUpto + ", isDeleted=" + isDeleted + ", active=" + active + "]";
	}
	public StudyGuide()
	{
		
	}
	
	
	
}
