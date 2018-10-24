package userrole;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class UserRoleMapper implements RowMapper<UserRole>{

	@Override
	public UserRole mapRow(ResultSet result, int arg1) throws SQLException {
		UserRole objUR = new UserRole();
		objUR.setUrID(result.getInt(1));
		objUR.setUrName(result.getString(2));
		
		return objUR;
	}
	

}
