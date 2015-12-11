package com.MVCApplication.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.MVCApplication.models.Post;
import com.MVCApplication.services.PostService;

@WebServlet("/viewMyPosts")
public class viewMyPostsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Reading session
		HttpSession session = request.getSession();
		String userName = (String)session.getAttribute("userName");

		//If not authentificated redirecting to login page
		if(userName==null){
			response.sendRedirect("login.jsp");
			return;
		} 
		//Fetching list of posts
		List<Post> postsList = PostService.getUserPosts(userName);
		//Passing result
		session.setAttribute("postsList", postsList);
		response.sendRedirect("myposts.jsp");
	}

}
