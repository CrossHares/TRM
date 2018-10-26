package ct.controller;

import java.text.ParseException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ct.dao.ConfirmedTraining;
import ct.dao.ConfirmedTrainingServices;


@Controller
public class ConfirmedTrainingController {
	@RequestMapping(value = "/") // slash is the root directory
	public String welcomeService(){
		//returns view name
		return "welcome"; //return name w/out file extension, SPRING will convert this for you
	}
	
	//confirmed training page
	@RequestMapping(value = "/confirmed")
	public String showConfirmedTraining(ModelMap ctmap){
		ConfirmedTrainingServices ct = new ConfirmedTrainingServices();
		List<ConfirmedTraining> ctlist = ct.readCT();
		ctmap.addAttribute("ct", ctlist);
		return "ctPage";
	}
	
		
	//delete ct
	@RequestMapping(value = "/deleteCT/{CtID}") 
	public ModelAndView deleteConfirmedTrainingService(@PathVariable Integer CtID){

		ConfirmedTrainingServices obj = new ConfirmedTrainingServices();
		int ret = obj.deleteCT(CtID);
		if(ret>0){	//is successful
			return new ModelAndView("redirect:/confirmed");
		}
		else{
			System.out.println("Delete failed");
			return new ModelAndView("error");
		}
	}
	//edit ct
	@RequestMapping(value = "/editCT/{CtID}")
	public ModelAndView editCTService(@PathVariable Integer CtID){
		System.out.println("edit function called Successful");
		ConfirmedTrainingServices ct = new ConfirmedTrainingServices();
		ConfirmedTraining newct = ct.getCT(CtID);
		
		return new ModelAndView("cteditform","command", newct); 
	}
	
	@RequestMapping(value = "/editctsave")
	public ModelAndView editVendorSaveService(@ModelAttribute("ct") ConfirmedTraining ct){
		System.out.println("Edit Save");
	
		ConfirmedTrainingServices cts = new ConfirmedTrainingServices();
		System.out.println("----------------------------------------------------------------------**");;
		//call update function
		int ret = cts.updateCT(ct.getCT_ROOM_NO(), ct.getCT_APPROVED_FILE_LOCATION(), ct.getLDTM_ID(), ct.getTRF_ID());
		
		if(ret>0){
			return new ModelAndView("redirect:/confirmed");
		}
		else{
			return new ModelAndView("error");
		}		
	}
	//insert ct
	@RequestMapping(value = "/insertct")
	public String insertCTService(){
		System.out.println("insertion");
		return "newconfirmedtraining";
	}	
	
	@RequestMapping(value = "/saveCT") 
	public ModelAndView saveCTFormService(HttpServletRequest req,HttpServletResponse res) throws ParseException{
		ConfirmedTrainingServices obj = new ConfirmedTrainingServices();
		
		int verid = Integer.parseInt(req.getParameter("VER_ID"));
		int venid = Integer.parseInt(req.getParameter("VEN_ID"));
		int ttid = Integer.parseInt(req.getParameter("TT_ID"));
		int osid = Integer.parseInt(req.getParameter("OS_ID"));
		int ldtm = Integer.parseInt(req.getParameter("LDTM_ID"));
		int capacity = Integer.parseInt(req.getParameter("CT_APPROX_NO_EMPLOYEES"));
		int source = Integer.parseInt(req.getParameter("CT_TRAINING_SOURCE"));
		
		int ret = obj.createNewCT(verid, venid,ttid,osid,
				req.getParameter("CT_PROJECT_ID"), req.getParameter("CT_TECHNOLOGY"),
				req.getParameter("CT_TRAINING_OBJECTIVES"), req.getParameter("CT_DATE_REQUESTED"), req.getParameter("CT_PROPOSED_START_DATE"),
				req.getParameter("CT_PROPOSED_END_DATE"), req.getParameter("CT_PROPOSED_START_TIME"), req.getParameter("CT_PROPOSED_END_TIME"), 
				req.getParameter("CT_PROPOSED_LOCATION"), req.getParameter("CT_ROOM_NO"), ldtm, 
				req.getParameter("CT_PROJECT_TRAINING_SPOC"), capacity, 
				req.getParameter("CT_REQUESTOR_EMPLOYEE_ID"), req.getParameter("CT_APPROVED_FILE_LOCATION"), 
				source, req.getParameter("CT_NOMINATION_FILE"), 
				req.getParameter("CT_ASSIGNED_EXEC"));

		
		if(ret>0){
			return new ModelAndView("redirect:/showAllEmployees");
		}
		else{
			return new ModelAndView("error");
		}
	}
	
