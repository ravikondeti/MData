package com.hibernate.learning;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="USER_DATA")
public class UserData {
	
	private String firstName;
	private String SecondName;
	private int age;
	private Date user_creation_date;
	
	@Id
	@Column(name="First_Name")
	public String getFirstName() {
		return firstName;
	}
	public Date getUser_creation_date() {
		return user_creation_date;
	}
	public void setUser_creation_date(Date user_creation_date) {
		this.user_creation_date = user_creation_date;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	@Column(name="Second_Name")
	public String getSecondName() {
		return SecondName;
	}
	public void setSecondName(String secondName) {
		SecondName = secondName;
	}
	@Column(name="Age")
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
}
