package com.magister.slim.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userid;
	private String username;
	private String password;
	private role role;
	public enum role{student , teacher;}
	public void setUserType(role input){
        role= input;
    }
	public role getRole()
	{
		return role;
	}
	private boolean active;
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	@Override
	public String toString() {
		return "[username=" + username + ", password=" + password
				+"]";
	}
	public User(int userid, String username, String password, com.magister.slim.entity.User.role role, boolean active) {
		super();
		this.userid = userid;
		this.username = username;
		this.password = password;
		this.role = role;
		this.active = active;
	}
	
	public User()
	{
		
	}

}
