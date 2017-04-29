package com.hibernate.learning;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CallHibernateFunction {
	
	public static void main(String[] args){
		
		UserData userData=new UserData();
		
		userData.setFirstName("sowmya");
		userData.setSecondName("kondeti");
		userData.setAge(30);
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		session.beginTransaction();
		session.save(userData);
		session.getTransaction().commit();
		
		UserData getUserData = session.get(UserData.class, "sowmya");
		System.out.println("User second name is :" + getUserData.getSecondName());
	}

}
