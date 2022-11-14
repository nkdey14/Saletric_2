<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search Bill</title>
</head>
<body>
<div align="center">
	<h3>Search Bill</h3><br>
	
	<form action="searchBillDetails" method="post">
		Enter Mob no. <input type="text" name="mobile">
		<input type="submit" value="Search">
	</form>
	${msg}
	<br>
	<a href="viewAllBills"><input type="button" value="Back"></a>
</div>
<br>
</body>
</html>
<%@ include file="footer.jsp" %>