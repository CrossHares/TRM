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
import dao.ConfirmedTraining2;
import dao.ConfirmedTrainingServices2;


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
	//version 2
	//confirmed training page
		@RequestMapping(value = "/confirmed2")
		public String showCT(ModelMap ctmap){
			ConfirmedTrainingServices2 ct = new ConfirmedTrainingServices2();
			List<ConfirmedTraining2> ctlist = ct.readCT();
			ctmap.addAttribute("ct", ctlist);
			return "ctPage2";
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
			
		int ret = cts.updateCTlocation(ct.getCtID(), ct.getCtLocation());
		int ret2 = cts.updateCTtechnology(ct.getCtID(), ct.getCtTechnology());
		int ret3 = cts.updateCTtrainingObj(ct.getCtID(), ct.getCtTrainingObj());
//		int ret4 = cts.updateCTstartDate(ct.getCtID(), ct.getCtStartDate());
//		int ret5 = cts.updateCTendDate(ct.getCtID(), ct.getCtEndDate());
		if(ret>0 && ret2>0 && ret3>0 ){
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
	@RequestMapping(value = "/a")
	public ModelAndView tester(@ModelAttribute("ct") ConfirmedTraining ct){
		return new ModelAndView("redirect:/confirmed");
	}
	
	@RequestMapping(value = "/saveCT")
	public ModelAndView saveEmployeeFormService(@ModelAttribute("ct") ConfirmedTraining ct){
		System.out.println("insertion Save");
		
		ConfirmedTrainingServices cts = new ConfirmedTrainingServices();
		int ret = cts.createNewCT(ct.getTsID(), ct.getTtID(), ct.getLdUserEmail(), ct.getVerID(), ct.getTrfIDs(), 
				ct.getCtStartDate(), ct.getCtEndDate(), ct.getCtStartTime(), ct.getCtEndTime(),
				ct.getCtTechnology(), ct.getCtTrainingObj(), ct.getCtLocation(), ct.getCtNomFile());
		
		if(ret>0){
			return new ModelAndView("redirect:/confirmed");
		}
		else{
			return new ModelAndView("error");
		}
	}
}
