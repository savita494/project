<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body >
<h1 align="center" font-size: 50px;"><b>Welcome To Stock Management App</b></h1>
<pre>
<center>
<b><a  href="searchproduct">Search Product</a>     <a   href="addProduct">Add Product </a>     <a   href="ShowCart">Show Cart </a>     <a  href="addtocart">Items for cart</a>    <a   href="showAllProduct">All Products/Update</a>    <a href="logout">LOGOUT</a></b><hr> 
<h1 align="center">${msg}</h1>
<h3 align="right" >${user} <br><br>
</pre>
</center>

</body>
</html>