<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Login | TRM</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width-device-width, initial-scale = 1">
        
<%--         <!-- CSS & Font Awesome -->
		<spring:url value="/resources/CSS/bootstrap.min.css"  var="bootstrapCSS"/>
		<spring:url value="/resources/CSS/custom.css"  var="customCSS"/>
		<spring:url value="/resources/CSS/login.css"  var="loginCSS"/>
		<spring:url value="/resources/FontAwesome/fontawesome-free-5.4.1-web/css/all.css" var="fontAwesome" />
		
		<!-- JavaScripts -->
		<spring:url value="/resources/JSFiles/bootstrap.min.js"  var="bootstrapJS"/>
		<spring:url value="/resources/JSFiles/jquery-3.3.1.min.js" var="jqueryJS" />
		
		<!-- Images -->
		<spring:url value="/resources/imgs/logo-sm.png" var="logo"></spring:url>
		
		<link href="${customCSS}" rel="stylesheet" />
		<link href="${loginCSS}" rel="stylesheet" />
		<link href="${fontAwesome}" rel="stylesheet" />
		<link href="${bootstrapCSS}" rel="stylesheet" />
		<script src="${jqueryJS}"></script>
		<script src="${bootstrapJS}"></script> --%>
        
        
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
        <link rel="stylesheet" type="text/css" href="resources/css/login.css">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" 
        crossorigin="anonymous">
    
    </head>

    <body>
    
    <%
		HttpSession ses = request.getSession();
		ses.putValue("loginMessage", "");
	
	%>
	
        <div class="container-fluid bg">
            <div class="row">
                <div class="col-md-4 col-sm-4 col-xs-12"></div>
                <div class="col-md-4 col-sm-4 col-xs-12 logo-container"><img src="${logo}" class="logo-corner" alt="logo"/></div>
                <div class="col-md-4 col-sm-4 col-xs-12">
                 <!-- form start-->
                    <form class="form-container" action="showDashboard" method="post">
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