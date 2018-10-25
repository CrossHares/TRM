package queries;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import trf.dao.MyJDBCTemplate;

public class RetrieveExecEmailsServices {

JdbcTemplate temp = MyJDBCTemplate.getJdbcTemplate();
	
	public List<RetrieveExecEmails> readRetrieveExecEmails()
	{
		List<RetrieveExecEmails> list = temp.query("select * from RETRIEVE_EXEC_EMAILS", new RetrieveExecEmailsMapper());
		return list;
	}
}
