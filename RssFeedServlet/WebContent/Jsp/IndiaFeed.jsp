<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css" href="Jsp/main.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>India | Top Stories</title>
</head>
<body>
	<div class="topic-container">
		<h2>Top Stories</h2>
		<ul class="unordered">

<c:forEach var="news" items="${arrayList}">
<li>
  <a href="${news.link}">${news.title}</a>
       <p>${news.date}</p> 
       
    
</li>


</c:forEach>
		</ul>
	</div>

</body>
</html>