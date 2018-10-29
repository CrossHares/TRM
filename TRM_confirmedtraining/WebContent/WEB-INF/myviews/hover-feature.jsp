<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page import = "servlet.TMRRequestHandler" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Confirmed Training</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- Latest compiled and minified CSS -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
		
		<!-- jQuery library -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
		
		<!-- Popper JS -->
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
		
		<!-- Latest compiled JavaScript -->
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
        <script>
        	/*
        	formTable function generates the hover block. 
        	Starting from the word "data-content", treat the html tags
        	as a string literal. 
        	The function takes two variables - data and id.
        	data - a json file with the table's properties you query.
        			The names of the properties are up to how you name them 
        			in your servlet file.
        	id - an id attribute value, used to identify which row your hover block
        			should show up.
        	*/
            function formTable(data,id)
            {
            	$('#'+id).attr(
                	{
                		"data-html":"true",
                		//This is where you need to edit.
                        "data-content": 
                        "<div>"+
	                        "<table class=\"class\">"+
		                        "<tr><td>Request ID: </td><td>"+data['TRF_ID']+"</td></tr>"+
		                        "<tr><td>Vertical ID: </td><td>"+data['VER_ID']+"</td></tr>"+
		                        "<tr><td>Vendor ID: </td><td>"+data['VEN_ID']+"</td></tr>"+
		                        "<tr><td>Technology: </td><td>"+data['CT_TECHNOLOGY']+"</td></tr>"+
		                        "<tr><td>Training Objectives: </td><td>"+data['CT_TRAINING_OBJECTIVES']+"</td></tr>"+
		                        "<tr><td>Date Requested: </td><td>"+data['CT_DATE_REQUESTED']+"</td></tr>"+
		                        "<tr><td>Start Date: </td><td>"+data['CT_PROPOSED_START_DATE']+"</td></tr>"+
		                        "<tr><td>End Date: </td><td>"+data['CT_PROPOSED_END_DATE']+"</td></tr>"+
		                        "<tr><td>Start Time: </td><td>"+data['CT_PROPOSED_START_TIME']+"</td></tr>"+
		                        "<tr><td>End Time: </td><td>"+data['CT_PROPOSED_END_TIME']+"</td></tr>"+
		                        "<tr><td>Location: </td><td>"+data['CT_PROPOSED_LOCATION']+"</td></tr>"+
		                        "<tr><td>Room Number: </td><td>"+data['CT_ROOM_NO']+"</td></tr>"+
		                        "<tr><td>Training Member: </td><td>"+data['LDTM_ID']+"</td></tr>"+
		                        "<tr><td>Training SPOC: </td><td>"+data['CT_PROJECT_TRAINING_SPOC']+"</td></tr>"+
		                        "<tr><td>Class Size: </td><td>"+data['CT_APPROX_NO_EMPLOYEES']+"</td></tr>"+
		                        "<tr><td>Requester ID: </td><td>"+data['CT_REQUESTOR_EMPLOYEE_ID']+"</td></tr>"+
		                        "<tr><td>Approved File Location: </td><td>"+data['CT_APPROVED_FILE_LOCATION']+"</td></tr>"+
		                        "<tr><td>Training Source: </td><td>"+data['CT_TRAINING_SOURCE']+"</td></tr>"+
		                        "<tr><td>Nomination File: </td><td>"+data['CT_NOMINATION_FILE']+"</td></tr>"+
		                        "<tr><td>Assigned Executive: </td><td>"+data['CT_ASSIGNED_EXEC']+"</td></tr>"+
		                        "<tr><td>Hide Status: </td><td>"+data['CT_HIDE_STATUS']+"</td></tr>"+
		                        "<tr><td>Button Count: </td><td>"+data['CT_BUTTON_COUNT']+"</td></tr>"+
		                        
	                        "</table>"+
                   	 	"</div>"
                	});
                
            }
        	/*
        	handleLookup function triggers your servlet. 
        	After the word "url", add a link which is a combination of your servlet name, question mark, and 
        	your parameter you want to pass to the backend.
        	*/
            function handleLookup(TRF_ID,id) {
                console.log("sending AJAX request to backend Java Servlet");

                jQuery.ajax({
                    "method": "GET",

                    "url": "TMRRequestHandler?trfId=" +TRF_ID,
                    "success": function(data) {
                        handleLookupAjaxSuccess(data,id);
                    },
                    "error": function(errorData) {
                        console.log("lookup ajax error");
                        console.log(errorData);
                    }
                })
            }
            /*
        	handleLookupAjaxSuccess function takes your json object, parse it, and call formTable function.
        	*/
            function handleLookupAjaxSuccess(data,id) {
                console.log("lookup ajax successful");
                var jsonData = JSON.parse(data);
                console.log(jsonData);
                formTable(jsonData,id);
            }
            /*
            When your html or jsp file is ready, the code below will call all the functions above.
            Don't worry about it. Copy and paste the snipplet.
            */
            $(document).ready(function(){
				$("a[data-toggle='popover']").popover();
                $("a[data-toggle='popover'][class!='collapse-btn']").each(function(){
                	var trfId = $(this).attr('href');
                	var id = $(this).attr('id');
                	handleLookup(trfId,id);
                	              	
                });
                $("a[data-toggle='popover'][class='collapse-btn']").each(function(){
                	$(this).attr('data-content',
                	"<button type=\"button\" onclick=\"alert('Edited!')\">Edit</button>"+
                	"<br>"+
                	"<button type=\"button\" onclick=\"alert('Updated!')\">Update</button>"
                	);
                });
            });

        </script>
    </head>
    <body>


        <div class="container">
            <h1>Confirmed Training</h1>
            <table class="table">
            	<tr>
            <th>TRFS IDS</th>
			<th>Training Technology </th>
			<th>Start Date</th>
			<th>Location </th>
			<th>Training Source </th>
			<th>Assigned Executive</th>

            	</tr>
                       <c:forEach var = "ctrain" items = "${ct}">
							<tr>
							
							<!-- hover on id -->
							  <td><a id="a${ctrain.getTRF_ID()}" href="${ctrain.getTRF_ID()}" title="Confirmed Training Form" data-toggle="popover" data-trigger="hover" data-placement="right" data-html="true" data-content="">
                        ${ctrain.getTRF_ID()}</a></td>

							<td>${ctrain.getCT_TECHNOLOGY()}</td>      
							<td>${ctrain.getCT_PROPOSED_START_TIME()}</td>   
							<td>${ctrain.getCT_PROPOSED_LOCATION()}</td>    
							<td>${ctrain.getCT_TRAINING_SOURCE()}</td>     
							<td>${ctrain.getCT_ASSIGNED_EXEC()}</td>  

						<td><a class="collapse-btn" href="#" data-toggle="popover" data-placement="right" data-html="true" data-content="">***</a>
                    </tr>
                </c:forEach>
            </table> 
          
        </div>

 <!-- Insert Section -->


