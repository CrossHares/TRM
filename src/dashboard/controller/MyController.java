package dashboard.controller;


import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import trf.dao.TrainingRequestForm;
import trf.dao.TrainingRequestFormServices;

@Controller
public class MyController
{
	
	@RequestMapping(value="/")
	public String showDashboard()
	{
		return "AdminDashboard"; //returning view name
	}
	
	@RequestMapping(value="/RequestDash")
	public String showRequestorDashboard(ModelMap rfmap)
	{
		TrainingRequestFormServices objRF = new TrainingRequestFormServices();
		List<TrainingRequestForm> listofRequests = objRF.readTRF();
		rfmap.addAttribute("values", listofRequests);
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