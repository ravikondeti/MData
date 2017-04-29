package com.mdata.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mdata.model.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {
	@Autowired
	private SessionFactory sessionFactory;
	
	public void addCustomer(Customer customer) {
		sessionFactory.getCurrentSession().saveOrUpdate(customer);
		
	}

	@SuppressWarnings("unchecked")
	public List<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery("from IndCustomer").list();
	}

	public void deleteCustomer(String customerId) {
		Customer customer = (Customer)sessionFactory.getCurrentSession().load(Customer.class, customerId);
		if (null != customer){
			
			this.sessionFactory.getCurrentSession().delete(customer);
		}
		
	}

	public Customer updateCustomer(Customer customer) {
		 sessionFactory.getCurrentSession().update(customer);
		 return customer;
	}

	public Customer getCustomer(String customerId) {
		// TODO Auto-generated method stub
		return (Customer)sessionFactory.getCurrentSession().load(Customer.class, customerId);
	}



}
