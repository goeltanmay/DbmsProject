<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	    <title> Health Indicator page</title>
		
	</head>
	<body>
	<h1>Recommended Observations</h1>
	 <form method="post" action="updateObservations">
           <table style="width:100%">
			<thead>
				<tr><th align="left"><font size=4 color=red>Observations Name</font> </th>
					<th align="left"><font size=4 color=red>Upper Limit</font> </th>
					<th align="left"><font size=4 color=red>Lower Limit</font> </th>
					<th align="left"><font size=4 color=red>Recommended Frequency</font> </th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="observ" items="${nominals}" >
					<c:if test="${observ != null}">
		  				<tr>
							<td align="left"><input type=hidden name="observName" value="${observ.oid.name}">${observ.oid.name}</td>
							<td align="left"><input type=text name="upperLimit_${observ.upper_limit}" size=3 value="${observ.upper_limit}"></td>
							<td align="left"><input type=text name="lowerLimit_${observ.lower_limit}" size=3 value="${observ.lower_limit}"></td>
							<td align="left"><input type=text name="recommFreq_${observ.frequency}" size=3 value="${observ.frequency}"></td>
						</tr>
					</c:if>
				</c:forEach>
				<tr><td id="existingObservation"></td></tr>
				 <tr><td><font size=5><input type=submit value="Update Diagnoses"></font></td></tr>
			</tbody>
		  </table> 
     </form>
	<a href="add_nominal_obs"> Add new Nominal Observation to be recorded</a>
	 <form method="post" action="updateObservations">
           <table style="width:100%">
			<thead>
				<tr><th align="left"><font size=4 color=red>Observations Name</font> </th>
					<th align="left"><font size=4 color=red>Expected Value</font> </th>
					<th align="left"><font size=4 color=red>Recommended Frequency</font> </th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="observ" items="${ordinals}" >
					<c:if test="${observ != null}">
		  				<tr>
							<td align="left"><input type=hidden name="observName" value="${observ.oid.name}">${observ.oid.name}</td>
							<td align="left"><input type=text name="upperLimit_${observ.expected}" size=3 value="${observ.expected}"></td>
							<td align="left"><input type=text name="recommFreq_${observ.frequency}" size=3 value="${observ.frequency}"></td>
						</tr>
					</c:if>
				</c:forEach>
				<tr><td id="existingObservation"></td></tr>
				 <tr><td><font size=5><input type=submit value="Update Diagnoses"></font></td></tr>
			</tbody>
		  </table> 
     </form>
	<a href="add_ordinal_obs"> Add new Ordinal Observation</a>
	
	<a href="home.jsp"> Go Back To Home Page</a>
	</body>	
</html>