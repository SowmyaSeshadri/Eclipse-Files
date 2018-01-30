<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Team | Pending Status</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css" href="<c:url value= "/CSS/header.css" />">
<link rel="shortcut icon" href="favicon.ico" type="image/x-icon" />
<link rel="stylesheet" type="text/css" href="<c:url value= "/CSS/page.css" />">
<link rel="stylesheet" type="text/css" href="<c:url value= "/CSS/custompage.css" />">
<link rel="stylesheet" type="text/css" href="<c:url value= "/CSS/viewall.css" />">
</head>
<body>
	<header> <img src="<c:url value= "/images/logobg.png" />" class="logo"
		width="100%" alt="logo">
	
		<a href="<c:url value= "/SignOut" />">
		<button class="sign-out-button">Sign Out</button>
		</a>
	
	</header>
	<div class="view-content">
		<h3>Pending Complaints:</h3>
		<div class="cards">
			<c:forEach var="complaint" items="${complaintsTeamPending}">
				<div class="card-main">
					<p class="comp-id">
						<span>Complaint ID:</span> ${complaint.compId}<span
							class="team-id">Team ID:</span> ${complaint.teamId}</p>
					<p class="prod-id">
						<span>Product ID:</span> ${complaint.prodId}</p>
					<p class="comp-desc">
						<span>Complaint-Title:</span> ${complaint.compDesc}</p>
					<p class="comp-date">
						<span>Date Of Complaint:</span> ${complaint.date}</p>
				</div>
			</c:forEach>
		</div>
	</div>
	

</body>
</html>