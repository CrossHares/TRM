package queries;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class TRFperSpocMapper implements RowMapper<TRFperSpoc>{

	@Override
	public TRFperSpoc mapRow(ResultSet result, int arg1) throws SQLException {
		TRFperSpoc objTrfPerSpoc = new TRFperSpoc();
		objTrfPerSpoc.setTrfID(result.getInt(1));
		objTrfPerSpoc.setLdUserEmail(result.getString(2));
		objTrfPerSpoc.setVerID(result.getInt(3));
		
		return objTrfPerSpoc;
	}
	
	
	

}
