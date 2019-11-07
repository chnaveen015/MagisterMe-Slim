package com.magister.slim.entity;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.magister.slim.references.CourseReference;
import com.magister.slim.references.GroupReference;

@Document
public class Student {

	@Id
	private int studentId;
	private int userReference;
	private List<GroupReference> groupReference;
	private String name, gender;
	private List<CourseReference> courseReference;
	private long phoneno;
	private boolean active;

	


	public int getUserReference() {
		return userReference;
	}

	public void setUserReference(int userReference) {
		this.userReference = userReference;
	}

	public void setGroup(List<GroupReference> groupReference) {
		this.groupReference = groupReference;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public long getPhoneno() {
		return phoneno;
	}

	public void setPhoneno(long phoneno) {
		this.phoneno = phoneno;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	
	public List<CourseReference> getCourseReference() {
		return courseReference;
	}

	public void setCourseReference(List<CourseReference> courseReference) {
		this.courseReference = courseReference;
	}

	
	

	public List<GroupReference> getGroupReference() {
		return groupReference;
	}

	public void setGroupReference(List<GroupReference> groupReference) {
		this.groupReference = groupReference;
	}

	
	public Student(int studentId, int userReference, List<GroupReference> groupReference, String name, String gender,
			List<CourseReference> courseReference, long phoneno, boolean active) {
		super();
		this.studentId = studentId;
		this.userReference = userReference;
		this.groupReference = groupReference;
		this.name = name;
		this.gender = gender;
		this.courseReference = courseReference;
		this.phoneno = phoneno;
		this.active = active;
	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", userReference=" + userReference + ", groupReference="
				+ groupReference + ", name=" + name + ", gender=" + gender + ", courseReference=" + courseReference
				+ ", phoneno=" + phoneno + ", active=" + active + "]";
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public Student()
	{
		
	}
	

}
