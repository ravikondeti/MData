package com.rest.sample.app;



import java.io.Serializable;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement(name = "plcdatatest")
public class PlcDataTest implements Serializable{

	//Read data from MySQL Database
	   private static final long serialVersionUID = 1L; 
	   //@Column(name ="username")
	String userName="";
	  // @Column(name ="firstName")
	String firstName="";
	   //@Column(name ="age")
	int age=0;
	
	public PlcDataTest(){};
	public PlcDataTest(String userName, String firstName, int age){
		this.userName =userName;
		this.firstName=firstName;
		this.age=age;
	}
	
	public String getUserName(){
		return userName;
	}
	
	@XmlElement
	public void setUserName(String userName){
		this.userName =userName;
	}
	
	public String getFirstName(){
		return firstName;
	}
	@XmlElement
	public void setFirstName(String firstName){
		this.firstName =firstName;
	}
	
	public int getAge(){
		return age;
	}
	
	@XmlElement
	public void setAge(int age){
		this.age =age;
	}

}



