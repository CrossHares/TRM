package ipt.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.syntelorg.trmmailapi.MailSender;


public class InProgressTrainingMapper implements RowMapper<InProgressTraining>{

	@Override
	public InProgressTraining mapRow(ResultSet result, int arg1) throws SQLException 
	{
		InProgressTraining objIPT = new InProgressTraining();
		objIPT.setIptID(result.getInt(1));
		objIPT.setVerID(result.getInt(2));
		objIPT.setVenID(result.getInt(3));
		objIPT.setTtID(result.getInt(4));
		objIPT.setTrfID(result.getInt(5));
		objIPT.setOsID(result.getInt(6));
		objIPT.setIptProjectID(result.getString(7));
		objIPT.setIptTechnology(result.getString(8));
		objIPT.setIptTrainingObj(result.getString(9));
		objIPT.setIptDateReq(result.getString(10));
		objIPT.setIptProposedStartDate(result.getString(11));
		objIPT.setIptProposedEndDate(result.getString(12));
		objIPT.setIptProjTrainSpoc(result.getString(13));
		objIPT.setIptAppxEmployees(result.getInt(14));
		objIPT.setIptRequestorID(result.getString(15));
		objIPT.setIptApprovedFileLoc(result.getString(16));
		objIPT.setIptTrainingSource(result.getInt(17));
		objIPT.setIptProposedLoc(result.getString(18));
		objIPT.setIptProposedStartTime(result.getString(19));
		objIPT.setIptProposedEndTime(result.getString(20));
		
		return objIPT;
	}
	
	

}
