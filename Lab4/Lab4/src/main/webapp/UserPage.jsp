<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Page</title>
<link rel="stylesheet" href="CSS/tableStyle.css">
</head>
<body>

	<h1>User Page</h1>
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
	<form action="/Lab4/CheckoutServlet" method="post">
		<p>address</p>
		<input type="text" size="40" name="address">
		<p>products</p>
		<input type="text" size="40" name="products">
		<button type="submit">checkout</button>
	</form>
	<form action="/Lab4/ProductSearchServlet" method="post">
		<p>search</p>
		<input type="text" size="40" name="query">
		<button type="submit">search</button>
	</form>
</body>
</html>