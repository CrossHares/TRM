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
<title>L&D Training Members</title>
</head>
<body>
<center>
	L&D Training Members Page
	<br>
	<br>
	<table border="2" cellspacing="4" cellpadding="4">
		<tr>
			<th>Name</th>
			<th>Location</th>
			<th>Email</th>
			<th>Phone</th>
			<th>Tech Specialty</th>
		</tr>
		<c:forEach var="ldtm" items="${ldtmList}">
			<tr>
				<td>${ldtm.getLdtmName()}</td>
				<td>${ldtm.getLdtmLocation()}</td>
				<td>${ldtm.getLdtmEmail()}</td>
				<td>${ldtm.getLdtmPhone()}</td>
				<td>${ldtm.getTechSpecialty()}</td>
				<td>
					<a data-toggle="modal" href="editLDTMember/${ldtm.getLdtmId()}" data-target="#editLDTMember">
						<img src="/TRMProject/images/editicon.jpg" width=30 height=30/>
					</a>
					
				</td>
				<td>
					<a href="deleteLDTrainingMember/${ldtm.getLdtmId()}" onclick="return confirm('Are you sure?')">
						<img src="/TRMProject/images/delete.png" width=30 height=30/>
					</a>
				</td>
			</tr>
		</c:forEach>
	</table>
	<br>
	<br>
	
	<form action="insertLDTrainingMembers">
	<button type="submit" >Insert New L&D Training Member</button>
	</form>
	
	
	
	
	<div class="modal fade" id="editLDTMember" role="dialog">
    <div class="modal-dialog modal-lg">
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">Modal Header</h4>
        </div>
        <div class="modal-body">
   
   		<form method="POST" action="editLDTMemberSave"> 
	<table>
		<tr>
			<td>LDT Member ID: </td>
			<td><input type="text" name="ldtmId" required size="20" height="50" readonly="true" /></td>
		</tr>
		<tr>
			<td>Name: </td>
			<td><input type="text" name="ldtmName" required size="20" height="50" /></td>
		</tr>
		<tr>
			<td>Location: </td>
			<td><input type="text" name="ldtmLocation" required size="20" height="50" /></td>
		</tr>
		<tr>
			<td>Email: </td>
			<td><input type="text" name="ldtmEmail" required size="20" height="50" /></td>
		</tr>
		<tr>
			<td>Phone: </td>
			<td><input type="text" name="ldtmPhone" required size="20" height="50" /></td>
		</tr>
		
		<tr>
			<td>Tech Specialty: </td>
			<td><input type="text" name="techSpecialty" required size="20" height="50" /></td>
		</tr>
		<tr>
			<td>
				<input type="submit" value="Edit Save" />
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
	
	  
	<br>
</center>
</body>
</html>