<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	    <title> Patient SignUp </title>
	</head>
	
	<body bgcolor="white">
		<center>
		 <form method="post" action="successSignUp">
           <table>
			<thead>
				<tr> <th><font size=7 color=red>Patients SignUp Here</font> </th></tr>
			</thead>
			<tbody>
				 <tr><td><font size=5> Gender <br> <input type="radio" name="gender" value="m"> Male
  											  <input type="radio" name="gender" value="f"> Female
  											  <input type="radio" name="gender" value="o"> Other
				        </font></td></tr>
				  <tr><td><font size=5> Address <br><textarea rows="5" cols="20" name="address" ></textarea><br>
				        	</font></td></tr>
				  <tr><td><font size=5> Date Of Birth<br> <input type="date" name="dob" id="dob" size=20><br>
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