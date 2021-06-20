<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %> 

			
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Add song</title>
	<link rel="stylesheet" href="/webjars/bootstrap/5.0.1/css/bootstrap.min.css" />
</head>
<body>
	<div class="container mt-5 border border-dark">
		<nav class="navbar navbar-light mt-2">
			<div class="container-fluid">
				<a class="nav-link disabled text-start">Add song</a>
				<a href="/dashboard" class="nav-link text-end">Dashboard</a>
			</div>
		</nav>
		<div class="main form-group row mt-2 p-3 bg-light">
			<form:form action="/songs/new" method="post" modelAttribute="song">
	    		<p class="m-3">
	        		<form:label  class="col-sm-2 col-form-label" path="title">Title (min 3 characters)</form:label>
	        		<form:errors class="text-danger" path="title"/>
	        		<form:input class="form-control" path="title"/>
	    		</p>
			    <p class="m-3">
			        <form:label class="col-sm-2 col-form-label" path="artist">Artist (min 3 characters)</form:label>
			        <form:errors class="text-danger" path="artist"/>
			        <form:textarea class="form-control" path="artist"/>
			    </p>
			    <p class="m-3">
			        <form:label class="col-sm-2 col-form-label" path="genre">Genre (min 3 characters)</form:label>
			        <form:errors class="text-danger" path="genre"/>
			        <form:textarea class="form-control" path="genre"/>
			    </p>
			    <p class="m-3">
			        <form:label class="col-sm-2 col-form-label" path="rating">Rating (1-10)</form:label>
			        <form:errors class="text-danger" path="rating"/>
			        <form:input class="form-control" path="rating" message="must be between 1-10"/>
			    </p>  
				<input type="submit" value="Add song" class="m-3"/>
			</form:form>
		</div>
	</div>
	<script src="/webjars/jquery/3.6.0/jquery.min.js"></script>
    <script src="/webjars/bootstrap/5.0.1/js/bootstrap.min.js"></script>		
</body>
</html>