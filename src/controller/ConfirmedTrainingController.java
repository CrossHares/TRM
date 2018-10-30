package controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import pkg.CalendarInfo;
import pkg.ReadExcel;
import pkg.TRMEmailAPI;
import pkg.TrainingNomineeRequestForm;

import java.util.*;

import jdk.management.resource.internal.inst.ThreadRMHooks;
import dao.ConfirmedTraining.ConfirmedTraining;
import dao.ConfirmedTraining.ConfirmedTrainingServices;

@Controller
public class ConfirmedTrainingController
{
	String saving;
	String html1 = "<html><body><div>Hi All,<br><br>The training for the " ;
	String html2 = " is launching on ";
	String html3 = " at ";
	String html4 = ". Please be available for the trainings.<br><br>This is to confirm your nomination for the session on <strong><u>";
	String html5 = ".</u></strong> Details of the session as below:<br><br><strong><u>Audio Bridge Details:</u></strong><br><br>Participants from Syntel office (From Nortel Extensions only) dail: 7600#<br><br>US / International Participants please dial: +1-919-948-2233 OR +1-919-719-5708 - at 		the prompt please enter the pass code.<br><br>The Pass Code is <strong><u>";
	String html6 = "</u></strong><br><br><table style: border='2px;'><tr><td>Conference Phone Numbers:</td><td>7614, CUG, Internal users in Syntel office dial 7600<br>External Users dial,<br>US : +1-919-948-2233 or +1-919-719-5708<br>UK : +44-141-240-1285<br>To extend the bridge, call CAC team on: 022-297225 or +1-919-233-6350</td></tr></table><br><br><strong><u>WebEx Details:</u></strong><br><br><strong>Meeting number: ";
	String html7 = "</strong><br><br><strong>Meeting password: ";
	String html8 = "</strong><br><br><br>Please Note:<br>a.  You are requested to accept the meeting invite as a confirmation of you participation<br>b.  Please login at least 10 minutes prior to the scheduled start of the program - We appreciate your punctuality<br>c.  In case you are unable to attend the session, request you to send us mail mentioning the reason for your absence with an approval from your reporting manager.<br><br>This mail has been send behalf of Trainingdesk_onsite, please write to Trainingdesk_Onsite@syntelinc.com<br><br><br><br>Team - Training &amp; Developmente-mail: trainingdesk_onsite@syntelinc.com</div></body></html>";
	
	String html9 = "<html><body><div>Hi All,<br><br>The training for the ";
	String html10 =  " is launching on ";
	String html11 = " at ";
	String html12 = ". Please be available for the trainings.<br><br>This is to confirm your nomination for the session on <strong><u>";
	String html13 =  ".</u></strong> Details of the session as below:<br><br><table style: border='2px;'><tr><th>Training Details:</th></tr><tr><td>Location: ";
	String html14 = "<br>Address: ";
	String html15 = "<br>Contact Person: ";
	String html16 = "<br>Time: ";
	String html17 = "<br>Date: ";
	String html18 =   "<td></tr></table><br><br>Please Note:<br>a.  You are requested to accept the meeting invite as a confirmation of you participation<br>b.  Please arrive at least 10 minutes prior to the scheduled start of the program - We appreciate your punctuality<br>c.  In case you are unable to attend the session, request you to send us mail mentioning the reason for your absence with an approval from your reporting manager.<br><br>This mail has been send behalf of Trainingdesk_onsite, please write to Trainingdesk_Onsite@syntelinc.com<br><br><br><br>Team - Training &amp; Developmente-mail: trainingdesk_onsite@syntelinc.com</div></body></html>";
	
	String subject = "Training Details";
	String passcode;
	String meetingno;
	String meetingpass;
	String trainingName;
	String startDate;
	String startTime;
	String endTime;
	String address;
	String location;
	String allocatedexec;
	
//	@RequestMapping(value="/")
//	public String showAdminDashboard()
//	{
//		return "AdminDashboard"; //returning view name
//	}
	
