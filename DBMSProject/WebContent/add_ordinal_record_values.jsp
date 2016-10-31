<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add val</title>
</head>
<body>
<form action="add_ordinal_record_final" method="post">
	<input type="hidden" value="${observation_type}" name="observation_type">
	<select name="observation">
	<c:forEach items="${values}" var="obs">
		<c:if test="${obs != null}">
			<option value="${obs.id}">${obs.value}</option>
		</c:if>
	</c:forEach>
	</select>
	<input type="text" name="recording_time" placeholder="Recording Time">
	<input type="submit" value="Next">
</form>
</body>
</html>