<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css"
	href="<c:url value= "/CSS/page.css" />">
<link rel="stylesheet" type="text/css"
	href="<c:url value= "/CSS/header.css" />">
<link rel="shortcut icon" href="favicon.ico" type="image/x-icon" />
<title>Admin | Add Team</title>
</head>
<body>
	<header> <img src="<c:url value= "/images/logobg.png"/>"
		class="logo" width="100%" alt="logo"> <a
		href="<c:url value= "/SignOut"/>"><button class="sign-out-button">Sign
			Out</button></a> </header>
	<div class="content-center">
		<div class="pro-pic-box">
			<p>Welcome Admin!</p>
			<img src="<c:url value= "/images/admin.png"/>">
		</div>

		<form method="post" action="<c:url value= "/AdminAddTeam" />"
			class="comp-form">
			<input type="text" name="teamId" class="teamId"
				placeholder="Enter team Id"> <input type="text"
				name="teamName" class="teamName" placeholder="Enter Team name">

			<input type="submit" class="submitButton" value="Add Team"
				class="page-form-buttons">
		</form>

		<form action="<c:url value= "/JSP/admin.jsp"/>" method="post">
			<input type="submit" value="Home" id="home" class="width-buttons">
		</form>
	</div>
</body>
</html>