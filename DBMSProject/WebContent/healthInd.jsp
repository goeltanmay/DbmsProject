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
					<th align="left"><font size=4 color=red>Description</font> </th>
					<th align="left"><font size=4 color=red>Upper Limit</font> </th>
					<th align="left"><font size=4 color=red>Lower Limit</font> </th>
					<th align="left"><font size=4 color=red>Alert Threshold</font> </th>
					<th align="left"><font size=4 color=red>Recommended Frequency</font> </th>
					<th align="left"><font size=4 color=red>Frequency Metrics (Daily, Weekly, Monthly)</font> </th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="observ" items="${observationsList}" >
	  				<tr>
						<td align="left"><input type=hidden name="observName" value="${observ.name}">${observ.name}</td>
						<td align="left">${observ.description}</td>
						<td align="left"><input type=text name="upperLimit_${observ.name}" size=3 value="${observ.upperLimit}"></td>
						<td align="left"><input type=text name="lowerLimit_${observ.name}" size=3 value="${observ.lowerLimit}"></td>
						<td align="left"><input type=text name="alertThreshold_${observ.name}" size=3 value="${observ.alertThreshold}"></td>
						<td align="left"><input type=text name="recommFreq_${observ.name}" size=3 value="${observ.recommFreq}"></td>
						<td align="left"><input type=text name="recommFreqMetrics_${observ.name}" size=10 value="${observ.recommFreqMetrics}"></td>
					</tr>
				</c:forEach>
				<tr><td id="existingObservation"></td></tr>
				 <tr><td><font size=5><input type=submit value="Update Diagnoses"></font></td></tr>
			</tbody>
		  </table> 
     </form>
	<h1>Existing Observations</h1>
    <table style="width:100%">
			<thead>
				<tr><th align="left"><font size=4 color=red>Observations Name</font> </th>
					<th align="left"><font size=4 color=red>Observations Time</font> </th>
					<th align="left"><font size=4 color=red>Recording Time</font> </th>
					<th align="left"><font size=4 color=red>Observation Value</font> </th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="records" items="${recordedObservations}" >
					<c:forEach var="recordsValue" items="${records.value}" >
		  				<tr>
							<td align="left">${recordsValue.type}</td>
							<td align="left">${recordsValue.observTime}</td>
							<td align="left">${recordsValue.recordTime}</td>
							<td align="left">${recordsValue.observValue}</td>
						</tr>
					</c:forEach>
				</c:forEach>
			</tbody>
	 </table>
	 <h1>Add Observations</h1>
	 <form method="post" action="addRecords">
	    <table style="width:100%">
				<thead>
					<tr><th align="left"><font size=4 color=red>Observations Name</font> </th>
						<th align="left"><font size=4 color=red>Observations Time</font> </th>
						<th align="left"><font size=4 color=red>Recording Time</font> </th>
						<th align="left"><font size=4 color=red>Observation Value</font> </th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="newRecords" items="${newObservations}" >
		  				<tr>
		  					<td align="left"><input type=hidden name="observType" value="${newRecords}">${newRecords}</td>
							<td align="left"><input type="date" name="observTime_${newRecords}" size=20></td>
							<td align="left"><input type="date" name="recordTime_${newRecords}" size=20></td>
							<td align="left"><input type="text" name="observValue_${newRecords}" size=5></td>
						</tr>
					</c:forEach>
					<tr><td><font size=5><input type=submit value="Add Records"></font></td></tr>
				</tbody>
		 </table>
	</form>	 
	<a href="home.jsp"> Go Back To Home Page</a>
	</body>	
</html>