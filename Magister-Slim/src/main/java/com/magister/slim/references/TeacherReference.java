package com.magister.slim.references;

import org.springframework.data.annotation.Id;

public class TeacherReference {
	
	@Id
	private int teacherid;
	private String name;
	private boolean isActive;
	
	@Override
	public String toString() {
		return "TeacherReference [teacherid=" + teacherid + ", name=" + name + ", isActive=" + isActive + "]";
	}
	public TeacherReference(int teacherid, String name, boolean isActive) {
		super();
		this.teacherid = teacherid;
		this.name = name;
		this.isActive = isActive;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
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
	public TeacherReference() {
		
	}
}
