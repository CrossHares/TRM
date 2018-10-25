package queries;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import trf.dao.MyJDBCTemplate;

public class RetrieveSpocEmailsServices {
	
JdbcTemplate temp = MyJDBCTemplate.getJdbcTemplate();
	
	public List<RetrieveSpocEmails> readRetrieveSpocEmails()
	{
		List<RetrieveSpocEmails> list = temp.query("select * from RETRIEVE_SPOC_EMAILS", new RetrieveSpocEmailsMapper());
		return list;
	}

}
