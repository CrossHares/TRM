package controller;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import dao.Login.Login;
import dao.Login.LoginServices;
import dao.Charts.ChartServices;
import dao.DashboardTables.Executives;
import dao.DashboardTables.NewRequestTable;
import dao.DashboardTables.NewRequestTableServices;
import dao.DashboardTables.RequestInQueueTable;

@Controller
public class MyController{
	ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
	JdbcTemplate template = (JdbcTemplate) context.getBean("jt");
	
	@RequestMapping(value="/")
	public String showLogin()
	{
		return "login";
	}
	
	@RequestMapping(value = "/showDashboard")
	public ModelAndView showDashboard(@RequestParam("username") String user, @RequestParam("password") String pass, HttpServletRequest req) {

		LoginServices obj = new LoginServices();
		Login myLogin = obj.isUserValid(user, pass);
		if (myLogin != null) {

			if (myLogin.getRole_name().equalsIgnoreCase("MANAGER")) {
				
				req.getSession().putValue("loginmessage", myLogin.getUserName());
				return new ModelAndView("redirect:/RequestDashboard");
			}
			else if (myLogin.getRole_name().equalsIgnoreCase("LD SPOC"))
			{
				req.getSession().putValue("loginmessage", myLogin.getUserName());
				return new ModelAndView("redirect:/AdminDashboard");
			}
			else if (myLogin.getRole_name().equalsIgnoreCase("EXECUTOR"))
			{
				req.getSession().putValue("loginmessage", myLogin.getRole_name());
				return new ModelAndView("redirect:/ExecutiveDashboard");
			}
			else {
				return new ModelAndView("redirect:/");
			}
		} else {
			return new ModelAndView("redirect:/");
		}
	}
	
	@RequestMapping(value="/AdminDashboard")
	public String showAdminDashboard(ModelMap DashboardTablesMap){
		
		//Table 1 - New Request Table
		NewRequestTableServices objNewRequestTable = new NewRequestTableServices();
		List<NewRequestTable> NewRequestTableVals = objNewRequestTable.getFirstTableData();
		DashboardTablesMap.addAttribute("NewRequestTableValues", NewRequestTableVals);
		
		//Table 2 - New Request Table
		NewRequestTableServices objRequestInQueueTable = new NewRequestTableServices();
		List<RequestInQueueTable> RequestInQueueTableVals = objRequestInQueueTable.getSecondTableData();
		DashboardTablesMap.addAttribute("RequestInQueueTableValues", RequestInQueueTableVals);
		
		//Table 3 - Ongoing Table
		NewRequestTableServices objOngoing = new NewRequestTableServices();
		List<RequestInQueueTable> OngoingTableVals = objOngoing.getThirdTableData();
		DashboardTablesMap.addAttribute("OngoingTableValues", OngoingTableVals);
				
		return "AdminDashboard";
	}
	
	@RequestMapping(value="/move/{trfID}")
	public ModelAndView moveThis(@PathVariable Integer trfID){
		NewRequestTableServices obj = new NewRequestTableServices();
		int ret = obj.createSecondTable(trfID);
		int ret2 = obj.deleteFromTable(trfID);
		if(ret>0)
			return new ModelAndView ("redirect:/AdminDashboard");
		return new ModelAndView("error");
	}
	
	@RequestMapping(value="/editform1/{trfID}")
	public ModelAndView editform1(@PathVariable Integer trfID, ModelMap value){
		value.addAttribute("trfID", trfID);
		return new ModelAndView("form1");
	}
	
	@RequestMapping(value="/editform1internal/{trfID}")
	public ModelAndView db1(@PathVariable Integer trfID)
	{
		NewRequestTableServices obj = new NewRequestTableServices();
		int ret = obj.enterform1(trfID);
		if(ret>0)
			return new ModelAndView ("redirect:/AdminDashboard");
		return new ModelAndView("error");
	}
	
	@RequestMapping(value="/editform2/{trfID}")
	public ModelAndView editform2(@PathVariable Integer trfID, ModelMap value){
		ModelMap map = new ModelMap();
		map.addAttribute("trfID", trfID);
		return new ModelAndView("form2internal");
	}
	 
	@RequestMapping(value="editform2internal/{trfID}")
	public ModelAndView db2(HttpServletRequest req, HttpServletResponse res, @PathVariable Integer trfID) throws ParseException {
		NewRequestTableServices obj = new NewRequestTableServices();
		Date javaSD = new SimpleDateFormat("yyyy-MM-dd").parse(req.getParameter("StartDate"));
		Date javaED = new SimpleDateFormat("yyyy-MM-dd").parse(req.getParameter("EndDate"));
		int ret = obj.enterform2(trfID, javaSD, javaED, req.getParameter("Location"), req.getParameter("StartTime"),
				req.getParameter("EndTime"), req.getParameter("Objectives"));
		if(ret>0)
			return new ModelAndView("redirect:/AdminDashboard");
	  
	  return new ModelAndView("error");
	}
	
