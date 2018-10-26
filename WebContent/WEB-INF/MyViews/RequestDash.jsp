<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

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
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel = "stylesheet" type = "text/css" href = "/WEB-INF/resources/style.css" />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
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
		<li class="nav-item"><a class="nav-link nav-active"
			href="RequestDash"><i class="fas fa-desktop"></i> Home</a></li>
		<li class="nav-item"><a class="nav-link" href="NewRequest"><i
				class="fab fa-wpforms"></i> New Training Request</a></li>
		</nav>
	</div>
	<div class="container-fluid main-content bg-dashboard-darkblue">

		<div class="row">

			<!-- Requests Card -->
			<div class="col-lg-12">
				<div class="card">
					<div class="card-body table-scrollable info-card">
						<div class="card-title-border">
							<h2 class="card-title">Training Requests</h2>
						</div>
						<table id="newRequestsTable" class="table">
							<thead>
								<tr>
									<th scope="col">Project ID</th>
									<th scope="col">Project Name</th>
									<th scope="col">Expect Training Date</th>
									<th scope="col">Date Requested</th>
									<th scope="col">Status</th>
									<th scope="col">Actions</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="trm" items="${values}">
									<tr>
										<td>${trm.getTrfProjectID()}</td>
										<td>${trm.getTechnology()}</td>
										<td>${trm.getProposedEndDate()}</td>
										<td>${trm.getDateRequested()}</td>
										<!-- Status Bar -->
										<td>
											<div class="progress">
												<div class="progress-bar progressbar-TE" role="progressbar"
													aria-valuenow="100" aria-valuemin="0" aria-valuemax="100"
													style="width: 100%;">${trm.getOsID()}</div>
											</div>
										</td>
										<!-- Actions-->
										<td>
											<c:if test='${trm.getOsID()==1}'>
												<a data-toggle="modal" data-target="#editRequest" href="editRequest/${trm.getTrfID()}">Edit a Request</a>
											</c:if>
											
										</td>
									</tr>
								</c:forEach>

							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
			<div id="editRequest" class="modal fade" role="dialog">
				<div class="modal-dialog">
					<div class="modal-content">
			      		<div class="modal-footer">
			        		<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
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