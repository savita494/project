<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>

<body>
<center>
<pre>
<h1>Product Data Store Page</h1>
<b><a  href="searchproduct">Search Product</a>     <a   href="addProduct">Add Product </a>     <a   href="ShowCart">Show Cart </a>     <a  href="addtocart">Items for cart</a>    <a   href="showAllProduct">All Products/Update</a>    <a href="logout">LOGOUT</a></b><hr> 
<h3 align="right" >${user} <br><br>
</center></pre>
<h4 align="center">${msg }</h4>
<pre><center><b>
<form action="regProductt"  method="post" >
  Name:	   	    <input style="width: 200px" type="text" name="pname"  required="required" ><br>
  
Category:	    <input style="width: 200px" type="text" name="pcategory"   required="required"><br>

Company: 	    <input style="width: 200px" type="text" name="pcompany"  required="required"><br>

Quantity: 	    <input style="width: 200px" type="text" name="pquantity"  required="required"><br>

  Price:	    <input style="width: 200px" type="number" name="price"  required="required"><br><br>
                       <input type="submit" value="Add Product">    
 </b></h3> 
</form>
</pre>

</center>
</body>
</html> 