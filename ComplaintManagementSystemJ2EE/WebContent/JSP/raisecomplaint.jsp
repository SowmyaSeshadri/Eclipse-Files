<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="shortcut icon" href="favicon.ico" type="image/x-icon" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css" href="<c:url value= "/CSS/header.css" />">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    
<title>Raise Complaint</title>
<link rel="stylesheet" type="text/css" href="<c:url value= "/CSS/page.css"/>">
<link rel="stylesheet" type="text/css" href="<c:url value= "/CSS/raiseComp.css"/>">
</head>
<body class="bodyOfPage">
	<header> <img src="<c:url value= "/images/logobg.png" />"class="logo"
		width="100%" alt="logo">
	<button class="sign-out-button">
		<a href="<c:url value= "/SignOut"/>">Sign Out</a>
	</button>
	</header>
	<div class="raise-form">
		<h3>Register your complaints here:</h3>
		<form action="<c:url value= "/RaiseComplaint" />" method="post" class="raiseForm">
		
			<div class="box">
				<fieldset>
					<legend>Complaint Type</legend>
					<input type="radio" name="radio" value="1"> <label for="radio">Size Mismatch</label><br>
					<input type="radio" name="radio" value="2"> <label for="radio">Defective Piece</label><br>
					<input type="radio" name="radio" value="3"> <label for="radio">Color Mismatch</label><br>
					<input type="radio" name="radio" value="4"> <label for="radio">Others</label><br>
				</fieldset>
			</div>
			
			<div class="box">
				<fieldset>
					<legend>Product:</legend>
					<input type="radio" name="radioProduct" value="123"> <label for="radioProduct">Tshirt</label>
					<input type="radio" name="radioProduct" value="124"> <label for="radioProduct">Shirt</label>
					<input type="radio" name="radioProduct" value="125"> <label for="radioProduct">Salwar</label>
					<input type="radio" name="radioProduct" value="126"> <label for="radioProduct">Jean</label>
				</fieldset>
			</div>
			
			<div class="box textarea-box">
				<label name="desc" for="desc">Complaint Description</label> 
				<textarea rows="5" columns="10" name="desc" id="desc"></textarea>
				<div class="on-hover">
					<div class="on-hover-tip">
					<span>Complaint Details</span>&nbsp;<i class="fa fa-question-circle" aria-hidden="true"></i>
					<p><b>Please provide as much information as possible:</b></p>
					<p>-full description of your complaint.</p>
					<p>-desirable resolution for your complaint Eg:request a refund, return etc</p>
					<p><b>Remember the more details you provide, it will be easier for us to resolve your issue!</b>
					</div>
			</div>
			
				</div>
				
			<input type="submit" class="submitButton color" value="Add Complaint">
		</form>
	</div>

</body>
</html>