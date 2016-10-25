<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	    <title> User Login page </title>
	</head>
	
	<body bgcolor="white">
		<div style="width:100%;"> <!-- Main Div -->
			    <font size=7 color="red"> User Login: </font>
				<br>
			    <form method=POST action=loginCommon>
			        <font size=5> Email <br> <input type=text name="email" size=20><br>
			        </font>
			        <font size=5> Password <br><input type=text name="password" size=20>
			        </font>
			        <br><br>
			        <input type=submit value="Submit"><br>
			    </form>
			    <font size=7 color="red">
			    	OR<br>
			    	Don't have account SignUp<br>
			    </font>
			    	<button onclick="window.location='signUpUser.jsp';">Sign Up</button>
			<!--div style="float:left; width:50%;">
				<font size=7 color="red"> Login as health supporter: </font>
				<br>
			    <form method=POST action=loginHS>
			        <font size=5> Email <br><input type=text name="emailHS" size=20><br>
			        </font>
			        <font size=5> Password <br><input type=text name="passwordHS" size=20>
			        </font>
			        <br><br>
			        <input type=submit value="Submit">
			    </form>
			</div-->
		</div>
	</body>
</html>