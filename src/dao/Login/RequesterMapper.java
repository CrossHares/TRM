package dao.Login;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class RequesterMapper implements RowMapper<Requesterdao> {

	@Override
	public Requesterdao mapRow(ResultSet res, int arg) throws SQLException {
		
		Requesterdao obj = new Requesterdao();
		obj.setRequester_id(res.getString(1));
		obj.setRequester_name(res.getString(2));
		obj.setRequester_email(res.getString(3));
		obj.setRequester_vertical(res.getString(4));
		
		return obj;
	}
	
	

}
