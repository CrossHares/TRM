package dao.ctraining;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import dao.ctraining.ConfirmedTraining;


public class ConfirmedTrainingMapper implements RowMapper<ConfirmedTraining>{

	@Override
	public ConfirmedTraining mapRow(ResultSet result, int arg1) throws SQLException {

		ConfirmedTraining obj = new ConfirmedTraining();
		obj.setCitid(result.getInt(1));
		obj.setTstatis_id(result.getInt(2));
		obj.setTt_id(result.getInt(3));
		obj.setLd_user_email(result.getString(4));
		obj.setTrf_ids(result.getString(5));
		obj.setCt_start_date(result.getString(6));
		obj.setCt_end_date(result.getString(7));
		obj.setCt_start_time(result.getString(8));
		obj.setCt_end_time(result.getString(9));
		obj.setCt_location(result.getString(10));
		obj.setCt_nomination_file(result.getString(11));
		return obj;
	}
}
