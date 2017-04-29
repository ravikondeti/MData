package com.mdata.controller;

import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.parsing.EmptyReaderEventListener;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mdata.model.Customer;
import com.mdata.service.CustomerService;


@Controller
public class CustomerController {
	private static final Logger logger = Logger.getLogger(CustomerController.class);
	
	public CustomerController(){
		System.out.println("CustomerController()");
	}
	
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping(value = "/")
	public ModelAndView getCustomers(ModelAndView model){
		List<Customer> customerList = customerService.getAllCustomers();
		model.addObject("CustomerList", customerList);
		model.setViewName("home");
		return model;
	}
	
	@RequestMapping(value = "/register")
	public ModelAndView register(ModelAndView model){
		model.setViewName("registration");
		return model;
	}
	
	@RequestMapping(value ="/newCustomer", method = RequestMethod.GET )
	public ModelAndView newCustomer(ModelAndView model){
		Customer customer = new Customer();
		model.addObject("customer", customer);
		model.setViewName("companyregistration");
		return model;
	}
	
	@RequestMapping(value ="/saveCustomer", method = RequestMethod.POST )
	public ModelAndView saveCustomer(@ModelAttribute Customer customer){
		if(customer.getIndCustomerKy() == 0){
			customerService.addCustomer(customer);
		}else{
			customerService.updateCustomer(customer);
		}
		return new ModelAndView("redirect:/");
	}
	
	
	
	
}
