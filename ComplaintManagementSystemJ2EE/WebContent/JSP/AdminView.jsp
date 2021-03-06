<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin | View All Complaints</title>
<link rel="shortcut icon" href="favicon.ico" type="image/x-icon" />
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css"
	href="<c:url value= "/CSS/page.css" />">
<link rel="stylesheet" type="text/css"
	href="<c:url value= "/CSS/custompage.css" />">
<link rel="stylesheet" type="text/css"
	href="<c:url value= "/CSS/viewall.css" />">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css" href="<c:url value= "/CSS/header.css" />">
</head>
<body>
	<header> <img src="<c:url value= "/images/logobg.png"/>"
		class="logo" width="100%" alt="logo"> <a href="SignOut">
		<button class="sign-out-button">Sign Out</button>
	</a> </header>

	<div class="view-content">
		<h3>Complaint History:</h3>
		<div class="cards">
			<c:forEach var="complaint" items="${complaintsHistory}">
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
					
					<c:set var="status" value="${complaint.compStatus}" scope="page">
					</c:set>
					<% 
					String res = (String)pageContext.getAttribute("status");
					if(res.equals("Pending"))
					{ %>
							<p class="comp-status red-pending">
							<span>Complaint-Status:</span> ${complaint.compStatus}
								
							<i class="fa fa-question-circle" aria-hidden="true"></i></p>	
								<%
					}
					else
					{
					%>
							<p class="comp-status green-done">
							<span>Complaint-Status:</span> ${complaint.compStatus}
							<i class="fa fa-check-circle" aria-hidden="true"></i>
							</p>
					<% } %>
				</div>
			</c:forEach>
		</div>
	</div>
</body>
</html>