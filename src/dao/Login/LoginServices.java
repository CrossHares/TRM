package dao.Login;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

public class LoginServices {

	public static Login isUserValid(String user, String pass)
	{
		JdbcTemplate temp = MyJDBCTemplate.getJdbcTemplate();
		
		List<Login> userList =  temp.query("select ld_user_name, ur_name from ld_team, user_role where ld_user_name = ? and ld_user_password = ? and ld_team.ur_id = user_role.ur_id",
				new Object[]{user,pass},
				new LoginMapper());
		
		if(userList.size() > 0) {
			return userList.get(0);
		}
		
		return null;
	}
	
	public Requesterdao isRequesterValid(String user, String pass)
	{
		JdbcTemplate temp = MyJDBCTemplate.getJdbcTemplate();
		
		List<Requesterdao> userList =  temp.query("select req_emp_id, req_name, req_email, req_ver from requestor where req_name = ? and reqr_password = ?",
				new Object[]{user,pass},
				new RequesterMapper());
		
		if(userList.size() > 0) {
			return userList.get(0);
		}
	
		
		return null;
	}
}
