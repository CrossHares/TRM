<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix = "form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit</title>
</head>
<body>
	<div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">Edit Training</h4>
          </div>
        <div class="modal-body">

 <form:form method="POST" action="../editctsave"> 

 <table >    
           
         <tr>    
          <td>Training Request ID: </td>   
          <td><form:input path="TRF_ID" readonly="true"/></td>  
         </tr> 
            
         <tr>    
          <td>Verification ID:</td>    
          <td><form:input path="VER_ID" readonly="true"/></td>  
         </tr>
            
         <tr>    
          <td>Vendor ID:</td>    
          <td><form:input path="VEN_ID" readonly="true"/></td>  
         </tr>  
          
            <tr>    
          <td>Training Type ID:</td>    
          <td><form:input path="TT_ID" readonly="true"/></td>  
         </tr>   
         <tr>
         <td>Overall Status ID:</td>    
          <td><form:input path="OS_ID" readonly="true"/></td>  
         </tr>   
         
         <tr>
          <td>Project ID:</td>    
          <td><form:input path="CT_PROJECT_ID" readonly="true"/></td>  
         </tr>
          
         <tr>
         <td>Technology:</td>    
          <td><form:input path="CT_TECHNOLOGY" readonly="true"/></td>  
         </tr> 
         <tr>
                  <td>Training Objectives:</td>    
          <td><form:input path="CT_TRAINING_OBJECTIVES" readonly="true"/></td>  
         </tr> 
         <tr>
                  <td>Date Requested:</td>    
          <td><form:input path="CT_DATE_REQUESTED" readonly="true"/></td>  
         </tr> 
         
         <tr>
                  <td>Proposed Start Date:</td>    
          <td><form:input path="CT_PROPOSED_START_DATE" readonly="true"/></td>  
         </tr> 
         <tr>
                  <td>Proposed End Date:</td>    
          <td><form:input path="CT_PROPOSED_END_DATE"  readonly="true"/></td>  
         </tr> 
         
         <tr>
                  <td>Proposed Start Time:</td>    
          <td><form:input path="CT_PROPOSED_START_TIME" readonly="true" /></td>  
         </tr> 
         <tr>
                  <td>Proposed End Time:</td>    
          <td><form:input path="CT_PROPOSED_END_TIME" readonly="true" /></td>  
         </tr> 
       
         <tr>
                  <td>Proposed Training Location:</td>    
          <td><form:input path="CT_PROPOSED_LOCATION"  /></td>  
         </tr> 
          <tr>
                  <td>Room Number:</td>    
          <td><form:input path="CT_ROOM_NO" /></td>  
         </tr> 
         
          <tr>
         <tr>
                  <td>Training LDTM ID:</td>    
          <td><form:input path="LDTM_ID" /></td>  
         </tr> 
         <tr>
         
                  <td>Project SPOC:</td>    
          <td><form:input path="CT_PROJECT_TRAINING_SPOC" readonly="true" /></td>  
         </tr> 
         
         
         <tr>
                  <td>Class Size:</td>    
          <td><form:input path="CT_APPROX_NO_EMPLOYEES" readonly="true" /></td>  
         </tr> 
          <tr>
                  <td>Training Employee Requester ID:</td>    
          <td><form:input path="CT_REQUESTOR_EMPLOYEE_ID" readonly="true" /></td>  
         </tr> 
          <tr>
                  <td>Training Approved File Location:</td>    
          <td><form:input path="CT_APPROVED_FILE_LOCATION" readonly="true" /></td>  
         </tr> 
          <tr>
                  <td>Training Source:</td>    
          <td><form:input path="CT_TRAINING_SOURCE" readonly="true" /></td>  
         </tr> 
          <tr>
                  <td>Training Nomination File:</td>    
          <td><form:input path="CT_NOMINATION_FILE" readonly="true" /></td>  
         </tr> 
          <tr>
                  <td>Assigned Exec:</td>    
          <td><form:input path="CT_ASSIGNED_EXEC"  /></td>  
         </tr> 
          <tr>
                  <td>Hide Status:</td>    
          <td><form:input path="CT_HIDE_STATUS"  readonly="true"/></td>  
         </tr> 
           <tr>
                  <td>Button Count:</td>    
          <td><form:input path="CT_BUTTON_COUNT" readonly="true" /></td>  
         </tr> 
       <tr>    
          <td> </td>    
          <td><input type="submit" value="Save Edit" /></td>    
         </tr>    
        </table>    
		 </form:form>  
		 
</div>

      </div>
    </div>
</body>
</html>