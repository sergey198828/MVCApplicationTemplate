<%@include file="header.jsp"%>
<%
//Reading session
String userName = (String)session.getAttribute("userName");

//If not authentificated redirecting to login page
if(userName==null){
	response.sendRedirect("login.jsp");
}
//Welcome messege
out.println("<p>Hello " + userName + " <a href=\"loginController?logoff=true\">Logoff</a></p>");
//Printing content
%>
<a href="viewMyPosts">My posts</a>
<body>

</body>
</html>