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
	
	@RequestMapping(value = "/confirmed") 
	public String hoverpage(ModelMap ctmap){
		ConfirmedTrainingServices ct = new ConfirmedTrainingServices();
		List<ConfirmedTraining> ctlist = ct.readCT();
		ctmap.addAttribute("ct", ctlist);
		return "hover-feature";
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
		System.out.println("----------------------------------------------------------------------**");
		//call update function
		int ret = cts.updateCT(ct.getCT_ROOM_NO(), ct.getCT_PROPOSED_LOCATION(), ct.getLDTM_ID(), ct.getTRF_ID());
		
		System.out.println("trfid = " + ct.getTRF_ID());
		System.out.println("location = " + ct.getCT_PROPOSED_LOCATION());
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
	public ModelAndView saveCTFormService2(@ModelAttribute("ct") ConfirmedTraining ct) throws ParseException{
		System.out.println("insertion Save----------");

		
		ConfirmedTrainingServices cts = new ConfirmedTrainingServices();
		int ret = cts.createNewCT(ct.getTRF_ID(), ct.getVER_ID(), ct.getVEN_ID(), ct.getTT_ID(), 
				ct.getOS_ID(), ct.getCT_PROJECT_ID(),ct.getCT_TECHNOLOGY(),
				ct.getCT_TRAINING_OBJECTIVES(), ct.getCT_DATE_REQUESTED(), ct.getCT_PROPOSED_START_DATE(), 
				ct.getCT_PROPOSED_END_DATE(), ct.getCT_PROPOSED_START_TIME(), 
				ct.getCT_PROPOSED_END_TIME(), ct.getCT_PROPOSED_LOCATION(), 
				ct.getCT_ROOM_NO(), ct.getLDTM_ID(), ct.getCT_PROJECT_TRAINING_SPOC(),
				ct.getCT_APPROX_NO_EMPLOYEES(), ct.getCT_REQUESTOR_EMPLOYEE_ID(), 
				ct.getCT_APPROVED_FILE_LOCATION(), ct.getCT_TRAINING_SOURCE(),
				ct.getCT_NOMINATION_FILE(), ct.getCT_ASSIGNED_EXEC() );


		if(ret>0){
			return new ModelAndView("redirect:/confirmed");
		}
		else{
			return new ModelAndView("error");
		}
		
	}
}
