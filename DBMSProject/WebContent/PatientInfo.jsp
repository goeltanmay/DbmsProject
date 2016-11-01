<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title> Patient Info </title>
</head>

<body bgcolor="white">

    <font size=7 color="red"> Patient Details: </font>
<br>
 <table style="width:40%">
			<thead>
				<tr><th align="left"><font size=5 color=red>List of Patients</font> </th>
				</tr>
			</thead>
			<tbody>
			
			<c:forEach var="patient" items="${patients}" >
				<tr><td><a href="set_patient?id=${patient.id}">${patient.id}</a> </td></tr>
			</c:forEach>
			
			</tbody>
 </table>    

</body>
</html>