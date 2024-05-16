<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
<link rel="stylesheet" href="styles/loginstyle.css">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css">
</head>
<body id="main-cover">
<div id="subdiv">
<div id="left" class="container"><img src="images/pennant.png"></div>
<div id="right" class="container">
	<form method="post" action="login">
		<input type="text" class="form-control mb-3 mt-3" placeholder="Enter Your Username"/>
		<input type="password" class="form-control mb-3" placeholder="Enter Your Password"/>
		<input type="password" class="form-control mb-3" placeholder="Re-Enter Your Password"/>
		<input type="submit" class="btn btn-success form-control mb-3" value="REGISTER"/>
	</form>
	<p>Already have an account? <a href="Login.jsp">Login into your account</a></p>
</div>
</div>
</body>
</html>