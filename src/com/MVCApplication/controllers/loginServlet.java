package com.MVCApplication.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.MVCApplication.services.UserService;

@WebServlet("/loginController")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Reading parameters
		String logoff = request.getParameter("logoff");
		//If logoff request
		if(logoff!=null)
		if(logoff.equals("true")){
			request.getSession().setAttribute("userName", null);
		}
		response.sendRedirect("login.jsp");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Reading parameters
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		//If authentification successful redirecting to index, otherwise to login
		String result = UserService.authentificate(userName, password.hashCode());
		if(result.equals("Ok")){
			request.getSession().setAttribute("userName", userName);
			response.sendRedirect("index.jsp");
		}else{
			response.sendRedirect("login.jsp?msg=" + result);
		}
			
	}

}
