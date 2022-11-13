<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>lead Details</title>
</head>
<body>
<div align="center">
${msg}
<br><br>
<h3>Lead Details</h3><br>
	<table border='1' cellspacing='1' cellpadding='8'>
		<tr>
			<th>First Name</th>
			<td>${lead.firstName}</td>
		</tr>
		<tr>
			<th>Last Name</th>
			<td>${lead.lastName}</td>
		</tr>
		<tr>
			<th>Email Id</th>
			<td>${lead.email}</td>
		</tr>
		<tr>
			<th>Mob no.</th>
			<td>${lead.mobile}</td>
		</tr>
		<tr>
			<th>City</th>
			<td>${lead.city}</td>
		</tr>
		<tr>
			<th>Source</th>
			<td>${lead.source}</td>
		</tr>
	</table>
	<br>
	<a href="updateLead?id=${lead.id}"><input type="button" value="Edit"></a>
	<a href="deleteLead?id=${lead.id}"><input type="button" value="Delete"></a>
	<a href="sendEmail?email=${lead.email}"><input type="button" value="Send Email"></a>
	<a href="convertLead?id=${lead.id}"><input type="button" value="Convert"></a>
	<br><br>
	<a href="viewAllLeads"><input type="button" value="Back"></a>
	<br>
</div>
</body>
</html>
<%@ include file="footer.jsp" %>