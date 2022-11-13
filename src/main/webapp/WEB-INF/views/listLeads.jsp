<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ include file="menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List of Leads</title>
</head>
<body>
<div align="center">
<a href="viewLeadPage"><input type="button" value="New Lead"></a>
<br><br>
	<h3>List of Leads</h3><br>
	
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
			<th>Convert</th>
		</tr>
		
		<c:forEach var="lead" items="${leads}">
		
		<tr>
			<td>${lead.id}</td>
			<td><a href="leadInfoPage?id=${lead.id}">${lead.firstName}</a></td>
			<td>${lead.lastName}</td>
			<td>${lead.email}</td>
			<td>${lead.mobile}</td>
			<td>${lead.city}</td>
			<td>${lead.source}</td>
			<td><a href="updateLead?id=${lead.id}"><input type="button" value="Edit"></a></td>
			<td><a href="deleteLead?id=${lead.id}"><input type="button" value="Delete"></a></td>
			<td><a href="sendEmail?email=${lead.email}"><input type="button" value="Send Email"></a></td>
			<td><a href="convertLead?id=${lead.id}"><input type="button" value="Convert"></a></td>
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