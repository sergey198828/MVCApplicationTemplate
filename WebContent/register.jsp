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
out.println("Please provide your details");
//Printing registration message
if(message!=null){
out.println("<div class='errors'><p>" + message + "</p></div>");
}
%>
<form action="registerController" method="post">
  
  <p>Username:</p>
  <p><input type="text" name="userName"/></p>
  
  <p>Password:</p>
  <p><input type="password" name="password"/></p>
  <p>Password once again:</p>
  <p><input type="password" name="passwordAgain"/></p>
  
  <p>Credentials:</p>
  <p>Name:</p>
  <p><input type="text" name="name"/></p>
  <p>Surname:</p>
  <p><input type="text" name="surname"/></p>
  <p>Birth:</p>
  <p><input type="text" name="birth"/></p>
  <p>Nationality:</p>
  <p><input type="text" name="nationality"/></p>
  
  <p>Address:</p>
  <p>Index:</p>
  <p><input type="text" name="index"/></p>
  <p>Country:</p>
  <p><input type="text" name="country"/></p>
  <p>City:</p>
  <p><input type="text" name="city"/></p>
  <p>Location:</p>
  <p><input type="text" name="location"/></p>  
   
  <p><input type="submit" title="Register"></p>
</form>
<a href="login.jsp">Login</a>
</body>
</html>