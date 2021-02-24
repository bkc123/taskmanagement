<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create task</title>
</head>
<body>
	<div align="center">
		<form action="create" method="post" >
			<table style="width: 70%">
				<tr>
					
					<th>Task Name</th>
					<th>Start Date</th>
					<th>End Date</th>
					<th>Description</th>
					<th>Severity</th>
					<th>User id</th>

				</tr>

				<tr>

					
					<td><input type="text" name="taskname" id="taskname"/></td>
					<td><input type="date" name="startdate" id="startdate" /></td>
					<td><input type="date" name="enddate" id="enddate"/></td>
					<td><textarea name="description" id="description"></textarea></td>
					<td><select name="severity" id="severity">
							<option value="HIGH">HIGH</option>
							<option value="MEDIUM">MEDIUM</option>
							<option value="LOW">LOW</option>
					</select></td>
					<td><input type="text" name="user" id="user" value="${userid}" readonly /></td>

				</tr>

			</table>
			<input type="submit" value="create" />
		</form>
	</div>
	&nbsp;
		<a href="/logout">
			<button>logout</button>
		</a>
</body>
</html>