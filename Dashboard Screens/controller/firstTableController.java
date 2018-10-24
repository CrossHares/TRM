package dao.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dao.dashboard_firstTable.*;


@Controller
public class firstTableController {

	@RequestMapping(value="/")
	public String welcomeService(){
		return "welcome";
	}
	
	
	@RequestMapping(value="/viewFirstTable")
	public String showFirstTable(ModelMap firstTableMap){
		
		FirstTableService objFirstTable = new FirstTableService();
		List<FirstTable> firsttable = objFirstTable.getFirstTableData();
		firstTableMap.addAttribute("firstTableValues", firsttable);
		FirstTableService objSecondTable = new FirstTableService();
		List<SecondTable> secondTable = objSecondTable.getSecondTableData();
		firstTableMap.addAttribute("secondTableValues", secondTable);
		return "firstTable";
	}
	
	@RequestMapping(value="/move/{trfID}")
	public ModelAndView moveThis(@PathVariable Integer trfID){
		FirstTableService obj = new FirstTableService();
		int ret = obj.createSecondTable(trfID);
		int ret2 = obj.deleteFromFirstTable(trfID);
		if(ret>0 && ret2 > 0)
			return new ModelAndView ("redirect:/viewFirstTable");
		return new ModelAndView("error");
	}
}
