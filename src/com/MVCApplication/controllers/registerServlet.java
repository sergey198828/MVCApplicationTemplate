package com.MVCApplication.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.MVCApplication.models.Address;
import com.MVCApplication.models.Credentials;
import com.MVCApplication.models.User;
import com.MVCApplication.services.UserService;

@WebServlet("/registerController")
public class registerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Reading and verifying parameters
		StringBuilder errors = new StringBuilder("");
		//Username
		String userName = request.getParameter("userName");
		//If less than 5 figures or inappropriate symbols return error
		if(!userName.matches("[A-Za-z0-9]{5,}")){
			errors.append("English letters and digits minimum 5 is allowed in Username, try again.<br>");
			}
		//Password
		String password = request.getParameter("password");
		String passwordAgain = request.getParameter("passwordAgain");
		//If passwords not match return back with appropriate message
		if(!password.equals(passwordAgain)){
			errors.append("Passwords not matches, try again.<br>");
			}
		//If less than 5 figures or inappropriate symbols return error
		if(!password.matches("[A-Za-z0-9]{8,}")){
			errors.append("English letters and figures minimum 8 is allowed in password, try again.<br>");
			}		
		//Birth
		String birth = request.getParameter("birth");
		if(!birth.matches("[0-9]{2}.[0-9]{2}.[0-9]{4}")){
			errors.append("Incorrect birth date format<br>");
			}	
		//Name
		String name = request.getParameter("name");
		if(!name.matches("[A-Za-z]{1,}")){
			errors.append("Incorrect name<br>");
			}
		//Surname
		String surname = request.getParameter("surname");
		if(!surname.matches("[A-Za-z]{1,}")){
			errors.append("Incorrect surname<br>");
			}
		//Nationality
		String nationality = request.getParameter("nationality");
		if(!nationality.matches("[A-Za-z]{1,}")){
			errors.append("Incorrect nationality<br>");
			}
		//City
		String city = request.getParameter("city");
		if(!city.matches("[A-Za-z]{1,}")){
			errors.append("Incorrect city<br>");
			}
		//Country
		String country = request.getParameter("country");
		if(!country.matches("[A-Za-z]{1,}")){
			errors.append("Incorrect country<br>");
			}		
		//Index
		String index = request.getParameter("index");
		if(!index.matches("[0-9]{4,}")){
			errors.append("Incorrect index<br>");
			}
		//Location
		String location = request.getParameter("location");
		if(!location.matches("[A-Za-z]{1,}")){
			errors.append("Incorrect location<br>");
			}
		//If were errors return
		if(!errors.equals("")){
			response.sendRedirect("register.jsp?msg="+errors);
			return;
		}
		
		
		//Creating user container using parameters
		User user = new User();		
		user.setUserName(userName);
		user.setPasswordHash(password.hashCode());
		
		Credentials credentials = new Credentials();
		credentials.setBirth(birth);
		credentials.setName(name);
		credentials.setSurname(surname);
		credentials.setNationality(nationality);
		user.setCredentials(credentials);
		
		Address address = new Address();
		address.setCity(city);
		address.setCountry(country);
		address.setIndex(Integer.parseInt(index));
		address.setLocation(location);
		List<Address> addresses = new ArrayList<Address>();
		addresses.add(address);
		user.setAddresses(addresses);
		
		//Run register
		String result=UserService.register(user);
		if(result.equals("Ok")){
			response.sendRedirect("login.jsp?msg=User successful added");
		}else{
			response.sendRedirect("register.jsp?msg=" + result);
		}
		
	}

}