	@RequestMapping(value="editform3/{trfID}")
	public String db3(@PathVariable Integer trfID, ModelMap executiveMap){
		NewRequestTableServices objexecutiveservice = new NewRequestTableServices();
		List<Executives> executives = objexecutiveservice. getAllExecutiveService();
			
		for(Executives e : executives){
			System.out.println(e.getLD_USER_NAME());
		}
		executiveMap.addAttribute("allExecutives",executives);
			
		executiveMap.addAttribute("trfID", trfID);
		return "assignexecutiveform";
	}

	@RequestMapping(value="/editassignexecutives/{trfID}")
	public ModelAndView executivedb(@PathVariable Integer trfID, ModelMap emplMap, HttpServletRequest req, HttpServletResponse res){
		NewRequestTableServices obj = new NewRequestTableServices();
		int ret = obj.enterform3(trfID, req.getParameter("LD_USER_NAME"));
			
		int ret1 = obj.updateconfirmedtraining(trfID);
		int ret2 = obj.deleteFromSecondTable(trfID);
		if(ret>0&&ret1>0&&ret2>0)
			return new ModelAndView("redirect:/AdminDashboard");
				  
		return new ModelAndView("error");
	}
	
	@RequestMapping(value="/delete/{trfid}")
	public ModelAndView deleterow(@PathVariable Integer trfid){
		System.out.println("In the  delete function");
		NewRequestTableServices obj = new NewRequestTableServices();
		int ret = obj.deletebutton(trfid);
		if(ret>0)
			return new ModelAndView("redirect:/viewFirstTable");
		return new ModelAndView("error");
	}
	
	
	
	
	
	
	
	
	
	
	
	@RequestMapping(value="/reports")
	public String viewSpocRequestsReportService(ModelMap SPOCChartDataMap)
	{
		ChartServices chartServices = new ChartServices();
		JSONObject chartData = chartServices.getLDName_TRCountFromDb();
		SPOCChartDataMap.addAttribute("spoc_requests_data", chartData);
		
		return "reports";
	}
	
	@RequestMapping(value="showidvreportforgivenspocview")
	public String viewIDVforGivenSPOCReportService(ModelMap SPOCChartDataMap)
	{
		//first do just for "CLINTON EXODIA"
		
		ChartServices chartServices = new ChartServices();
		String idv_clinton = chartServices.getIDVForSPOC_clinton();//next step->do for each SPOC, maybe put a static list of the 6 names->use preparedStatement
		String idv_tyberius = chartServices.getIDVForSPOC_tyberius();
		String idv_jerimahia = chartServices.getIDVForSPOC_jerimahia();
		String idv_jose = chartServices.getIDVForSPOC_jose();
		String idv_shaq = chartServices.getIDVForSPOC_shaq();
		String idv_mike = chartServices.getIDVForSPOC_mike();
		
		SPOCChartDataMap.addAttribute("clintonIDV", idv_clinton);//changed from "exodiaIDV" (using first names for this now)
		SPOCChartDataMap.addAttribute("tyberiusIDV", idv_tyberius);
		SPOCChartDataMap.addAttribute("jerimahiaIDV", idv_jerimahia);
		SPOCChartDataMap.addAttribute("joseIDV", idv_jose);
		SPOCChartDataMap.addAttribute("shaqIDV", idv_shaq);
		SPOCChartDataMap.addAttribute("mikeIDV", idv_mike);
		
		//SPOCChartDataMap.addAttribute("spocName", "\"Clinton Exodia\"");

		
		return "idvforgivenspoc";
	}
	
	@RequestMapping(value="showverticalwiserequestview")
	public String viewRequestsFromEachVerticalService(ModelMap SPOCChartDataMap)
	{
		ChartServices chartServices = new ChartServices();
		
		JSONObject chartData = chartServices.getVerticalWiseRequestData();
		SPOCChartDataMap.addAttribute("verticalChartData",chartData);
		
		return "requestsfromeachvertical";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*	@RequestMapping(value="/reports")
	public String showReports()
	{
		return "reports";
	}*/
	
	
	/*
	
	@RequestMapping(value="/showchartsview")
	public String viewChartsService(ModelMap SPOCChartDataMap)
	{
		ChartServices chartServices = new ChartServices();
		JSONObject chartData = chartServices.getChartData();
		SPOCChartDataMap.addAttribute(chartData);
		
		return "chartsview";
	}
	
	@RequestMapping(value="/showmodelmapview")
	public String modelMapTestService(ModelMap SPOCChartDataMap)
	{
		ChartServices chartServices = new ChartServices();
		JSONObject chartData = chartServices.getChartData();
		SPOCChartDataMap.addAttribute("spocChartData",chartData);
		System.out.println(SPOCChartDataMap);
		
		return "modelmaptest";
	}
	
	@RequestMapping(value="/showchartsfromjsonview")
	public String viewChartsFromJsonService(ModelMap SPOCChartDataMap)
	{
		ChartServices chartServices = new ChartServices();
		JSONObject chartData = chartServices.getSPOC_CoursesDataFromDb();
		SPOCChartDataMap.addAttribute("spocChartData",chartData);
		
		return "chartsfromjsonview";
	}*/
	
}