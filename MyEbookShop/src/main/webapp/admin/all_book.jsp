
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.util.List" %>
<%@page import="com.DAO.AdminDAO" %>
<%@page import="com.DAO.AdminDAOImpl" %>
<%@page import="com.entity.AddBook" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	 <%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin: All Books</title>
<%@include file="allCss.jsp" %>
</head>
<body>
<%@include file="navbar.jsp" %>
<h3 class="text-center">Available Books</h3>

<c:if test="${not empty succMsg }">
<p class="text-center text-success">${succMsg}</p>
<c:remove var="succMsg" scope="session"/>
</c:if>
<c:if test="${not empty faildMsg }">
<p class="text-center text-danger">${faildMsg}</p>
<c:remove var="faildMsg" scope="session"/>
</c:if>
<table class="table table-striped">
  <thead class="bg-primary text-white">
    <tr>
     <th scope="col">ID</th>
      <th scope="col">Image</th>
      <th scope="col">Book Name</th>
      <th scope="col">Author</th>
      <th scope="col">Price</th>
      <th scope="col">Categories</th>
      <th scope="col">Status</th>
      <th scope="col">Action</th>
    </tr>
  </thead>
  <tbody>
  
  <%
  AdminDAO dao = new AdminDAOImpl();
  List<AddBook> list = dao.getAllBook();
  for(AddBook b:list)
  {
  %>
	
		  <tr>
		  <td><%=b.getBookId() %></td>
		  <td><img alt="" src="../book/<%=b.getImage()%>" style="width:50px; height:50px;"></td>
		  <td><%=b.getBookName() %></td>
		  <td><%=b.getAuthorName() %></td>
		   <td><%=b.getPrice() %></td>
		  <td><%=b.getBookCategory() %></td>
		  <td>><%=b.getBookStatus() %></td>
		  <td>
		  <a href="editBook.jsp?id=<%=b.getBookId() %>" class="btn btn-sm btn-primary">Edit </a>
		   <a href="#" class="btn btn-sm btn-danger">Delete </a>
		  </td>
		</tr>

	<%  
  }
  %>
   
  </tbody>
</table>
<div style="margin-top:80px;">
<%@include file="footer.jsp" %>
</div>
</body>
</html>