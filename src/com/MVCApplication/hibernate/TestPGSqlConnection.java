package com.MVCApplication.hibernate;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/TestPGSqlConnection")
public class TestPGSqlConnection extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			out.println("<p>Deriver registed issue happened</p>");
			out.println("<p>"+e+"</p>");
		}
		
		Connection connection = null;
		try {
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/mydbtest","postgres", "sergey88");
		} catch (SQLException e) {
			out.println("<p>Connection creation issues happened</p>");
			out.println("<p>"+e+"</p>");
		}
		
		Statement statement = null;
		try {
			statement = connection.createStatement();
		} catch (SQLException e) {
			out.println("<p>Statement creation issues happened</p>");
			out.println("<p>"+e+"</p>");
		}
		
		ResultSet res;
		try {
			res = statement.executeQuery("Select * from users");
			while(res.next()){
				out.println("<p>" + res.getInt("id") + res.getString("username") + res.getString("password") + "</p>");
			}
		} catch (SQLException e) {
			out.println("<p>Query execution issues happened</p>");
			out.println("<p>"+e+"</p>");
		}
		
		
		try {
			connection.close();
		} catch (SQLException e) {
			out.println("<p>Connection closure issue happened</p>");
			out.println("<p>"+e+"</p>");
		}
	}

}
