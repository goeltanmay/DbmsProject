<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	    <title> Diagnoses page </title>
		<script>
			function setValue(){
				var diagnoses = ${existDiag};
				var i;
				var text = "";
				for (i = 0; i < diagnoses.length; i++) {
					text += "<input type='checkbox' name='removeDiag' value='" + diagnoses[i] + "' /> " + diagnoses[i] + "<br/>";
				}
				document.getElementById("existingDiag").innerHTML = text;

				var remainingDiag = ${remainDiag};
				var i;0
				var textRemain = "";
				for (i = 0; i < remainingDiag.length; i++) {
					textRemain += "<input type='checkbox' name='addDiag' value='" + remainingDiag[i] + "' /> " + remainingDiag[i] + "<br/>";
				}
				document.getElementById("remainingDiag").innerHTML = textRemain;
			}
			window.onload = setValue;
		</script>
	</head>
	<body>
	 <form method="post" action="diagnosesRemove">
           <table>
			<thead>
				<tr> <th><font size=7 color=red>View or edit existing diagnoses</font> </th></tr>
			</thead>
			<tbody>
				 <tr><td id="existingDiag"></td></tr>
				  <tr><td><font size=5> <input type=submit value="Remove Selected Diagnoses">
				        </font></td></tr>
			</tbody>
		   </table> 
      </form>
	  <form method="post" action="diagnosesAdd">
		   <table>
			<thead>
				<tr> <th><font size=7 color=red>Add new diagnoses</font> </th></tr>
			</thead>
			<tbody>
				 <tr><td id="remainingDiag"></td></tr>
				  <tr><td><font size=5> <input type=submit value="Add Selected Diagnoses">
				        </font></td></tr>
			</tbody>
		   </table> 
      </form>
	  <a href="home.jsp"> Go Back To Home Page</a>
	</body>	
</html>