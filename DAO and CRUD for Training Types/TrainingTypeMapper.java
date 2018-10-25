package trainingtype.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class TrainingTypeMapper implements RowMapper<TrainingType>{

	@Override
	public TrainingType mapRow(ResultSet results, int arg1) throws SQLException {
		TrainingType tt = new TrainingType();
		tt.setTtID(results.getInt(1));
		tt.setTtDesc(results.getString(2));
		
		return tt;
	}

}
