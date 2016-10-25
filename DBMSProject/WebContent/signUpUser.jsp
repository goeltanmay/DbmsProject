<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	    <title> SignUp </title>
	</head>
	
	<body bgcolor="white">
		<center>
		 <form method="post" action="signUp">
           <table>
			<thead>
				<tr> <th><font size=7 color=red>SignUp Here</font> </th></tr>
			</thead>
			<tbody>
				 <tr><td> <font size=5> Name<br> <input type=text name="name" size=20/><br>
				        </font></td></tr>
				 <tr><td> <font size=5> Email<br> <input type=text name="email" size=20/><br>
				        </font></td></tr>
				 <tr><td><font size=5> Password <br> <input type=text name="password" size=20/><br>
				        </font></td></tr>
				   <tr><td><font size=5> <input type=submit value="Submit">
				        </font></td></tr>
			</tbody>
			
		   </table> 
           
        </form>
		<a href="login.jsp"> Go Back To Login Page</a>
	  </center>
	</body>
</html>