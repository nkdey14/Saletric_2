<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ include file="menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List of Contacts</title>
</head>
<body>
<div align="center">
<a href="viewContactPage"><input type="button" value="Search"></a>
<br><br>
	<h3>List of Contacts</h3><br>
	
	<table border='1' cellspacing='1' cellpadding='8'>
		<tr>
			<th>Id</th>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Email Id</th>
			<th>Mob no.</th>
			<th>City</th>
			<th>Source</th>
			<th>Edit</th>
			<th>Delete</th>
			<th>Send Email</th>
		</tr>
		
		<c:forEach var="contact" items="${contacts}">
		
		<tr>
			<td>${contact.id}</td>
			<td><a href="contactInfoPage?id=${contact.id}">${contact.firstName}</a></td>
			<td>${contact.lastName}</td>
			<td>${contact.email}</td>
			<td>${contact.mobile}</td>
			<td>${contact.city}</td>
			<td>${contact.source}</td>
			<td><a href="updateContact?id=${contact.id}"><input type="button" value="Edit"></a></td>
			<td><a href="deleteContact?id=${contact.id}"><input type="button" value="Delete"></a></td>
			<td><a href="sendEmail?email=${contact.email}"><input type="button" value="Send Email"></a></td>
		</tr>
		
		</c:forEach>
	</table>
	<br>
	${msg}
</div>
<br>
</body>
</html>
<%@ include file="footer.jsp" %>