<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search Contact</title>
</head>
<body>
<div align="center">
	<h3>Search Contact</h3><br>
	
	<form action="searchContact" method="post">
		Enter Mob no. <input type="text" name="mobile">
		<input type="submit" value="Search">
	</form>
	<br>
	${msg}
</div>
<br>
</body>
</html>
<%@ include file="footer.jsp" %>