package queries;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import trf.dao.MyJDBCTemplate;


public class VerticalSpocsServices {

	JdbcTemplate temp = MyJDBCTemplate.getJdbcTemplate();
	
	//Create - irrelevant for this query, since we are selecting from views; need to create via the base tables
	
	
	//Read
	public List<VerticalSpocs> readVerticalSpocs(int verID)
	{
		List<VerticalSpocs> list = temp.query("select * from VERTICAL_SPOCS where ", new Object[]{verID}, new VerticalSpocsMapper());
		return list;
	}
		
	//Update - irrelevant for this query, since we are selecting from views; need to update via the base tables
	
	
	//Delete - irrelevant for this query, since we are selecting from views; need to delete via the base tables
	
}
