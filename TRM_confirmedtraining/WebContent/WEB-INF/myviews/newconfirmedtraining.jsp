
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix = "form" uri="http://www.springframework.org/tags/form" %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit</title>
</head>
<script>
		var date = new Date();
		y = date.getFullYear();
		m = date.getMonth() + 1;
		d = date.getDate();
		var mindate = y + "-" + m + "-" + d;
		var maxdate = y + "-"+ (m+2) + "-" + d;
		
		document.getElementById("startdate").min = mindate;
		document.getElementById("startdate").max = maxdate;
		document.getElementById("enddate").min = document.getElementById("startdate").innerHTML;
		document.getElementById("endtime").min = document.getElementById("starttime").innerHTML;
</script>

<body>

   <!-- Modal Header -->
        <div class="modal-header">
          <h4 class="modal-title">New Confirmed Training</h4>
          <button type="button" class="close" data-dismiss="modal">&times;</button>
        </div>
        
        <!-- Modal body -->
        <div class="modal-body">

			 <form action="saveCT"> 
			 
			<table >   
			          <tr><td>TRF_ID:</td>    
			          <td> <select name ="TRF_ID" >
			               <c:forEach var = "ctrain" items = "${listofTRF}">
			               
			               		<option value = ${ctrain.trfid}> ${ctrain.trfid}</option> 
			               </c:forEach>
			           </select></td>  
	       
			          		           </tr>
      
			         <tr>  <!-- first row -->
			         <td>Technology:</td>    
			          <td> <select name ="CT_TECHNOLOGY" >
			               <option>Java</option>
			               <option>C++</option>
			               <option>SQL</option>
			               <option>Python</option>
			               <option>Ruby on Rails</option>
			           </select></td>  
			           <td>Requester Employee ID:</td>
			           <td><input type="text" name="CT_REQUESTOR_EMPLOYEE_ID"  /></td> 
			         </tr> 
			         
			         <!-- second row -->
			         <tr>
			          <td>Date Requested:</td>    
			          <td><input type="date" name = "CT_DATE_REQUESTED" required/></td>    
			          <td>Training Objectives:</td>    
			          <td><textarea name = "CT_TRAINING_OBJECTIVES" /></textarea> </td>      
			         </tr> 
			         
			          <!-- third row -->
			         <tr>
			                  <td>Proposed Start Date:</td>    
			          <td><input type="date" id="startdate" name = "CT_PROPOSED_START_DATE" required></td>  
			
			                  <td>Proposed End Date:</td>    
			          <td><input type="date"  id = "enddate" name = "CT_PROPOSED_END_DATE" required></td>  
			         </tr> 
			         
			          <!--fourth row -->
			         <tr>
			                  <td>Proposed Start Time:</td>    
			          <td><input type="time" id = "starttime" name ="CT_PROPOSED_START_TIME"/></td>  
			
			                  <td>Proposed End Time:</td>    
			          <td><input type="time" id = "endtime" name = "CT_PROPOSED_END_TIME"  /></td>  
			         </tr> 
			       
			         <tr>
			                  <td>Proposed Training Location:</td>    
			          <td> 
			           <select name = "CT_PROPOSED_LOCATION">
			               <option>Nashville, Tennessee</option>
			               <option>Memphis, Tennessee</option>
			               <option>Phoenix, Arizona</option>
			               <option>New York, New York</option>
			               <option>Pune, India</option>
			               <option>Chennai, India</option>
			           </select>
			           <td>Room Number:</td>    
			          <td><input type="text" name = "CT_ROOM_NO"  /></td>  
			       </td>  
			         </tr> 
			         
			         <!-- fifth row -->
			         
			         <tr>    
			          <td>Vertical ID:</td>    
			          <td><select name = "VER_ID" >
			               <option>1</option>
			               <option>2</option>
			               <option>3</option>
			           </select></td>  
			    
			          <td>Vendor ID:</td>    
			            <td> <select name ="VEN_ID" >
			               <c:forEach var = "VEN" items = "${venIDlist}">
			               
			               		<option value = ${VEN.getVenId()}> ${VEN.getVenId()}</option> 
			               </c:forEach>
			           </select></td>  
			         </tr>  
			          
			            <!-- sixth row -->
			            <tr>    
			          <td>Training Status ID:</td>    
			          <td>
			          <select  name ="TT_ID">
			               <option>1</option>
			               <option>2</option>
			               <option>3</option>
			           </select></td>  
			         <td>Overall Status ID:</td>    
			          <td><select  name ="OS_ID">
			               <option>1</option>
			               <option>2</option>
			               <option>3</option>
			           </select></td>  
			         </tr>   
			         
			         <!-- seventh row -->
			         <tr>
			          <td>Project ID:</td>    
			          <td><select  name = "CT_PROJECT_ID">
			               <option>1</option>
			               <option>2</option>
			               <option>3</option>
			           </select></td>  
			            <td>Assigned Executive:</td>    
			          <td>
			          <select name = "CT_ASSIGNED_EXEC" >
			               <option>Exec1</option>
			               <option>Exec2</option>
			               <option>Exec3</option>
			           </select>
			          </td>  
			         </tr>
			         
			         <!-- eightth row -->
			         <tr>
			                  <td>Learning Development Team Member:</td>    
			          <td> <select name = "ldtmName">
			               <option>LIJI SHYNU</option>
			               <option>SARAH COLEMAN</option>
			                <option>MIKE WALLACE</option>
			           </select></td> 
			           
			            <td>Training Source:</td>    
			          <td> <select name = "tsdesc">
			               <option>INTERNAL</option>
			               <option>DEVELOPMENT TEAM</option>
			               <option>VENDOR</option>
			           </select></td>   
			         </tr> 
			         <tr>
			         
			         <!-- row -->
			         <tr>
			                  <td>Project SPOC:</td>    
			          <td><input type="text" name = CT_PROJECT_TRAINING_SPOC"  /></td>  
			           <td>Class Size:</td>    
			          <td><input type="number" name = "CT_APPROX_NO_EMPLOYEES" required/></td>  
			         </tr> 
			
					<!-- row -->
			          <tr>
			                  <td>Approved File Location:</td>    
			          <td><input type="text" name ="CT_APPROVED_FILE_LOCATION"  /></td>  
			         </tr> 
			         
			          <tr>
			                  <td>Training Nomination File:</td>    
			          <td><input type="text" name="CT_NOMINATION_FILE"  /></td>  
			  
			          <td> </td>    
			          <td><input type="submit" value="Request Training" /></td>    
			         </tr>    
			        </table>    
			        
					 </form>  

      </div>

</body>
</html>