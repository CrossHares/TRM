package ems.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dao.ctraining.ConfirmedTraining;
import dao.ctraining.ConfirmedTrainingServices;


@Controller
public class ConfirmedTrainingController {

	//confirmed training page
	@RequestMapping(value = "/confirmed")
	public String showConfirmedTraining(ModelMap ctmap){
		ConfirmedTrainingServices ct = new ConfirmedTrainingServices();
		List<ConfirmedTraining> ctlist = ct.read();
		ctmap.addAttribute("ct", ctlist);
		return "ctPage";
	}
	//delete ct
	@RequestMapping(value = "/deleteCT/{ctid}") //has child record in database
	public ModelAndView deleteConfirmedTrainingService(@PathVariable Integer ctid){
		
		ConfirmedTrainingServices obj = new ConfirmedTrainingServices();
		int ret = obj.delete(ctid);
		if(ret>0){	//is successful
			System.out.println("Delete Successful");
			return new ModelAndView("redirect:/confirmed");
		}
		else{
			System.out.println("Delete failed");
			return new ModelAndView("error");
		}
	}
	//edit ct
	@RequestMapping(value = "/editCT/{ctid}")
	public ModelAndView editCTService(@PathVariable Integer ctid){
		
		ConfirmedTrainingServices ct = new ConfirmedTrainingServices();
		ConfirmedTraining newct = ct.getConfirmedTraining(ctid);
		
		return new ModelAndView("cteditform","command", newct); 
	}
	@RequestMapping(value = "editctsave")
	public ModelAndView editVendorSaveService(@ModelAttribute("ctrain") ConfirmedTraining ct){
		
		ConfirmedTrainingServices cts = new ConfirmedTrainingServices();
		//call update function
		int ret = cts.update(ct.getCitid(), ct.getCt_location());
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
		return "newconfirmedtraining";
	}	
}