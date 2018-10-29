<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<div id="nav-wrapper">
	<nav class="navbar navbar-expand-lg navbar-light bg-dashboard-darkblue"> 
    	<a class="navbar-brand" href="#" class="my-2 my-lg-0"><img src="${logo}" class="logo-corner" alt="logo"/></a>
    	<div id="profile">
        	<span>Hello, <%= session.getAttribute("loginmessage") %></span>
      	</div>
	</nav>
    <nav id="nav-links" class="nav nav-pills nav-fill bg-dashboard-dark">
      <li class="nav-item"><a class="nav-link nav-active" href="#"><i class="fas fa-desktop"></i> Home</a></li>
      <li class="nav-item"><a class="nav-link" href="#"><i class="fas fa-chalkboard-teacher"></i> Training</a></li>
      <li class="nav-item"><a class="nav-link" href="#"><i class="fab fa-wpforms"></i> Request Form</a></li>
      <li class="nav-item"><a class="nav-link" href="reports"><i class="fas fa-chart-bar"></i> Reports</a></li>
      <li class="nav-item"><a class="nav-link" href="#"><i class="fas fa-users"></i> Users</a></li>
      <li class="nav-item"><a class="nav-link" href="showAllVendors"><i class="fas fa-box-open"></i> Vendors</a></li>
      <li class="nav-item"><a class="nav-link" href="showLDTrainingMember"><i class="fas fa-book-reader"></i> Trainers</a></li>
    </nav>
</div>

<div class="container-fluid main-content bg-dashboard-darkblue">
	<div class="col-lg-12">
		<div class="card">
    		<div class="card-body table-scrollable info-card">
    			<div class="card-title-border">
            		<h2 class="card-title">Assign Executive</h2>
            	</div>
					<form action="../editassignexecutives/${trfID}" style="background-color: khaki; border: dotted;color:red">	
						<select name="executive">
							<c:forEach var="executivename" items="${allExecutives}"> 
								<option value="${executivename.getLD_USER_NAME()}">${executivename.getLD_USER_NAME()}</option>
							</c:forEach>
						</select>
						<input type="submit" onclick="return confirm('Are you sure you'd assign this Executive?')" value ="Submit"/>
					</form>
			</div>
		</div>
	</div>
</div>
</body>
</html>