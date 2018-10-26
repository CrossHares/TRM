<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="d" uri="http://java.sun.com/jsp/jstl/core" %>

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
	<title>Admin Dashboard | TRM</title>
	
	
</head>
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
      <li class="nav-item"><a class="nav-link" href="#"><i class="fas fa-box-open"></i> Vendors</a></li>
      <li class="nav-item"><a class="nav-link" href="#"><i class="fas fa-book-reader"></i> Trainers</a></li>
    </nav>
</div>


  <div class="container-fluid main-content bg-dashboard-darkblue">

    <div class="row">

      <!-- Critical Content Card-->
        <div class="col-lg-12 dashboard-critical-content">
            <div class="card">
              <div class="card-body">
                  <div id="demo" class="carousel slide bg-dashboard-darkblue dashboard-carousel" data-ride="carousel" data-interval="3000">
                    <!-- Indicators -->
                    <ul class="carousel-indicators">
                      <li data-target="#demo" data-slide-to="0" class="active"></li>
                      <li data-target="#demo" data-slide-to="1"></li>
                      <li data-target="#demo" data-slide-to="2"></li>
                      <li data-target="#demo" data-slide-to="3"></li>
                      <li data-target="#demo" data-slide-to="4"></li>
                    </ul> 
                    <!-- The slideshow -->
                    <div class="carousel-inner">
                      <div class="carousel-item active">
                        <h1>Dorothy</h1> <span>"Toto, I've got a feeling we're not in Kansas anymore." </span>
                      </div>
                      <div class="carousel-item">
                        <h1>Darth Vader</h1> <span>"I am altering the deal, pray I do not alter it any further."</span>
                      </div>
                      <div class="carousel-item">
                          <h1>Thanos</h1> <span>"Fun isn't something one considers when balancing the universe." </span>
                      </div>
                      <div class="carousel-item">
                          <h1>Joker</h1> <span>"Do I look like a guy with a plan?" </span>
                      </div>
                      <div class="carousel-item">
                        <h1>Don Vito Corleone</h1> <span>"I'm gonna make him an offer he can't refuse."</span>
                      </div>
                    </div>

                  </div>
              </div>
            </div>
        </div>

    </div>
    <div class="row">

      <!-- New Requests Card -->
      <div class="col-lg-4">
          <div class="card">
              <div class="card-body table-scrollable info-card">
                <div class="card-title-border">
                    <h2 class="card-title">New Requests</h2>
                </div>
                <table id="newRequestsTable" class="table">
                    <thead>
                      <tr>
                        <th scope="col">Request ID</th>
                        <th scope="col">Requested Tech</th>
                        <th scope="col">Request Date</th>
                        <th scope="col"></th>
                      </tr>
                    </thead>
                    <tbody>
                    	<d:forEach var="nrqv" items="${NewRequestTableValues}">
                    	<d:if test='${nrqv.getHidestatus()==1}'>
							<tr>
								<td>${nrqv.getTrfID()}</td> 
								<td>${nrqv.getTechnology()}</td>
								<td>${nrqv.getDateRequested()}</td>
								<td><a href="move/${nrqv.getTrfID()}"><i class="far fa-2x fa-arrow-alt-circle-right"></i></a></td>
							</tr>
							</d:if>
						</d:forEach>
                    </tbody>
                  </table>
              </div>
          </div>
      </div>

      <!-- Highlights Card-->
      <div class="col-lg-4">
          <div class="card">
              <div class="card-body list-scrollable info-card">
                <div class="card-title-border">
                    <h2 class="card-title">Requests in Queue</h2>
                </div>
                <table id="queueTable" class="table">
                    <thead>
                      <tr>
                        <th scope="col">Request ID</th>
                        <th scope="col">Requested Tech</th>
                        <th scope="col">Request Date</th>
                        <th scope="col">Status</th>
                        <th scope="col"></th>
                      </tr>
                    </thead>
                    <tbody>
                    	<d:forEach var="rqtv" items="${RequestInQueueTableValues}">
							<d:if test='${rqtv.getHidestatus()==1}'>
								<tr>
									<td>${rqtv.getTrfID()}</td> 
									<td>${rqtv.getTechnology()}</td>
									<td>${rqtv.getDateRequested()}</td>
