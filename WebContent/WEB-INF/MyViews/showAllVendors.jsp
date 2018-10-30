<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>Vendors | TRM</title>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	
	<!-- CSS & Font Awesome -->
	<spring:url value="/resources/CSS/custom.css"  var="customCSS"/>
	<spring:url value="/resources/FontAwesome/fontawesome-free-5.4.1-web/css/all.css" var="fontAwesome" />
	
	<!-- Images -->
	<spring:url value="/resources/imgs/logo-sm.png" var="logo"></spring:url>
	
	<link href="${customCSS}" rel="stylesheet" />
	<link href="${fontAwesome}" rel="stylesheet" />
		
	<!-- Latest compiled and minified CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
	
	<!-- jQuery library -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	
	<!-- Popper JS -->
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
	
	<!-- Latest compiled JavaScript -->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
	
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
	<nav class="navbar navbar-light bg-dashboard-darkblue"> 
    	<a class="navbar-brand" href="#"><img src="${logo}" class="logo-corner" alt="logo"/></a>
    	<div id="profile">
        	<span>Hello, <%= session.getAttribute("loginmessage") %></span>
      	</div>
	</nav>
    <nav id="nav-links" class="nav nav-pills nav-fill bg-dashboard-dark">
      <li class="nav-item"><a class="nav-link" href="AdminDashboard"><i class="fas fa-desktop"></i> Home</a></li>
      <li class="nav-item"><a class="nav-link" href="#"><i class="fas fa-chalkboard-teacher"></i> Training</a></li>
      <li class="nav-item"><a class="nav-link" href="#"><i class="fab fa-wpforms"></i> Request Form</a></li>
      <li class="nav-item"><a class="nav-link" href="reports"><i class="fas fa-chart-bar"></i> Reports</a></li>
      <li class="nav-item"><a class="nav-link" href="#"><i class="fas fa-users"></i> Users</a></li>
      <li class="nav-item"><a class="nav-link nav-active" href="#"><i class="fas fa-box-open"></i> Vendors</a></li>
      <li class="nav-item"><a class="nav-link" href="showLDTrainingMember"><i class="fas fa-book-reader"></i> Trainers</a></li>
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
											<i class="far fa-2x fa-arrow-alt-circle-right"></i>
										</a>
									</td>
									<td>
										<a href="deleteVendor/${ven.getVenId()}" onclick="return confirm('Are you sure?')">
											<i class="far fa-2x fa-times-circle" style="color: red"></i>
										</a>
									</td>
								</tr>
							</c:forEach>
	                    </tbody>
	                  </table>
	              </div>
	          </div>
          
          <form action="insertVendorForm" style="padding-top: 20px">
	          <div class="row">
		          <div class="col-lg-6">
		          	<button class="btn btn-block btn-mint" type="submit" >Insert New Vendor</button>
		          </div>
		          <div class="col-lg-6">
					<a class="btn btn-block btn-primary btn-atag" href="showVendorEmp" >View Vendor Employees</a>
		          </div>
	          </div>
		  </form>
		  
		</div>		
		
	</div>
</div>

<!-- Footer -->
  <div>
    <footer class="bg-dashboard-dark">
        <span>&copy; Copyright Atos | Syntel</span>
    </footer>
  </div>
	
	
	
	<div class="modal" id="editVen" tabindex="-1" role="dialog">
  		<div class="modal-dialog" role="document">
    		<div class="modal-content">
      			<div class="modal-header">
        			<h5 class="modal-title">Edit Vendor</h5>
			        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
			          <span aria-hidden="true">&times;</span>
			        </button>
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
								<td style="padding-top: 10px">
									<input class="btn btn-block btn-mint" type="submit" value="Save" />
								</td>
							</tr>
						</table>
					
					</form>
		        </div>
		        <div class="modal-footer">
		          <button type="button" class="btn btn-block btn-danger" data-dismiss="modal">Close</button>
		        </div>
		      </div>
	      </div>
	  </div>
	
</body>
</html>