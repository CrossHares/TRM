<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="pop" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>Executive Dashboard | L&D</title>
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

    <div class="row">

      <!-- Trainers Card-->
      <div class="col-lg-8 offset-md-2">
          <div class="card">
              <div class="card">
                  <div class="card-body table-scrollable info-card">
                    <div class="card-title-border">
                        <h2 class="card-title">Trainings</h2>
                    </div>
                    <table id="trainersTable" class="table">
                        <thead>
                          <tr>
                            <th scope="col">Training Name</th>
                            <th scope="col" class = "tablecol-progressbar">Status</th>
                            <th scope="col">Next Work Flow</th>
                          </tr>
                        </thead>
                        
                        <pop:forEach var="confirmedTraining" items="${allTrainings}">
                        <tbody>
	                      <pop:if test='${confirmedTraining.getOs_id()==6 && confirmedTraining.getCt_hide_status() == 1}'>
	                      <tr>
	                  	 	  	<th class="trainingName">${confirmedTraining.getCt_technology().toLowerCase()}</th>
	                  	 	  	<td><div class="progress">
    								<div class="progress-bar progressbar-ATR" role="progressbar"
    								aria-valuenow="10" aria-valuemin="0" aria-valuemax="100" style="width:10%;">
      								0%
      								</div>
      							</div></td>
      							
      							<td><a href="edit_ct/${confirmedTraining.getTrf_id()}">Allocate Training Resources</a></td>
      							<td><a href="showTrainingInfo/${confirmedTraining.getTrf_id()}">...</a></td>
		                  </tr>
		                  </pop:if>
		                  <pop:if test='${confirmedTraining.getOs_id()==7 && confirmedTraining.getCt_hide_status() == 1 && (confirmedTraining.getTt_id() == 2 || confirmedTraining.getTt_id() == 3)}'>
	                      <tr>
	                  	 	  	<th class="trainingName">${confirmedTraining.getCt_technology().toLowerCase()}</th>
	                  	 	  	<td><div class="progress">
    								<div class="progress-bar progressbar-TI" role="progressbar"
    								aria-valuenow="50" aria-valuemin="0" aria-valuemax="100" style="width:50%;">
      								50%
      								</div>
      							</div></td>
      						
      							<td><a href="send_email_webex/${confirmedTraining.getTrf_id()}">Send Email</a></td>
      							<td><a href="showTrainingInfo/${confirmedTraining.getTrf_id()}">...</a></td>
		                  </tr>
		                  </pop:if>
		                  <pop:if test='${confirmedTraining.getOs_id()==7 && confirmedTraining.getCt_hide_status() == 1 && confirmedTraining.getTt_id() == 1}'>
	                      <tr>
	                  	 	  	<th class="trainingName">${confirmedTraining.getCt_technology().toLowerCase()}</th>
	                  	 	  	<td><div class="progress">
    								<div class="progress-bar progressbar-TI" role="progressbar"
    								aria-valuenow="50" aria-valuemin="0" aria-valuemax="100" style="width:50%;">
      								50%
      								</div>
      							</div></td>
      				
      							<td><a href="send_email_cr/${confirmedTraining.getTrf_id()}">Send Email</a></td>
      							<td><a href="showTrainingInfo/${confirmedTraining.getTrf_id()}">...</a></td>
		                  </tr>
		                  </pop:if>
		                  <pop:if test='${confirmedTraining.getOs_id()==8 && confirmedTraining.getCt_hide_status() == 1}'>
	                      <tr>
	                  	 	  	<th class="trainingName">${confirmedTraining.getCt_technology().toLowerCase()}</th>
	                  	 	  	<td><div class="progress">
    								<div class="progress-bar progressbar-TE" role="progressbar"
    								aria-valuenow="100" aria-valuemin="0" aria-valuemax="100" style="width:100%;">
      								100%
      								</div>
      							</div></td>
      							
      							<td><a href="complete_training/${confirmedTraining.getTrf_id()}">Complete Training</a></td>
      							<td><a href="showTrainingInfo/${confirmedTraining.getTrf_id()}">...</a></td>
		                  </tr>
		                  </pop:if>
		                  </tbody>
	                      </pop:forEach>
                      </table>
                      <a href="#" class="btn btn-mint">View All Trainings</a>
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