<%-- 									<td>${rqtv.getOsID()}</td>
 --%>									
									<d:if test='${rqtv.getOsID()==1}'>
									<td><span class="label label-danger">PDC</span></td>
									</d:if>
									
									<d:if test='${rqtv.getOsID()==2}'>
									<td><span class="label label-warning">PDCN</span></td>
									</d:if>
									
									
									<d:if test='${rqtv.getButtoncount()==1}' >
									<td><a class="collapse-btn" data-toggle="popover" data-trigger="focus"  data-html="true" href="1/${rqtv.getTrfID()}">...</a></td>
									</d:if>
									
									<d:if test='${rqtv.getButtoncount()==2}' >
									<td><a class="collapse-btn" data-toggle="popover" data-trigger="focus"  data-html="true" href="2/${rqtv.getTrfID()}">...</a></td>
									</d:if>
									
									<d:if test='${rqtv.getButtoncount()==3}' >
									<td><a class="collapse-btn" data-toggle="popover" data-trigger="focus"  data-html="true" href="3/${rqtv.getTrfID()}">...</a></td>
									</d:if>	
								</tr>
							</d:if>	
						</d:forEach>
						
                    </tbody>
                  </table>
              </div>
          </div>
      </div>

      <!-- Trainers Card-->
      <div class="col-lg-4">
          <div class="card">
              <div class="card">
                  <div class="card-body table-scrollable info-card">
                    <div class="card-title-border">
                        <h2 class="card-title">Ongoing Trainings</h2>
                    </div>
                    <table id="trainersTable" class="table">
                        <thead>
                          <tr>
                            <th scope="col">Request ID</th>
                        	<th scope="col">Requested Tech</th>
                        	<th scope="col">Request Date</th>
                        	<th scope="col">Status</th>
                          </tr>
                        </thead>
                        <tbody>
                          	<d:forEach var="ogtv" items="${OngoingTableValues}">
								<d:if test='${ogtv.getHidestatus()==1}'>
									<tr>
										<td>${ogtv.getTrfID()}</td> 
										<td>${ogtv.getTechnology()}</td>
										<td>${ogtv.getDateRequested()}</td>
										<td>${ogtv.getOsID()}</td>
									</tr>
								</d:if>
							</d:forEach>
                        </tbody>
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
  
  
<div class="modal fade" id="edit1">
	<div class="modal-dialog modal-lg">
		<div class="modal-content">
			<div class="modal-body">
			</div>
		</div>
	</div>
</div> 

<div class="modal fade" id="edit2">
	<div class="modal-dialog modal-lg">
		<div class="modal-content">
			<div class="modal-body">
			</div>
		</div>
	</div>
</div> 

<div class="modal fade" id="edit3">
	<div class="modal-dialog modal-lg">
		<div class="modal-content">
			<div class="modal-body">
			</div>
		</div>
	</div>
</div>

<script>
            function formTable(data,id)
            {
            	$('#'+id).attr(
                	{
                		"data-html":"true",
                        "data-content": 
                        "<div>"+
	                        "<table class=\"class\">"+
		                        "<tr><td>Request ID: </td><td>"+data['trfId']+"</td></tr>"+
		                        "<tr><td>Ver ID: </td><td>"+data['verId']+"</td></tr>"+
		                        "<tr><td>Technology: </td><td>"+data['tech']+"</td></tr>"+
		                        "<tr><td>Training Objectives: </td><td>"+data['object']+"</td></tr>"+
	                        "</table>"+
                   	 	"</div>"
                	});
                
            }
            
            function handleLookup(trfId,id) {
                console.log("sending AJAX request to backend Java Servlet");

                jQuery.ajax({
                    "method": "GET",

                    "url": "TMRRequestHandler?trfId=" +trfId,
                    "success": function(data) {
                        handleLookupAjaxSuccess(data,id);
                    },
                    "error": function(errorData) {
                        console.log("lookup ajax error");
                        console.log(errorData);
                    }
                })
            }
            
            function handleLookupAjaxSuccess(data,id) {
                console.log("lookup ajax successful");
                var jsonData = JSON.parse(data);
                console.log(jsonData);
                formTable(jsonData,id);
            }
            
            $(document).ready(function(){
				$("a[data-toggle='popover']").popover();
                $("a[data-toggle='popover'][class!='collapse-btn']").each(function(){
                	var trfId = $(this).attr('href');
                	var id = $(this).attr('id');
                	handleLookup(trfId,id);
                	              	
                });
                $("a[data-toggle='popover'][class='collapse-btn']").each(function(){
                	var btnc = $(this).attr('href');
                	var arrayB = btnc.split("/");
                	var editf ="editform"+arrayB[0]+"/"+arrayB[1];
                	var editm = "#edit" + arrayB[0];
                	var formName="";
                	console.log(editm);
                	if(arrayB[0]==1)
                		formName="Training Type";
                	else if(arrayB[0]==2)
                		formName="Training Detail";
                	else
                		formName="Assign Executive";
                	console.log("editf-----"+editf);
                	console.log("editm-----"+editf);
                	$(this).attr('href','#');
                	$(this).attr('data-content',
                	"<a data-toggle=\"modal\" data-target=\"" + editm + "\" class=\"btn btn-primary\" href=\""+editf+"\">"+ formName +"</a>"+
                	"<br>"+
                	"<button type=\"button\" onclick=\"alert('Deleted!')\">Delete</button>"
                	);
                });//a data-toggle="modal" href="editform2/${dash.getTrfID()}" data-target="#edit2">edit from 2</a></
            });

</script>

</body>
</html>