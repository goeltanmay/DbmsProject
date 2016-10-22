<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	    <title> Profile Update page </title>
	    <script type="text/javascript">
			function setValue(){
			document.getElementById("${gender}").checked=true;
			}
			window.onload = setValue;</script>
	</head>
	<body></body>
	 <form method="post" action="profileUpdate">
           <table>
			<thead>
				<tr> <th><font size=7 color=red>SignUp Here</font> </th></tr>
			</thead>
			<tbody>
				 <tr><td> <font size=5> Name<br> <input type=text name="name" size=20 value="${name}"><br><br>
				        </font></td></tr>
				 <tr><td> <font size=5> Email<br> <input type=text name="email" size=20 value="${email}"><br><br>
				        </font></td></tr>
				 <tr><td><font size=5> Gender <br> <input type="radio" name="gender" id="m" value="m"> Male
  											  <input type="radio" name="gender" id="f" value="f"> Female
  											  <input type="radio" name="gender" id="o" value="o"> Other<br><br>
				        </font></td></tr>
				  <tr><td><font size=5> Address <br><textarea rows="5" cols="20" name="address" >${address}</textarea><br><br>
				        	</font></td></tr>
				  <tr><td><font size=5> Date Of Birth<br> <input type="date" name="dob" size=20 value="${dob}"></input><br><br>
				        </font></td></tr>
				  <tr><td><font size=5 color=red> Patient Category:</font> <br>${patientCategory}<br><br>
				        </td></tr>
				  <tr><td><font size=5> <input type=submit value="Update Profile">
				        </font></td></tr>
			</tbody>
			
		   </table> 
           
        </form>
		<a href="home.jsp"> Go Back To Home Page</a>
</html>