<html>
	<head>
	    <title> Alerts </title>
	</head>
	
	<body>
	<table>
	<tr>
		<th>
			Alert Description
		</th>
		<th>
			Clear?
		</th>
	</tr>
	<tr>
		<c:type items="${alertTypeList}" var="alert">
			<td>${alert.description}</td>
			<form action="" method="post">
			<td><input type="submit" name="Clear Alert" value="${alert.id}"></td>
			</form>
		</c:type>
	</tr>
	</table>
	</body>
</html>