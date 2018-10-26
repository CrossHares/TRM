package mypro;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WebController {
	@RequestMapping(value="/developertrainingmember")
	public String developerTrainingMemberService(ModelMap toMap)
	{
		DeveloperTrainingMemberServices ser = new DeveloperTrainingMemberServices();
		List<DeveloperTrainingMember> toAdd = ser.getDtmList();
		toMap.addAttribute("dtmList",toAdd);
		return "developer-training-member";
	}
	@RequestMapping(value="/developertrainingmember/delete/{memid}")
	public ModelAndView developerTrainingMemberDeleteService(@PathVariable Integer memid)
	{
		DeveloperTrainingMemberServices ser = new DeveloperTrainingMemberServices();
		int ret = ser.deleteDtmMember(memid);
		if(ret>0)
			return new ModelAndView("redirect:/developertrainingmember");
		return new ModelAndView("error");
		
	}
	@RequestMapping(value="/developertrainingmember/edit/{memid}")
	public ModelAndView developerTrainingMemberEditService(@PathVariable Integer memid)
	{
		DeveloperTrainingMemberServices ser = new DeveloperTrainingMemberServices();
		DeveloperTrainingMember obj = ser.getMember(memid);
		return new ModelAndView("developer-training-member-edit-form","command",obj);
		
	}
	@RequestMapping(value="/developertrainingmember/edited")
	public ModelAndView developerTrainingMemberEditedService(@ModelAttribute("DeveloperTrainingMember") DeveloperTrainingMember dtmMem)
	{
		DeveloperTrainingMemberServices ser = new DeveloperTrainingMemberServices();
		int ret = ser.updateDtmMember(dtmMem.getDtmId(), dtmMem.getDtmName(), dtmMem.getDtmPhone(), dtmMem.getDtmEmail());
		return new ModelAndView("redirect:/developertrainingmember");
		
	}
	@RequestMapping(value="/ldtrainingmember")
	public String ldTrainingMemberServices(ModelMap toMap)
	{
		
		LDTrainingMemberServices ser = new LDTrainingMemberServices();
		List<LDTrainingMember> toAdd = ser.getLDTMList();
		toMap.addAttribute("ldtmList",toAdd);
		return "ld-training-member";
	}
	@RequestMapping(value="/hoverfeature")
	public String hoverFeatureService(ModelMap toMap)
	{	TrainingRequestFormServices ser = new TrainingRequestFormServices();
		List<TrainingRequestForm> toAdd = ser.readTRF();
		System.out.println(toAdd.size());
		toMap.addAttribute("trfList",toAdd);
		return "hover-feature";
	}
	
}
