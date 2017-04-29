package com.mdata.dao;

import java.util.List;


import com.mdata.model.User;

public interface UserDAO {

	public void addUser(User user);
	public List<User> getAllUsers();
	public void deleteUser(String userId);
	public User updateUser(User user);
	public User getUser(String userId);
	
	
}
