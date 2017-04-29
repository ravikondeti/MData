package com.mdata.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mdata.dao.UserDAO;
import com.mdata.model.User;
@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	UserDAO userDAO;
	
	@Transactional
	public void addUser(User user) {
		userDAO.addUser(user);	
	}
	@Transactional
	public List<User> getAllUsers() {
		
		return userDAO.getAllUsers();
	}
	@Transactional
	public void deleteUser(String userId) {
		userDAO.deleteUser(userId);
		
	}

	public User updateUser(User user) {		
		return userDAO.updateUser(user);
	}

	public User getUser(String userId) {
		return userDAO.getUser(userId);
	}

}
