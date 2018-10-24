<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit</title>
</head>
<body>

 <form:form method="POST" action="../editctsave">
<input type="text" name="ctid" placeholder= "CT ID" required/>
			<input type="text" name="tstatis_id" placeholder= "Training Status ID" required/>
			<input type="text" name="tt_id" placeholder= "Training Type ID" required/>
			<input type="text" name="ld_user_email" placeholder= "LD User Email" required/>
			<input type="text" name="trf_ids" placeholder= "TRF IDS" required/>
			<input type="text" name="ct_start_date" placeholder= "Training Start Date" required/>
			<input type="text" name="ct_end_date" placeholder= "Training End Date" required/>
			<input type="text" name="ct_start_time" placeholder= "Training Start Time" required/>
			<input type="text" name="ct_end_time" placeholder= "Training End Time" required/>
			<input type="text" name="ct_location" placeholder= "Training Location" required/>
			<input type="text" name="ct_nomination_file" placeholder= "Training Nomination File" required/>
  </form:form> 
</body>
</html>