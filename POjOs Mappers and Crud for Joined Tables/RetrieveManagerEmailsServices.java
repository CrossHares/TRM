package queries;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import trf.dao.MyJDBCTemplate;

public class RetrieveManagerEmailsServices {
JdbcTemplate temp = MyJDBCTemplate.getJdbcTemplate();
	
	public List<RetrieveManagerEmails> readRetrieveSpocEmails()
	{
		List<RetrieveManagerEmails> list = temp.query("select * from RETRIEVE_MANAGER_EMAILS", new RetrieveManagerEmailsMapper());
		return list;
	}

}
