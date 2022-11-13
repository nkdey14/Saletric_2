<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Compose Email</title>
</head>
<body>
<div align="center">
${msg}
<br><br>
	<h3>New Email</h3><br>
	<form action="triggerEmail" method="post">
		<table>
			<tr>
				<td>To</td>
				<td><input type="email" name="email" value="${email}"></td>
			</tr>
			<tr>
				<td>Subject</td>
				<td><input type="text" name="subject"></td>
			</tr>
			<tr>
				<td>Message</td>
				<td><textarea name="content" rows="10" cols="50"></textarea></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Send"></td>
			</tr>
		</table>
	</form>
</div>
<br>
</body>
</html>
<%@ include file="footer.jsp" %>