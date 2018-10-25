<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
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
	
<title>Admin Dashboard | TRM</title>
</head>
<body>
<div id="nav-wrapper">
	  <nav class="navbar navbar-expand-lg navbar-light bg-dashboard-darkblue"> 
      <a class="navbar-brand" href="#"><img src="/resources/imgs/logo-sm.png"></a>
      <div id="profile">
          <span>Hello, User!</span>
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
                        <th scope="col">Request Name</th>
                        <th scope="col">Vertical</th>
                        <th scope="col">Move</th>
                      </tr>
                    </thead>
                    <tbody>
                      <tr>
                        <th>C# Training</th>
                        <td>BNSF</td>
                        <td><a href="#"><i class="far fa-2x fa-arrow-alt-circle-right"></i></a></td>
                      </tr>
                      <tr>
                          <th>Java Training</th>
                          <td>Insurance</td>
                          <td><a href="#"><i class="far fa-2x fa-arrow-alt-circle-right"></i></a></td>
                      </tr>
                      <tr>
                          <th>New Hire Training</th>
                          <td>RLT</td>
                          <td><a href="#"><i class="far fa-2x fa-arrow-alt-circle-right"></i></a></td>
                      </tr>
                      <tr>
                        <th>C# Training</th>
                        <td>BNSF</td>
                        <td><a href="#"><i class="far fa-2x fa-arrow-alt-circle-right"></i></a></td>
                      </tr>
                      <tr>
                          <th>Java Training</th>
                          <td>Insurance</td>
                          <td><a href="#"><i class="far fa-2x fa-arrow-alt-circle-right"></i></a></td>
                      </tr>
                      <tr>
                          <th>New Hire Training</th>
                          <td>RLT</td>
                          <td><a href="#"><i class="far fa-2x fa-arrow-alt-circle-right"></i></a></td>
                      </tr>
                      <tr>
                        <th>C# Training</th>
                        <td>BNSF</td>
                        <td><a href="#"><i class="far fa-2x fa-arrow-alt-circle-right"></i></a></td>
                      </tr>
                      <tr>
                          <th>Java Training</th>
                          <td>Insurance</td>
                          <td><a href="#"><i class="far fa-2x fa-arrow-alt-circle-right"></i></a></td>
                      </tr>
                      <tr>
                          <th>New Hire Training</th>
                          <td>RLT</td>
                          <td><a href="#"><i class="far fa-2x fa-arrow-alt-circle-right"></i></a></td>
                      </tr>
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
                        <th scope="col">Request Name</th>
                        <th scope="col">Edit</th>
                        <th scope="col">Delete</th>
                      </tr>
                    </thead>
                    <tbody>
                      <tr>
                        <th>C# Training</th>
                        <td><a href="#" class="btn btn-mint btn-block">Edit</a></td>
                        <td><a href="#" class="btn btn-delete btn-block">Delete</a></td>
                      </tr>
                      <tr>
                          <th>Java Training</th>
                          <td><a href="#" class="btn btn-mint btn-block">Edit</a></td>
                          <td><a href="#" class="btn btn-delete btn-block">Delete</a></td>
                      </tr>
                      <tr>
                          <th>New Hire Training</th>
                          <td><a href="#" class="btn btn-mint btn-block">Edit</a></td>
                          <td><a href="#" class="btn btn-delete btn-block">Delete</a></td>
                      </tr>
                      <tr>
                        <th>C# Training</th>
                        <td><a href="#" class="btn btn-mint btn-block">Edit</a></td>
                        <td><a href="#" class="btn btn-delete btn-block">Delete</a></td>
                      </tr>
                      <tr>
                          <th>Java Training</th>
                          <td><a href="#" class="btn btn-mint btn-block">Edit</a></td>
                          <td><a href="#" class="btn btn-delete btn-block">Delete</a></td>
                      </tr>
                      <tr>
                          <th>New Hire Training</th>
                          <td><a href="#" class="btn btn-mint btn-block">Edit</a></td>
                          <td><a href="#" class="btn btn-delete btn-block">Delete</a></td>
                      </tr>
                      <tr>
                        <th>C# Training</th>
                        <td><a href="#" class="btn btn-mint btn-block">Edit</a></td>
                        <td><a href="#" class="btn btn-delete btn-block">Delete</a></td>
                      </tr>
                      <tr>
                          <th>Java Training</th>
                          <td><a href="#" class="btn btn-mint btn-block">Edit</a></td>
                          <td><a href="#" class="btn btn-delete btn-block">Delete</a></td>
                      </tr>
                      <tr>
                          <th>New Hire Training</th>
                          <td><a href="#" class="btn btn-mint btn-block">Edit</a></td>
                          <td><a href="#" class="btn btn-delete btn-block">Delete</a></td>
                      </tr>
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
                            <th scope="col">Name</th>
                            <th scope="col">Specialty</th>
                            <th scope="col"></th>
                          </tr>
                        </thead>
                        <tbody>
                          <tr>
                            <th>Mahesh Rajput</th>
                            <td>Spring MVC</td>
                            <td><a href="#" class="btn btn-mint">View Trainer</a></td>
                          </tr>
                          <tr>
                            <th>Liji Shynu</th>
                            <td>SQL</td>
                            <td><a href="#" class="btn btn-mint">View Trainer</a></td>
                          </tr>  
                          <tr>
                            <th>Michael Scott</th>
                            <td>HTML</td>
                            <td><a href="#" class="btn btn-mint">View Trainer</a></td>
                          </tr>
                          <tr>
                            <th>Dwight Schrute</th>
                            <td>Java</td>
                            <td><a href="#" class="btn btn-mint">View Trainer</a></td>
                          </tr>
                          <tr>
                            <th>Jim Halpert</th>
                            <td>Spring MVC</td>
                            <td><a href="#" class="btn btn-mint">View Trainer</a></td>
                          </tr>
                          <tr>
                            <th>Creed Bratton</th>
                            <td>???</td>
                            <td><a href="#" class="btn btn-mint">View Trainer</a></td>
                          </tr>
                          <tr>
                            <th>Stanley Hudson</th>
                            <td>C#</td>
                            <td><a href="#" class="btn btn-mint">View Trainer</a></td>
                          </tr>
                          <tr>
                            <th>Oscar Martinez</th>
                            <td>Java</td>
                            <td><a href="#" class="btn btn-mint">View Trainer</a></td>
                          </tr>
                        </tbody>
                      </table>
                      <a href="#" class="btn btn-mint">View All Trainers</a>
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