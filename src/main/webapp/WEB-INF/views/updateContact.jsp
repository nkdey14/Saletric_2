<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Contact Details</title>
</head>
<body>
	<div align="center">
	<h3>Update Contact Details</h3><br>
		<form action="updateContactInfo" method="post">
			<table>
				<tr>
					<td><input type="hidden" name="id" value="${contact.id}"></td>
				</tr>
				<tr>
					<td>First Name</td>
					<td><input type="text" name="firstName" value="${contact.firstName}"></td>
				</tr>
				<tr>
					<td>Last Name</td>
					<td><input type="text" name="lastName" value="${contact.lastName}"></td>
				</tr>
				<tr>
					<td>Email Id</td>
					<td><input type="text" name="email" value="${contact.email}"></td>
				</tr>
				<tr>
					<td>Mob no.</td>
					<td><input type="text" name="mobile" value="${contact.mobile}"></td>
				</tr>
				<tr>
					<td>City</td>
					<td><input type="text" name="city" value="${contact.city}"></td>
				</tr>
				<tr>
					<td>Source</td>
					<td><select name="source">
						  <option value="Website">Website</option>
						  <option value="Newspaper">Newspaper</option>
						  <option value="Webinar">Webinar</option>
						  <option value="TV Ads">TV Ads</option>
						</select>
					</td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="Update"></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>
<%@ include file="footer.jsp" %>