package dao.DashboardTables;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.*;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

//Inside the parentheses is the name of your servlet you need to call in AJAX (front-end)
//When you copy, make sure you change the class name and everything to make your file name.
@WebServlet("/TMRRequestHandler")
public class TMRRequestHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public TMRRequestHandler() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String query = "select * from TRAINING_REQUEST_FORM where TRF_ID = ?";
		String trfID = request.getParameter("trfID");
		System.out.println(trfID);
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","syntel123$");
			PreparedStatement stat =  con.prepareStatement(query);
			stat.setString(1,trfID);
			ResultSet rs = stat.executeQuery();
			
			
			
			//After you create a connection and query, create a json file.
			JSONObject jObj = new JSONObject();
			while(rs.next())
			{	
				//add more fields here down below.
				//You can name your properties whatever you want.
				//Remember to use the same names at the front-end as well.
				
				jObj.put("trfID", rs.getInt(1));
				jObj.put("verID", rs.getInt(2));
				jObj.put("venID", rs.getString(3));
				jObj.put("ttID", rs.getString(4));
				jObj.put("osID", rs.getString(5));
				jObj.put("trfProjectID", rs.getString(6));
				jObj.put("technology", rs.getString(7));
				jObj.put("trainingObjectives", rs.getString(8));
				jObj.put("dateRequested", rs.getString(9));
				jObj.put("proposedStartDate", rs.getString(10));
				jObj.put("proposedEndDate", rs.getString(11));
				jObj.put("startTime", rs.getString(12));
				jObj.put("endTime", rs.getString(13));
				jObj.put("location", rs.getString(14));
				jObj.put("roomNo", rs.getString(15));
				jObj.put("ldtmid", rs.getString(16));
				jObj.put("projectSPOC", rs.getString(17));
				jObj.put("appxEmployees", rs.getString(18));
				jObj.put("requestorEmpID", rs.getString(19));
				jObj.put("fileLocation", rs.getString(20));
				jObj.put("trainingSource", rs.getString(21));
				jObj.put("nominationfile", rs.getString(22));
				jObj.put("assignedexecutive", rs.getString(23));
				jObj.put("hidestatus", rs.getString(24));
				jObj.put("buttoncount", rs.getString(25));
			}
			
			System.out.println(jObj);
			
			//Send your json file to the front-end as a string.
			response.getWriter().write(jObj.toString());
			
			rs.close();
			stat.close();
			con.close();
		} catch (Exception e) {
	
			e.printStackTrace();
			response.getWriter().write("{}");
			
		}

	}

}
