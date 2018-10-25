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
<th>CT_ID </th>
<th>IPT_ID</th>
<th>TRF_ID</th>
<th>VER_ID </th>
<th>VEN_ID </th>
<th>TT_ID</th>
<th>OS_ID </th>
<th>CT_PROJECT_ID</th>
<th>CT_TECHNOLOGY  </th>
<th>CT_TRAINING_OBJECTIVES</th>
<th>CT_DATE_REQUESTED </th>
<th>CT_PROPOSED_START_DATE</th>
<th>CT_PROPOSED_END_DATE </th>
<th>CT_PROPOSED_START_TIME</th>
<th>CT_PROPOSED_END_TIME </th>
<th>CT_PROPOSED_LOCATION  </th>
<th>LDTM_ID  </th>
<th>CT_PROJECT_TRAINING_SPOC</th>
<th>CT_APPROX_NO_EMPLOYEES  </th>
<th>CT_REQUESTOR_EMPLOYEE_ID </th>
<th>CT_APPROVED_FILE_LOCATION </th>
<th>CT_TRAINING_SOURCE </th>
<th>CT_NOMINATION_FILE </th>
<th>CT_ASSIGNED_EXEC</th>
<th>CT_HIDE_STATUS</th>
<th>Update</th>
<th>Delete</th>
</tr>
		<c:forEach var = "ctrain" items = "${ct}">
				<tr>
				<td>${ctrain.getCT_ID()}</td>
				<td>${ctrain.getIPT_ID()}</td>
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
				<td>${ctrain.getLDTM_ID()}</td>
				<td>${ctrain.getCT_PROJECT_TRAINING_SPOC()}</td>
				<td>${ctrain.getCT_APPROX_NO_EMPLOYEES()}</td>
				<td>${ctrain.getCT_REQUESTOR_EMPLOYEE_ID()}</td>
				<td>${ctrain.getCT_APPROVED_FILE_LOCATION()}</td>
				<td>${ctrain.getCT_TRAINING_SOURCE()}</td>
				<td>${ctrain.getCT_NOMINATION_FILE()}</td>
				<td>${ctrain.getCT_ASSIGNED_EXEC()}</td>
				<td>${ctrain.getCT_HIDE_STATUS()}</td>
			    <td><a href="editCT/${ctrain.getCT_ID()}">Edit</a></td>  
				<!-- <td><a data-toggle="modal" data-target="#editCT" href="editCT/${ctrain.getCT_ID()}">Edit</a><td> --->
				<td><a href="deleteCT/${ctrain.getCT_ID()}" onclick="return confirm('Are you sure?')">Delete</a></td>
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