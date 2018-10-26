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

<!-- Insert Section -->
<a data-toggle="modal" data-target="#newCT"  href = "insertct">Insert</a>
<br>
<!-- <a href="insertct">Insert</a>  -->

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
<th>Vendor ID </th>
<th>Training Type ID</th>
<th>Project ID</th>
<th>Technology</th>
<th>Training Objectives</th>
<th>Start Date</th>
<th>End Date </th>
<th>Start Time</th>
<th>End Time </th>
<th>Location</th>
<th>Learning Development TM ID  </th>
<th>Room </th>
<th>Project SPOC</th>
<th>Class Size  </th>
<th>Requester ID </th>
<th>Training Source </th>
<th>Assigned Executive</th>

<th>Update</th>
<th>Delete</th>
</tr>
		<c:forEach var = "ctrain" items = "${ct}">
				<tr>
				<td>${ctrain.getVEN_ID()}</td>
				<td>${ctrain.getTT_ID()}</td>
				<td>${ctrain.getCT_PROJECT_ID()}</td>
				<td>${ctrain.getCT_TECHNOLOGY()}</td>
				<td>${ctrain.getCT_TRAINING_OBJECTIVES()}</td>
				<td>${ctrain.getCT_PROPOSED_START_DATE()}</td>
				<td>${ctrain.getCT_PROPOSED_END_DATE()}</td>
				<td>${ctrain.getCT_PROPOSED_START_TIME()}</td>
				<td>${ctrain.getCT_PROPOSED_END_TIME()}</td>
				<td>${ctrain.getCT_PROPOSED_LOCATION()}</td>
				<td>${ctrain.getCT_ROOM_NO()}</td>
				<td>${ctrain.getLDTM_ID()}</td>
				<td>${ctrain.getCT_PROJECT_TRAINING_SPOC()}</td>
				<td>${ctrain.getCT_APPROX_NO_EMPLOYEES()}</td>
				<td>${ctrain.getCT_REQUESTOR_EMPLOYEE_ID()}</td>
				<td>${ctrain.getCT_TRAINING_SOURCE()}</td>
				<td>${ctrain.getCT_ASSIGNED_EXEC()}</td>

			    <!-- <td><a href="editCT/${ctrain.getTRF_ID()}">Edit</a></td> -->
				<td><a data-toggle="modal" data-target="#editCT" href="editCT/${ctrain.getTRF_ID()}">Edit</a><td> 
				<td><a href="deleteCT/${ctrain.getTRF_ID()}" onclick="return confirm('Are you sure?')">Delete</a></td>
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