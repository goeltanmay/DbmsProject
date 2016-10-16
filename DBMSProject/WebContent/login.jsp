<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title> Login page for the calendar. </title>
</head>

<body bgcolor="white">
<center>

    <font size=7 color="red"> Please Enter the following information: </font>

<br>
    <form method=GET action=mylogin>

        <font size=5> Email <input type=text name="email" size=20>
        </font>
        <br>
        <font size=5> Password <input type=text name="password" size=20>
        </font>
        <br>
        <input type=submit value="Submit">

    </form>
<hr>
<font size=3 color="red"> Note: This application does not implement the complete
functionality of a typical calendar application. It demonstrates a way JSP can
be used with html tables and forms.</font>

</center>
</body>
</html>