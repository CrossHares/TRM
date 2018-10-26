package dashboard.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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
		List<TrainingRequestForm> listofRequests = objRF.readTRFByRId("JJ12312");
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
	
	@RequestMapping(value="/send")
	public ModelAndView saveRequest(HttpServletRequest req, HttpServletResponse res)
	{
		System.out.println("Here");
		TrainingRequestFormServices objRF = new TrainingRequestFormServices();
		int ret = objRF.insertNewTRFLocation(1,1,1,req.getParameter("CT_PROJECT_ID"), req.getParameter("CT_TECHNOLOGY"),
				req.getParameter("CT_TRAINING_OBJECTIVES"), req.getParameter("CT_DATE_REQUESTED"),
				req.getParameter("CT_PROPOSED_END_DATE"), req.getParameter("CT_PROPOSED_LOCATION"),
				req.getParameter("CT_PROJECT_SPOC"),
				Integer.parseInt(req.getParameter("CT_APPROX_NO_EMPLOYEES")),req.getParameter("CT_REQUESTOR_EMPLOYEE_ID"),
				req.getParameter("CT_APPROVED_FILE_LOCATION"), 0);
		
			return new ModelAndView("redirect:/RequestDash");
	
		
	}
}