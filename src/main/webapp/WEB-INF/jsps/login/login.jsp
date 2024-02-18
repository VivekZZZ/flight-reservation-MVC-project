<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
	<h1>Login Here ...</h1>
	${error}
	<form action="verifyLogin" method="post">
		EmailId<input type="text" name="email"> <br> Password<input
			type="password" name="password"><br> <input
			type="submit" value="login">
	</form>
</body>
</html>