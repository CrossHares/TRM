<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix = "form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<spring:url value="/resources/CSS/bootstrap.min.css"  var="bootstrapCSS"/>
	<spring:url value="/resources/CSS/custom.css"  var="customCSS"/>
	<spring:url value="/resources/FontAwesome/fontawesome-free-5.4.1-web/css/all.css" var="fontAwesome" />
	<spring:url value="/resources/JSFiles/bootstrap.min.js"  var="bootstrapJS"/>
	<spring:url value="/resources/JSFiles/jquery-3.3.1.min.js" var="jqueryJS" />
	
	<link href="${customCSS}" rel="stylesheet" />
	<link href="${fontAwesome}" rel="stylesheet" />
	<link href="${bootstrapCSS}" rel="stylesheet" />
	<script src="${jqueryJS}"></script>
	<script src="${bootstrapJS}"></script>
	
<title>Executive Dashboard | L&D</title>
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
      <li class="nav-item"><a class="nav-link nav-active" href="#"><i class="fas fa-desktop"></i> Home</a></li>
      <li class="nav-item"><a class="nav-link" href="#"><i class="fas fa-chalkboard-teacher"></i> Training</a></li>
      <li class="nav-item"><a class="nav-link" href="#"><i class="fab fa-wpforms"></i> Request Form</a></li>
      <li class="nav-item"><a class="nav-link" href="#"><i class="fas fa-chart-bar"></i> Reports</a></li>
      <li class="nav-item"><a class="nav-link" href="#"><i class="fas fa-users"></i> Users</a></li>
      <li class="nav-item"><a class="nav-link" href="#"><i class="fas fa-box-open"></i> Vendors</a></li>
      <li class="nav-item"><a class="nav-link" href="#"><i class="fas fa-book-reader"></i> Trainers</a></li>
    </nav>
  </div>
  <div class="container-fluid main-content bg-dashboard-darkblue">

    <div class="row">

      <!-- Ongoing Trainings -->
      <div class="col-lg-8 offset-md-2">
          <div class="card">
              <div class="card">
                  <div class="card-body table-scrollable info-card">
                    <div class="card-title-border">
                        <h2 class="card-title">Confirmed Training Information</h2>
                    </div>
					<form:form method="POST" action="../ExecDashboard">
                    <table id="trainingInfo" class="table">
                        <thead>
                          <tr>
                            <th scope="col">Information</th>
                            <th scope="col" class="tablecol-size">Details</th>
                          </tr>
                        </thead>
                        <tbody>
						<tr>
                        	<th>Training ID</th>
                            <td><form:input path="trf_id" readonly="true" style="width:50%;"/></td>
						</tr>
                        <tr>
                          	<th>Training Request FormID</th>
							<td><form:input path="trf_id" readonly="true" style="width:50%;"/></td>
						</tr>
						<tr>
							<th>Verification ID </th>
							<td><form:input path="ver_id" readonly="true" style="width:50%;"/></td>
						</tr>
						<tr>
							<th>Vendor ID </th>
							<td><form:input path="ven_id" readonly="true" style="width:50%;"/></td>
						</tr>
						<tr>
							<th>Training TypeID</th>
							<td><form:input path="tt_id" readonly="true" style="width:50%;"/></td>
						</tr>
						<tr>
							<th>Overall Status ID </th>
							<td><form:input path="os_id" readonly="true" style="width:50%;"/></td>
						</tr>
						<tr>
							<th>Project ID</th>
							<td><form:input path="ct_project_id" readonly="true" style="width:50%;"/></td>
						</tr>
						<tr>
							<th>Technology</th>
							<td><form:input path="ct_technology" readonly="true" style="width:50%;"/></td>
						</tr>
						<tr>
							<th>Training Objectives</th>
							<td><form:input path="ct_training_objectives" readonly="true" style="width:50%;"/></td>
						</tr>
						<tr>
							<th>Date Requested</th>
							<td><form:input path="ct_date_requested" readonly="true" style="width:50%;"/></td>
						</tr>
						<tr>
							<th>Proposed Start Date</th>
							<td><form:input path="ct_proposed_start_date" readonly="true" style="width:50%;"/></td>
						</tr>
						<tr>
							<th>Proposed End Date</th>
							<td><form:input path="ct_proposed_end_date" readonly="true" style="width:50%;"/></td>
						</tr>
						<tr>
							<th>Proposed Start Time</th>
							<td><form:input path="ct_proposed_start_time" readonly="true" style="width:50%;"/></td>
						</tr>
						<tr>
							<th>Proposed End Time</th>
							<td><form:input path="ct_proposed_end_time" readonly="true" style="width:50%;"/></td>
						</tr>
						<tr>
							<th>Proposed Location</th>
							<td><form:input path="ct_proposed_location" readonly="true" style="width:50%;"/></td>
						</tr>
						<tr>
							<th>Learning Development TM ID</th>
							<td><form:input path="ct_room_no" readonly="true" style="width:50%;"/></td>
						</tr>
						<tr>
							<th>Room Number</th>
							<td><form:input path="ldtm_id" readonly="true" style="width:50%;"/></td>
						</tr>
						<tr>
							<th>Project Training SPOC</th>
							<td><form:input path="ct_project_training_spoc" readonly="true" style="width:50%;"/></td>
						</tr>
						<tr>
							<th>Approx Number of Employees</th>
							<td><form:input path="ct_approx_no_employees" readonly="true" style="width:50%;"/></td>
						</tr>
						<tr>
							<th>Requestor Employee ID</th>
							<td><form:input path="ct_requestor_employee_id" readonly="true" style="width:50%;"/></td>
						</tr>
						<tr>
							<th>Approved File Location</th>
							<td><form:input path="ct_approved_file_location" readonly="true" style="width:50%;"/></td>
						</tr>
						<tr>
							<th>Training Source</th>
							<td><form:input path="ct_training_source" readonly="true" style="width:50%;"/></td>
						</tr>
						<tr>
							<th>Nomination File</th>
							<td><form:input path="ct_nomination_file" readonly="true" style="width:50%;"/></td>
						</tr>
						<tr>
							<th>Assigned Executive</th>
							<td><form:input path="ct_assigned_exec" readonly="true" style="width:50%;"/></td>
						</tr>
						<tr>
							<th>Hide Status</th>
							<td><form:input path="ct_hide_status" readonly="true" style="width:50%;"/></td>
						</tr>
						<tr>
							<th>Button Count</th>
							<td><form:input path="ct_button_count" readonly="true" style="width:50%;"/></td>
						</tr>                   
						</tbody>
                      </table>
                      <input class="btn btn-mint" type = "submit" value="Back"/>
                      </form:form>
						</table>
                  </div>
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
	
</body>
</html>