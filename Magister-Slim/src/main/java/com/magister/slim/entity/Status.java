package com.magister.slim.entity;

import org.springframework.data.annotation.Id;

public class Status {
	
	@Id
	private int id;
	enum statusState{
		STARTED,HANDEDIN,GRADED,COMPLETED;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
}
