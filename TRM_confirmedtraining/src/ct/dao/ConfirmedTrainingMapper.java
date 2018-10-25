package ct.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class ConfirmedTrainingMapper implements RowMapper<ConfirmedTraining>{

	@Override
	public ConfirmedTraining mapRow(ResultSet result, int arg1) throws SQLException 
	{
		ConfirmedTraining objCT = new ConfirmedTraining();

		objCT.setTRF_ID(result.getInt(1));
		objCT.setVER_ID(result.getInt(2));
		objCT.setVEN_ID(result.getInt(3));
		objCT.setTT_ID(result.getInt(4));
		objCT.setOS_ID(result.getInt(5));
		objCT.setCT_PROJECT_ID(result.getString(6));
		objCT.setCT_TECHNOLOGY(result.getString(7));
		objCT.setCT_TRAINING_OBJECTIVES(result.getString(8));
		objCT.setCT_DATE_REQUESTED(result.getString(9));
		objCT.setCT_PROPOSED_START_DATE(result.getString(10));
		objCT.setCT_PROPOSED_END_DATE(result.getString(11));
		objCT.setCT_PROPOSED_START_TIME(result.getString(12));
		objCT.setCT_PROPOSED_END_TIME(result.getString(13));
		objCT.setCT_PROPOSED_LOCATION(result.getString(14));
		objCT.setCT_ROOM_NO(result.getString(15));
		objCT.setLDTM_ID(result.getInt(16));
		objCT.setCT_PROJECT_TRAINING_SPOC(result.getString(17));
		objCT.setCT_APPROX_NO_EMPLOYEES(result.getInt(18));
		objCT.setCT_REQUESTOR_EMPLOYEE_ID(result.getString(19));
		objCT.setCT_APPROVED_FILE_LOCATION(result.getString(20));
		objCT.setCT_TRAINING_SOURCE(result.getInt(21));
		objCT.setCT_NOMINATION_FILE(result.getString(22));
		objCT.setCT_ASSIGNED_EXEC(result.getString(23));
		objCT.setCT_HIDE_STATUS(result.getInt(24));
		objCT.setCT_BUTTON_COUNT(result.getInt(25));
		
		return objCT;
	}

}
