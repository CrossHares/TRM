<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix = "form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>


<title>Confirmed Trainers</title>
</head>

<body>
<h1>Welcome to Confirmed Training Services</h1>
<!-- Search Pop up forms -->

<!-- Insert Section -->
<a data-toggle="modal" data-target="#newCT"  href = "insertct">Insert</a>
<br>
<a href="insertct">Insert</a> 

  <div class="modal fade" id="newCT">
    <div class="modal-dialog modal-lg">

      <div class="modal-content">
		<!-- populate -->			
      </div>
    </div>
  </div>


<!-- Show All data -->
<h2>Confirmed Training Data</h2>
	
<table class = "data">
	<tr>
<th>Training ID</th>
<th>Training Status ID</th>
<th>Training Type ID</th>
<th>L&D User Email</th>
<th>Verification ID </th>
<th>TRFS IDS</th>
<th>Training Start Date</th>
<th>Training End Date</th>
<th>Training Start Time</th>
<th>Training End Time</th>
<th>Training Technology </th>
<th>Training Objective </th>
<th>Training Location </th>
<th>Training Nomination File</th>
<th>Update</th>
<th>Delete</th>
</tr>
		<c:forEach var = "ctrain" items = "${ct}">
				<tr>
				<td>${ctrain.getCtID()}</td>
				<td>${ctrain.getTsID()}</td>
				<td>${ctrain.getTtID()}</td>
				<td>${ctrain.getLdUserEmail()}</td>
				<td>${ctrain.getVerID()}</td>
				<td>${ctrain.getTrfIDs()}</td>
				<td>${ctrain.getCtStartDate()}</td>
				<td>${ctrain.getCtEndDate()}</td>
				<td>${ctrain.getCtStartTime()}</td>
				<td>${ctrain.getCtEndTime()}</td>
				<td>${ctrain.getCtTechnology()}</td>
				<td>${ctrain.getCtTrainingObj()}</td>
				<td>${ctrain.getCtLocation()}</td>
				<td>${ctrain.getCtNomFile()}</td>
			    <td><a href="editCT/${ctrain.getCtID()}">Edit</a></td>  
				<!-- <td><a data-toggle="modal" data-target="#editCT" href="editCT/${ctrain.getCtID()}">Edit</a><td> --->
				<td><a href="deleteCT/${ctrain.getCtID()}" onclick="return confirm('Are you sure?')">Delete</a></td>
				</tr>
		</c:forEach>
	</table>
	
	<!-- -edit form -->
  <div class="modal fade" id="editCT">
    <div class="modal-dialog modal-lg">
      <div class="modal-content">
        <!-- populate -->
      </div>
    </div>
  </div>

</body>

</html>