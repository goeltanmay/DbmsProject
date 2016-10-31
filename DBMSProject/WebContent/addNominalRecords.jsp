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
Enter the details:
<br>
<form method="post" action="addNominalRecord">
	Enter the observation type:
	<select name="observation">
		<c:forEach items="${nominals}" var="obs">
			<c:if test="${obs != null}">
				<option value="${obs.id}">${obs.oid.name}</option>
			</c:if>
		</c:forEach>
	</select>
	<br>
	Enter the Value: <input type=text name="reading" size=20/>
	<br>
	Enter the observation Time: <input type=text name="obtime" size=20/>
	<br>
	<input type=submit value="Submit"> 
</form>

</body>
</html>