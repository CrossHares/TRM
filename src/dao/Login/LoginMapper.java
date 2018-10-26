package dao.Login;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class LoginMapper implements RowMapper<Login> {

	@Override
	public Login mapRow(ResultSet res, int arg1) throws SQLException {
		Login obj = new Login();
		obj.setUserName(res.getString(1));
		obj.setRole_name(res.getString(2));
		
		return obj;
	}

}
