<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add ordinal Recording</title>
</head>
<body>
<form action="add_ordinal_record_values" method="post">
	<select name="observation">
	<c:forEach items="${ordinals}" var="obs">
		<c:if test="${obs != null}">
			<option value="${obs.id}">${obs.oid.name}</option>
		</c:if>
	</c:forEach>
	</select>
	<input type="submit" value="Next">
</form>
</body>
</html>