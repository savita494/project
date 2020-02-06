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
<h1>Change Password</h1>
<div align="center">
<h5><b><a href="inbox">Inbox</a>&nbsp
<a href="sent">Sent</a>&nbsp
<a href="draft">Draft</a>&nbsp
<a href="compose">Compose</a>&nbsp
<a href="change">ChangePassword</a>&nbsp
<a href="deleteMail">DeletedMail</a>&nbsp
<a href="logout">LogOut</a></b>&nbsp</h5>
</div>
<hr>
<form action="chang" method="post">
<pre>
   Password       :<input type="password" name="password"><br>
 Confirm Password :<input type="password" name="cpassword"><br>
                   <input type="submit" value="submit">
        <h4> ${msg } </h4>
        </pre>
</form>
</center>
</body>
</html>