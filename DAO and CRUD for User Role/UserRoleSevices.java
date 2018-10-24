package userrole;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import ipt.dao.InProgressTraining;
import ipt.dao.InProgressTrainingMapper;
import trf.dao.MyJDBCTemplate;

public class UserRoleSevices {

	JdbcTemplate temp = MyJDBCTemplate.getJdbcTemplate();
	
	//Create
	public int createUserRole(int urID, String urName)
	{
		int ret = temp.update("insert into USER_ROLE values(?,?)",
				new Object[]{urID, urName});
		return ret;
	}
	
	//Read
	public List<UserRole> readUserRole()
	{
		List<UserRole> list = temp.query("select * from USER_ROLE", new UserRoleMapper());
		return list;
	}
	
	
	//Update
	public int updateUserRole(int urID, String urName)
	{
		int ret = temp.update("update USER_ROLE set UR_NAME=? where UR_ID=?",
				new Object[]{urName, urID});
		return ret;
	}
	
	//Delete
	public int deleteUserRole(int urID)
	{
		int ret = temp.update("delete from USER_ROLE where UR_ID=?",
				new Object[]{urID});
		return ret;
	}
	
}
