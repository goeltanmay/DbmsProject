<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	    <title> Home </title>
	</head>
	
	<body bgcolor="white">
	 <center>
		<font size=7 color="red"> Welcome Choose your option </font><br>
	    <form method=get action=profile>
	    	<font size=5><input type="submit" action="PatientEditProfile" value="View or Edit Profile"/> </font>
	    </form><br>
	    <form method=get action=diagnoses>
	    	<font size=5><input type="submit" value="View or Edit Diagnoses"/> </font>
	    </form><br>
	    <form method=get action=healthInd>
	    	<font size=5><input type="submit" value="View and Add Health Observations"/> </font>
	    </form><br>
	  </center>
	</body>
</html>