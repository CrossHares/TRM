<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>Requestor Dashboard | TRM</title>
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
<body>
	<div id="nav-wrapper">
		<nav class="navbar navbar-light bg-dashboard-darkblue"> 
    		<a class="navbar-brand" href="#" class="my-2 my-lg-0"><img src="${logo}" class="logo-corner" alt="logo"/></a>
	    	<div id="profile">
	        	<span>Hello, <%= session.getAttribute("loginmessage") %></span>
	      	</div>
		</nav>
		<nav id="nav-links" class="nav nav-pills nav-fill bg-dashboard-dark">
			<li class="nav-item"><a class="nav-link" href="RequestDash"><i class="fas fa-desktop"></i> Home</a></li>
			<li class="nav-item"><a class="nav-link nav-active" href="NewRequest"><i class="fas fa-chalkboard-teacher"></i> New Training Request</a></li>
		</nav>
	</div>
	<div class="container-fluid main-content bg-dashboard-darkblue">

		<div class="row">


			<div class="col-lg-8 offset-md-2">
				<div class="card">
					<div class="card-body table-scrollable info-card">
						<div class="card-title-border">
							<h2 class="card-title">New Requests</h2>
						</div>
						<form action="savenew">
							<table class="table">
								<tbody>
									<tr>
										<td>Vertical ID :</td>
										<td><select name="verID">
												<option value="NONE" label="--- Select an Option ---" />
												<option value="1">Banking and Financial Services</option>
												<option value="2">Healthcare and Life Sciences</option>
												<option value="3">Insurance</option>
												<option value="4">Retail and Logistics</option>
												<option value="5">Telecom, Media, and Tech</option>
												<option value="6">Telecom, Media, and Tech</option>
										</select></td>
									</tr>
									<tr>
										<td>Vendor ID :</td>
										<td><input type="text" name="venID" /></td>
									</tr>
									<tr>
										<td>Training Type ID :</td>
										<td><select name="ttID">
												<option value="NONE" label="--- Select an Option ---" />
												<option value="1">Classroom</option>
												<option value="2">Virtual Classroom</option>
												<option value="3">Webex</option>
										</select></td>
									</tr>
									<tr>
										<td>Project ID:</td>
										<td><input type="text" name="trfProjectID" required
											size="30" height="40" /></td>
									</tr>
									<tr>
										<td>Technology:</td>
										<td><input type="text" name="technology" required
											size="30" height="40" /></td>
									</tr>
									<tr>
										<td>Training Objectives:</td>
										<td><input type="text" name="trainingObjectives" required
											size="30" height="40" /></td>
									</tr>
									<tr>
										<td>Date Requested:</td>
										<script>
											$(document)
													.ready(
															function() {
																var date = new Date();
	
																var day = date
																		.getDate();
																var month = date
																		.getMonth() + 1;
																var year = date
																		.getFullYear();
	
																if (month < 10)
																	month = "0"
																			+ month;
																if (day < 10)
																	day = "0" + day;
	
																var today = year
																		+ "-"
																		+ month
																		+ "-" + day;
																$("#theDate").attr(
																		"value",
																		today);
															});
										</script>
										<td><input id="theDate" type="date" name="dateRequested"
											readonly="true" required size="30" height="40" /></td>
									</tr>
									<tr>
										<td>Proposed End Date:</td>
										<td><input type="date" name="proposedEndDate" required
											size="30" height="40" /></td>
									</tr>
									<tr>
										<td>Project SPOC:</td>
										<td><input type="text" name="projectSPOC" required
											size="30" height="40" /></td>
									</tr>
									<tr>
										<td>Approx. No. Employees:</td>
										<td><input type="text" name="appxEmployees" required
											size="30" height="40" /></td>
									</tr>
									<tr>
										<td>Requestor Employee ID:</td>
										<td><input type="text" name="requestorEmpID" required
											size="30" height="40" /></td>
									</tr>
									<tr>
										<td>File Location:</td>
										<td><input type="text" name="fileLocation" size="30"
											height="40" /></td>
									</tr>
									<tr>
										<td>Training Source:</td>
										<td><input type="radio" name="trainingSource" value="1"
											size="30" height="40" />Internal<br> <input type="radio"
											name="trainingSource" value="2" size="30" height="40" />Development
											Team<br> <input type="radio" name="trainingSource"
											value="3" size="30" height="40" />Vendor</td>
									</tr>
									<tr>
										<td></td>
										<td><input type="submit" value="save form" /></td>
								</tbody>
							</table>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- Footer -->
	<div>
		<footer class="bg-dashboard-dark"> <span>&copy;
			Copyright Atos | Syntel</span> </footer>
	</div>

</body>
</html>