<div class="container">

  <!--Open the Modal -->
<a data-toggle="modal" data-target="#newCT"  href = "insertct">Insert</a>

  <!-- The Modal -->
  <div class="modal" id="newCT">
    <div class="modal-dialog">
      <div class="modal-content">
      
        <!-- Modal Header -->
        <div class="modal-header">
          <h4 class="modal-title">Modal Heading</h4>
          <button type="button" class="close" data-dismiss="modal">&times;</button>
        </div>
        
        <!-- Modal body -->
        <div class="modal-body">
 
 
 <form action="saveCT"> 
 
<table >   
          <tr>
          <td>Vertical ID</td>
          <td><select name ="TRF_ID" >
               <option>1</option>
               <option>2</option>
               <option>3</option>
               <option>4</option>
               <option>5</option>
               <option>6</option>
               <option>7</option>
               <option>8</option>
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
          <td><input type="date" name = "CT_DATE_REQUESTED" /></td>    
          <td>Training Objectives:</td>    
          <td><textarea name = "CT_TRAINING_OBJECTIVES" /></textarea> </td>      
         </tr> 
         
          <!-- third row -->
         <tr>
                  <td>Proposed Start Date:</td>    
          <td><input type="date" id="startdate" name = "CT_PROPOSED_START_DATE"></td>  

                  <td>Proposed End Date:</td>    
          <td><input type="date"  id = "enddate" name = "CT_PROPOSED_END_DATE"></td>  
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
          <td><select  name = "VEN_ID" >
               <option>101</option>
               <option>102</option>
               <option>103</option>
               <option>104</option>
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
                  <td>Learning Development Team Member ID:</td>    
          <td> <select name = "LDTM_ID">
               <option>1</option>
               <option>2</option>
               <option>3</option>
           </select></td> 
           
            <td>Training Source:</td>    
          <td> <select name = "CT_TRAINING_SOURCE">
               <option>1</option>
               <option>2</option>
               <option>3</option>
           </select></td>   
         </tr> 
         <tr>
         
         <!-- row -->
         <tr>
                  <td>Project SPOC:</td>    
          <td><input type="text" name = CT_PROJECT_TRAINING_SPOC"  /></td>  
           <td>Class Size:</td>    
          <td><input type="number" name = "CT_APPROX_NO_EMPLOYEES" /></td>  
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
        
      </div>
    </div>
  </div>
  
</div>


    </body>
</html>
