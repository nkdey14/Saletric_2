<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Generate Bill</title>
</head>
<body>
	<div align="center">
	<h3>Generate Bill</h3><br>
	
		<form action="saveBill" method="post">
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
					<td>Choose a Product</td>
					<td><select name="product">
						  <option value="Hp Laptop">Hp Laptop</option>
						  <option value="Lenovo Laptop">Lenovo Laptop</option>
						  <option value="Dell Laptop">Dell Laptop</option>
						  <option value="Asus Laptop">Asus Laptop</option>
						  <option value="Acer Laptop">Acer Laptop</option>
						</select>
					</td>
				</tr>
				<tr>
					<td>Quantity</td>
					<td><input type="text" name="quantity" placeholder="Enter the Quantity"></td>
				</tr>
				<tr>
					<td>Price</td>
					<td><input type="text" name="price" placeholder="Enter the Price"></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="Generate Bill"></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>
<%@ include file="footer.jsp" %>