<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome to task manager for users</title>
</head>
<body>
	<div align="center">
	<h3> ${msg} </h3>
	------------------------------</br>
	------------------------------</br>
	<h4> Select to perform action </h4>

		<a href="/create"> Create </a> &nbsp;
		<a href="/delete">Delete </a> &nbsp;
		<a href="/display">Display </a> &nbsp;
		<a href="/updateFromWelcome">Update </a>&nbsp;
		<a href="/logout">
			<button>logout</button>
		</a>

	</div>

</body>
</html>