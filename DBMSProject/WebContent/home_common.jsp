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
<div> 
	<c:choose>
	    <c:when test="${is_patient}">
		   <a href="home.jsp"> GO TO PATIENT PROFILE</a>
	    </c:when>
	    <c:otherwise>
	    	<a href="patientSignUp.jsp"> SIGN UP AS PATIENT </a>
	    </c:otherwise>
	</c:choose>
</div>
<div> 
	<c:choose>
	    <c:when test="${is_hs}">
		   <a href="healthSupp.jsp"> GO TO HEALTH SUPPORTER PROFILE</a>
	    </c:when>
	    <c:otherwise>
	    	<a href="hSSignUp.jsp"> SIGN UP AS HEALTH SUPPORTER </a>
	    </c:otherwise>
	</c:choose>
</div>
<div>
	<br>
	<form method="post" action="logOut">
		<input type=submit value="Log Out">
    </form>
</div>
</body>
</html>