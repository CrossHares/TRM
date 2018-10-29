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

<!--  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"> -->
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
<th>Technology</th>
<th>Start Date</th>
<th>Location</th>
<th>Project SPOC</th>
<th>Training Source </th>
<th>Assigned Executive</th>

<th>Update</th>
<th>Delete</th>
</tr>
		<c:forEach var = "ctrain" items = "${ct}">
				<tr>
				<td>${ctrain.getCT_TECHNOLOGY()}</td>
				<td>${ctrain.getCT_PROPOSED_START_DATE()}</td>
				<td>${ctrain.getCT_PROPOSED_LOCATION()}</td>
				<td>${ctrain.getCT_PROJECT_TRAINING_SPOC()}</td>
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