	@RequestMapping(value="/ExecDashboard")
	public String showExecDashboard(ModelMap trainingMap)
	{
		ConfirmedTrainingServices CTServicesObj = new ConfirmedTrainingServices();
		List<ConfirmedTraining>trainings = CTServicesObj.getAllTrainingService();
		trainingMap.addAttribute("allTrainings", trainings);
		return "ExecDashboard";
	}
	
	@RequestMapping(value="/ResourceAllocation")
	public String showResourceAllocation()
	{
		return "ResourceAllocation";
	}
	
	@RequestMapping(value="/edit_ct/{trf_id}")
	public ModelAndView editCT(@PathVariable Integer trf_id)
	{
		ConfirmedTrainingServices objctservice = new ConfirmedTrainingServices();
		ConfirmedTraining confirmedTraining = objctservice.getTraining(trf_id);
		return new ModelAndView("ResourceAllocation", "command", confirmedTraining);
	}
	
	@RequestMapping(value="/showTrainingInfo/{trf_id}")
	public ModelAndView showTrainingInfo(@PathVariable Integer trf_id)
	{
		ConfirmedTrainingServices objctservice = new ConfirmedTrainingServices();
		ConfirmedTraining confirmedTraining = objctservice.getTraining(trf_id);
		return new ModelAndView("ShowTrainingInfo", "command", confirmedTraining);
	}
	
	@RequestMapping(value="/editallocationresources")
	public ModelAndView updateConfirmedTrainingService(@ModelAttribute("confirmedTraining") ConfirmedTraining confirmedTraining)
	{
		ConfirmedTrainingServices objctservice = new ConfirmedTrainingServices();
		objctservice.updateAllocationResources(confirmedTraining.getTrf_id(), confirmedTraining.getCt_room_no(), confirmedTraining.getCt_proposed_location());
		return new ModelAndView("redirect:/ExecDashboard");
	}
	
	@RequestMapping(value="/submitallocationresources")
	public ModelAndView submitConfirmedTrainingService(@ModelAttribute("confirmedTraining") ConfirmedTraining confirmedTraining)
	{
		ConfirmedTrainingServices objctservice = new ConfirmedTrainingServices();
		objctservice.submitAllocationResources(confirmedTraining.getTrf_id(), confirmedTraining.getCt_room_no(), confirmedTraining.getCt_proposed_location());
		return new ModelAndView("redirect:/ExecDashboard");
	}
	
	@RequestMapping(value="/send_email_webex/{trf_id}")
	public ModelAndView sendEmailWebex(@PathVariable Integer trf_id)
	{
		ConfirmedTrainingServices objctservice = new ConfirmedTrainingServices();
		ConfirmedTraining confirmedTraining = objctservice.getTraining(trf_id);
		return new ModelAndView("ExecEmailSend", "command", confirmedTraining);
	}
	
	@RequestMapping(value="/send_email_cr/{trf_id}")
	public ModelAndView sendEmailClassroom(@PathVariable Integer trf_id)
	{
		ConfirmedTrainingServices objctservice = new ConfirmedTrainingServices();
		ConfirmedTraining confirmedTraining = objctservice.getTraining(trf_id);
		return new ModelAndView("OnSiteTrainingForm", "command", confirmedTraining);
	}
	
	@RequestMapping(value="/sendEmail")
	public ModelAndView sendEmailService(@ModelAttribute("confirmedTraining") ConfirmedTraining confirmedTraining, 
			HttpServletRequest req, HttpServletResponse res) throws Exception
	{
		ConfirmedTrainingServices objctservice = new ConfirmedTrainingServices();
		passcode = req.getParameter("passcode");
		meetingno = req.getParameter("meetingno");
		meetingpass = req.getParameter("meetingpass");
		trainingName = confirmedTraining.getCt_technology();
		startDate = confirmedTraining.getCt_proposed_start_date();
		startTime = confirmedTraining.getCt_proposed_start_time();
		endTime = confirmedTraining.getCt_proposed_end_time();
		location = "WEBEX";
		TrainingNomineeRequestForm emaillist = ReadExcel.ReadXslx("C:/Users/syntel/workspace/FTRM/WebContent/resources/Java-Nominiees.xlsx");
		TRMEmailAPI emailapi = new TRMEmailAPI();
		CalendarInfo newCal = new CalendarInfo(startDate, startTime, endTime, location, subject, trainingName);
		for(int i = 0; i < emaillist.getNominees().length; i++)
		{
			int sentemail = emailapi.send(emaillist.getNominees()[i].getEmail(), subject, html1+trainingName+html2+startDate+html3+startTime+html4+trainingName+html5+passcode+html6+meetingno+html7+meetingpass+html8, newCal);
			if(sentemail == 1)
			{
				System.out.println("Email Successfully Sent!");
				objctservice.sendEmail(confirmedTraining.getTrf_id());
			}
		}
		return new ModelAndView("redirect:/ExecDashboard");
	}
	
