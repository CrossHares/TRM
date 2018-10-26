package mypro;

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

@WebServlet("/TMRRequestHandler")
public class TMRRequestHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public TMRRequestHandler() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String query = "select * from Training_Request_Form where trf_id = ?";
		String trfId = request.getParameter("trfId");
		System.out.println(trfId);
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","hr");
			PreparedStatement stat =  con.prepareStatement(query);
			stat.setString(1,trfId);
			ResultSet rs = stat.executeQuery();
			
			
			//JSONArray jArray = new JSONArray();
			JSONObject jObj = new JSONObject();
			while(rs.next())
			{	
			
				jObj.put("trfId", rs.getInt(1));
				jObj.put("verId", rs.getInt(2));
				jObj.put("tech", rs.getString(6));
				jObj.put("object", rs.getString(7));
			}
			System.out.println(jObj);
			response.getWriter().write(jObj.toString());
			rs.close();
			stat.close();
			con.close();
		} catch (Exception e) {
	
			e.printStackTrace();
			response.getWriter().write("[]");
			
		}
	}

}
