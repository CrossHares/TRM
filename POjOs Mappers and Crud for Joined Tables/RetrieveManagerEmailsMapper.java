package queries;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class RetrieveManagerEmailsMapper implements RowMapper<RetrieveManagerEmails>{

	@Override
	public RetrieveManagerEmails mapRow(ResultSet results, int arg1) throws SQLException {
		RetrieveManagerEmails objRetManEmails = new RetrieveManagerEmails();
		objRetManEmails.setLdUserName(results.getString(1));
		objRetManEmails.setLdUserName(results.getString(2));
		objRetManEmails.setUrName(results.getString(3));
		
		return objRetManEmails;
	}

}
