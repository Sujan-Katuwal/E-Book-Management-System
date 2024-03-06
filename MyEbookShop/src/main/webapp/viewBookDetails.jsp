<%@page import="com.DAO.UserDAOImpl" %>
<%@page import="com.DAO.UserDAO" %>
<%@page import="com.entity.AddBook" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Book Details</title>
<%@include file="all_component/allCss.jsp"%>
</head>
<body>
	<%@include file="all_component/navbar.jsp"%>
	
	<%
	int bid = Integer.parseInt(request.getParameter("bid"));
	UserDAOImpl dao = new UserDAOImpl();
	AddBook b = dao.getBookById(bid);
	%>
	
	<div class="container p-5">
	<div class="row">
	<div class="col md-6 text-center p-5 border bg-white">
	<img alt="" src="book/<%=b.getImage() %>" 
	style="height:200px; width:150px;"><br>
	<h5><%=b.getBookName() %></h5>
	<h5><%=b.getAuthorName() %> </h5>
	<h5><%=b.getBookCategory() %></h5>
	</div>
	
	<div class="col md-6 text-center p-5 border bg-white">
	<h3 class="text-center p-3"><%=b.getBookName() %></h3>
	
	<%
	if("Old".equals(b.getBookCategory())){%>
		
		<h4 classs="text-primary">Out Of Stock</h4>
   <%
	}
	%>
	<div class="row">
	<div class="col-md-4 text-success text-center p-2"><%=b.getAuthorName() %> </div>
	<div class="col-md-4 text-success text-center p-2"><%=b.getBookCategory() %></div>
	</div>
	<%
	if("Old".equals(b.getBookCategory())){%>
		<div class="text-center p-3">
	<a href="index.jsp" class="btn btn-primary"><i class="fa-solid fa-cart-shopping"></i>Continue Shopping </a>
	<a href="" class="btn btn-danger"><i class="fa-solid fa-rupee-sign"></i><%=b.getPrice() %></a>
	</div>
	<%
	}else{
	%>
	
	<div class="text-center p-3">
	<a href="addToCart.jsp" class="btn btn-primary"><i class="fa-solid fa-cart-shopping"></i>Add to Cart</a>
	<a href="" class="btn btn-danger"><i class="fa-solid fa-rupee-sign"></i><%=b.getPrice() %></a>
	</div>
	<%
	}%>
	</div>
	
	</div>
	</div>
	
		<%@include file ="all_component/footer.jsp" %>
</body>
</html>