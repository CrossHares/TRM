package queries;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class RetrieveExecEmailsMapper implements RowMapper<RetrieveExecEmails>{

	@Override
	public RetrieveExecEmails mapRow(ResultSet results, int arg1) throws SQLException {
		RetrieveExecEmails objRetExecEmails = new RetrieveExecEmails();
		objRetExecEmails.setLdUserName(results.getString(1));
		objRetExecEmails.setLdUserName(results.getString(2));
		objRetExecEmails.setUrName(results.getString(3));
		
		return objRetExecEmails;
	}

}
