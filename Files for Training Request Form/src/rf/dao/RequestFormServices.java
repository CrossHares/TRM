package rf.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

public class RequestFormServices {
	public List<RequestForm> read() {
		JdbcTemplate temp = MyJDBCTemplate.getJdbcTemplate();
		List<RequestForm> list = temp.query("select * from TRAINING_REQUEST_FORM", new RequestFormMapper());
		return list;
	}
}
