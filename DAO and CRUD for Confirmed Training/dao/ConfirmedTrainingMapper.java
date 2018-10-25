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
		objCT.setVerID(result.getInt(2));
		objCT.setVenID(result.getInt(3));
		objCT.setTtID(result.getInt(4));
		objCT.setTrfID(result.getInt(5));
		objCT.setOsID(result.getInt(6));
		objCT.setIptID(result.getInt(7));
		objCT.setCtProjectID(result.getString(8));
		objCT.setCtTechnology(result.getString(9));
		objCT.setCtTrainingObj(result.getString(10));
		objCT.setCtDateReq(result.getString(11));
		objCT.setCtProposedStartDate(result.getString(12));
		objCT.setCtProposedEndDate(result.getString(13));
		objCT.setCtProjTrainSpoc(result.getString(14));
		objCT.setCtAppxEmployees(result.getInt(15));
		objCT.setCtRequestorID(result.getString(16));
		objCT.setCtApprovedFileLoc(result.getString(17));
		objCT.setCtTrainingSource(result.getInt(18));
		objCT.setCtProposedLoc(result.getString(19));
		objCT.setCtProposedStartTime(result.getString(20));
		objCT.setCtProposedEndTime(result.getString(21));
		
		return objCT;
	}

}
