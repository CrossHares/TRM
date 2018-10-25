package ct.controller;

import java.util.List;

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
		
		System.out.println("delete----------");
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
		//return new ModelAndView("redirect:/confirmed");
		
		//call update function

		int TRF_ID = ct.getTRF_ID();
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
		String CT_PROJECT_TRAINING_SPOC = ct.getCT_PROJECT_TRAINING_SPOC();
		int CT_APPROX_NO_EMPLOYEES = ct.getCT_APPROX_NO_EMPLOYEES();
		String CT_REQUESTOR_EMPLOYEE_ID = ct.getCT_REQUESTOR_EMPLOYEE_ID();
		String CT_APPROVED_FILE_LOCATION = ct.getCT_APPROVED_FILE_LOCATION();
		int CT_TRAINING_SOURCE = ct.getCT_TRAINING_SOURCE();
		String CT_PROPOSED_LOCATION = ct.getCT_PROPOSED_LOCATION();
		String CT_PROPOSED_START_TIME = ct.getCT_PROPOSED_START_TIME();
		String CT_PROPOSED_END_TIME = ct.getCT_PROPOSED_END_TIME();
		int CT_BUTTON_COUNT = ct.getCT_BUTTON_COUNT();
		
		int ret = cts.updateCT(VER_ID, VEN_ID, TT_ID, OS_ID, CT_PROJECT_ID, CT_TECHNOLOGY,
				CT_TRAINING_OBJECTIVES, CT_DATE_REQUESTED, CT_PROPOSED_START_DATE,
				CT_PROPOSED_END_DATE,CT_PROPOSED_START_TIME, CT_PROPOSED_END_TIME,
				CT_PROPOSED_LOCATION, CT_PROJECT_TRAINING_SPOC, CT_APPROX_NO_EMPLOYEES,
				CT_REQUESTOR_EMPLOYEE_ID, CT_APPROVED_FILE_LOCATION,CT_TRAINING_SOURCE, 
				CT_BUTTON_COUNT , TRF_ID);
		
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
	public ModelAndView saveEmployeeFormService(@ModelAttribute("ct") ConfirmedTraining ct){
		System.out.println("insertion Save");
		
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
		int CT_HIDE_STATUS = ct.getCT_HIDE_STATUS();
		String CT_ASSIGNED_EXEC = ct.getCT_ASSIGNED_EXEC();
		
		int CT_BUTTON_COUNT = ct.getCT_BUTTON_COUNT();
		
		ConfirmedTrainingServices cts = new ConfirmedTrainingServices();
		int ret = cts.createNewCT(VER_ID, VEN_ID, TT_ID, OS_ID, CT_PROJECT_ID,
				CT_TECHNOLOGY,CT_TRAINING_OBJECTIVES, CT_DATE_REQUESTED, CT_PROPOSED_START_DATE, 
				CT_PROPOSED_END_DATE, CT_PROPOSED_START_TIME, CT_PROPOSED_END_TIME,CT_PROPOSED_LOCATION, 
				CT_ROOM_NO, LDTM_ID, CT_PROJECT_TRAINING_SPOC,CT_APPROX_NO_EMPLOYEES, 
				CT_REQUESTOR_EMPLOYEE_ID, CT_APPROVED_FILE_LOCATION, CT_TRAINING_SOURCE,
			  CT_NOMINATION_FILE, CT_ASSIGNED_EXEC, CT_HIDE_STATUS,CT_BUTTON_COUNT );


		if(ret>0){
			return new ModelAndView("redirect:/confirmed");
		}
		else{
			return new ModelAndView("error");
		}
		
	}
}
