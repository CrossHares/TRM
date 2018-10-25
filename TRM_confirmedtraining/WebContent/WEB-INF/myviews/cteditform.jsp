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
        <td>Confirmed Training ID:</td>    
         <td><form:input  path="ctID" readonly="true" /></td>  
         </tr> 
        <tr>  
        <td>Training Status ID:</td>    
         <td><form:input  path="tsID" readonly="true" /></td>  
         </tr> 
           
         <tr>    
          <td>Training Type ID: </td>   
          <td><form:input path="ttID" /></td>  
         </tr> 
            
         <tr>    
          <td>LD User Email:</td>    
          <td><form:input path="ldUserEmail" readonly="true" /></td>  
         </tr>
            
         <tr>    
          <td>Verification ID:</td>    
          <td><form:input path="verID" readonly="true" /></td>  
         </tr>  
          
            <tr>    
          <td>TRFS IDS:</td>    
          <td><form:input path="trfIDs" readonly="true" /></td>  
         </tr>   
         <tr>
         <td>Training Start Date:</td>    
          <td><form:input path="ctStartDate" readonly="true"/></td>  
         </tr>   
         
         <tr>
          <td>Training End Date:</td>    
          <td><form:input path="ctEndDate" readonly="true"/></td>  
         </tr>
          
         <tr>
         <td>Training Start Time:</td>    
          <td><form:input path="ctStartTime" readonly="true" /></td>  
         </tr> 
         <tr>
                  <td>Training End Time:</td>    
          <td><form:input path="ctEndTime" readonly="true" /></td>  
         </tr> 
         <tr>
                  <td>Training Technology:</td>    
          <td><form:input path="ctTechnology" /></td>  
         </tr> 
         
         <tr>
                  <td>Training Objective:</td>    
          <td><form:input path="ctTrainingObj"/></td>  
         </tr> 
         <tr>
                  <td>Training Location:</td>    
          <td><form:input path="ctLocation"  /></td>  
         </tr> 
         
         <tr>
                  <td>Training Nomination File:</td>    
          <td><form:input path="ctNomFile"  /></td>  
         </tr> 
       <tr>    
          <td> </td>    
          <td><input type="submit" value="Save Edit" /></td>    
         </tr>    
        </table>    
		 </form:form>  
		 
</div>
 	<div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
          <button type="button" class="btn btn-default" data-dismiss="modal">Submit</button>
        </div>
      </div>
    </div>
</body>
</html>