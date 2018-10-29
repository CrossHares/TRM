package dao.Login;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class RoleMapper implements RowMapper<Roledao> {

	@Override
	public Roledao mapRow(ResultSet res, int arg) throws SQLException {
		
		Roledao obj = new Roledao();
		obj.setRole_name(res.getString(1));
		
		return obj;
	}

}
