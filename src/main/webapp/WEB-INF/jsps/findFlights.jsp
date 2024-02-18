<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset="ISO-8859-1">
<link rel="stylesheet" href="style.css">
<title>Find Flights</title>
</head>
<body>
	<h1>Find Flights</h1>
	<form action="findFlights" method="post">
		From: <input type="text" name="from"> 
		To: <input type="text" name="to"> 
		DetartureDate: <input type="text" placeholder="MM-dd-yyyy" name="departureDate"> 
		<input type="submit" value="search">
	</form>
</body>
</html>