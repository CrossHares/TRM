package controller;


import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dao.dashboard_firstTable.FirstTableService;
import dao.dashboard_firstTable.SecondTable;
import trf.dao.TrainingRequestForm;
import trf.dao.TrainingRequestFormServices;

@Controller
public class RequestorDashboardController
{
	//for testing purposes set to request dash
	
	@RequestMapping(value="/RequestDash")
	public String showRequestorDashboard(ModelMap rfmap)
	{
		Session ses = Session.getDefaultInstance();
		String reqID = ses.getAttribute("requester_id");
		
		TrainingRequestFormServices objRF = new TrainingRequestFormServices();
		List<TrainingRequestForm> listofRequests = objRF.readTRFByRId(reqID);
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
	
	@RequestMapping(value="/f")
	public String showForm()
	{
		return "requestForm"; //returning view name
	}
	
	
	@RequestMapping(value="/savenew")
	public ModelAndView createConfirmService(HttpServletRequest req, HttpServletResponse res) throws ParseException {
		TrainingRequestFormServices objRF = new TrainingRequestFormServices();
		Date javaRD = new SimpleDateFormat("yyyy-MM-dd").parse(req.getParameter("dateRequested"));
		Date javaPD= new SimpleDateFormat("yyyy-MM-dd").parse(req.getParameter("proposedEndDate"));
		String oracleRD = new SimpleDateFormat("dd/MMM/yyyy").format(javaRD);
		String oraclePD = new SimpleDateFormat("dd/MMM/yyyy").format(javaPD);
		int ret = objRF.insertNewTRF(Integer.parseInt(req.getParameter("verID").trim()),Integer.parseInt(req.getParameter("venID")),
									Integer.parseInt(req.getParameter("ttID")),req.getParameter("trfProjectID"),req.getParameter("technology"),
									req.getParameter("trainingObjectives"),oracleRD,oraclePD,
									req.getParameter("projectSPOC"),Integer.parseInt(req.getParameter("appxEmployees")),req.getParameter("requestorEmpID"),
									req.getParameter("fileLocation"),Integer.parseInt(req.getParameter("trainingSource")));
		if (ret > 0) {
			return new ModelAndView("redirect:/RequestDash");
		} else {
			return new ModelAndView("error");
		}
	}
	
	@RequestMapping(value="/editRequest/{trfID}")
	public ModelAndView updateService(@PathVariable int trfID) {
		TrainingRequestFormServices objRF = new TrainingRequestFormServices();
		TrainingRequestForm trf = objRF.fetchTrainingRequest(trfID);
		return new ModelAndView("editRequest", "command", trf);
	}
	
	@RequestMapping(value="/confirmTRFDetails/{trfID}")
	public ModelAndView confirmService(@PathVariable int trfID) {
		FirstTableService objRF = new FirstTableService();
		SecondTable iptrf = objRF.getSecondTableDataByTRFID(trfID);
		return new ModelAndView("confirmTRFDetails", "command", iptrf);
	}
	
	@RequestMapping(value="/nomineeUpload/{trfID}")
	public ModelAndView uploadService(@PathVariable int trfID) {
		TrainingRequestFormServices objRF = new TrainingRequestFormServices();
		TrainingRequestForm trf = objRF.fetchTrainingRequest(trfID);
		return new ModelAndView("nomineeUpload", "command", trf);
	}

	@RequestMapping(value="/saveEditRequest")
	public ModelAndView updateConfirmService(HttpServletRequest req, HttpServletResponse res) throws ParseException {
		TrainingRequestFormServices objRF = new TrainingRequestFormServices();
		Date javaRD = new SimpleDateFormat("yyyy-MM-dd").parse(req.getParameter("dateRequested"));
		Date javaPD= new SimpleDateFormat("yyyy-MM-dd").parse(req.getParameter("proposedEndDate"));
		int ret;
		
		if (Integer.parseInt(req.getParameter("venID")) > 0) {
			ret = objRF.updateTRF(Integer.parseInt(req.getParameter("trfID")), Integer.parseInt(req.getParameter("verID")),Integer.parseInt(req.getParameter("venID")),
					Integer.parseInt(req.getParameter("ttID")),req.getParameter("trfProjectID"),req.getParameter("technology"),
					req.getParameter("trainingObjectives"), javaRD, javaPD,
					req.getParameter("projectSPOC"),Integer.parseInt(req.getParameter("appxEmployees")),req.getParameter("requestorEmpID"),
					req.getParameter("fileLocation"),Integer.parseInt(req.getParameter("trainingSource")));
		} else {
			ret = objRF.updateTRF(Integer.parseInt(req.getParameter("trfID")), Integer.parseInt(req.getParameter("verID")),
					Integer.parseInt(req.getParameter("ttID")),req.getParameter("trfProjectID"),req.getParameter("technology"),
					req.getParameter("trainingObjectives"), javaRD, javaPD,
					req.getParameter("projectSPOC"),Integer.parseInt(req.getParameter("appxEmployees")),req.getParameter("requestorEmpID"),
					req.getParameter("fileLocation"),Integer.parseInt(req.getParameter("trainingSource")));
		}
		if (ret > 0) {
			return new ModelAndView("redirect:/RequestDash");
		} else {
			return new ModelAndView("error");
		}
	}
	
	@RequestMapping(value="/confirmTraining")
	public ModelAndView confirmTrainingService(HttpServletRequest req, HttpServletResponse res) throws ParseException {
		TrainingRequestFormServices objRF = new TrainingRequestFormServices();
		FirstTableService objIPRF = new FirstTableService();
		int ret = 0;
		
	   ret = objRF.updateTRFOS_ID(Integer.parseInt(req.getParameter("trfID")), 3);
		
	   if (ret > 1) {
			return new ModelAndView("redirect:/RequestDash");
		} else {
			return new ModelAndView("error");
		}
	}
	
	@RequestMapping(value="/nomineeUpload/{trfID}")
	public ModelAndView uploadService(@PathVariable int trfID) {
		return new ModalAndView("redirect:/RequestDash");
	}
}