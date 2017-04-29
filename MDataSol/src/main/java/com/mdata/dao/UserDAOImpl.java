package com.mdata.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mdata.model.User;

@Repository
public class UserDAOImpl implements UserDAO{

	@Autowired
	private  SessionFactory sessionFactory;
	
	public void addUser(User user) {
		sessionFactory.getCurrentSession().saveOrUpdate(user);
	}

	@SuppressWarnings("unchecked")
	public List<User> getAllUsers() {
		List<User> userList =sessionFactory.getCurrentSession().createQuery("from INDCUSTOMER").getResultList();
		return userList;	 		 
	}

	public void deleteUser(String userId) {
		User user=sessionFactory.getCurrentSession().load(User.class, userId);
		if(user != null){
			this.sessionFactory.getCurrentSession().delete(user);
		}
	}

	public User updateUser(User user) {
		sessionFactory.getCurrentSession().update(user);
		 return user;
		
	}

	public User getUser(String userId) {
		User user = sessionFactory.getCurrentSession().load(User.class, userId);
		return user;
		
		 
	}

	
}
