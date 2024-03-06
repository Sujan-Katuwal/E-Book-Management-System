<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	 <%@page isELIgnored="false" %>
	 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Book Page</title>
<%@include file="allCss.jsp" %>
</head>
<body style="background-color: #f0f1f2;">
<%@include file="navbar.jsp" %>

<div class="container">
<div class="row">
<div class="col-md-4 offset-md-4">
<div class="card">
<div class="card-body">
<h4 class="text-center">Add Books</h4>

<c:if test="${not empty succMsg }">
<p class="text-center text-success">${succMsg}</p>
<c:remove var="succMsg" scope="session"/>
</c:if>
<c:if test="${not empty faildMsg }">
<p class="text-center text-danger">${faildMsg}</p>
<c:remove var="faildMsg" scope="session"/>
</c:if>


<form action="../AddBookServlet" method="post" enctype="multipart/form-data">
  <div class="form-group">
    <label for="exampleInputEmail1">Book Name</label>
    <input type="text" name="bname" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
  </div>
    <div class="form-group">
    <label for="exampleInputEmail1">Author Name</label>
    <input type="text" name="author" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
  </div>
    <div class="form-group">
    <label for="exampleInputEmail1">Price</label>
    <input type="number" name="price" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
  </div>
  
  
<div class="form-groupl">
<label for="inputState">Book Categories</label>
<select id="inputState" name="categories" class="form-control">
  <option selected>--Select---</option>
  <option value="New">New</option>
  <option value="Old">Old</option>
  </select>
</div>

<div class="form-groupl">
<label for="inputState">Book Status</label>
<select id="inputState" name="status" class="form-control">
  <option selected>--Select---</option>
  <option value="Active">Active</option>
  <option value="Inactive">Inactive</option>
  </select>
</div>

  <div class="form-group">
    <label for="exampleFormControlFile1">Choose file</label>
    <input type="file" name="bimg" class="form-control-file" id="exampleFormControlFile1">
  </div>
  <button type="submit" class="btn btn-primary">Add</button>
  

</form>


</div>
</div>
</div>
</div>
</div>
<div style="margin-top:80px;">
<%@include file="footer.jsp" %>
</div>
</body>
</html>