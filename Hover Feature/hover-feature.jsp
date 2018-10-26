<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Bootstrap Example</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <script>
            function formTable(data,id)
            {
            	$('#'+id).attr(
                	{
                		"data-html":"true",
                        "data-content": 
                        "<div>"+
	                        "<table class=\"class\">"+
		                        "<tr><td>Request ID: </td><td>"+data['trfId']+"</td></tr>"+
		                        "<tr><td>Ver ID: </td><td>"+data['verId']+"</td></tr>"+
		                        "<tr><td>Technology: </td><td>"+data['tech']+"</td></tr>"+
		                        "<tr><td>Training Objectives: </td><td>"+data['object']+"</td></tr>"+
	                        "</table>"+
                   	 	"</div>"
                	});
                
            }
            function handleLookup(trfId,id) {
                console.log("sending AJAX request to backend Java Servlet");

                jQuery.ajax({
                    "method": "GET",

                    "url": "TMRRequestHandler?trfId=" +trfId,
                    "success": function(data) {
                        handleLookupAjaxSuccess(data,id);
                    },
                    "error": function(errorData) {
                        console.log("lookup ajax error");
                        console.log(errorData);
                    }
                })
            }
            function handleLookupAjaxSuccess(data,id) {
                console.log("lookup ajax successful");
                var jsonData = JSON.parse(data);
                console.log(jsonData);
                formTable(jsonData,id);
            }
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
            <h1>Training Request Form</h1>
            <table class="table">
            	<tr>
            		<th>Request ID</th>
            		<th>Vertical ID</th>
            		<th>Technology</th>
            	</tr>
                <c:forEach var="i" items="${trfList}">
                    <tr>
                        <td><a id="a${i.getTrfID()}" href="${i.getTrfID()}" title="Request Form" data-toggle="popover" data-trigger="hover" data-placement="right" data-html="true" data-content="">
                        ${i.getTrfID()}</a></td>
						<td>${i.getVerID()}</td>
						<td>${i.getTechnology()}</td>
						<td><a class="collapse-btn" href="#" data-toggle="popover" data-placement="right" data-html="true" data-content="">***</a>
                    </tr>
                </c:forEach>
            </table>
                
                
          
        </div>

        

    </body>
</html>
