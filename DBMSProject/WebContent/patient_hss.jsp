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
	<c:forEach items="${health_supporters}" var="hs">
		<tr>
			<td> ${hs.user_id.name}</td>
			<td> ${hs.phone_number}</td>
			<td> url to remove </td>
		</tr>
	</c:forEach>
</table>

<form action="">
	<select name="hs_role">
		<option value="primary"> Primary </option>
		<option value="secondary"> Secondary </option>
	</select>
	<select name="hs">
		<c:forEach items="${all_hs}" var="hs">
			<option value="${hs.id}">${hs.user_id.name }</option>
		</c:forEach>
	</select>
	<submit> Add new Health Supporter </submit>
</form>
</body>
</html>