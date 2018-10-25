<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<!-- CSS & Font Awesome -->
<spring:url value="/resources/CSS/bootstrap.min.css" var="bootstrapCSS" />
<spring:url value="/resources/CSS/custom.css" var="customCSS" />
<spring:url
	value="/resources/FontAwesome/fontawesome-free-5.4.1-web/css/all.css"
	var="fontAwesome" />

<!-- JavaScripts -->
<spring:url value="/resources/JSFiles/bootstrap.min.js"
	var="bootstrapJS" />
<spring:url value="/resources/JSFiles/jquery-3.3.1.min.js"
	var="jqueryJS" />

<!-- Images -->
<spring:url value="/resources/imgs/atos_syntel.jpg" var="logo"></spring:url>

<link href="${customCSS}" rel="stylesheet" />
<link href="${fontAwesome}" rel="stylesheet" />
<link href="${bootstrapCSS}" rel="stylesheet" />
<script src="${jqueryJS}"></script>
<script src="${bootstrapJS}"></script>

<title>Requestor Dashboard | TRM</title>
</head>
<body>
	<div id="nav-wrapper">
		<nav
			class="navbar navbar-expand-lg navbar-light bg-dashboard-darkblue">
		<a class="navbar-brand" href="#"><img src="${logo}"></a>
		<div id="profile">
			<span>Hello, User!</span>
		</div>
		</nav>
		<nav id="nav-links" class="nav nav-pills nav-fill bg-dashboard-dark">
		<li class="nav-item"><a class="nav-link" href="RequestDash"><i
				class="fas fa-desktop"></i> Home</a></li>
		<li class="nav-item"><a class="nav-link nav-active" href="NewRequest"><i
				class="fas fa-chalkboard-teacher"></i> New Training Request</a></li>
		</nav>
	</div>
	<div class="container-fluid main-content bg-dashboard-darkblue">

		<div class="row">

			
			<div class="col-lg-12">
				<div class="card">
					<div class="card-body table-scrollable info-card">
						<div class="card-title-border">
							<h2 class="card-title">New Requests</h2>
						</div>
						<table id="newRequestsTable" class="table">
							<thead>
								<tr>
									<th scope="col"></th>
									<th scope="col"></th>
									<th scope="col"></th>
									<th scope="col"></th>
								</tr>
							</thead>
							<tbody>
							         <tr>
								          <td>Project ID:</td>    
								          <td><input type="text"CT_PROJECT_ID"/></td>  
								         <td>Technology:</td>    
								          <td><input type="text"CT_TECHNOLOGY" /></td>  
							         </tr> 
							         <tr>
								         <td>Training Objectives:</td>    
								          <td><input type="text"CT_TRAINING_OBJECTIVES" /></td>  
								         <td>Date Requested:</td>    
								          <td><input type="text"CT_DATE_REQUESTED" /></td>  
							         </tr> 
							         <tr>
								         
								          <td>Proposed End Date:</td>    
								          <td><input type="date"CT_PROPOSED_END_DATE"  /></td>  
								          <td>Proposed Training Location:</td>    
								          <td><input type="text"CT_PROPOSED_LOCATION"  /></td> 
								     </tr> 
							         <tr> 
								         <td>Training Approx number of Employees:</td>    
								         <td><input type="text" CT_APPROX_NO_EMPLOYEES"  /></td> 
								         <td>Training Employee Requester ID:</td>    
								         <td><input type="text"CT_REQUESTOR_EMPLOYEE_ID"  /></td>  
								     </tr> 
							         <tr>    
								         <td>Training Approved File Location:</td>    
								         <td><input type="text"CT_APPROVED_FILE_LOCATION"  /></td>  
								         <td>Project Training SPOC:</td>    
								         <td><input type="text"CT_APPROVED_FILE_LOCATION"  /></td>  
							          </tr>
							          <tr>
							            
							          <td colspan="4"><input type="submit" value="Submit" /></td>    
							         </tr>    
								
							</tbody>
						</table>
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