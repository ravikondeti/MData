package com.mdata.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="INDCUSTOMER")
public class Customer implements Serializable{
	
	private static final long serialVersionUID = 1l;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int indCustomerKy;
	@Column
	private String indCustomerId;
	@Column
	private String indCustomerName;
	@Column
	private String indCustomerAddress1;
	@Column
	private String indCustomerAddress2;
	
	private String indCustomercountry;
	public int getIndCustomerKy() {
		return indCustomerKy;
	}
	public void setIndCustomerKy(int indCustomerKy) {
		this.indCustomerKy = indCustomerKy;
	}
	public String getIndCustomerId() {
		return indCustomerId;
	}
	public void setIndCustomerId(String indCustomerId) {
		this.indCustomerId = indCustomerId;
	}
	public String getIndCustomerName() {
		return indCustomerName;
	}
	public void setIndCustomerName(String indCustomerName) {
		this.indCustomerName = indCustomerName;
	}
	public String getIndCustomerAddress1() {
		return indCustomerAddress1;
	}
	public void setIndCustomerAddress1(String indCustomerAddress1) {
		this.indCustomerAddress1 = indCustomerAddress1;
	}
	public String getIndCustomerAddress2() {
		return indCustomerAddress2;
	}
	public void setIndCustomerAddress2(String indCustomerAddress2) {
		this.indCustomerAddress2 = indCustomerAddress2;
	}
	public String getIndCustomercountry() {
		return indCustomercountry;
	}
	public void setIndCustomercountry(String indCustomercountry) {
		this.indCustomercountry = indCustomercountry;
	}
	
}
