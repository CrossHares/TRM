package trainingsource;

import org.springframework.jdbc.core.JdbcTemplate;

import ct.dao.MyJDBCTemplate;

public class TrainingSourceServices {

	public int getIDfromSource(String sourceName){
		JdbcTemplate temp = MyJDBCTemplate.getJdbcTemplate();
		int trainingsourceid = temp.queryForInt("select ts_id from training_source where ts_desc=?",new Object[]{sourceName});
		return trainingsourceid;
	}
}
