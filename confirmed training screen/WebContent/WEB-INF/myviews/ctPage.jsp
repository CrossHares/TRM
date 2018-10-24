<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<!-- jquery for populating div element -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<title>Confirmed Trainers</title>
</head>

<body>
<h1>Welcome to Confirmed Training Services</h1>
<!-- Search Pop up forms -->

<!-- Insert Section -->
<button type="button" id = "insertButton" class="btn btn-info btn-sm" data-toggle="modal" data-target="#newCT" href="/insertct">Create New Confirmed Training<br><br></button>
  
  <div class="modal fade" id="newCT">
    <div class="modal-dialog modal-lg">

      <div class="modal-content">
	<div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">New Confirmed Training</h4>
          </div>
        <div class="modal-body">
			<input type="text" name="ctid" placeholder= "CT ID" required/>
			<input type="text" name="tstatis_id" placeholder= "Training Status ID" required/>
			<input type="text" name="tt_id" placeholder= "Training Type ID" required/>
			<input type="text" name="ld_user_email" placeholder= "LD User Email" required/>
			<input type="text" name="trf_ids" placeholder= "TRF IDS" required/>
			<input type="text" name="ct_start_date" placeholder= "Training Start Date" required/>
			<input type="text" name="ct_end_date" placeholder= "Training End Date" required/>
			<input type="text" name="ct_start_time" placeholder= "Training Start Time" required/>
			<input type="text" name="ct_end_time" placeholder= "Training End Time" required/>
			<input type="text" name="ct_location" placeholder= "Training Location" required/>
			<input type="text" name="ct_nomination_file" placeholder= "Training Nomination File" required/>
        </div>
 	<div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
          <button type="button" class="btn btn-default" data-dismiss="modal">Submit</button>
        </div>
      </div>
    </div>
  </div>

<!-- -edit form -->
  
  <div class="modal fade" id="editCT">
    <div class="modal-dialog modal-lg">
      <div class="modal-content">
        <div class="modal-body">
			<!-- populate -->
        </div>
 	<div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
          <button type="button" class="btn btn-default" data-dismiss="modal" href="/editctsave">Submit</button>
        </div>
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
<th>TRFS IDS</th>
<th>Training Start Date</th>
<th>Training End Date</th>
<th>Training Start Time</th>
<th>Training End Time</th>
<th>Training Location </th>
<th>Training Nomination File</th>
<th>Update</th>
<th>Delete</th>
</tr>
		<c:forEach var = "ctrain" items = "${ct}">
				<tr>
				<td>${ctrain.getCitid()}</td>
				<td>${ctrain.getTstatis_id()}</td>
				<td>${ctrain.getTt_id()}</td>
				<td>${ctrain.getLd_user_email()}</td>
				<td>${ctrain.getTrf_ids()}</td>
				<td>${ctrain.getCt_start_date()}</td>
				<td>${ctrain.getCt_end_date()}</td>
				<td>${ctrain.getCt_start_time()}</td>
				<td>${ctrain.getCt_end_time()}</td>
				<td>${ctrain.getCt_location()}</td>
				<td>${ctrain.getCt_nomination_file()}</td>
				<!-- <td><a href="editCT/${ctrain.getCitid()}">Edit</a></td>  -->
				<td><button type="button" id = "editButton" class="btn btn-info btn-sm" data-toggle="modal" data-target="#editCT" href="/editCT/${ctrain.getCitid()}">Edit</button></td>
				<td><a href="deleteCT/${ctrain.getCitid()}" onclick="return confirm('Are you sure?')">Delete</a></td>
				</tr>
		</c:forEach>
	</table>
	
</body>

<script>
$(document).ready(function(){
	alert( "Load was performed." );
	$('.modal-body').second().css( "background-color", "red" );
	$('.modal-body').first().load("newconfirmedtraining.jsp");

	$('.modal-body').second().load("cteditform.html");

});
</script>

</html>