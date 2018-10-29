<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<center>
		<h2>edit employee details</h2>
			<form:form method="POST" action="saveEditRequest">    
			        <table >    
				        <tr>  
					        <td>TRF ID : </td>    
					         <td><form:input path="trfID" readonly="true"/></td>  
				         </tr>   
				         <tr>    
					          <td>Vertical ID : </td>   
					          <td><form:select path="verID" >
					  				<option value="NONE" label="--- Select an Option ---" />
					  				<option value="1" label="Banking and Financial Services"/>
					  				<option value="2" label="Healthcare and Life Sciences"/>
					  				<option value="3" label="Insurance"/>
					  				<option value="4" label="Retail and Logistics"/>
					  				<option value="5" label="Telecom, Media, and Tech"/>
					  				<option value="6" label="Manufacturing"/>
				     				</form:select></td>  
				         </tr>    
				         <tr>    
					          <td>Vendor ID :</td>    
					          <td><form:input path="venID" /></td>  
				         </tr>   
				         <tr>    
					          <td>Training Type ID :</td>    
					          <td><form:select path="ttID" >
					  				<option value="NONE" label="--- Select an Option ---" />
					  				<option value="1" label="Classroom"/>
					  				<option value="2" label="Virtual Classroom"/>
					  				<option value="3" label="Webex"/>
				     				</form:select></td>  
				         </tr >   
				         <tr>    
					          <td>TRF Project ID :</td>    
					          <td><form:input path="trfProjectID" /></td>  
				         </tr >   
				         <tr>    
					          <td>Technology :</td>    
					          <td><form:input path="technology" /></td>  
				         </tr >   
				         <tr>    
					          <td>Training Objectives :</td>    
					          <td><form:input path="trainingObjectives" /></td>  
				         </tr >   
				         <tr>    
					          <td>Date of Request :</td>    
					          <td><form:input type="date" path="dateRequested" /></td>  
				         </tr >   
				         <tr>    
					          <td>Proposed End Date :</td>    
					          <td><form:input type="date" path="proposedEndDate" /></td>  
				         </tr >   
				         <tr>    
					          <td>Project Training SPOC :</td>    
					          <td><form:input path="projectSPOC" /></td>  
				         </tr >   
				         <tr>    
					          <td>Approx. No. of Employees :</td>    
					          <td><form:input path="appxEmployees" /></td>  
				         </tr >   
				         <tr>    
					          <td>Requestor Employee ID :</td>    
					          <td><form:input path="requestorEmpID" /></td>  
				         </tr >   
				         <tr>    
					          <td>Vendor File Location :</td>    
					          <td><form:input path="fileLocation" /></td>  
				         </tr >   
				         <tr>    
					          <td>Training Source :</td>    
					          <td><input type="radio" name="trainingSource" value="1"/>Internal<br>
									<input type="radio" name="trainingSource" value="2"/>Development Team<br>
									<input type="radio" name="trainingSource" value="3"/>Vendor</td>  
				         </tr >   
				           
				         <tr>    
					          <td> </td>    
					          <td><input type="submit" value="Save Update" /></td>    
				         </tr>    
			        </table>    
			</form:form>    
	
	</center>
</body>
</html>