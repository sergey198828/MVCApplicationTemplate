<%@include file="header.jsp"%>
<body>


<%
//Reading session
String userName=(String)session.getAttribute("userName");

//Reading parameter
String message=(String)request.getParameter("msg");

//If authentificated already redirecting to index
if(userName!=null){
	response.sendRedirect("index.jsp");
}

//Otherwize printing authentification request
out.println("<p>Authentification required</p>");
//Printing authentification message
if(message!=null){
out.println("<p>" + message + "</p>");
}
%>
<form action="loginController" method="post">
  <p>Username:</p>
  <p><input type="text" name="userName"/></p>
  <p>Password:</p>
  <p><input type="password" name="password"/></p>
  <p><input type="submit" title="Login"/></p>
</form>
<a href="register.jsp">Register new account</a>
</body>
</html>