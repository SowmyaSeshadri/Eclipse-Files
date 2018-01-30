<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="shortcut icon" href="favicon.ico" type="image/x-icon" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css"
	href="<c:url value= "/CSS/header.css" />">
<link rel="stylesheet" type="text/css"
	href="<c:url value= "/CSS/team.css" />">
<title>Team Defective</title>
</head>
<body class="bodyOfPage">
	<header> <img src="<c:url value= "/images/logobg.png" />"
		class="logo" width="100%" alt="logo"> <a
		href="<c:url value= "/SignOut" />"><button class="sign-out-button">Sign
			Out</button></a> </header>

	<section class="content-center">
	<div class="pro-pic-box">
		<p>Welcome Team!</p>
		<img src="<c:url value= "/images/team.png" />">
	</div>
</section>
	<div class="functions-team">
		<form method="post" class="page-form"
			action="<c:url value= "/TeamView" />">
			<input type="submit" value="View All Complaints" id="viewUser"
				class="page-form-buttons">
		</form>
		<form method="post" class="page-form"
			action="<c:url value= "/TeamUpdateStatus"/>">
			<input type="submit" value="Update Status of complaints"
				id="raiseUser" class="page-form-buttons">
		</form>
		<form method="post" class="page-form"
			action="<c:url value= "/TeamViewPending"/>">
			<input type="submit" value="View Pending Complaints" id="raiseUser"
				class="page-form-buttons">
		</form>
	</div>
</body>
</html>