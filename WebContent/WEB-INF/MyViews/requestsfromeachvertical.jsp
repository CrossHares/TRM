<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
    <!--Load the AJAX API-->
       
    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
       
    <script type="text/javascript">

        // Load the Visualization API and the corechart package.
        google.charts.load('current', { 'packages': ['corechart'] });

        // Set a callback to run when the Google Visualization API is loaded.
        google.charts.setOnLoadCallback(drawChart);

        // Callback that creates and populates a data table,
        // instantiates the pie chart, passes in the data and
        // draws it.

        //create array with key/value data (this would come from another source instead of hardcoded)


        /*
        Going From JSON Format To Array For DataTable Input
        */

        var vert_data = ${verticalChartData};       //put json ModelMap into var 

        var result = [];

		//use a for loop to push arrays into the array for each JSON key/value pair
        for (var i in vert_data)
            result.push([i, vert_data[i]]);
        //convert json to array of arrays, becasue google chart needs array format


        function drawChart() {
            //create data table
            var data = new google.visualization.DataTable();
            data.addColumn('string', 'Vertical');
            data.addColumn('number', 'NumberOfRequests');
            //data.addRows(trainer_data);
            data.addRows(result);

           /* var alt_options  = {'title': 'Vertical-Wise Requests Made',
            'width': 1000,
            'height': 900,
            colors: ['#e0440e', '#e6693e', '#ec8f6e', '#f3b49f', '#f6c7b6'],
            is3D: true}*/
            
            var options = 
            {
	       		'title': 'Vertical-Wise Requests Made',
				'titleFontSize': 30,
	       		'titlePosition': 'center',
	            'width': 1000,
	            'height': 900,
	            is3D: true,
	          	'legend': {'position': 'right'}
           	}
            //if used for bar chart only will take the first color, pie chart will use them for diff slices


            //'stroke-color': '#871B47', 'stroke-opacity': 0.6, 'stroke-width': 8, 'fill-color': '#BC5679', 'fill-opacity': 0.2

            //instantiate and draw the chart
            //must pass in the data and the options

            var pie_chart_3d = new google.visualization.PieChart(document.getElementById('pie_chart_3d_div'));

            //pie_chart_3d.draw(data, alt_options);
            pie_chart_3d.draw(data, options);

        }
    </script>
</head>

<body>

    <div id='pie_chart_3d_div'></div>

</body>

</html>