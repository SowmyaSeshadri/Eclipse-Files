<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Welcome | Complaint Management System</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css" href="<c:url value= "/CSS/header.css" />">
<link rel="shortcut icon" href="favicon.ico" type="image/x-icon" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link href="https://fonts.googleapis.com/css?family=PT+Sans" rel="stylesheet">
<link rel="stylesheet" type="text/css" 	href="<c:url value= "/CSS/page.css" />">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>

<body class="bodyOfPage">
	<header> <img src="<c:url value= "/images/logobg.png"/>"
		class="logo" width="100%" alt="logo"> <a
		href="<c:url value= "/SignOut" />"><button class="sign-out-button">Sign
			Out</button></a> </header>

	<div class="container"> 
	<div class="content">
	<div class="pro-pic-box">
		<img src="<c:url value= "/images/girl.jpg" />">
	</div>
	<div class="pro-details">
		<p class="pro-details-para">
			<span>First Name:</span> ${firstname}
		</p>
		<p class="pro-details-para">
			<span>Last Name:</span> ${lastname}
		</p>
		<p class="pro-details-para">
			<span>Email:</span> ${email}
		</p>
	</div>

	</div> 
	
	<div class="content">
	<div class="user-functions">
		<form method="post" class="page-form"
			action="<c:url value= "/CustomPage"/>">
			<input type="submit" value="View Previous Complaints" id="viewUser"
				class="page-form-buttons">
		</form>
		<form method="post" class="page-form"
			action="<c:url value= "/CustomPage1"/>">
			<input type="submit" value="Raise a complaint" id="raiseUser"
				class="page-form-buttons">
		</form>
		<form method="post" class="page-form" action="<c:url value= "/ErrorPage"/>">
			<input type="submit" value="Notifications" class="page-form-buttons">
		</form>
		<form method="post" class="page-form" action="<c:url value= "/ErrorPage"/>">
			<input type="submit" value="User Settings" class="page-form-buttons">
		</form>
		<form method="post" class="page-form" action="<c:url value= "/ErrorPage"/>">
			<input type="submit" value="FAQ" class="page-form-buttons">
		</form>
	</div>
	</div> 
	
	</div>

</body>
</html>
