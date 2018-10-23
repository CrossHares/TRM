package ipt.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import ct.dao.ConfirmedTraining;
import ct.dao.ConfirmedTrainingMapper;
import trf.dao.MyJDBCTemplate;

public class InProgressTrainingServices {
	
	JdbcTemplate temp = MyJDBCTemplate.getJdbcTemplate();
	
	//Create
	public int createNewIPT(int tsID, int ttID, String ldUserEmail, int verID, int trfID, String iptStartDate, String iptEndDate, 
			String iptStartTime, String iptEndTime, String iptTechnology, String iptTrainingObj, String iptLocation, String iptNomFile)
	{
		int ret = temp.update("insert into IN_PROGRESS_TRAINING values(gIPTNo.nextval,?,?,?,?,?,?,?,?,?,?,?,?,?)",
				new Object[]{tsID, ttID, ldUserEmail, verID, trfID, iptStartDate, iptEndDate, iptStartTime, iptEndTime, iptTechnology, iptTrainingObj,
						iptLocation, iptNomFile});
		return ret;
	}
	
	//Read
	public List<InProgressTraining> readIPT()
	{
		List<InProgressTraining> list = temp.query("select * from IN_PROGRESS_TRAINING", new InProgressTrainingMapper());
		return list;
	}
	
	//Update
	//Update won't allow the user to change the TRF_ID that is linked in order to maintain the data integrity
	public int updateIPT(int iptID, int tsID, int ttID, String ldUserEmail, int verID, String iptStartDate, String iptEndDate, 
			String iptStartTime, String iptEndTime, String iptTechnology, String iptTrainingObj, String iptLocation, String iptNomFile)
	{
		int ret = temp.update("update IN_PROGRESS_TRAINING set TSTATUS_ID=?, TT_ID=?, LD_USER_EMAIL=?, VER_ID=?, IPT_START_DATE=?, IPT_END_DATE=?,IPT_START_TIME=?,IPT_END_TIME=?, IPT_TECHNOLOGY=?, IPT_TRAINING_OBJECTIVES=?, IPT_LOCATION=?, IPT_NOMINATION_FILE=?  where IPT_ID=?",
				new Object[]{tsID, ttID, ldUserEmail, verID, iptStartDate, iptEndDate, iptStartTime, iptEndTime, iptTechnology, iptTrainingObj, iptLocation, iptNomFile});
		return ret;
	}
	
	//Delete
	public int deleteIPT(int iptID)
	{
		int ret =  temp.update("delete from IN_PROGRESS_TRAINING where IPT_ID=?",
				new Object[]{iptID});
		return ret;
	}
	
	public static void main(String args[])
	{
		//InProgressTrainingServices iptSvcs = new InProgressTrainingServices();
		//System.out.println(iptSvcs.readIPT().size());
		//iptSvcs.createNewIPT(4, 1, "CLINTON_EXODIA@SYNTELINC.COM", 5, 11, "21-FEB-18", "15-OCT-19", "0900", "1700","C SHARP", "OOP CONCEPTS", "MEMPHIS, TENNESSEE", "T:/TRAINIEES/3D_MODELING_TRAINIESS.DOCX");
		//System.out.println(iptSvcs.readIPT().size());
		//iptSvcs.deleteIPT(12);
		//System.out.println(iptSvcs.readIPT().size());
	
	}
	

}
