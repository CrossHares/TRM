<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@page import="javax.servlet.annotation.MultipartConfig"%>
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
	
<title>Executive Send Email</title>
</head>
<body>
<%String saving;%>
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
                        <h2 class="card-title">Send Email</h2>
                    </div>
					<form:form method="POST" action="../sendEmail">
                    <table id="trainingInfo" class="table">
                        <thead>
                          <tr>
                            <th scope="col">Input Text for Email</th>
                          </tr>
                        </thead>
                        <tbody>
                            <tr hidden="true">
                            	<td><form:textarea rows="11" path="trf_id" readonly="true"/></td>
							</tr>   
                            <tr hidden="true">
                            	<td><form:input name="trainingName" path="ct_technology" readonly="true" style="width:100%; height:100%;"/></td>
							</tr>
							<tr hidden="true">
                            	<td><form:input name="startDate" path="ct_proposed_start_date" readonly="true" style="width:100%; height:100%;"/></td>
							</tr>
							<tr hidden="true">
                            	<td><form:input name="startTime" path="ct_proposed_start_time" readonly="true" style="width:100%; height:100%;"/></td>
							</tr>
							<tr hidden="true">
                            	<td><form:input name="endTime" path="ct_proposed_end_time" readonly="true" style="width:100%; height:100%;"/></td>
							</tr>
                            <tr>
                            	<td><input name="passcode" placeholder="Passcode" style="width:25%; height:100%;"/></td>
							</tr>
							 <tr>
                            	<td><input name="meetingno" placeholder="Meeting Number" style="width:25%; height:100%;"/></td>
							</tr>
							 <tr>
                            	<td><input name="meetingpass" placeholder="Meeting Password" style="width:25%; height:100%;"/></td>
							</tr>          
						</tbody>
                      </table>
                      <input class="btn btn-mint" type = "submit" value="Send Email"/>
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