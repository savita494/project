<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body><center><pre>
<h1 align="center"><b>All Products Available</b></h1>
<b><a  href="searchproduct">Search Product</a>     <a   href="addProduct">Add Product </a>     <a   href="ShowCart">Show Cart </a>     <a  href="addtocart">Items for cart</a>    <a   href="showAllProduct">All Products/Update</a>    <a href="logout">LOGOUT</a></b><hr> 
<h1 align="center">${msg}</h1>
<h3 align="right" >${user} <br><br>

</pre>
<h3><center><table border='1'><tr><th>Product Name</th><th>Product Category</th><th>Company Name</th> <th>Quantity</th><th>Price</th><th>Update</th></tr>
<c:forEach var="mdto" items="${mlist}">
<form action="updateProduct" method="post">
<tr>
<input type="hidden" name="pid" value=" ${mdto.getPid() }">
<td><center><input type="text" name="pname" value="${mdto.getPname() }"></center></td>
<td><center> <input type="text" name="pcategory" value="${mdto.getPcategory() }"></center></td>
<td><center><input type="text" name="pcompany"  value="${mdto.getPcompany() }"></center></td>
<td><center><input type="text" name="pquantity" value="${mdto.getPquantity() }"></center></td>
<td><center><input type="text" name="price" value="${mdto.getPrice() }"></center></td> 
<td><center><input type="submit" value="Update"></center></td>
</tr>
</form>
</c:forEach>
</table>
</center></h3>
</body>
</html>
