<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="create_ordinal_observation" method="post">
	<select name="observation">
	<c:forEach items="${observations}" var="obs">
		<c:if test="${obs != null}">
			<option value="${obs.id}">${obs.name}</option>
		</c:if>
	</c:forEach>
	</select>
	<input name="values" type="text"  placeholder="CS values list">
	<input name="expected" type="text"  placeholder="Expected">
	<input name="freq" type="text"  placeholder="Frequency">
	<input type="submit" value="Add new nominal observation">
</form>
</body>
</html>