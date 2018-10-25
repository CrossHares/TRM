package ctrl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import trf.dao.*;

@Controller
public class MyController {
	
	@RequestMapping(value="/")
	public String homeService() {
		return "home";
	}
	
	@RequestMapping(value="/readRequests")
	public String readRequestsService(ModelMap rfmap) {
		TrainingRequestFormServices objRF = new TrainingRequestFormServices();
		List<TrainingRequestForm> listofRequests = objRF.readTRF();
		rfmap.addAttribute("values", listofRequests);
		return "requestForm";
	}
	
	@RequestMapping(value="/editRequest/{trfID}")
	public ModelAndView updateService(@PathVariable int trfID) {
		TrainingRequestFormServices objRF = new TrainingRequestFormServices();
		TrainingRequestForm trf = objRF.fetchTrainingRequest(trfID);
		return new ModelAndView("editRequest", "command", trf);
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
			return new ModelAndView("redirect:/readRequests");
		} else {
			return new ModelAndView("error");
		}
	}
	
	@RequestMapping(value="/delete/{trfID}")
	public ModelAndView deleteService(@PathVariable int trfID) {
		TrainingRequestFormServices objRF = new TrainingRequestFormServices();
		int ret = objRF.deleteTRF(trfID);
		if (ret >0 ) {
			return new ModelAndView("redirect:/readRequests");
		} else {
			return new ModelAndView("error");
		}

	}
	
	@RequestMapping(value="/createRequest")
	public String createService() {
		return "createRequest";
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
			return new ModelAndView("redirect:/readRequests");
		} else {
			return new ModelAndView("error");
		}
	}
	
	
}
