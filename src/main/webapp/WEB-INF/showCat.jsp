  
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
			<h1>${cat.name}</h1>
			<table class="table">
                   <tr>
                       <th>Products</th>
                   </tr>
                   <c:forEach items="${cat.products}" var="product">
                      <tr>
                          <td>${product.name}</td>
                      </tr>
                   </c:forEach>
                </table>
                <div class="col-sm-3">
	           <form action="/add/product" method="post">
                   <div class="form-group">
                       <label>Genre</label>
                       <select name="productId" class="form-control">
                            <c:forEach items="${allProducts}" var="product">
                                <option value="${product.id}">${product.name}</option>
                            </c:forEach>
                       </select>
                       <input type="hidden" name="catId" value="${cat.id}"/>
                   </div>
                   <input type="submit" value="Add product to category" class="btn btn-primary" />
	           </form>
	       </div>
		</div>
	</div>
</body>
</html>