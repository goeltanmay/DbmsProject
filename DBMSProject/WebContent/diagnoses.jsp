<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	    <title> Diagnoses page </title>
	</head>
	<body>
	 <form method="post" action="diagnosesRemove">
           <table style="width:40%">
			<thead>
				<tr><th align="left"><font size=5 color=red>View or edit existing diagnoses</font> </th>
					<th align="left"><font size=5 color=red>Diagnosis Date</font> </th>
				</tr>
			</thead>
			<tbody>
			<c:forEach var="existDiag" items="${existDiag}" >
				<tr><td><input type='checkbox' name='removeDiag' value="${existDiag.name}"/>${existDiag.name} </td> 
					<td>${existDiag.date}</td></tr><br/>
			</c:forEach>
				 <br/>
				  <tr><td><font size=5> <input type=submit value="Remove Selected Diagnoses">
				        </font></td></tr>
			</tbody>
		   </table> 
      </form>
	  <form method="post" action="diagnosesAdd">
		   <table style="width:50%">
			<thead>
				<tr><th align="left"><font size=5 color=red>Add new diagnoses</font> </th>
				</tr>
			</thead>
			<tbody>
				 <c:forEach var="remainDiag" items="${remainDiag}" >
					<tr><td><input type='checkbox' name='addDiag' value="${remainDiag.name}"/>${remainDiag.name} </td> 
					</tr><br/>
				 </c:forEach>
				 <tr><td>Date<input type="date" name="date" id="dob" size=20></td></tr><br/><br/>
				 <tr><td><font size=5> <input type=submit value="Add Selected Diagnoses">
				        </font></td></tr>
			</tbody>
		   </table> 
      </form>
	  <a href="home.jsp"> Go Back To Home Page</a>
	</body>	
</html>