<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	
		<!-- CSS & Font Awesome -->
		<spring:url value="/resources/CSS/bootstrap.min.css"  var="bootstrapCSS"/>
		<spring:url value="/resources/CSS/custom.css"  var="customCSS"/>
		<spring:url value="/resources/FontAwesome/fontawesome-free-5.4.1-web/css/all.css" var="fontAwesome" />
		
		<!-- JavaScripts -->
		<spring:url value="/resources/JSFiles/bootstrap.min.js"  var="bootstrapJS"/>
		<spring:url value="/resources/JSFiles/jquery-3.3.1.min.js" var="jqueryJS" />
		
		<!-- Images -->
		<spring:url value="/resources/imgs/logo-sm.png" var="logo"></spring:url>
		
		<link href="${customCSS}" rel="stylesheet" />
		<link href="${fontAwesome}" rel="stylesheet" />
<%-- 		<link href="${bootstrapCSS}" rel="stylesheet" /> --%>
<%-- 		<script src="${jqueryJS}"></script> --%>
<%-- 		<script src="${bootstrapJS}"></script> --%>
		
<!-- 		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">		
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script> -->
		<!-- Latest compiled and minified CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
	
	<!-- jQuery library -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	
	<!-- Popper JS -->
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
	
	<!-- Latest compiled JavaScript -->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
	<title>Vendors | TRM</title>
	
	
</head>

<style>
td{
	width: 150px;
	word-wrap: break-word;
}
</style>


<body>

<!-- Navbar -->
<div id="nav-wrapper">
	<nav class="navbar navbar-expand-lg navbar-light bg-dashboard-darkblue"> 
    	<a class="navbar-brand" href="#"><img src="${logo}" class="logo-corner" alt="logo"/></a>
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
      <li class="nav-item"><a class="nav-link" href="#"><i class="fas fa-book-reader"></i> Trainers</a></li>
    </nav>
</div>

<div class="container-fluid main-content bg-dashboard-darkblue">
	<div class="row">
	
	
	      <div class="col-lg-12">
	          <div class="card">
	              <div class="card-body table-scrollable info-card">
	                <div class="card-title-border">
	                    <h2 class="card-title">Vendors</h2>
	                </div>
	                <table id="newRequestsTable" class="table">
	                    <thead>
	                    	<tr>
							<th>Name</th>
							<th>Location</th>
							<th>Address</th>
							<th>SPOC</th>
							<th>Phone</th>
							<th>Email</th>
							</tr>
	                    </thead>
	                    <tbody>
	                    	<c:forEach var="ven" items="${vendorList}">
								<tr>
									<td>${ven.getVenName()}</td>
									<td>${ven.getVenLocation()}</td>
									<td>${ven.getVenAddress()}</td>
									<td>${ven.getVenSpoc()}</td>
									<td>${ven.getVenPhone()}</td>
									<td>${ven.getVenEmail()}</td>
									<td>
										<a data-toggle="modal" href="editVendor/${ven.getVenId()}" data-target="#editVen">
											<img src="/TRMProject/images/editicon.jpg" width=30 height=30/>
										</a>
									</td>
									<td>
										<a href="deleteVendor/${ven.getVenId()}" onclick="return confirm('Are you sure?')">
											<img src="/TRMProject/images/delete.png" width=30 height=30/>
										</a>
									</td>
								</tr>
							</c:forEach>
	                    </tbody>
	                  </table>
	              </div>
	          </div>
          
          <form action="insertVendorForm">
	          <div class="row">
		          <div class="col-lg-4">
		          	<button class="btn btn-block btn-mint" type="submit" >Insert New Vendor</button>
		          </div>
		          <div class="col-lg-4">
					<a class="btn btn-block btn-primary" href="showVendorEmp" >View Vendor Employees</a>
		          </div>
	          </div>
		  </form>
		  
		</div>		
		
	</div>
</div>
	
	
	
	<div class="modal fade" id="editVen" role="dialog">
    	<div class="modal-dialog modal-lg">
      		<div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">Modal Header</h4>
        </div>
        <div class="modal-body">
        	<form method="POST" action="editVendorSave"> 
				<table>
					<tr>
						<td>Vendor ID: </td>
						<td><input type="text" name="venId" required size="20" height="50" readonly="true"/></td>
					</tr>
					<tr>
						<td>Name: </td>
						<td><input type="text" name="venName" required size="20" height="50" /></td>
					</tr>
					<tr>
						<td>Location: </td>
						<td><input type="text" name="venLocation" required size="20" height="50" /></td>
					</tr>
					<tr>
						<td>Address: </td>
						<td><input type="text" name="venAddress" required size="20" height="50" /></td>
					</tr>
					<tr>
						<td>SPOC: </td>
						<td><input type="text" name="venSpoc" required size="20" height="50" /></td>
					</tr>
					
					<tr>
						<td>Phone: </td>
						<td><input type="text" name="venPhone" required size="20" height="50" /></td>
					</tr>
					<tr>
						<td>Email: </td>
						<td><input type="text" name="venEmail" required size="20" height="50" /></td>
					</tr>
					<tr>
						<td>
							<input type="submit" value="Edit Save" />
						</td>
					</tr>
				</table>
			
			</form>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        </div>
      </div>
    </div>
  </div>
	
</body>
</html>