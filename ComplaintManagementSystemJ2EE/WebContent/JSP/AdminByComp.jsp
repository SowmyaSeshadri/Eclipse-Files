<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Admin | Complaint Id Search</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="shortcut icon" href="favicon.ico" type="image/x-icon" />
<link rel="stylesheet" type="text/css"
	href="<c:url value= "/CSS/header.css" />">
<link rel="stylesheet" type="text/css"
	href="<c:url value= "/CSS/page.css" />">
</head>
<body class="bodyOfPage">
	<header> <img src="<c:url value= "/images/logobg.png"/>"
		class="logo" width="100%" alt="logo"> <a href="SignOut">
		<button class="sign-out-button">Sign Out</button>
	</a> </header>
	
	<div class="content-center">

		<div class="pro-pic-box">
			<img src="<c:url value= "/images/admin.png" />">
		</div>

		<form method="post" action="CompById" class="comp-form">
			<label for="comptype">Complaint ID</label> <input type="text"
				name="comptype" class="comptype"> <input type="submit"
				class="submitButton" value="Get Details" class="page-form-buttons">
		</form>

		<form action="<c:url value= "/JSP/admin.jsp" />" method="post">
			<input type="submit" value="Home" id="home" class="width-buttons">
		</form>
	</div>
</body>
</html>