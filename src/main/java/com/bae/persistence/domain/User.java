package com.bae.persistence.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class User {
	@Column(length = 100)
	private String userEmail;
	@Column(length = 50)
	private String userName;
	@Column(length = 25)
	private String userPassword = "";

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Activity> activityList = new ArrayList<>();

	public User(String userEmail, String userName, String userPassword) {
		super();
		this.userEmail = userEmail;
		this.userName = userName;
		this.userPassword = userPassword;
		this.activityList = new ArrayList<>();
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public List<Activity> getActivityList() {
		return activityList;
	}

	public void setActivityList(List<Activity> activityList) {
		this.activityList = activityList;
	}

}
