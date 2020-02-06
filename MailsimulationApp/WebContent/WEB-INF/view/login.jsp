<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>
<h1>Welcome To The Login Page</h1>
<h4>${m }</h4>
<h4>${masg }</h4>
<h4>${msg }</h4><br>
<form action="login" method="post">
<pre>
<b>
Email      <input type="email" name="email"><br>
Password   <input type="password" name="password"><br>
           <input type="submit" value="login"><br>
               <a href="fpass">forgot password</a> | <a href="reg">Register</a>
 <b>
</pre>
</form>
</center>
</body>
</html>