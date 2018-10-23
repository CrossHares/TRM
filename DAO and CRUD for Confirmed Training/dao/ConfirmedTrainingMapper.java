package ct.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class ConfirmedTrainingMapper implements RowMapper<ConfirmedTraining>{

	@Override
	public ConfirmedTraining mapRow(ResultSet result, int arg1) throws SQLException 
	{
		ConfirmedTraining objCT = new ConfirmedTraining();
		objCT.setCtID(result.getInt(1));
		objCT.setTsID(result.getInt(2));
		objCT.setTtID(result.getInt(3));
		objCT.setLdUserEmail(result.getString(4));
		objCT.setVerID(result.getInt(5));
		objCT.setTrfIDs(result.getString(6));
		objCT.setCtStartDate(result.getString(7));
		objCT.setCtEndDate(result.getString(8));
		objCT.setCtStartTime(result.getString(9));
		objCT.setCtEndTime(result.getString(10));
		objCT.setCtTechnology(result.getString(11));
		objCT.setCtTrainingObj(result.getString(12));
		objCT.setCtLocation(result.getString(13));
		objCT.setCtNomFile(result.getString(14));
		
		return objCT;
	}

}
