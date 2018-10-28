<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<meta charset="ISO-8859-1">
<style>
td{
	width: 150px;
	word-wrap: break-word;
}
</style>
<title>Vendor Employees</title>
</head>
<body>
<center>
	Vendor Employees
	<br>
	<br>
	<table border="2" cellspacing="4" cellpadding="4" table-layout:fixed;>
		<tr>
			<th>Name</th>
			<th>Email</th>
			<th>Location</th>
			<th>Address</th>
			<th>Phone</th>
			<th>Tech Specialty</th>
		</tr>
		<c:forEach var="venEmp" items="${vendorEmpList}">
			<tr>
				<td>${venEmp.getvEmpName()}</td>
				<td>${venEmp.getvEmpEmail()}</td>
				<td>${venEmp.getvEmpLocation()}</td>
				<td>${venEmp.getvEmpAddress()}</td>
				<td>${venEmp.getvEmpPhone()}</td>
				<td>${venEmp.getvEmpSpecialty()}</td>
				<td>
					<a data-toggle="modal" href="editVendorEmp/${venEmp.getvEmpId()}" data-target="#editVenEmp">
						<img src="/TRMProject/images/editicon.jpg" width=30 height=30/>
					</a>
				</td>
				<td>
					<a href="deleteVendorEmployee/${venEmp.getvEmpId()}" onclick="return confirm('Are you sure?')">
						<img src="/TRMProject/images/delete.png" width=30 height=30/>
					</a>
				</td>
			</tr>
		</c:forEach>
	</table>
	
	<br>
	<br>
	
	
	<form action="insertVendorEmp">
	<button type="submit" >Insert New Vendor Employee</button>
	</form>
	
	
	
	<div class="modal fade" id="editVenEmp" role="dialog">
    <div class="modal-dialog modal-lg">
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">Modal Header</h4>
        </div>
        <div class="modal-body">
        	<form method="POST" action="editVendorEmployeeSave"> 
					<table>
						<tr>
							<td>Vendor Employee ID: </td>
							<td><input type="text" name="vEmpId" required size="20" height="50" readonly="true"/></td>
						</tr>
						<tr>
							<td>Vendor Company ID: </td>
							<td><input type="text" name="venId" required size="20" height="50" /></td>
						</tr>
						<tr>
							<td>Employee Name: </td>
							<td><input type="text" name="vEmpName" required size="20" height="50" /></td>
						</tr>
						<tr>
							<td>Email: </td>
							<td><input type="text" name="vEmpEmail" required size="20" height="50" /></td>
						</tr>
						<tr>
							<td>Location: </td>
							<td><input type="text" name="vEmpLocation" required size="20" height="50" /></td>
						</tr>
						<tr>
							<td>Address: </td>
							<td><input type="text" name="vEmpAddress" required size="20" height="50" /></td>
						</tr>
						<tr>
							<td>Phone: </td>
							<td><input type="text" name="vEmpPhone" required size="20" height="50" /></td>
						</tr>
						<tr>
							<td>Tech Specialty: </td>
							<td><input type="text" name="vEmpSpecialty" required size="20" height="50" /></td>
						</tr>
						<tr>
							<td>
								<input type="submit" value="Edit Employee Save" />
							</td>
						</tr>
					</table>
				</form>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        </div>
      </div>
    </div>
  </div>
	
	
	
</center>
</body>
</html>