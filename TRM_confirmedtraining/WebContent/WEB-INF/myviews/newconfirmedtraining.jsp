
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
        <td>Confirmed Training ID:</td>    
         <td><input type="number" name="ctID" readonly = "true"/></td>  <!-- auto generated id -->
         </tr> 
        <tr>  
        <td>Training Status ID:</td>    
         <td><input type="number" name="tsID" required/></td>  
         </tr> 
           
         <tr>    
          <td>Training Type ID: </td>   
          <td><input type="number" name="ttID" required/></td>  
         </tr> 
            
         <tr>    
          <td>LD User Email:</td>    
          <td><input type="text" name="ldUserEmail" required /></td>  
         </tr>
            
         <tr>    
          <td>Verification ID:</td>    
          <td><input type="text" name="verID" /></td>  
         </tr>  
          
            <tr>    
          <td>TRFS IDS:</td>    
          <td><input type="text" name="trfIDs" /></td>  
         </tr>   
         <tr>
         <td>Training Start Date:</td>    
          <td><input type="text" name="ctStartDate"/></td>  
         </tr>   
         
         <tr>
          <td>Training End Date:</td>    
          <td><input type="text" name="ctEndDate" /></td>  
         </tr>
          
         <tr>
         <td>Training Start Time:</td>    
          <td><input type="text" name="ctStartTime" /></td>  
         </tr> 
         <tr>
                  <td>Training End Time:</td>    
          <td><input type="text" name="ctEndTime" /></td>  
         </tr> 
         <tr>
                  <td>Training Technology:</td>    
          <td><input type="text" name="ctTechnology" /></td>  
         </tr> 
         
         <tr>
                  <td>Training Objective:</td>    
          <td><input type="text" name="ctTrainingObj"/></td>  
         </tr> 
         <tr>
                  <td>Training Location:</td>    
          <td><input type="text" name="ctLocation"  /></td>  
         </tr> 
         
         <tr>
                  <td>Training Nomination File:</td>    
          <td><input type="text" name="ctNomFile"  /></td>  
         </tr> 
       <tr>    
          <td> </td>    
          <td><input type="submit" value="Submit" /></td>    
         </tr>    
        </table>    
		 </form>  
		 
</div>
 	<div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
          <button type="button" class="btn btn-default" data-dismiss="modal">Submit</button>
        </div>
      </div>
    </div>


</body>
</html>