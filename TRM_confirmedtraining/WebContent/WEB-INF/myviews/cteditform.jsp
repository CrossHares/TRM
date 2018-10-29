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

 <form:form method="POST" action="../TRM_confirmedtraining/editctsave"> 
 
 
 <table >   
          
         <tr>  <!-- first row -->
         <td>Technology:</td>    
          <td> <form:select path="CT_TECHNOLOGY">
               <option>Java</option>
               <option>C++</option>
               <option>SQL</option>
           </form:select></td>  
           <td>Training Employee Requester ID:</td>
           <td><form:input path="CT_REQUESTOR_EMPLOYEE_ID" type="text" readonly="true"/></td> 
         </tr> 
         
         <!-- second row -->
         <tr>
          <td>Date Requested:</td>    
          <td><form:input path= "CT_DATE_REQUESTED" type="date" readonly="true"/></td>    
          <td>Training Objectives:</td>    
          <td><form:textarea path = "CT_TRAINING_OBJECTIVES" readonly="true"/></textarea> </td>      
         </tr> 
         
          <!-- third row -->
         <tr>
                  <td>Start Date:</td> 
                  <td><form:input path= "CT_PROPOSED_START_DATE" type="date" readonly="true"/></td>        

                  <td>End Date:</td>    
          <td><form:input path= "CT_PROPOSED_END_DATE" type="date" readonly="true"/></td>     
         </tr> 
         
          <!--fourth row -->
         <tr>
                  <td>Proposed Start Time:</td>    
          <td><form:input path= "CT_PROPOSED_START_TIME" type="time" readonly="true"/></td>  

                  <td>Proposed End Time:</td>    
          <td><form:input path= "CT_PROPOSED_END_TIME" type="time" readonly="true"/></td>  
         </tr> 
       
         <tr>
                  <td>Proposed Training Location:</td>    
          <td> 
           <form:select path= "CT_PROPOSED_LOCATION">
               <option>Nashville</option>
               <option>Memphis</option>
               <option>Phoenix</option>
           </form:select>
           <td>Room Number:</td>    
          <td><form:input path= "CT_ROOM_NO" type="number"/></td>  
       </td>  
         </tr> 
         
         <!-- fifth row -->
         
         <tr>    
          <td>Vertical ID:</td>    
          <td><form:input path = "VER_ID" readonly="true"/>

    
          <td>Vendor ID:</td>    
          <td><form:input  path = "VEN_ID" readonly="true"/></td>  
         </tr>  
          
            <!-- sixth row -->
            <tr>    
          <td>Training Status ID:</td>    
          <td>
          <form:input path ="TT_ID" readonly="true"/></td>  
         <td>Overall Status ID:</td>    
          <td><form:input  path ="OS_ID" readonly="true"/></td>  
         </tr>   
         
         <!-- seventh row -->
         <tr>
          <td>Project ID:</td>    
          <td><form:input  path = "CT_PROJECT_ID" readonly="true"/></td>  
            <td>Training Assigned Executive:</td>    
          <td>
          <form:input path = "CT_ASSIGNED_EXEC" readonly="true"/></td>  
         </tr>
         
         <!-- eightth row -->
         <tr>
                  <td>Learning Development Training Member:</td>    
          <td> <form:select path = "LDTM_ID">
               <option>Liji Shynu</option>
               <option>Majesh Rajput</option>
               <option>John Doe</option>
           </form:select></td> 
           
            <td>Training Source:</td>    
          <td> <form:input path = "CT_TRAINING_SOURCE" readonly="true"/></td>   
         </tr> 
         <tr>
         
         <!-- row -->
         <tr>
                  <td>Project Training SPOC:</td>    
          <td><form:input path="CT_PROJECT_TRAINING_SPOC" type="text" readonly="true" /></td>  
           <td>Class Size:</td>    
          <td><form:input path = "CT_APPROX_NO_EMPLOYEES" type="text" readonly="true" /></td>  
         </tr> 

		<!-- row -->
          <tr>
                  <td>Training Approved File Location:</td>    
          <td><form:input path= "CT_APPROVED_FILE_LOCATION" type="text" readonly="true"/></td>  
         </tr> 
         
          <tr>
                  <td>Training Nomination File:</td>    
          <td><form:input path= "CT_NOMINATION_FILE" type="text" readonly="true"/></td>  
  
          <td> </td>    
          <td><input type="submit" value="Edit" /></td>    
         </tr>    
        </table>  
		 </form:form>  
		 
</div>

      </div>
    </div>
</body>
</html>