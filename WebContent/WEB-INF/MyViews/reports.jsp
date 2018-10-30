<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Reports | TRM</title>
    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
 
	<!-- CSS & Font Awesome -->
	<spring:url value="/resources/CSS/custom.css"  var="customCSS"/>
	<spring:url value="/resources/FontAwesome/fontawesome-free-5.4.1-web/css/all.css" var="fontAwesome" />
	
	<!-- Images -->
	<spring:url value="/resources/imgs/logo-sm.png" var="logo"></spring:url>
	
	<link href="${customCSS}" rel="stylesheet" />
	<link href="${fontAwesome}" rel="stylesheet" />
		
	<!-- Latest compiled and minified CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
	
	<!-- jQuery library -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	
	<!-- Popper JS -->
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
	
	<!-- Latest compiled JavaScript -->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>

</head>

<body>

<!-- Navbar -->
<div id="nav-wrapper">
	<nav class="navbar navbar-light bg-dashboard-darkblue"> 
    	<a class="navbar-brand" href="#"><img src="${logo}" class="logo-corner" alt="logo"/></a>
    	<div id="profile">
        	<span>Hello, <%= session.getAttribute("loginmessage") %></span>
      	</div>
	</nav>
    <nav id="nav-links" class="nav nav-pills nav-fill bg-dashboard-dark">
      <li class="nav-item"><a class="nav-link" href="AdminDashboard"><i class="fas fa-desktop"></i> Home</a></li>
      <li class="nav-item"><a class="nav-link" href="#"><i class="fas fa-chalkboard-teacher"></i> Training</a></li>
      <li class="nav-item"><a class="nav-link" href="#"><i class="fab fa-wpforms"></i> Request Form</a></li>
      <li class="nav-item"><a class="nav-link nav-active" href="#"><i class="fas fa-chart-bar"></i> Reports</a></li>
      <li class="nav-item"><a class="nav-link" href="#"><i class="fas fa-users"></i> Users</a></li>
      <li class="nav-item"><a class="nav-link" href="showAllVendors"><i class="fas fa-box-open"></i> Vendors</a></li>
      <li class="nav-item"><a class="nav-link" href="showLDTrainingMember"><i class="fas fa-book-reader"></i> Trainers</a></li>
    </nav>
</div>

<div class="container-fluid main-content bg-dashboard-darkblue">
    
    <div class="row chart-padding">
		<div class="col-lg-6">
			<div class="card">
             	<div class="card-body table-scrollable info-card">
                	<div class="card-title-border">
                    	<h2 class="card-title">Bar Chart</h2>
                	</div>
    			<div id='bar_chart_div'></div>
    			</div>
    		</div>
		</div>
		
		<div class="col-lg-6">
			<div class="card">
             	<div class="card-body table-scrollable info-card">
                	<div class="card-title-border">
                    	<h2 class="card-title">Pie Chart</h2>
                	</div>
    			<div id='pie_chart_div'></div>
    		</div>
			</div>	
    	</div>
    </div>
    
    <div class="row">
		<div class="col-lg-6">
			<div class="card">
             	<div class="card-body table-scrollable info-card">
                	<div class="card-title-border">
                    	<h2 class="card-title">Alt Pie Chart</h2>
                	</div>
    				<div id='pie_chart_3d_div'></div>
    			</div>
    		</div>
		</div>
		
		<div class="col-lg-6">
			<div class="card">
             	<div class="card-body table-scrollable info-card">
                	<div class="card-title-border">
                    	<h2 class="card-title">Alt Bar Chart</h2>
                	</div>
    				<div id='alt_bar_chart_div'></div>
    			</div>
			</div>	
    	</div>
    </div>
    
</div>

<div bg-color="white">
<a href = "showidvreportforgivenspocview"> IDV report for given SPOC Report</a><br><br>
<a href = "showverticalwiserequestview"> Vertical Wise Request Report</a><br><br>
<a href = "showspocrequestsreportview"> SPOC, Number Of Requests Report (low priority)</a><br>
</div>

    
    
	<!-- Footer -->
	<div>
		<footer class="bg-dashboard-dark">
        <span>&copy; Copyright Atos | Syntel</span>
    	</footer>
  	</div>

</body>

<script type="text/javascript">

//Load the Visualization API and the corechart package.
google.charts.load('current', { 'packages': ['corechart'] });

//Set a callback to run when the Google Visualization API is loaded.
google.charts.setOnLoadCallback(drawChart);

var trainer_data_JSON = ${spoc_requests_data};       //put json ModelMap into var 

var result = [];

//use a for loop to push arrays into the array for each JSON key/value pair
for (var i in trainer_data_JSON)
    result.push([i, trainer_data_JSON[i]]);
    
function drawChart() {
    //create data table
    var data = new google.visualization.DataTable();
    data.addColumn('string', 'SPOC Name');
    data.addColumn('number', 'Number Of Requests');
    //data.addRows(trainer_data);
    data.addRows(result);

    //set chart options
    var options = {'title': 'Requests Made By SPOC',
        'width': 600,
        'height': 500};

    var alt_options  = {'title': 'Requests Made By SPOC',
    'width': 600,
    'height': 500,
    colors: ['#e0440e', '#e6693e', '#ec8f6e', '#f3b49f', '#f6c7b6'],
    is3D: true}
    //if used for bar chart only will take the first color, pie chart will use them for diff slices


    //instantiate and draw the chart
    //must pass in the data and the options

    //instantiate two types of chart with same data
    var bar_chart = new google.visualization.BarChart(document.getElementById('bar_chart_div'));
    var pie_chart = new google.visualization.PieChart(document.getElementById('pie_chart_div'));
    var pie_chart_3d = new google.visualization.PieChart(document.getElementById('pie_chart_3d_div'));
    var alt_bar_chart = new google.visualization.BarChart(document.getElementById('alt_bar_chart_div'));

    //draw
    bar_chart.draw(data, options);
    pie_chart.draw(data, options);
    pie_chart_3d.draw(data, alt_options);
    alt_bar_chart.draw(data, alt_options);
}

</script>

</html>