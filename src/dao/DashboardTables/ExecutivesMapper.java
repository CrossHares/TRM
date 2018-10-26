package dao.DashboardTables;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class ExecutivesMapper implements RowMapper<Executives> {

	@Override
	public Executives mapRow(ResultSet result, int arg1) throws SQLException {
		Executives objRF = new Executives();
		
		objRF.setLD_USER_NAME(result.getString(1));
		
		return objRF;
	}

}
