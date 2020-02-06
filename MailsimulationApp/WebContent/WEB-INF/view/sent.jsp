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
<h1>Sent Mail</h1>
<div align="center">
<h5><b><a href="inbox">Inbox</a>&nbsp
<a href="sent">Sent</a>&nbsp
<a href="draft">Draft</a>&nbsp
<a href="compose">Compose</a>&nbsp
<a href="change">ChangePassword</a>&nbsp
<a href="deleteMail">DeletedMail</a>&nbsp
<a href="logout">LogOut</a></b></h5>
</div>
<h3><table border='1'><tr><th>To Mail Id</th><th>Messages</th><th>Action</th></tr>
<c:forEach var="dto" items="${list}">
<tr><td><center>${dto.getToId() }</center></td><td><center><a href="message1?id=${dto.getId() }">${dto.getMessage() } </a></center></td><td><a href="delete?id=+${dto.getId() }+">delete</a></td></tr><br>
</c:forEach>
</center>
</body>
</html>