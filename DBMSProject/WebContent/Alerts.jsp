<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

		<c:forEach items="${alertList}" var="alert">
			<tr>
				<c:if test="${alert != null}">
					<option value="${obs.id}">${obs.name}</option>
					<td>${alert.oid.name}</td>
					<td>${alert.details}</td>
					<c:if test="${as_hs == true || alert.tid.id == 1}">
					<td>	<a href="remove_alert?id=${alert.id}"> Remove!</a></td>
					</c:if>
			    </c:if>
		    </tr>
		</c:forEach>
	
	</table>
	</body>
</html>