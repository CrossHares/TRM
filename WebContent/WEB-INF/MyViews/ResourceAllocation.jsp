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
	  <nav class="navbar navbar-expand-lg navbar-light bg-dashboard-darkblue"> 
      <a class="navbar-brand" href="#"><img src="atos_syntel.jpg"></a>
      <div id="profile">
          <span>Hello, Executive!</span>
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
                        <h2 class="card-title">Confirmed Training</h2>
                    </div>
                    <form:form method="POST" action="../editallocationresources">
                    <table id="trainersTable" class="table">
                        <thead>
                          <tr>
                            <th scope="col">Information</th>
                            <th scope="col" class="tablecol-size">Details</th>
                          </tr>
                        </thead>
                        <tbody>
							<tr>
                            	<th>Training ID</th>
                            	<td><form:input class="nochange" path="trf_id" readonly="true" style="width:50%;"/></td>
                          </tr>
                          <tr>
                            <th>Trainer</th>
                            <td><form:input class="nochange" path="ldtm_id" readonly="true" style="width:50%;"/></td>
                          </tr>
                          <tr>
                            <th>Date</th>
                            <td><form:input class="nochange" path="ct_proposed_start_date" readonly="true" style="width:50%;"/></td>
                          </tr>  
                          <tr>
                            <th>Time</th>
                            <td><form:input class="nochange" path="ct_proposed_start_time" readonly="true" style="width:50%;"/></td>
                          </tr>
                          <tr>
                            <th>Location</th>
                            <td><form:select path="ct_proposed_location" style="width:50%;">
									<form:option value="Phoenix"/>
									<form:option value="Memphis"/>
									<form:option value="Dallas"/>
									<form:option value="Portland"/>
									<form:option value="Other"/>
								</form:select>
                            </td>
                          </tr>
                          <tr>
                            <th>Room#</th>
                            <td><form:input path="ct_room_no" placeholder="RoomNumber" style="width:50%;"/></td>
                          </tr>
                        </tbody>
                      </table>
                      <input class="btn btn-mint" type = "submit" value="Save"/>
                      <input class="btn btn-mint" formaction="../submitallocationresources" type = "submit" value="Submit"/>
                      <input class="btn btn-mint" formaction="../ExecDashboard" type = "submit" value="Back"/>
                      </form:form>
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