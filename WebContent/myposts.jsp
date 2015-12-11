<%@page import="com.MVCApplication.models.Post"%>
<%@page import="java.util.List"%>
<%@include file="header.jsp"%>
<%
List<Post> postsList = (List<Post>)session.getAttribute("postsList");
out.println("<table>");
out.println("<tr> <td>ID</td> <td>Creator</td> <td>Title</td> <td>Text</td> </tr>");
for(Post post:postsList){
	out.println("<tr>");
	out.println("<td>" + post.getPostId() + "</td>" + "<td>" + post.getCreator() + "</td>" + "<td>" + post.getTitle() + "</td>" + 
	"<td>" + post.getText() + "</td>");
	out.println("</tr>");
}
out.println("</table>");
%>