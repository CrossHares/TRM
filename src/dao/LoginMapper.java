package dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class LoginMapper implements RowMapper<Logindao> {

	@Override
	public Logindao mapRow(ResultSet res, int arg) throws SQLException {
		
		Logindao obj = new Logindao();
		obj.setUserName(res.getString(1));
		obj.setUserPassword(res.getString(2));
		
		return obj;
		
	}
	
	

}
