<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Assign The Executive</title>
</head>
<body>

	

<form action="../editassignexecutives/${trfID}" style="background-color: khaki; border: dotted;color:red">	
	<select name="executive">
	<c:forEach var="executivename" items="${allExecutives}"> 
	
		
			<option value="${executivename.getLD_USER_NAME()}">${executivename.getLD_USER_NAME()}</option>
			
			
			</c:forEach>
</select>
<input type="submit" value ="Submit"/>
</form>
</body>
</html>