<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Registration</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
</head>
<body>
	<h1>Create New Account</h1>
	<form action="saveReg" method="post">
		<div class="mb-4">
			<label class="form-label">First Name</label><input type="text"
				name="firstName" class="form-control" />
		</div>
		<div class="md-4">
			<label class="form-label">Last Name</label><input type="text"
				name="lastName" class="form-control" />
		</div>
		<div class="md-4">
			<label class="form-label">Email</label><input type="text"
				name="email" class="form-control" />
		</div>
		<div class="md-4">
			<label class="form-label">Password</label><input type="text"
				name="password" class="form-control" />
		</div>
		<button type="submit" class="btn btn-primary">submit</button>
	</form>
</body>
</html>