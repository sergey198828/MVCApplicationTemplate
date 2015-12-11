package com.MVCApplication.hibernate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.MVCApplication.models.*;
import com.MVCApplication.services.PostService;

public class TestHibernate {

	public static void main(String[] args) {
		PostService ps = new PostService();
		System.out.println(ps.getUserPosts("kiyanser"));
		
		/*
		//User1--------------------------------------------------
		User user1 = new User();
		
		user1.setUserName("kiyanser");
		
		user1.setPasswordHash("qwerty".hashCode());
		
		Credentials credentials1 = new Credentials();
		credentials1.setBirth("1988");
		credentials1.setName("Sergey");
		credentials1.setSurname("Kiyan");
		credentials1.setNationality("Russian");
		user1.setCredentials(credentials1);
		
		Address address1 = new Address();
		address1.setCity("Kazan");
		address1.setCountry("Russia");
		address1.setIndex(420075);
		address1.setLocation("Vyaemskaya 26-46");
		Address address2 = new Address();
		address2.setCity("Stupino");
		address2.setCountry("Russia");
		address2.setIndex(142800);
		address2.setLocation("Pushkina 24/2 69");
		List<Address> addresses1 = new ArrayList<Address>();
		addresses1.add(address1);
		addresses1.add(address2);
		user1.setAddresses(addresses1);
		//User2--------------------------------------------------
		User user2 = new User();
		
		user2.setUserName("lebedtat");
		
		user2.setPasswordHash("asdfgh".hashCode());
		
		Credentials credentials2 = new Credentials();
		credentials2.setBirth("1987");
		credentials2.setName("Tatyana");
		credentials2.setSurname("Lebedeva");
		credentials2.setNationality("Russian");
		user2.setCredentials(credentials2);
		
		Address address3 = new Address();
		address3.setCity("Novosibirsk");
		address3.setCountry("Russia");
		address3.setIndex(123000);
		address3.setLocation("Some Street 12-18");
		Address address4 = new Address();
		address4.setCity("Stupino");
		address4.setCountry("Russia");
		address4.setIndex(142800);
		address4.setLocation("Pushkina 24/2 69");
		List<Address> addresses2 = new ArrayList<Address>();
		addresses2.add(address3);
		addresses2.add(address4);
		user2.setAddresses(addresses2);		
		//User3--------------------------------------------------
		User user3 = new User();		
		
		user3.setUserName("bartobar");
		
		user3.setPasswordHash("zxcvbnm".hashCode());
		
		Credentials credentials3 = new Credentials();
		credentials3.setBirth("1980");
		credentials3.setName("Bartek");
		credentials3.setSurname("Bartoszewski");
		credentials3.setNationality("Poland");
		user3.setCredentials(credentials3);
		
		Address address5 = new Address();
		address5.setCity("Sochachev");
		address5.setCountry("Poland");
		address5.setIndex(77770000);
		address5.setLocation("Some Street 15-20");
		Address address6 = new Address();
		address6.setCity("Stupino");
		address6.setCountry("Russia");
		address6.setIndex(142800);
		address6.setLocation("Pushkina 24/2 30");
		List<Address> addresses3 = new ArrayList<Address>();
		addresses3.add(address5);
		addresses3.add(address6);
		user3.setAddresses(addresses3);	
		//Friendship
		user1.getFriends().add(user2);
		user1.getFriends().add(user3);
		//Post
		Post post1 = new Post();
		post1.setCreator(user1);
		user1.getPosts().add(post1);
		post1.getModifiers().put(user2, new Date());
		post1.getModifiers().put(user3, new Date());
		post1.setText("Some long long long message.");
		post1.setTitle("First post.");
		//NewsPost
		NewsPost newsPost1 = new NewsPost();
		newsPost1.setCreator(user2);
		user2.getPosts().add(newsPost1);
		newsPost1.getModifiers().put(user1, new Date());
		newsPost1.getModifiers().put(user3, new Date());
		newsPost1.setText("Some very awesome news!");
		newsPost1.setTitle("First news");
		newsPost1.setAgency(NewsAgency.CNN);
		//Writing DB
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.persist(user1);
		session.persist(user2);
		session.persist(user3);
		session.getTransaction().commit();
		session.close();
		*/
		/*
		User user =new User();
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		user = (User) session.get(User.class, "kiyanser");
		user.getCredentials().setBirth("1987");
		//user.getAddresses().remove(new Address(142801,"Russia","Stupino","Turgeneva 11-12"));
		session.delete(user);
		session.getTransaction().commit();
		session.close();
		*/
	}

}
