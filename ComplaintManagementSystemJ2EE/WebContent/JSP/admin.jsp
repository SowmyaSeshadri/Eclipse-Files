<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css" href="<c:url value= "/CSS/header.css" />">
<link rel="stylesheet" type="text/css" href="<c:url value= "/CSS/admin.css" />">
<link rel="shortcut icon" href="favicon.ico" type="image/x-icon" />
<title>Admin | Plainte</title>
</head>
<body class="bodyOfPage">
	<header> <img src="<c:url value= "/images/logobg.png" />" class="logo"
		width="100%" alt="logo">
	
		<a href="<c:url value= "/SignOut" />"><button class="sign-out-button">Sign Out</button></a>
	
	</header>
	<section class="content">
	
    <section class="admin-content">
        <div class="admin-box">
            <img src="<c:url value= "/images/admin.png" />">
            <p>Welcome Admin!</p>
        </div>

        <div class="functions">

            <form method="post" action="<c:url value= "/AdminViewAll" />" >
                <input type="submit" value="View All Complaints" id="viewUser" class="btn animate action-button">
            </form>
            <form method="post" action="<c:url value= "/AdminComplaintId" />" >
                <input type="submit" value="View Complaint By Id" id="raiseUser" class="btn animate action-button">
            </form>
            <form method="post" action="<c:url value= "/Addteam" />">
                <input type="submit" value="Add New Team" id="addNewTeam" class="btn animate action-button">
            </form>
            <form method="post" action="<c:url value= "/ViewPending" />" >
                <input type="submit" value="View Pending Complaints" id="viewPending" class="btn animate action-button">
            </form>
            <br/>
        </div>

        <div class="functions-default" >
            <form class="bot-btn-form" action="<c:url value= "/ErrorPage" />" method="post">
                <input type="submit" value="FAQ" id="faq" class="bottom-button btn animate action-button">
            </form>
            <form class="bot-btn-form" action="<c:url value= "/ErrorPage" />" method="post">
                <input type="submit" value="Setting" id="setting" class="bottom-button btn animate action-button">
            </form>
        </div>

    </section>
    <section class="calendar">
        <div class="clock">
            <iframe src="http://free.timeanddate.com/clock/i636r36d/n553/szw110/szh110/hoc000/hbw3/hfc0084ff/cf100/hgr0/hwc000/fiv0/fan3/facfff/fnu2/fdi76/mqcfff/mqs3/mql18/mqw4/mqd60/mhceee/mhs4/mhl5/mhw4/mhd62/mmv0/hhcfff/hhs1/hhb10/hmcfff/hms1/hmb10/hscfff/hsw3"
                frameborder="0" width="110" height="110"></iframe>
        </div>
        <div id="divifm">
            <iframe id="ifmCalendar" src="https://www.google.com/calendar/embed?
            height=550&amp;wkst=1&amp;bgcolor=%23FFFFFF&
            amp;src=24tn4fht2sssdssfdiqqlsedk%40group.calendar.google.com&
            amp;color=%238C500B&amp;ctz=Asia%2FCalcutta" style="border-width: 0" width="367" height="250" frameborder="0"
                scrolling="no">
            </iframe>
        </div>

    </section>
     <script src="<c:url value= "/JS/scriptCal.js" />"></script>
</body>
</html>