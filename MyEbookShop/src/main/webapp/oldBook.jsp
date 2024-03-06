<%@page import="java.util.List" %>
<%@page import="com.DAO.UserDAOImpl" %>
<%@page import="com.entity.AddBook" %>
<%@page import="com.DAO.UserDAO" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Book</title>
<%@include file="all_component/allCss.jsp"%>
</head>
<body>
<%@include file="all_component/navbar.jsp"%>

<div class="container">
<h3 class="text-center">Old Books</h3>
<div class="row">

	
			<%
		UserDAOImpl oldBook_dao = new UserDAOImpl();
		List<AddBook> lists = oldBook_dao.getAllOldBook();
		for(AddBook b:lists)
		  {
		  %>
			<div class="col-md-3">
				<div class="card crd-ho">
					<div class="card-body text-center">
						<img alt="" src="book/<%=b.getImage() %>"
							style="width: 150px; height: 200px;" class="img-thumblin">
						<p><%=b.getBookName() %></p>
						<p><%=b.getAuthorName() %></p>
						<p>Categories: <%=b.getBookCategory()%></p>
						<div class="row">
							<a href="" class="btn btn-danger btn-sm ml-2"><i
								class="fa-solid fa-cart-shopping"></i>Add Cart</a> <a href="viewBookDetails.jsp?bid=<%=b.getBookId() %>"
								class="btn btn-success btn-sm ml-1">View Details</a> <a href=""
								class="btn btn-danger btn-sm ml-1"><%=b.getPrice() %></a>
						</div>
					</div>
				</div>
			</div>
			<%
		  }
		%>
		
</div>

</div>


	<%@include file ="all_component/footer.jsp" %>
</body>
</html>