	@RequestMapping(value="/sendEmailCR")
	public ModelAndView sendOnSiteEmailService(@ModelAttribute("confirmedTraining") ConfirmedTraining confirmedTraining, 
			HttpServletRequest req, HttpServletResponse res) throws Exception
	{
		ConfirmedTrainingServices objctservice = new ConfirmedTrainingServices();
		address = req.getParameter("address");
		trainingName = confirmedTraining.getCt_technology();
		startDate = confirmedTraining.getCt_proposed_start_date();
		startTime = confirmedTraining.getCt_proposed_start_time();
		endTime = confirmedTraining.getCt_proposed_end_time();
		location = confirmedTraining.getCt_proposed_location();
		allocatedexec = confirmedTraining.getCt_assigned_exec();
		ReadExcel excelapi = new ReadExcel();
		TrainingNomineeRequestForm emaillist = excelapi.ReadXslx("C:/Users/syntel.PHX-E5440-5K7DP/Documents/Syntel/Project/EmailAPI/Java-Nominiees.xlsx");
		TRMEmailAPI emailapi = new TRMEmailAPI();
		CalendarInfo newCal = new CalendarInfo(startDate, startTime, endTime, location, subject, trainingName);
		for(int j = 0; j < emaillist.getNominees().length; j++)
		{
			int sentemail = emailapi.send(emaillist.getNominees()[j].getEmail(), subject, html9+trainingName+html10+startDate+html11+startTime+html12+trainingName+html13+location+html14+address+html15+allocatedexec+html16+startTime+html17+startDate+html18, newCal);
			if(sentemail == 1)
			{
				System.out.println("Email Successfully Sent!");
				objctservice.sendEmail(confirmedTraining.getTrf_id());
			}	
		}
		return new ModelAndView("redirect:/ExecDashboard");
	}
	
	@RequestMapping(value="/complete_training/{trf_id}")
	public ModelAndView completeTraining(@PathVariable Integer trf_id)
	{
		ConfirmedTrainingServices objctservice = new ConfirmedTrainingServices();
		ConfirmedTraining confirmedTraining = objctservice.getTraining(trf_id);
		return new ModelAndView("CompleteTrainingForm", "command", confirmedTraining);
	}
	
	@RequestMapping(value="/completeTraining")
	public ModelAndView completeTrainingService(@ModelAttribute("confirmedTraining") ConfirmedTraining confirmedTraining, 
												HttpServletRequest req, HttpServletResponse res)
	{
		try
		{
			String box1 = req.getParameter("firstcheckbox");
			String box2 = req.getParameter("secondcheckbox");
			String box3 = req.getParameter("thirdcheckbox");
			System.out.println(box1 + box2 + box3);
			if(box1.equals("1") && box2.equals("1") && box3.equals("1"))
			{
				//Email JAR Goes here
				ConfirmedTrainingServices objctservice = new ConfirmedTrainingServices();
				objctservice.completeTraining(confirmedTraining.getTrf_id());
				System.out.println(box1);
				System.out.println(box2);
				return new ModelAndView("redirect:/ExecDashboard");
			}
			else
			{
				return new ModelAndView("redirect:/complete_training/" + confirmedTraining.getTrf_id());
			}
		}
		catch (NullPointerException ne)
		{
			return new ModelAndView("redirect:/complete_training/" + confirmedTraining.getTrf_id());
		}
	}
	
}