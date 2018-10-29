<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="d" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	
		<!-- CSS & Font Awesome -->
<%-- 		<spring:url value="/resources/CSS/bootstrap.min.css"  var="bootstrapCSS"/>
 --%>		<spring:url value="/resources/CSS/custom.css"  var="customCSS"/>
		<spring:url value="/resources/FontAwesome/fontawesome-free-5.4.1-web/css/all.css" var="fontAwesome" />
		
<%-- 		<!-- JavaScripts -->
		<spring:url value="/resources/JSFiles/bootstrap.min.js"  var="bootstrapJS"/>
		<spring:url value="/resources/JSFiles/jquery-3.3.1.min.js" var="jqueryJS" /> --%>
		
		<!-- Images -->
		<spring:url value="/resources/imgs/logo-sm.png" var="logo"></spring:url>
		
		<link href="${customCSS}" rel="stylesheet" />
		<link href="${fontAwesome}" rel="stylesheet" />
<%-- 		<link href="${bootstrapCSS}" rel="stylesheet" /> --%>
<%-- 		<script src="${jqueryJS}"></script> --%>
<%-- 		<script src="${bootstrapJS}"></script> --%>

	<!-- Latest compiled and minified CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
	
	<!-- jQuery library -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	
	<!-- Popper JS -->
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
	
	<!-- Latest compiled JavaScript -->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
	<title>Admin Dashboard | TRM</title>
	
	
</head>
<body>
<!-- Navbar -->

<div class="modal-header">
</div>
<div class="modal-body">
<div class="container-fluid main-content bg-dashboard-darkblue">


<div class="col-lg-12">
	<div class="card">
    	<div class="card-body table-scrollable info-card">
    		<div class="card-title-border">
            	<h2 class="card-title">${trfID}</h2>
            </div>
			<a href="../editform1internal/${trfID}" onclick="return confirm('Are you sure you want to submit?')" >InternalTraining</a>
		</div>
	</div>
</div>
	
</div>

</div>
<div class="modal-footer">
</div>


</body>
</html>	