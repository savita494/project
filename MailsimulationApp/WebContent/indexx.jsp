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
<h1>Welcome To Mail Simulation App</h1>
<h2>Login To Mail Simulation App</h2>
<h4>${m }</h4>
<h4>${masg }</h4>
<h4>${msg }</h4><br>
<form action="login" method="post">
<pre><b>
Email Id:  <input type="email" name="email"><br>
Password:  <input type="password" name="password"><br>
                           <input type="submit" value="login"><br>
               <a href="fpass">Forget Password</a>  <a href="reg">Register</a>
</pre></b>
</form>
</center>
</body>
</html>