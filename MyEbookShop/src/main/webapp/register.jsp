<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
	 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	 <%@page isELIgnored="false" %>
	 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ebook Register</title>
<%@include file="all_component/allCss.jsp"%>
</head>
<body style="background-color:#d2d5d9;">


	<%@include file="all_component/navbar.jsp"%>

	<div class="container p-2">
		<div class="row mt-2">
			<div class="col-md-4 offset-md-4">
				<div class="card">
					<div class="card-body">
					<h4 class="text-center">SignUp Now</h4>
					
					<c:if test="${not empty succMsg }">
					<p class="text-center text-success">${ succMsg }</p>
					<c:remove var="succMsg" scope="session"/>
					</c:if>
					<c:if test="${not empty faildMsg }">
					<p class="text-center text-danger">${ faildMsg }</p>
					<c:remove var="faildMsg" scope="session"/>
					</c:if>
					
				

						<form action="RegisterServlet" method="post">
							<div class="form-group">
								<label for="exampleInputEmail1">Full Name</label> <input
									type="text" class="form-control" id="exampleInputEmail1"
									aria-describedby="emailHelp" required="required" name="fname">
							</div>
							<div class="form-group">
								<label for="exampleInputEmail1">Email address</label> <input
									type="email" class="form-control" id="exampleInputEmail1"
									aria-describedby="emailHelp" required="required" name="email">
							</div>
							<div class="form-group">
								<label for="exampleInputPassword1">Password</label> <input
									type="password" class="form-control" id="exampleInputPassword1" required="required" name="password">
							</div>
								<div class="form-group">
								<label for="exampleInputEmail1">Phone Number</label> <input
									type="number" class="form-control" id="exampleInputEmail1"
									aria-describedby="emailHelp" required="required" name="phone">
							</div>
							<div class="form-check">
								<input type="checkbox" class="form-check-input" name="check"
									id="exampleCheck1"> <label class="form-check-label"
									for="exampleCheck1">Agree terms & onditions</label>
							</div>
							<button type="submit" class="btn btn-primary">SignUp</button>
							<a href="login.jsp">Already have Account</a>
						</form>

					</div>
				</div>
			</div>
		</div>
	</div>
	
	<%@include file="all_component/footer.jsp" %>
</body>
</html>