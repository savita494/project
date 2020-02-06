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
<h1>Forget Password</h1>
<form action="forgot" method="post">
<pre>
    Email         :<input type="email" name="email"><br>
 For Security          What is Your first company Name?<br>
Security Answer   :<input type="text" name="seqanswer"><br>
   Password       :<input type="password" name="password"><br>
 Confirm Password :<input type="password" name="cpassword"><br>
                   <input type="submit" value="submit"><br>
        <h4> ${msg } </h4>
        </pre>
</form>
</center>
</body>
</html>