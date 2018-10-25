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
	
	@RequestMapping(value="/Requestor")
	public String showRequestorDashboard()
	{
		return "RequestorDashboard"; //returning view name
	}
}