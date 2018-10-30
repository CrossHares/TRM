package dao.ConfirmedTraining;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class ConfirmedTrainingMapper implements RowMapper<ConfirmedTraining> {

	public ConfirmedTraining mapRow(ResultSet arg0, int arg1) throws SQLException {
		
		ConfirmedTraining ctObj = new ConfirmedTraining();
		
		ctObj.setTrf_id(arg0.getInt(1));
		ctObj.setVer_id(arg0.getInt(2));
		ctObj.setVen_id(arg0.getInt(3));
		ctObj.setTt_id(arg0.getInt(4));
		ctObj.setOs_id(arg0.getInt(5));
		ctObj.setCt_project_id(arg0.getString(6));
		ctObj.setCt_technology(arg0.getString(7));
		ctObj.setCt_training_objectives(arg0.getString(8));
		ctObj.setCt_date_requested(arg0.getDate(9).toString());
		try{
			ctObj.setCt_proposed_start_date(arg0.getDate(10).toString());
		}
		catch(NullPointerException e)
		{
			ctObj.setCt_proposed_start_date(" ");
		}
		ctObj.setCt_proposed_end_date(arg0.getDate(11).toString());
		ctObj.setCt_proposed_start_time(arg0.getString(12));
		ctObj.setCt_proposed_end_time(arg0.getString(13));
		ctObj.setCt_proposed_location(arg0.getString(14));
		ctObj.setCt_room_no(arg0.getString(15));
		ctObj.setLdtm_id(arg0.getInt(16));
		ctObj.setCt_project_training_spoc(arg0.getString(17));
		ctObj.setCt_approx_no_employees(arg0.getInt(18));
		ctObj.setCt_requestor_employee_id(arg0.getString(19));
		ctObj.setCt_approved_file_location(arg0.getString(20));
		ctObj.setCt_training_source(arg0.getInt(21));
		ctObj.setCt_nomination_file(arg0.getString(22));
		ctObj.setCt_assigned_exec(arg0.getString(23));
		ctObj.setCt_hide_status(arg0.getInt(24));
		ctObj.setCt_button_count(arg0.getInt(25));

		
		return ctObj;
	}
	
}
