<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Song details</title>
	<link rel="stylesheet" href="/webjars/bootstrap/5.0.1/css/bootstrap.min.css" />
</head>
<body>
	<div class="container mt-5">
	  	<a class="nav-link text-end" href="/dashboard">Dashboard</a>
		<div class="main bg-light mt-2 p-3">      
			<p>Title: <c:out value="${song.title}"/></p>
			<p>Artist: <c:out value="${song.artist}"/></p>
			<p>Rating: <c:out value="${song.rating}"/></p>
		</div>
		<!-- Set this up as a separate div in case new functionality is added -->
		<div class="footer">
			<a class="nav-link p-3" href="/songs/${song.id}/delete">Delete</a>
		</div>
	</div>
	
	<script src="/webjars/jquery/3.6.0/jquery.min.js"></script>
	<script src="/webjars/bootstrap/5.0.1/js/bootstrap.min.js"></script>		
</body>
</html> 