<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>   
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="ISO-8859-1">
<title>Training Members | TRM</title>
    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
 
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
      <li class="nav-item"><a class="nav-link" href="showAllVendors"><i class="fas fa-box-open"></i> Vendors</a></li>
      <li class="nav-item"><a class="nav-link nav-active" href="#"><i class="fas fa-book-reader"></i> Trainers</a></li>
    </nav>
</div>

<div class="container-fluid main-content bg-dashboard-darkblue">
	<div class="row">
	 <div class="col-lg-12">
	          <div class="card">
	              <div class="card-body table-scrollable info-card">
	                <div class="card-title-border">
	                    <h2 class="card-title">L&D Training Members Page</h2>
	                </div>
	                <table id="newRequestsTable" class="table">
		                <thead>
			                <tr>
								<th>Name</th>
								<th>Location</th>
								<th>Email</th>
								<th>Phone</th>
								<th>Tech Specialty</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="ldtm" items="${ldtmList}">
								<tr>
									<td>${ldtm.getLdtmName()}</td>
									<td>${ldtm.getLdtmLocation()}</td>
									<td>${ldtm.getLdtmEmail()}</td>
									<td>${ldtm.getLdtmPhone()}</td>
									<td>${ldtm.getTechSpecialty()}</td>
									<td>
										<a data-toggle="modal" href="editLDTMember/${ldtm.getLdtmId()}" data-target="#editLDTMember">
											<i class="far fa-2x fa-arrow-alt-circle-right"></i>
										</a>
										
									</td>
									<td>
										<a href="deleteLDTrainingMember/${ldtm.getLdtmId()}" onclick="return confirm('Are you sure?')">
											<i class="far fa-2x fa-times-circle" style="color: red"></i>
										</a>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					<form action="insertLDTrainingMembers">
						<button type="submit" class="btn btn-mint">Insert New Training Member</button>
					</form>
				</div>
			</div>
		</div>
	</div>
</div>
	
	
<!-- Footer -->
 <div>
   <footer class="bg-dashboard-dark">
       <span>&copy; Copyright Atos | Syntel</span>
   </footer>
 </div>	
	
	
	
<div class="modal" id="editLDTMember" tabindex="-1" role="dialog">
	<div class="modal-dialog" role="document">
    	<div class="modal-content">
      		<div class="modal-header">
        		<h5 class="modal-title">Insert New Member</h5>
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
		          <span aria-hidden="true">&times;</span>
		        </button>
        	</div>
        	<div class="modal-body">
				<form method="POST" action="editLDTMemberSave"> 
					<table>
						<tr>
							<td>LDT Member ID: </td>
							<td><input type="text" name="ldtmId" required size="20" height="50" readonly="true" /></td>
						</tr>
						<tr>
							<td>Name: </td>
							<td><input type="text" name="ldtmName" required size="20" height="50" /></td>
						</tr>
						<tr>
							<td>Location: </td>
							<td><input type="text" name="ldtmLocation" required size="20" height="50" /></td>
						</tr>
						<tr>
							<td>Email: </td>
							<td><input type="text" name="ldtmEmail" required size="20" height="50" /></td>
						</tr>
						<tr>
							<td>Phone: </td>
							<td><input type="text" name="ldtmPhone" required size="20" height="50" /></td>
						</tr>
						
						<tr>
							<td>Tech Specialty: </td>
							<td><input type="text" name="techSpecialty" required size="20" height="50" /></td>
						</tr>
						<tr>
							<td>
								<input class="btn btn-block btn-mint" type="submit" value="Add Member" />
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