
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="d" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<p>${trfID}</p>


<form action="FTRM/editform2internal/${trfID}" method="POST" style="border:solid 1 black">
  <table >    
        <tr>  
        <td>Start Date</td>    
         <td><input type="date" name="StartDate" required size="20" height="50"/></td>  
         </tr>   
         <tr>    
          <td>End Date </td>   
          <td><input type="date" name="EndDate" required size="20" height="50"/></td>  
         </tr>    
         <tr>    
          <td>Location</td>    
          <td><input type="text" name="Location" required size="20" height="50"/></td>  
         </tr>   
         <tr>    
          <td>Start Time</td>    
          <td><input type="text" name="StartTime" required size="20" height="50"/></td>  
         </tr>   
         <tr>    
          <td>End Time</td>    
          <td><input type="text" name="EndTime" required size="20" height="50"/></td>  
         </tr>  
         <tr>    
          <td>Objectives</td>    
          <td><input type="text" name="Objectives" required size="50" height="70"/></td>  
         </tr> 
             
        
       </table>  
<br> 
<input type="submit" value ="Submit"/>
</form>

</body>
</html>