package dao;

import org.springframework.jdbc.core.JdbcTemplate;
import java.util.List;

public class LoginServices {
	
	public static boolean isUserValid(String user, String pass)
	{
		JdbcTemplate temp = MyJDBCTemplate.getJdbcTemplate();
		
		List<Logindao> userList =  temp.query("select * from ld_team where ld_user_name = ? and ld_user_password = ?",
				new Object[]{user,pass},
				new LoginMapper());
		
		if(userList.size() > 0) {
			return true;
		}
		
		return false;
	}

}
