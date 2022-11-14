<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Contact Details</title>
</head>
<body>
<div align="center">
${msg}
<br><br>
<h3>Contact Details</h3><br>
	<table border='1' cellspacing='1' cellpadding='8'>
		<tr>
			<th>First Name</th>
			<td>${contact.firstName}</td>
		</tr>
		<tr>
			<th>Last Name</th>
			<td>${contact.lastName}</td>
		</tr>
		<tr>
			<th>Email Id</th>
			<td>${contact.email}</td>
		</tr>
		<tr>
			<th>Mob no.</th>
			<td>${contact.mobile}</td>
		</tr>
		<tr>
			<th>City</th>
			<td>${contact.city}</td>
		</tr>
		<tr>
			<th>Source</th>
			<td>${contact.source}</td>
		</tr>
	</table>
	<br>
	<a href="updateContact?id=${contact.id}"><input type="button" value="Edit"></a>
	<a href="deleteContact?id=${contact.id}"><input type="button" value="Delete"></a>
	<a href="sendEmail?email=${contact.email}"><input type="button" value="Send Email"></a>
	<td><a href="generateBill?id=${contact.id}"><input type="button" value="Generate Bill"></a></td>
	<br><br>
	<a href="viewAllContacts"><input type="button" value="Back"></a>
	<br>
</div>
</body>
</html>
<%@ include file="footer.jsp" %>