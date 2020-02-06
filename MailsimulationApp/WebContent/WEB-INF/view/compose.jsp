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
<h1>Compose mail</h1>
<div align="center">
<h5><b><a href="inbox">Inbox</a>&nbsp
<a href="sent">Sent</a>&nbsp
<a href="draft">Draft</a>&nbsp
<a href="compose">Compose</a>&nbsp
<a href="change">ChangePassword</a>&nbsp
<a href="deleteMail">DeletedMail</a>&nbsp
<a href="logout">LogOut</a></b></h5>
</div>
<hr>
<form action="comp">
<pre>
from: ${msg }<br>
to:   <input type="text" name="to"><br>
sub:  <input type="text" name="sub"><br>
Message: <input type="text" name="body"><br>
     <input type="submit" value="sent"><br>
</pre>
</form>
</center>
</body>
</html>