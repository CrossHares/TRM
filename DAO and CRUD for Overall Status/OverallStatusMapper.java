package overallstatus.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class OverallStatusMapper implements RowMapper<OverallStatus>{

	@Override
	public OverallStatus mapRow(ResultSet results, int arg1) throws SQLException {
		OverallStatus objOS = new OverallStatus();
		objOS.setOsID(results.getInt(1));
		objOS.setOsName(results.getString(2));
		
		return objOS;
	}

}
