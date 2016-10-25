<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title> Edit Profile </title>
</head>

<body bgcolor="white">

    <font size=7 color="red"> Health Supporter Profile Details: </font>
<br>

<table>
<form method=POST action="update_hs_profile" >
    <tr>
        <td>UID:</td>
        <td><input type="text" name="id" value="${user.id}" disabled></td>
    </tr>
    <tr>
        <td>Name:</td>
        <td><input type="text" name="name" value="${user.name}"></td>
    </tr>
    <tr>
        <td>Email:</td>
        <td><input type="text" name="email" value="${user.email}"></td>
    </tr>
    <tr>
        <td>Password:</td>
        <td><input type="password" name="password" value="${user.password}"></td>
    </tr>
    <tr>
        <td>Contact Info:</td>
        <td><input type="text" name="phone_number" value="${hs.phone_number}"></td>
    </tr>
    <tr>
        <td colspan="2" align="center"><input type="submit" name="save" value="Save"></td>
    </tr>
    </form>
</table>    

</body>
</html>