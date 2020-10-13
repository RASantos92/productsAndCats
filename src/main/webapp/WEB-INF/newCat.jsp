  
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="java.io.*,java.util.*"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Products and Categories</title>
<link rel="stylesheet"
	href="/webjars/bootstrap/4.5.2/css/bootstrap.min.css" />
<script src="/webjars/jquery/3.5.1/jquery.min.js"></script>
<script src="/webjars/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>

<body style="background-color: dark">
	<div class="container">
		<div class="col mx-auto text-center">
			<h1>New Categories</h1> 
			<form:form action="/cat/new" method="post" modelAttribute="newCat">
                   <div class="form-group">
                       <label>Category Name</label>
                       <form:input path="name" class="form-control" />
                       <form:errors path="name" class="text-danger" />
                   </div>
                   <input type="submit" value="Add Product" class="btn btn-primary" />
               </form:form>
				
		</div>
	</div>
</body>
</html>