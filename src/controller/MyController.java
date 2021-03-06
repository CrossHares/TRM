package controller;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.mail.Session;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import dao.Login.Login;
import dao.Login.LoginServices;
import dao.Login.Requesterdao;
import dao.dashboard_firstTable.FirstTable;
import dao.dashboard_firstTable.FirstTableService;
import dao.dashboard_firstTable.SecondTable;
import dao.ldtm.LDTeam;
import dao.ldtm.LDTeamServices;
import dao.vendor.Vendor;
import dao.vendor.VendorServices;
import dao.vendoremp.VendorEmp;
import dao.vendoremp.VendorEmpServices;
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
		Requesterdao reqLogin = obj.isRequesterValid(user, pass);
		
		System.out.println(myLogin);
		
		
		if (myLogin != null) {

			if(myLogin.getRole_name().equalsIgnoreCase("MANAGER") || myLogin.getRole_name().equalsIgnoreCase("LD SPOC")) {
				
				req.getSession().putValue("loginmessage", myLogin.getUserName());
				req.getSession().putValue("ld_user_email", myLogin.getGet_user_email());
				return new ModelAndView("redirect:/AdminDashboard");
			} else if (myLogin.getRole_name().equalsIgnoreCase("EXECUTOR")) {
				req.getSession().putValue("loginmessage", myLogin.getUserName());
				req.getSession().putValue("ld_executor_email", myLogin.getGet_user_email());
				return new ModelAndView("redirect:/ExecDashboard");
			}else {
				
				return new ModelAndView("redirect:/RequstorDash");						//Requester Dashboard
			}
	}else if (reqLogin != null) {
		
		req.getSession().putValue("loginmessage", reqLogin.getRequester_name());
		req.getSession().putValue("req_email", reqLogin.getRequester_email());
		req.getSession().putValue("req_id", reqLogin.getRequester_id());
		return new ModelAndView("redirect:/RequestDash");
	}else {
		
		return new ModelAndView("redirect:/");
	}

}
	
	@RequestMapping(value="/AdminDashboard")
	public String showAdminDashboard(ModelMap DashboardTablesMap, HttpServletRequest req){
		
		//Table 1 - New Request Table
		NewRequestTableServices objNewRequestTable = new NewRequestTableServices();
		Object emailIds = req.getSession().getAttribute("ld_user_email");
		String newEmail = emailIds.toString();
		List<NewRequestTable> NewRequestTableVals = objNewRequestTable.getFirstTableData(newEmail);
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
	

	
	
	
	
	
	
	
	
	
	
	
	@RequestMapping(value="/showAllVendors")
	public String showAllVEndorsService(ModelMap vendorMap, HttpServletRequest req)
	{
		VendorServices objVendorService = new VendorServices();
		List<Vendor> listOfVendors = objVendorService.showAllVendorService();
		vendorMap.addAttribute("vendorList", listOfVendors);
		req.getSession().putValue("loginMessage", " ");
		return "showAllVendors";
	}
	
	@RequestMapping(value="/insertVendorForm")
	public String inserVendorService()
	{
		return "insertVendorForm";
	}
	
	
	@RequestMapping(value="/saveVendor")
	public ModelAndView saveVendorFormService(HttpServletRequest req, HttpServletResponse res)
	{
		VendorServices objVendorService = new VendorServices();
		int ret = objVendorService.insertNewVendorService(req.getParameter("venName"),req.getParameter("venLocation"), 
					req.getParameter("venAddress"), req.getParameter("venSpoc"), req.getParameter("venPhone"), 
					req.getParameter("venEmail"));  
		if(ret>0){
			req.getSession().putValue("loginMessage", " ");
			return new ModelAndView("redirect:/showAllVendors");
		}
		else
		{
			String message = req.getParameter("venEmail") + " Already Exists";
			req.getSession().putValue("loginMessage", message);
			return new ModelAndView("insertVendorForm");
		}
	}
	
	
	@RequestMapping(value="/deleteVendor/{venId}")
	public ModelAndView deleteEmployeeService(@PathVariable Integer venId)
	{
		VendorServices objVendorService = new VendorServices();
		int ret = objVendorService.deleteVendorService(venId);
		if(ret>0)
		{
			return new ModelAndView("redirect:/showAllVendors");
		}
		return new ModelAndView("welcome");
	}
	
	
	@RequestMapping(value="/editVendorSave")
	public ModelAndView editEmployeeService(@ModelAttribute("vendor") Vendor vendor)
	{
		VendorServices objVendorService = new VendorServices();
		// Call Update
		objVendorService.updateVendorService(vendor.getVenId(), vendor.getVenName(), vendor.getVenLocation(), 
				vendor.getVenAddress(), vendor.getVenSpoc(), vendor.getVenPhone(), vendor.getVenEmail());
		return new ModelAndView("redirect:/showAllVendors");
	}
	
	
	@RequestMapping(value="/editVendor/{venId}")
	public ModelAndView editEmployeeService(@PathVariable Integer venId)
	{
		VendorServices objVendorService = new VendorServices();
		Vendor vendor = objVendorService.getVendor(venId);
		return new ModelAndView("vendorEditForm", "command", vendor);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@RequestMapping(value="/showVendorEmp")
	public String showVendorEmpService(ModelMap vendorEmpMap, HttpServletRequest req)
	{
		VendorEmpServices vendEmpObj = new VendorEmpServices();
		List<VendorEmp> listOfVendorEmps = vendEmpObj.showAllVendorEmployeeService();
		vendorEmpMap.addAttribute("vendorEmpList", listOfVendorEmps);
		req.getSession().putValue("loginMessage", " ");
		return "showVendorEmp";
	}
	
	@RequestMapping(value="/insertVendorEmp")
	public String insertVendorEmpService()
	{
		return "insertVendorEmp";
	}
	
	
	@RequestMapping(value="/saveVendorEmp")
	public ModelAndView saveVendorEmployeeFormService(HttpServletRequest req, HttpServletResponse res)
	{
		VendorEmpServices vendEmpObj = new VendorEmpServices();
		int ret = vendEmpObj.insertNewVendorEmployeeService(Integer.parseInt(req.getParameter("venId")), req.getParameter("vEmpName"), 
				req.getParameter("vEmpEmail"), req.getParameter("vEmpLocation"), req.getParameter("vEmpAddress"), 
				req.getParameter("vEmpPhone"), req.getParameter("vEmpSpecialty"));
				
		if(ret>0){
			req.getSession().putValue("loginMessage", " ");
			return new ModelAndView("redirect:/showVendorEmp");
		}
		else
		{
			String message = req.getParameter("vEmpEmail") + " Already Exists";
			req.getSession().putValue("loginMessage", message);
			return new ModelAndView("insertVendorEmp");
		}
	}
	
	
	@RequestMapping(value="/deleteVendorEmployee/{vEmpId}")
	public ModelAndView deleteVendorEmployeeService(@PathVariable Integer vEmpId)
	{
		VendorEmpServices vendEmpObj = new VendorEmpServices();
		int ret = vendEmpObj.deleteVendorEmployeeService(vEmpId); 
		if(ret>0)
		{
			return new ModelAndView("redirect:/showVendorEmp");
		}
		return new ModelAndView("welcome");
	}
	
	
	@RequestMapping(value="/editVendorEmployeeSave")
	public ModelAndView editVendorEmployeeService(@ModelAttribute("venEmp") VendorEmp venEmp)
	{
		VendorEmpServices vendEmpObj = new VendorEmpServices();
		// Call Update
		vendEmpObj.updateVendorEmployeeService(venEmp.getvEmpId(), venEmp.getVenId(), venEmp.getvEmpName(), venEmp.getvEmpEmail(), 
				venEmp.getvEmpLocation(), venEmp.getvEmpAddress(), venEmp.getvEmpPhone(), venEmp.getvEmpSpecialty());
		return new ModelAndView("redirect:/showVendorEmp");
	}
	
	
	
	@RequestMapping(value="/showLDTrainingMember")
	public String showLDTeamMembersService(ModelMap ldtmMap, HttpServletRequest req)
	{
		LDTeamServices objLDTeamService = new LDTeamServices();
		List<LDTeam> listOfLDTMembers = objLDTeamService.showAllTrainingMemberService();
		ldtmMap.addAttribute("ldtmList", listOfLDTMembers);
		req.getSession().putValue("loginMessage", " ");
		return "showLDTrainingMember";
	}
	
	
	@RequestMapping(value="/insertLDTrainingMembers")
	public String inserLDTeamMembersService()
	{
		return "insertLDTrainingMembers";
	}
	
	
	@RequestMapping(value="/saveLDTMember")
	public ModelAndView saveLDTeamMembersService(HttpServletRequest req, HttpServletResponse res)
	{
		LDTeamServices objLDTeamService = new LDTeamServices();
		int ret = objLDTeamService.insertNewTrainingMemberService(req.getParameter("ldtmName"), req.getParameter("ldtmLocation"), 
				req.getParameter("ldtmEmail"), req.getParameter("ldtmPhone"), req.getParameter("techSpecialty"));
		if(ret>0)
		{
			req.getSession().putValue("loginMessage", " ");
			return new ModelAndView("redirect:/showLDTrainingMember");
		}
		else
		{
			String message = req.getParameter("ldtmEmail") + " Already Exists";
			req.getSession().putValue("loginMessage", message);
			return new ModelAndView("insertLDTrainingMembers");
		}
	}
	
	
	@RequestMapping(value="/deleteLDTrainingMember/{ldtmId}")
	public ModelAndView deleteLDTeamMembersService(@PathVariable Integer ldtmId)
	{
		LDTeamServices objLDTeamService = new LDTeamServices();
		int ret = objLDTeamService.deleteTrainingMemberService(ldtmId);
		if(ret>0)
		{
			return new ModelAndView("redirect:/showLDTrainingMember");
		}
		return new ModelAndView("welcome");
	}
	
	
	@RequestMapping(value="/saveEditLDTMember")
	public ModelAndView editLDTMemberService(@ModelAttribute("member") LDTeam member)
	{
		LDTeamServices objLDTeamService = new LDTeamServices();
		// Call Update
		objLDTeamService.updateTrainingMemberService(member.getLdtmId(), member.getLdtmName(), member.getLdtmLocation(), member.getLdtmEmail(),  member.getLdtmPhone(),  member.getTechSpecialty());
		return new ModelAndView("redirect:/showLDTrainingMember");
	}
	
	
	@RequestMapping(value="/editLDTMember/{ldtmId}")
	public ModelAndView editLDTeamService(@PathVariable Integer ldtmId)
	{
		LDTeamServices objLDTeamService = new LDTeamServices();
		LDTeam member = objLDTeamService.getTrainingMember(ldtmId); 
		return new ModelAndView("editLDTrainingMembers", "command", member);
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
	
	@RequestMapping(value="/delete/{trfID}")
	public ModelAndView deleterow(@PathVariable Integer trfID){
		NewRequestTableServices obj = new NewRequestTableServices();
		int ret = obj.deletebutton(trfID);
		if(ret>0)
			return new ModelAndView("redirect:/AdminDashboard");
		return new ModelAndView("error");
	}
	
	@RequestMapping(value="/deleteMiddle/{trfid}")
	public ModelAndView deleteMiddle(@PathVariable Integer trfid)
	{
		System.out.println("In the  delete function");
		FirstTableService obj = new FirstTableService();
		int ret = obj.deletebutton(trfid);
		if(ret>0)
			return new ModelAndView("redirect:/AdminDashboard");
		  
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
	
	@RequestMapping(value="/viewFirstTable")
	public String showFirstTable(ModelMap firstTableMap, @PathVariable Object emailID){
		
		FirstTableService objFirstTable = new FirstTableService();
		String emailID2 = emailID.toString();
		List<FirstTable> firsttable = objFirstTable.getFirstTableData(emailID2);
		firstTableMap.addAttribute("firstTableValues", firsttable);
		
		FirstTableService objSecondTable = new FirstTableService();
		List<SecondTable> secondTable = objSecondTable.getSecondTableData();
		firstTableMap.addAttribute("secondTableValues", secondTable);
		
		FirstTableService objThirdTable = new FirstTableService();
		List<SecondTable> thirdTable = objThirdTable.getThirdTableData();
		firstTableMap.addAttribute("thirdTableValues", thirdTable);
		
		return "firstTable";
	}
	
	
}