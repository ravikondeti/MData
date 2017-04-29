package com.mdata.service;

import java.util.List;

import com.mdata.model.User;

public interface UserService {

	public void addUser(User user);
	public List<User> getAllUsers();
	public void deleteUser(String userId);
	public User updateUser(User user);
	public User getUser(String userId);
	
}
