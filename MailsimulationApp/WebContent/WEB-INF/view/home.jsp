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
<h1>Welcome To Home Page Of Mail Simulation App ${ sdto.getUserName() }</h1>
<pre><h4><a href="compose">Compose</a>   <a href="inbox">Inbox</a>   <a href="sent">Sent</a>   <a href="draft">Draft</a>  <a href="change">ChangePassword</a> <a href="deleteMail">DeletedMail</a>   <a href="logout">LogOut</a> </h4><hr>
</pre>
<h4>${m }<br></h4>
<h4>${msg }<br></h4>
</center>
</body>
</html>