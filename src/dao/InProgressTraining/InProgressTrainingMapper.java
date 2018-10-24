package dao.InProgressTraining;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;


public class InProgressTrainingMapper implements RowMapper<InProgressTraining>{

	@Override
	public InProgressTraining mapRow(ResultSet result, int arg1) throws SQLException 
	{
		InProgressTraining objIPT = new InProgressTraining();
		objIPT.setIptID(result.getInt(1));
		objIPT.setTsID(result.getInt(2));
		objIPT.setTtID(result.getInt(3));
		objIPT.setLdUserEmail(result.getString(4));
		objIPT.setVerID(result.getInt(5));
		objIPT.setTrfID(result.getInt(6));
		objIPT.setIptStartDate(result.getString(7));
		objIPT.setIptEndDate(result.getString(8));
		objIPT.setIptStartTime(result.getString(9));
		objIPT.setIptEndTime(result.getString(10));
		objIPT.setIptTechnology(result.getString(11));
		objIPT.setIptTrainingObj(result.getString(12));
		objIPT.setIptLocation(result.getString(13));
		objIPT.setIptNomFile(result.getString(14));
		
		return objIPT;
	}
	

}
