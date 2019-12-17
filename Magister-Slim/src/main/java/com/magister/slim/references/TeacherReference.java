package com.magister.slim.references;

import org.springframework.data.annotation.Id;

public class TeacherReference {
	
	@Id
	private String teacherid;
	private String name;
	private boolean isActive;
	public String getTeacherid() {
		return teacherid;
	}
	public void setTeacherid(String teacherid) {
		this.teacherid = teacherid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	
}
