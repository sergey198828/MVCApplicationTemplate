package com.MVCApplication.services;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.MVCApplication.models.User;

public class UserService {
	
	public static SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	
	public static String authentificate(String userName, int passwordHash){
		//Creating Hibernate session
		Session session = sessionFactory.openSession();
		//Beginning the transaction
		session.beginTransaction();
		//Fetcing user
		User user = (User) session.get(User.class, userName);
		//Closing transaction
		session.getTransaction().commit();
		//Closing session
		session.close();
		//Verify user
		if(user!=null)//User exist
			if(user.getPasswordHash()==passwordHash)//Password correct
				return "Ok";
			else
				return "Wrong password, try again";
		return "User doesnt exist.";
	}
	public static String register(User user){
		//Temp usern container
		User tempUser = null;
		//Result container
		String result = null;
		//Open Hibernate session
		Session session = sessionFactory.openSession();
		//Beginning the transaction
		session.beginTransaction();
		//Trying to fetch user
		tempUser = session.get(User.class, user.getUserName());
		//Adding user
		if(tempUser==null){
			session.persist(user);
			result = "Ok";	
		}else{//If already exist return message
			result = "User is already exist";
		}
		//Close transaction
		session.getTransaction().commit();
		//Close session
		session.close();
		return result;
		
	}
}
