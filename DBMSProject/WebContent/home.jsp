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
	    <form method=post action=profile>
	    	<font size=5><input type="submit" action="PatientEditProfile" value="View or Edit Profile"/> </font>
	    </form><br>
	     <form method=post action="list_of_health_supporters">
	    	<font size=5><input type="submit" action="ListHealthSupporters" value="View or Edit Health Supporter"/> </font>
	    </form><br>
	    <form method=post action="diagnoses">
	    	<font size=5><input type="submit" value="View or Edit Diagnoses"/> </font>
	    </form><br>
	    <form method=post action="list_health_indicators">
	    	<font size=5><input type="submit" value="View or Edit Health Indicators"/> </font>
	    </form><br>
	    <form method=post action="add_ordinal_record">
	    	<font size=5><input type="submit" value="View and Add Ordinal Records"/> </font>
	    </form><br>
	    <form method="post" action="getEnteries">
	    	<font size=5><input type="submit" value="View and Add Nominal Records"/> </font>
	    </form><br>
	    <form method="post" action="alerts">
	    	<font size=5><input type="submit" value="View and Remove Alerts"/> </font>
	    </form><br>
		<form method="post" action="logOut">
			<input type=submit value="Log Out">
		</form><br>
	  </center>
	</body>
</html>