package com.mdata.controller;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mdata.model.Customer;
import com.mdata.model.User;
import com.mdata.service.UserService;

@Controller
public class UserController {

	private static final Logger logger = Logger.getLogger(UserController.class);
	
	public UserController(){
		System.out.println("UserController()");
	}
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value ="/newUser", method = RequestMethod.GET )
	public ModelAndView newUser(ModelAndView model){
		User user =new User();
		model.addObject("user", user);
		model.setViewName("userregistration");
		return model;
	}
	
	@RequestMapping(path="/saveUser", method=RequestMethod.POST)
	public ModelAndView saveUser(@ModelAttribute User user){
		if(user.getIndUserKy() == 0){
			userService.addUser(user);
		}else{
			userService.updateUser(user);
		}
		
		return new ModelAndView("redirect:/");
		
	}
	
	
	
}
