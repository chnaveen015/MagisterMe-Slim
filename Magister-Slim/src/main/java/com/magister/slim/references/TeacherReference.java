package com.magister.slim.references;

import org.springframework.data.annotation.Id;

public class TeacherReference {
	
	@Id
	private int teacherid;
	private String name;
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

}
