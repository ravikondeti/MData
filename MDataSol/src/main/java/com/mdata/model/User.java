package com.mdata.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="IndUser")
public class User implements Serializable {
	
	private static final long serialVersionUID = 2l;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int indUserKy;
	@Column
	private String indUserId;
	@Column
	private String indUserFirstName;
	@Column
	private String indUserLastName;
	
	
	public int getIndUserKy() {
		return indUserKy;
	}
	public void setIndUserKy(int indUserKy) {
		this.indUserKy = indUserKy;
	}
	public String getIndUserId() {
		return indUserId;
	}
	public void setIndUserId(String indUserId) {
		this.indUserId = indUserId;
	}
	public String getIndUserFirstName() {
		return indUserFirstName;
	}
	public void setIndUserFirstName(String indUserFirstName) {
		this.indUserFirstName = indUserFirstName;
	}
	public String getIndUserLastName() {
		return indUserLastName;
	}
	public void setIndUserLastName(String indUserLastName) {
		this.indUserLastName = indUserLastName;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}


}
