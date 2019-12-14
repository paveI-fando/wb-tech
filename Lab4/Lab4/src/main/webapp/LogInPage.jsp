<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<html>
<head>
</head>
<body>
	<form action="/Lab4/LogInServlet" method="post">
		<input type="text" size="40" name="login"> 
		<input type="password" size="40" name="password">
		<button type="submit">log in</button>
	</form>
	<button onclick="location.href='/Lab4/SwitchToSignInPageServlet'">not registered?</button>
</body>
</html>
