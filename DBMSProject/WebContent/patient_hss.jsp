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
<table>
<tr>
<th>Name
</th>
<th>Contact Number
</th>
<th>Remove?
</th>
</tr>
	<c:forEach items="${health_supporters}" var="hs">
		<c:if test="${hs != null }">
			<tr>
				<td> ${hs.user_id.name}</td>
				<td> ${hs.phone_number}</td>
				<td> <a href="remove_hs?hs=${hs.id}">remove</a></td>
			</tr>
		</c:if>
	</c:forEach>
</table>

<form action="update_hs" method="post">
	<select name="hs_role">
		<option value="primary"> Primary </option>
		<option value="secondary"> Secondary </option>
	</select>
	<select name="hs">
		<c:forEach items="${all_hs}" var="hs">
			<option value="${hs.id}">${hs.user_id.name }</option>
		</c:forEach>
	</select>
	<input type="text" name="date" placeholder="authDate"></input>
	<input type="submit" value="Add new HS">
</form>
</body>
</html>