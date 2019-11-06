package com.magister.slim.entity;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.magister.slim.references.GroupReference;

@Document
public class Teacher {
	
	@Id
	private int teacherid;
	private User userReference;
	private String name;
	private String address;
	private long phoneno;
	private List<GroupReference> groupReference;
	public List<GroupReference> getGroupReference() {
		return groupReference;
	}
	public void setGroupReference(List<GroupReference> groupReference) {
		this.groupReference = groupReference;
	}
	private int age;
	private String gender;
	private boolean isActive;
	public int getTeacherid() {
		return teacherid;
	}
	public void setTeacherid(int teacherid) {
		this.teacherid = teacherid;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public long getPhoneno() {
		return phoneno;
	}
	public void setPhoneno(long phoneno) {
		this.phoneno = phoneno;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean active) {
		this.isActive = active;
	}
	
	
	public Teacher(int teacherid, User userReference, String name, String address, long phoneno,
			List<GroupReference> groupReference, int age, String gender, boolean isActive) {
		super();
		this.teacherid = teacherid;
		this.userReference = userReference;
		this.name = name;
		this.address = address;
		this.phoneno = phoneno;
		this.groupReference = groupReference;
		this.age = age;
		this.gender = gender;
		this.isActive = isActive;
	}
	@Override
	public String toString() {
		return "Teacher [teacherid=" + teacherid + ", userReference=" + userReference + ", name=" + name + ", address="
				+ address + ", phoneno=" + phoneno + ", groupReference=" + groupReference + ", age=" + age + ", gender="
				+ gender + ", isActive=" + isActive + "]";
	}
	public Teacher()
	{
		
	}
	public User getUserReference() {
		return userReference;
	}
	public void setUserReference(User userReference) {
		this.userReference = userReference;
	}
	
	
}

