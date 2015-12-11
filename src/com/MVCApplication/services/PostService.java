package com.MVCApplication.services;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.MVCApplication.models.Post;

public class PostService {
	public static SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	
	public static List<Post> getUserPosts(String userName){
		//Result container
		List<Post> result = null;
		//Creating Hibernate session
		Session session = sessionFactory.openSession();
		//Beginning the transaction
		session.beginTransaction();
		//Creating query
		Query query = session.getNamedQuery("Posts.byCreator");
		query.setString("name", userName);
		//Fetching result
		result = (List<Post>) query.list();
		//Closing transaction		
		session.getTransaction().commit();
		//Closing session
		session.close();
		//Return result
		return result;
	}

}
