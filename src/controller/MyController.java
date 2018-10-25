package controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController
{
	
	@RequestMapping(value="/")
	public String showDashboard()
	{
		return "AdminDashboard"; //returning view name
	}
	
	@RequestMapping(value="/RequestDash")
	public String showRequestorDashboard()
	{
		return "RequestDash"; //returning view name
	}
	
	@RequestMapping(value="/NewRequest")
	public String showNewRequest()
	{
		return "NewRequest"; //returning view name
	}
	
	@RequestMapping(value="/login")
	public String showLogin()
	{
		return "login"; //returning view name
	}
}