package queries;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import trf.dao.MyJDBCTemplate;

public class TRFperSpocServices {
	
	JdbcTemplate temp = MyJDBCTemplate.getJdbcTemplate();
	
	public List<TRFperSpoc> readTRFperSpoc()
	{
		List<TRFperSpoc> list = temp.query("select * from TRF_PER_SPOC", new TRFperSpocMapper());
		return list;
	}
	

}
