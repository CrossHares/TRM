package login.dao;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpRequest;

@WebServlet("/Loginservlet")
public class Loginservlet extends HttpServlet{
	
	String message = "hi";
	
	public void init() {
		
	}

	public void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
		String uname = req.getParameter("username");
		String upass = req.getParameter("password");
		
		boolean result = LoginServices.isUserValid(uname, upass);
		
		if(result) {
			String message = "Welcome : " + uname;
			req.getSession().putValue("loginMessage", message);
			resp.sendRedirect("dashboard.jsp");
		}else {
			
			String message = "User ID/Password does not exist. Please try again";
			req.getSession().putValue("loginMessage", message);
			resp.sendRedirect("login.jsp");
		}
		
	}
}
