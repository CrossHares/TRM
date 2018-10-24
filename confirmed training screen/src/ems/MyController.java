package ems;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import dao.ems.Employee;
import dao.ems.EmployeeServices;
import dao.ld_team.Ld_Team;
import dao.ld_team.Ld_Team_Services;
import dao.training_status.Training_Status;
import dao.training_status.Training_Status_Services;
import dao.training_type.Training_Type;
import dao.training_type.Training_Type_Services;
import dao.user_role.User_Role;
import dao.user_role.User_Role_Services;
import dao.vertical_type.Vertical_Type;
import dao.vertical_type.Vertical_Type_Services;

@Controller
public class MyController {
	//http://localhost:8080/ABC/mahesh
	
	@RequestMapping(value="/")
	public String welcomeService() {
		return "welcome"; //returning view name
	}
	
	@RequestMapping(value="/showAll")
	public String showAllEmployeeService(ModelMap employeemap) {
		EmployeeServices objEmployeeService = new EmployeeServices();
		List<Employee> listofEmployees = objEmployeeService.showAllEmployeeService();
		employeemap.addAttribute("mango", listofEmployees);
		return "showAll"; //view name
	}
	
	@RequestMapping(value="/readUser_Role")
	public String readUser_Role(ModelMap user_role_map) {
		User_Role_Services objUserRoleService = new User_Role_Services();
		List<User_Role> listofUserRoles = objUserRoleService.read();
		user_role_map.addAttribute("user_role_att", listofUserRoles);
		return "user_role";
	}
	
	@RequestMapping(value="/readTraining_Type")
	public String readTraining_Type(ModelMap training_type_map) {
		Training_Type_Services objTrainingTypeService = new Training_Type_Services();
		List<Training_Type> listofTrainingTypes = objTrainingTypeService.read();
		training_type_map.addAttribute("training_type_att", listofTrainingTypes);
		return "training_type";
	}
	
	@RequestMapping(value="/readTraining_Status")
	public String readTraining_Status(ModelMap training_status_map) {
		Training_Status_Services objTrainingStatusService = new Training_Status_Services();
		List<Training_Status> listofTrainingStatuses = objTrainingStatusService.read();
		training_status_map.addAttribute("training_status_att", listofTrainingStatuses);
		return "training_status";
	}
	
	@RequestMapping(value="/readLd_Team")
	public String readLd_Team(ModelMap ld_team_map) {
		Ld_Team_Services objLdTeamService = new Ld_Team_Services();
		List<Ld_Team> listofLdTeams = objLdTeamService.read();
		ld_team_map.addAttribute("ld_team_att", listofLdTeams);
		return "ld_team";
	}
	
	@RequestMapping(value="/readVertical_Type")
	public String readVertical_Type(ModelMap vertical_type_map) {
		Vertical_Type_Services objVerticalTypeService = new Vertical_Type_Services();
		List<Vertical_Type> listofVerticalTypes = objVerticalTypeService.read();
		vertical_type_map.addAttribute("vertical_type_att", listofVerticalTypes);
		return "vertical_type";
	}
}
