<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Page</title>
<link rel="stylesheet" href="CSS/tableStyle.css">
</head>
<body>

	<h1>Admin Page</h1>
	<table class="simple-little-table">
		<tr>
			<td>PRODUCT</td>
			<td>TITLE</td>
			<td>MANUFANTURER</td>
			<td>MODEL</td>
			<td>PRICE</td>
			<td>AMOUNT</td>
		</tr>
		<c:forEach items="${productList}" var="product">
			<tr>
				<td><c:out value="${product.attribute}" /></td>
				<td><c:out value="${product.title}" /></td>
				<td><c:out value="${product.manufacturer}" /></td>
				<td><c:out value="${product.model}" /></td>
				<td><c:out value="${product.price}" /></td>
				<td><c:out value="${product.amount}" /></td>
			</tr>
		</c:forEach>
	</table>
	<table class="simple-little-table">
		<tr>
			<td>LOGIN</td>
			<td>EMAIL</td>
			<td>STATUS</td>
		</tr>
	<c:forEach items="${userList}" var="user">
			<tr>
				<td><c:out value="${user.login}" /></td>
				<td><c:out value="${user.email}" /></td>
				<td><c:out value="${user.status}" /></td>
			</tr>
		</c:forEach>
	</table>
	<form action="/Lab4/AddProductToListServlet" method="post">
		<input type="text" size="40" name="id">
		<input type="text" size="40" name="title">
		<input type="text" size="40" name="manufacturer">
		<input type="text" size="40" name="model">
		<input type="text" size="40" name="price">
		<input type="text" size="40" name="amount">
		<button type="submit">add product</button>
	</form>
	
	<form action="/Lab4/DeleteProductFromListServlet" method="post">
		<input type="text" size="40" name="id">
		<button type="submit">delete product</button>
	</form>
	
	<form action="/Lab4/BanUserByNameServlet" method="post">
		<input type="text" size="40" name="login">
		<button type="submit">ban user</button>
	</form>

	
</body>
</html>