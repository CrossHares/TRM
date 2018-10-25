<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title> First Report - Exodia, C. </title>
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>

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

</head>
<body>

<h4>bar chart example:</h4>
    <div id='bar_chart_div'></div>
    <h4>pie chart example:</h4>
    <div id='pie_chart_div'></div>
    <h4>alt pie chart:</h4>
    <div id='pie_chart_3d_div'></div>
    <h4>alt bar chart:</h4>
    <div id='alt_bar_chart_div'></div>

</body>
</html>