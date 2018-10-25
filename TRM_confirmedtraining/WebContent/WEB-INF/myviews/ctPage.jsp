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
<th>Training Request FormID</th>
<th>Verification ID </th>
<th>Vendor ID </th>
<th>Training TypeID</th>
<th>Overall Status ID </th>
<th>PROJECT_ID</th>
<th>TECHNOLOGY  </th>
<th>TRAINING_OBJECTIVES</th>
<th>DATE_REQUESTED </th>
<th>PROPOSED_START_DATE</th>
<th>PROPOSED_END_DATE </th>
<th>PROPOSED_START_TIME</th>
<th>PROPOSED_END_TIME </th>
<th>PROPOSED_LOCATION  </th>
<th>Learning Development TM ID  </th>
<th>ROOM_NO  </th>
<th>PROJECT TRAINING SPOC</th>
<th>APPROX NO EMPLOYEES  </th>
<th>REQUESTOR EMPLOYEE ID </th>
<th>APPROVED FILE LOCATION </th>
<th>TRAINING SOURCE </th>
<th>NOMINATION FILE </th>
<th>ASSIGNED EXEC</th>
<th>HIDE STATUS</th>
<th>BUTTON COUNT</th>
<th>Update</th>
<th>Delete</th>
</tr>
		<c:forEach var = "ctrain" items = "${ct}">
				<tr>
				<td>${ctrain.getTRF_ID()}</td>
				<td>${ctrain.getVER_ID()}</td>
				<td>${ctrain.getVEN_ID()}</td>
				<td>${ctrain.getTT_ID()}</td>
				<td>${ctrain.getOS_ID()}</td>
				<td>${ctrain.getCT_PROJECT_ID()}</td>
				<td>${ctrain.getCT_TECHNOLOGY()}</td>
				<td>${ctrain.getCT_TRAINING_OBJECTIVES()}</td>
				<td>${ctrain.getCT_DATE_REQUESTED()}</td>
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
				<td>${ctrain.getCT_APPROVED_FILE_LOCATION()}</td>
				<td>${ctrain.getCT_TRAINING_SOURCE()}</td>
				<td>${ctrain.getCT_NOMINATION_FILE()}</td>
				<td>${ctrain.getCT_ASSIGNED_EXEC()}</td>
				<td>${ctrain.getCT_HIDE_STATUS()}</td>
				<td>${ctrain.getCT_BUTTON_COUNT()}</td>
			    <td><a href="editCT/${ctrain.getTRF_ID()}">Edit</a></td> 
				<!-- <td><a data-toggle="modal" data-target="#editCT" href="editCT/${ctrain.getTRF_ID()}">Edit</a><td> -->
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