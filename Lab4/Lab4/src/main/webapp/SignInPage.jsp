<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sign In</title>
</head>
<body>
	 <form action="/Lab4/SignInServlet" method="post">
		<input type="text" size="40" name="login"> 
		<input type="text" size="40" name="email"> 
		<input type="password" size="40" name="password">
		<button type="submit">sign in</button>
	</form>
	 <button onclick="location.href='/Lab4/SwitchToLogInPageServlet'">already registered?</button>
</body>
</html>