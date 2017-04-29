package com.mdata.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mdata.dao.CustomerDAO;
import com.mdata.model.Customer;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDAO customerDAO;
	
	@Transactional
	public void addCustomer(Customer customer) {
		customerDAO.addCustomer(customer);
		
	}
	@Transactional
	public List<Customer> getAllCustomers() {
		return customerDAO.getAllCustomers();
	}
	@Transactional
	public void deleteCustomer(String customerId) {
		customerDAO.deleteCustomer(customerId);
		
	}

	public Customer updateCustomer(Customer customer) {

		return customerDAO.updateCustomer(customer);
	}

	public Customer getCustomer(String customerId) {
		return customerDAO.getCustomer(customerId);
	}
	
	
}
