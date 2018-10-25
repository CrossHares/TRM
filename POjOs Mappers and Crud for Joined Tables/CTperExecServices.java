package queries;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import trf.dao.MyJDBCTemplate;

public class CTperExecServices {
	
	JdbcTemplate temp = MyJDBCTemplate.getJdbcTemplate();
	
	public List<CTperExec> readCTperExec()
	{
		List<CTperExec> list = temp.query("select * from CT_PER_EXEC", new CTperExecMapper());
		return list;
	}

}
