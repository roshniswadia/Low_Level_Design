package com.parkinglot.model;

import java.time.LocalDateTime;

public class Account {
	private String id;
	private String username;
	private String password;
	private LocalDateTime lastAccessTime;
	private String phoneNumber;
	
	public Account() {
		
	}
	
	public Account(String id, String username, String password, LocalDateTime lastAccessTime, String phoneNumber) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.lastAccessTime = lastAccessTime;
		this.phoneNumber = phoneNumber;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	public LocalDateTime getLastAccessTime() {
		return lastAccessTime;
	}
	public void setLastAccessTime(LocalDateTime lastAccessTime) {
		this.lastAccessTime = lastAccessTime;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

}
