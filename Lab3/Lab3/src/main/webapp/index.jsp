<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>

<style>
   <%@include file='tableStyle.css' %>
</style>
<style>
   <%@include file='btnStyle.css' %>
</style>
<body>
	<h1>Import from XML-file</h1>
	<%-- <c:if test="${productList is empty}">hkejfhsd</c:if>
	// --%>
	<%--<c:out value="${productList}" />--%>
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
	<button class="button28" onclick="location.href='/Lab3/SAXParserServlet'">UseSAXParser</button>
	<button class="button28" onclick="location.href='/Lab3/StAXParserServlet'">Use StAX Parser</button>
	<button class="button28" onclick="location.href='/Lab3/DOMParserServlet'">Use DOM Parser</button>
</body>
</html>
