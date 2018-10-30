package trainingsource;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class TrainingSourceMapper implements RowMapper<TrainingSource>{

	@Override
	public TrainingSource mapRow(ResultSet result, int arg1) throws SQLException {

		TrainingSource obj = new TrainingSource();
		obj.setTsid(result.getInt(1));
		obj.setTsdesc(result.getString(2));
		return obj;
	}

}
