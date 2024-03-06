<%@page import="java.util.List" %>
<%@page import="com.DAO.UserDAOImpl" %>
<%@page import="com.entity.AddBook" %>
<%@page import="com.DAO.UserDAO" %>
<%@page import="com.entity.User" %>
<!DOCTYPE html>

<html>
<head>
<title>Ebook: Index</title>
<%@include file="all_component/allCss.jsp"%>
<style type="text/css">
.back-img {
	background: url("img/b2.jpeg");
	height: 80vh;
	width: 100%;
	background-repeat: no-repeat;
	background-size: cover;
}

.crd-ho:hover {
	background: #d2d5d9;
}
</style>
</head>
<body style="background-color: #f7f7f7">

<%
User u =(User)session.getAttribute("userDao");

%>
	<%@include file="all_component/navbar.jsp"%>

	<div class="container-fluid back-img">
		<h2 class="text-center text-white">Ebook Management System</h2>
	</div>
	
	

	<!-- Start Recent Book -->


	<div class="container">
		<h3 class="text-center">Recent Book</h3>
		<div class="row">
		
			<%
		UserDAOImpl recentBook_dao = new UserDAOImpl();
		List<AddBook> lists = recentBook_dao.getRecentBook();
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
						<%
						if(u == null){
							%>
							<a href="login.jsp" class="btn btn-danger btn-sm ml-2"><i
								class="fa-solid fa-cart-shopping"></i>Add Cart</a> 
						<% 
						}else{
							%>
							<a href="order?bid=<%=b.getBookId() %> && uid=<%=u.getId() %>" class="btn btn-danger btn-sm ml-2"><i
								class="fa-solid fa-cart-shopping"></i>Add Cart</a> 
						<%
						}
						%>
							
								<a href="viewBookDetails.jsp?bid=<%=b.getBookId() %>" class="btn btn-success btn-sm ml-1">View Details</a>
								 <a href=""class="btn btn-danger btn-sm ml-1"><%=b.getPrice() %></a>
						</div>
					</div>
				</div>
			</div>
			<%
		  }
		%>
		
	
		
		</div>
		<div class="text-center mt-1">
			<a href="recentBook.jsp" class="btn btn-danger btn-sm text-white">View All</a>
		</div>
	</div>

	<!-- End Recent Book -->

	<hr>

	<!-- Start New Book -->

	<div class="container">
		<h3 class="text-center">New Book</h3>
		<div class="row">
		<%
		UserDAOImpl dao = new UserDAOImpl();
		List<AddBook> list = dao.getNewBooks();
		for(AddBook b:list)
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
							<a href="" class="btn btn-danger btn-sm ml-2"><i class="fa-solid fa-cart-shopping"></i>Add Cart</a> <a
								href="viewBookDetails.jsp?bid=<%=b.getBookId() %>" class="btn btn-success btn-sm ml-1">View Details</a> <a
								href="" class="btn btn-danger btn-sm ml-1"><%=b.getPrice() %></a>
						</div>
					</div>
				</div>
			</div>
		
		<%
		  }
		%>
		
		</div>
		<div class="text-center mt-1">
			<a href="newBook.jsp" class="btn btn-danger btn-sm text-white">View All</a>
		</div>
	</div>

	<!-- End New Book -->

	<hr>


	<!-- Start Old Book -->

	<div class="container">
		<h3 class="text-center">Old Book</h3>
		<div class="row">
			<%
		UserDAOImpl oldBok_dao = new UserDAOImpl();
		List<AddBook> old_list = oldBok_dao.getOldBook();
		for(AddBook b:old_list)
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
							<a href="viewBookDetails.jsp?bid=<%=b.getBookId() %>" class="btn btn-success btn-sm ml-5">View Details</a> <a
								href="" class="btn btn-danger btn-sm ml-1"><%=b.getPrice() %></a>
						</div>
					</div>
				</div>
			</div>
        <%
		  }
		%>

		
		
		</div>
		<div class="text-center mt-1">
			<a href="oldBook.jsp" class="btn btn-danger btn-sm text-white">View All</a>
		</div>
	</div>

	<!-- End Old Book -->
	
	<%@include file ="all_component/footer.jsp" %>

</body>
</html>