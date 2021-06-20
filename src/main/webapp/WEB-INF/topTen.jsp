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
	<title>Top 10</title>
	<link rel="stylesheet" href="/webjars/bootstrap/5.0.1/css/bootstrap.min.css" />
</head>
<body>
	<div class="container mt-5 border border-dark">
		<nav class="navbar navbar-light mt-3">
			<div class="container-fluid">
				<a class="nav-link disabled text-start">Top 10 Rated Songs</a>
				<a href="/dashboard" class="nav-link text-end">Dashboard</a>
			</div>
		</nav>
		<div class="main form-group row mt-2 p-3">
			<table class="table table-striped">
				<thead>
					<th>Rating</th>
					<th>Artist</th>
					<th>Title</th>
					<th>Genre</th>
				</thead>
	    		<tbody>
	        		<c:forEach items="${songs}" var="song">
	        			<tr>
	        				<td><c:out value="${song.rating}"/></td>
	            			<td><c:out value="${song.artist}"/></td>
	            			<td><a href="/songs/${song.id}"><c:out value="${song.title}"/></a></td>
	            			<td><c:out value="${song.genre}"/></td>
	        			</tr>
	        		</c:forEach>
	    		</tbody>
			</table>
		</div>
	</div>
	<script src="/webjars/jquery/3.6.0/jquery.min.js"></script>
	<script src="/webjars/bootstrap/5.0.1/js/bootstrap.min.js"></script>		
</body>
</html> 