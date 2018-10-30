<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Login TRM</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width-device-width, initial-scale = 1">
        
        <!-- Logo & Lgin CSS -->
        <spring:url value="/resources/imgs/logo-md.png" var="logo"></spring:url>
        <spring:url value="/resources/CSS/login.css" var="loginCSS"></spring:url>
        <link href="${loginCSS}" rel="stylesheet" />

        
        <!-- Bootstrap -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
        
        <!-- Additional CSS -->
        <link rel="stylesheet" type="text/css" href="resources/css/login.css">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">
        
        <!-- Favicon -->
        <link rel="apple-touch-icon" sizes="57x57" href="/apple-icon-57x57.png">
		<link rel="apple-touch-icon" sizes="60x60" href="/apple-icon-60x60.png">
		<link rel="apple-touch-icon" sizes="72x72" href="/apple-icon-72x72.png">
		<link rel="apple-touch-icon" sizes="76x76" href="/apple-icon-76x76.png">
		<link rel="apple-touch-icon" sizes="114x114" href="/apple-icon-114x114.png">
		<link rel="apple-touch-icon" sizes="120x120" href="/apple-icon-120x120.png">
		<link rel="apple-touch-icon" sizes="144x144" href="/apple-icon-144x144.png">
		<link rel="apple-touch-icon" sizes="152x152" href="/apple-icon-152x152.png">
		<link rel="apple-touch-icon" sizes="180x180" href="/apple-icon-180x180.png">
		<link rel="icon" type="image/png" sizes="192x192"  href="/android-icon-192x192.png">
		<link rel="icon" type="image/png" sizes="32x32" href="/favicon-32x32.png">
		<link rel="icon" type="image/png" sizes="96x96" href="/favicon-96x96.png">
		<link rel="icon" type="image/png" sizes="16x16" href="/favicon-16x16.png">
		<link rel="manifest" href="/manifest.json">
		<meta name="msapplication-TileColor" content="#ffffff">
		<meta name="msapplication-TileImage" content="/ms-icon-144x144.png">
		<meta name="theme-color" content="#ffffff">
    </head>

    <body>
    
    <%
		HttpSession ses = request.getSession();
		ses.putValue("loginMessage", "");
	
	%>
            <div class="container-fluid bg">
            <div class="row">
            	<div class="col-md-4 col-sm-3 col-xs-12"></div>
                <div class="col-md-3 col-sm-3 col-xs-12 logo-container"><img class="logo" src="${logo}" alt="logo"></div>
                <div class="col-md-1 col-sm-3 col-xs-12"></div>
                <div class="col-md-3 col-sm-3 col-xs-12 "> 
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
                                <button type="submit" class="btn btn-success">Log-in</button>
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