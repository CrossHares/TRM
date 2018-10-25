package queries;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class RetrieveSpocEmailsMapper implements RowMapper<RetrieveSpocEmails>{

	@Override
	public RetrieveSpocEmails mapRow(ResultSet results, int arg1) throws SQLException {
		RetrieveSpocEmails objRetSpocEmails = new RetrieveSpocEmails();
		objRetSpocEmails.setLdUserName(results.getString(1));
		objRetSpocEmails.setLdUserName(results.getString(2));
		objRetSpocEmails.setUrName(results.getString(3));
		
		return objRetSpocEmails;
	}
	
	

}
