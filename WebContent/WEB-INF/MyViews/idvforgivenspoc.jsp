<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
  <head>
    <!--Load the AJAX API-->
    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">

      // Load the Visualization API and the corechart package.
      google.charts.load('current', {'packages':['corechart']});

      // Set a callback to run when the Google Visualization API is loaded.
      google.charts.setOnLoadCallback(drawChart);

    var clintonIDV = ${clintonIDV};
    var tyberiusIDV = ${tyberiusIDV}; 
    var jerimahiaIDV = ${jerimahiaIDV}; 
    var joseIDV = ${joseIDV}; 
    var shaqIDV = ${shaqIDV}; 
    var mikeIDV = ${mikeIDV};

    clintonIDV.unshift("Clinton");
    tyberiusIDV.unshift("Tyberius");
    jerimahiaIDV.unshift("Jerimahia");
    joseIDV.unshift("Jose");
    shaqIDV.unshift("Shaq");
    mikeIDV.unshift("Mike");

      function drawChart() {

        // Create the data table.
        var data = new google.visualization.DataTable();    

        var idvForSpoc  =[['SpocName','Internal', 'Development', 'Vendor' , ],
            clintonIDV,
            tyberiusIDV,
            jerimahiaIDV,
            joseIDV,
            shaqIDV,
            mikeIDV];

        var NumRows = idvForSpoc.length;
        var NumCols = idvForSpoc[0].length;
       
        data.addColumn('string', idvForSpoc[0][0]);

        for(var i = 1; i<NumCols; i++)
        data.addColumn('number', idvForSpoc[0][i]);

        for(var i=1; i< NumRows; i++)
        data.addRow(idvForSpoc[i]);

        // Set chart options
        var options = 
					{
						'title':'SPOC-Wise Training Executions',
						'titleFontSize': 30,
						'width':1000,
						'height':900,
						'hAxis': {'title': 'Trainings Completed'},
						'vAxis': {'title': 'SPOCs'}
					};

        // Instantiate and draw our chart, passing in some options.
        var chart = new google.visualization.BarChart(document.getElementById('chart_div'));
        chart.draw(data, options);
      }
    </script>

  </head>

  <body>
    <!--Div that will hold the pie chart-->
    <br><br><br>
    <div id="chart_div"></div>
  </body>
</html>