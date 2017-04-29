package com.mdata.service;

import java.util.List;

import com.mdata.model.Customer;

public interface CustomerService {

	public void addCustomer(Customer customer);
	public List<Customer> getAllCustomers();
	public void deleteCustomer(String customerId);
	public Customer updateCustomer(Customer customer);
	public Customer getCustomer(String customerId);
	
	
}
