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
		<nav class="navbar navbar-light bg-light">
			<div class="container-fluid">
				<p class="text-start">Songs by <c:out value="${song.artist}"/></p>
	    		<form:form class="d-flex" action="/search" method="post">
	    			<input class="form-control me-2" name="artist" type="search" placeholder="New search" aria-label="Search">
	        		<button class="btn btn-outline-primary" type="submit">Search</button>
	     		</form:form>
	  			<a class="nav-link text-end" href="/dashboard">Dashboard</a>
			</div>
		</nav>
		<div class="main form-group row">
			<table class="table table-striped">
	    		<thead>
	        		<tr>
	            		<th>Name</th>
	            		<th>Genre</th>
	            		<th>Rating</th>
	            		<th>Actions</th>
	        		</tr>
	    		</thead>
	    		<tbody>
	        		<c:forEach items="${songs}" var="song">
	        			<tr>
	            			<td><a href="/songs/${song.id}"><c:out value="${song.title}"/></a></td>
	            			<td><c:out value="${song.genre}"/></td>
	            			<td><c:out value="${song.rating}"/></td>
	            			<td>
		            			<a class="m-3" href="/songs/${song.id}/delete">Delete</a>            	
	            			</td>
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