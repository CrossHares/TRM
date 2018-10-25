
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
          <h4 class="modal-title">New Confirmed Training</h4>
          </div>
        <div class="modal-body">

 <form action="saveCT"> 
 
<table >    
            
         <tr>    
          <td>Verification ID:</td>    
          <td><input type="text" name = "VER_ID" /></td>  
         </tr>
            
         <tr>    
          <td>Vendor ID:</td>    
          <td><input type="text" name = "VEN_ID" /></td>  
         </tr>  
          
            <tr>    
          <td>Training Status ID:</td>    
          <td><input type="text" name ="TT_ID" /></td>  
         </tr>   
         <tr>
         <td>OS ID:</td>    
          <td><input type="text" name ="OS_ID" /></td>  
         </tr>   
         
         <tr>
          <td>Project ID:</td>    
          <td><input type="text" name = "CT_PROJECT_ID" /></td>  
         </tr>
          
         <tr>
         <td>Technology:</td>    
          <td><input type="text" name ="CT_TECHNOLOGY" /></td>  
         </tr> 
         <tr>
                  <td>Training Objectives:</td>    
          <td><input type="text" name = "CT_TRAINING_OBJECTIVES" /></td>  
         </tr> 
         <tr>
                  <td>Date Requested:</td>    
          <td><input type="text" name = "CT_DATE_REQUESTED" /></td>  
         </tr> 
         
         <tr>
                  <td>Proposed Start Date:</td>    
          <td><input type="text" name = "CT_PROPOSED_START_DATE"/></td>  
         </tr> 
         <tr>
                  <td>Proposed End Date:</td>    
          <td><input type="text" name = "CT_PROPOSED_END_DATE"  /></td>  
         </tr> 
         
         <tr>
                  <td>Proposed Start Time:</td>    
          <td><input type="text" name ="CT_PROPOSED_START_TIME"  /></td>  
         </tr> 
         <tr>
                  <td>Proposed End Time:</td>    
          <td><input type="text" name = "CT_PROPOSED_END_TIME"  /></td>  
         </tr> 
       
         <tr>
                  <td>Proposed Training Location:</td>    
          <td><input type="text" name = "CT_PROPOSED_LOCATION"  /></td>  
         </tr> 
         
           <tr>
                  <td>Room Number:</td>    
          <td><input type="text name = "CT_ROOM_NO"  /></td>  
         </tr> 
         
         <tr>
                  <td>Training LDTM ID:</td>    
          <td><input type="text" name="LDTM_ID"  /></td>  
         </tr> 
         <tr>
         
         <tr>
                  <td>Project Training SPOC:</td>    
          <td><input type="text" name = CT_PROJECT_TRAINING_SPOC"  /></td>  
         </tr> 
         <tr>
                  <td>Class Size:</td>    
          <td><input type="text" name = "CT_APPROX_NO_EMPLOYEES"  /></td>  
         </tr> 
          <tr>
                  <td>Training Employee Requester ID:</td>    
          <td><input type="text" name="CT_REQUESTOR_EMPLOYEE_ID"  /></td>  
         </tr> 
          <tr>
                  <td>Training Approved File Location:</td>    
          <td><input type="text" name ="CT_APPROVED_FILE_LOCATION"  /></td>  
         </tr> 
          <tr>
                  <td>Training Source:</td>    
          <td><input type="text" name="CT_TRAINING_SOURCE"  /></td>  
         </tr> 
          <tr>
                  <td>Training Nomination File:</td>    
          <td><input type="text" name="CT_NOMINATION_FILE"  /></td>  
         </tr> 
          <tr>
                  <td>Training ASSIGNED_EXEC:</td>    
          <td><input type="text" name = "CT_ASSIGNED_EXEC"  /></td>  
         </tr> 
          <tr>
                  <td>Training HIDE_STATUS:</td>    
          <td><input type="text" name="CT_HIDE_STATUS"  /></td>  
         </tr> 
         <tr>  
        <td>Number of Buttons:</td>    
         <td><input type="text" name="CT_BUTTON_COUNT"/></td>  
         </tr> 
       <tr>    
          <td> </td>    
          <td><input type="submit" value="Submit" /></td>    
         </tr>    
        </table>    
        
		 </form>  

      </div>
    </div>


</body>
</html>