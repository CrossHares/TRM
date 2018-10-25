<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>TRM Log-in</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width-device-width, initial-scale = 1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
        <link rel="stylesheet" type="text/css" href="resources/css/login.css">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">
    </head>

    <body>
    
    <%
		HttpSession ses = request.getSession();
		ses.putValue("loginMessage", "");
	
	%>
	
        <div class="container-fluid bg">
            <div class="row">
                <div class="col-md-4 col-sm-4 col-xs-12"></div>
                <div class="col-md-4 col-sm-4 col-xs-12"><img src="../resources/images/logo-md.png" alt="logo"></div>
                <div class="col-md-4 col-sm-4 col-xs-12">
                 <!-- form start-->
                    <form class="form-container" action="Loginservlet">
                        <h1>Welcome</h1>
                            <div class="form-group">
                                <label for="input-username">Username</label>
                                <input name="username" type="text" class="form-control" id="input-username" placeholder="Enter Username">
                            </div>
                            <div class="form-group">
                                <label for="input-password">Password</label>
                                <input name="password" type="password" class="form-control" id="input-password" placeholder="Enter Password">
                            </div>
                                <button type="submit" class="btn btn-success btn-block">Log-in</button>
                    </form>
                <!--form end-->
                </div>
            </div>    
        </div>
        
        <div>  
		<%= session.getAttribute("loginMessage") %>
		</div>
    </body>

</html>