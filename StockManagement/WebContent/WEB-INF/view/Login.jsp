<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>
<h1>Admin Login Page</h1>
<!-- <fieldset style="width:350px;">
 --><form action="adminLogin"  method="post" >
<pre><h4>${msg}</h4>

<h3 ><b>
Email Id:  <input type="email" name="email"  required="required"><br>
Password:  <input type="password" name="password"  required="required"><br><br>
            <input  type="submit" value="Login">    <a style="color: blue;" href="Register">Register</a></b></h3> </b></h3> 
</pre>
</form>
<!-- </fieldset>
 --><br><br>
</center>
</body>
</html>