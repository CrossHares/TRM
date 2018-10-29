package servlet;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.*;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
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
		
		String query = "select * from confirmed_training where TRF_ID = ?";
		
		String trfId = request.getParameter("trfId");

		System.out.println(trfId);

		//////////
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","syntel123$");
			PreparedStatement stat =  con.prepareStatement(query);
			stat.setString(1,trfId);
			ResultSet rs = stat.executeQuery();

			/*
			After you create a connection and query, create a json file.
			 */
			JSONObject jObj = new JSONObject();
			while(rs.next())
			{	
				//add more fields here down below.
				//You can name your properties whatever you want.
				//Remember to use the same names at the front-end as well.
				jObj.put("TRF_ID", rs.getInt(1));
				jObj.put("VER_ID", rs.getInt(2));
				jObj.put("VEN_ID", rs.getInt(3));
				jObj.put("TT_ID", rs.getInt(4));
				jObj.put("OS_ID", rs.getInt(5));
				jObj.put("CT_PROJECT_ID", rs.getString(6));
				jObj.put("CT_TECHNOLOGY", rs.getString(7));
				jObj.put("CT_TRAINING_OBJECTIVES", rs.getString(8));
				jObj.put("CT_DATE_REQUESTED", rs.getString(9));
				jObj.put("CT_PROPOSED_START_DATE", rs.getString(10));
				jObj.put("CT_PROPOSED_END_DATE", rs.getString(11));
				jObj.put("CT_PROPOSED_START_TIME", rs.getString(12));
				jObj.put("CT_PROPOSED_END_TIME", rs.getString(13));
				jObj.put("CT_PROPOSED_LOCATION", rs.getString(14));
				jObj.put("CT_ROOM_NO", rs.getString(15));
				jObj.put("LDTM_ID", rs.getInt(16));
				jObj.put("CT_PROJECT_TRAINING_SPOC", rs.getString(17));
				jObj.put("CT_APPROX_NO_EMPLOYEES", rs.getInt(18));
				jObj.put("CT_REQUESTOR_EMPLOYEE_ID", rs.getString(19));
				jObj.put("CT_APPROVED_FILE_LOCATION", rs.getString(20));
				jObj.put("CT_TRAINING_SOURCE", rs.getInt(21));
				jObj.put("CT_NOMINATION_FILE",rs.getString(22));
				jObj.put("CT_ASSIGNED_EXEC",rs.getString(23));
				jObj.put("CT_HIDE_STATUS", rs.getInt(24));
				jObj.put("CT_BUTTON_COUNT",rs.getInt(25));
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
