package ipt.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;



public class InProgressTrainingMapper implements RowMapper<InProgressTraining>{

	@Override
	public InProgressTraining mapRow(ResultSet result, int arg1) throws SQLException 
	{
		InProgressTraining objIPT = new InProgressTraining();
		objIPT.setTrfID(result.getInt(1));
		objIPT.setVerID(result.getInt(2));
		objIPT.setVenID(result.getInt(3));
		objIPT.setTtID(result.getInt(4));
		objIPT.setOsID(result.getInt(5));
		objIPT.setIptProjectID(result.getString(6));
		objIPT.setIptTechnology(result.getString(7));
		objIPT.setIptTrainingObj(result.getString(8));
		objIPT.setIptDateReq(result.getString(9));
		objIPT.setIptProposedStartDate(result.getString(10));
		objIPT.setIptProposedEndDate(result.getString(11));
		objIPT.setIptProposedStartTime(result.getString(12));
		objIPT.setIptProposedEndTime(result.getString(13));
		objIPT.setIptProposedLoc(result.getString(14));
		objIPT.setIptRoomNo(result.getString(15));
		objIPT.setLDTM_ID(result.getInt(16));
		objIPT.setIptProjTrainSpoc(result.getString(17));
		objIPT.setIptAppxEmployees(result.getInt(18));
		objIPT.setIptRequestorID(result.getString(19));
		objIPT.setIptApprovedFileLoc(result.getString(20));
		objIPT.setIptTrainingSource(result.getInt(21));
		objIPT.setIptNomFile(result.getString(22));
		objIPT.setIptAssignedExec(result.getString(23));
		objIPT.setIptHideStatus(result.getInt(24));
		objIPT.setIptButtonCount(result.getInt(25));
		

		
		return objIPT;
	}
	
	

}