	@RequestMapping(value = "/saveCT2")
	public ModelAndView saveCTFormService2(@ModelAttribute("ct") ConfirmedTraining ct) throws ParseException{
		System.out.println("insertion Save----------");
		
		int VER_ID = ct.getVER_ID();
		int VEN_ID= ct.getVEN_ID();
		int TT_ID = ct.getTT_ID();
		int OS_ID = ct.getOS_ID();
		
		String CT_PROJECT_ID = ct.getCT_PROJECT_ID();
		String CT_TECHNOLOGY = ct.getCT_TECHNOLOGY();
		String CT_TRAINING_OBJECTIVES = ct.getCT_TRAINING_OBJECTIVES();
		String CT_DATE_REQUESTED = ct.getCT_DATE_REQUESTED();
		String CT_PROPOSED_START_DATE =  ct.getCT_PROPOSED_START_DATE();
		String CT_PROPOSED_END_DATE = ct.getCT_PROPOSED_END_DATE();
		String CT_PROPOSED_START_TIME = ct.getCT_PROPOSED_START_TIME();
		String CT_PROPOSED_END_TIME = ct.getCT_PROPOSED_END_TIME();
		String CT_PROPOSED_LOCATION = ct.getCT_PROPOSED_LOCATION();
		
		String CT_PROJECT_TRAINING_SPOC = ct.getCT_PROJECT_TRAINING_SPOC();
		int CT_APPROX_NO_EMPLOYEES = ct.getCT_APPROX_NO_EMPLOYEES();
		String CT_REQUESTOR_EMPLOYEE_ID = ct.getCT_REQUESTOR_EMPLOYEE_ID();
		String CT_APPROVED_FILE_LOCATION = ct.getCT_APPROVED_FILE_LOCATION();
		String CT_ROOM_NO = ct.getCT_ROOM_NO();
		int LDTM_ID = ct.getLDTM_ID();
		
		int CT_TRAINING_SOURCE = ct.getCT_TRAINING_SOURCE();
		String CT_NOMINATION_FILE = ct.getCT_NOMINATION_FILE();
		String CT_ASSIGNED_EXEC = ct.getCT_ASSIGNED_EXEC();

		
		ConfirmedTrainingServices cts = new ConfirmedTrainingServices();
		int ret = cts.createNewCT(VER_ID, VEN_ID, TT_ID, OS_ID, CT_PROJECT_ID,
				CT_TECHNOLOGY,CT_TRAINING_OBJECTIVES, CT_DATE_REQUESTED, CT_PROPOSED_START_DATE, 
				CT_PROPOSED_END_DATE, CT_PROPOSED_START_TIME, CT_PROPOSED_END_TIME,CT_PROPOSED_LOCATION, 
				CT_ROOM_NO, LDTM_ID, CT_PROJECT_TRAINING_SPOC,CT_APPROX_NO_EMPLOYEES, 
				CT_REQUESTOR_EMPLOYEE_ID, CT_APPROVED_FILE_LOCATION, CT_TRAINING_SOURCE,
			  CT_NOMINATION_FILE, CT_ASSIGNED_EXEC );


		if(ret>0){
			return new ModelAndView("redirect:/confirmed");
		}
		else{
			return new ModelAndView("error");
		}
		
	}
}
