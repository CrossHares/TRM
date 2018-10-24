package dao.InProgressTraining;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

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
	
	//What follows is additional update functions, designed to update one attribute at a time.
	
	//Update tsID
	public int updateIPTtsID(int iptID, int tsID)
	{
		int ret = temp.update("update IN_PROGRESS_TRAINING set TSTATUS_ID=? where IPT_ID=?",
				new Object[]{tsID, iptID});
		return ret;
	}
	
	//Update ttID
		public int updateIPTttID(int iptID, int ttID)
		{
			int ret = temp.update("update IN_PROGRESS_TRAINING set TT_ID=? where IPT_ID=?",
					new Object[]{ttID, iptID});
			return ret;
		}

	//Update ldUserEmail
		public int updateIPTldUserEmail(int iptID, String ldUserEmail)
		{
			int ret = temp.update("update IN_PROGRESS_TRAINING set LD_USER_EMAIL=? where IPT_ID=?",
					new Object[]{ldUserEmail, iptID});
			return ret;
		}

	//Update verID
		public int updateIPTverID(int iptID, int verID)
		{
			int ret = temp.update("update IN_PROGRESS_TRAINING set VER_ID=? where IPT_ID=?",
					new Object[]{verID, iptID});
			return ret;
		}
		
	//Update iptStartDate
		public int updateIPTstartDate(int iptID, String iptStartDate)
		{
			int ret = temp.update("update IN_PROGRESS_TRAINING set IPT_START_DATE=? where IPT_ID=?",
					new Object[]{iptStartDate, iptID});
			return ret;
		}

	//Update iptEndDate
		public int updateIPTendDate(int iptID, String iptEndDate)
		{
			int ret = temp.update("update IN_PROGRESS_TRAINING set IPT_END_DATE=? where IPT_ID=?",
					new Object[]{iptEndDate, iptID});
			return ret;
		}

	//Update iptStartTime
		public int updateIPTstartTime(int iptID, String iptStartTime)
		{
			int ret = temp.update("update IN_PROGRESS_TRAINING set IPT_START_TIME=? where IPT_ID=?",
					new Object[]{iptStartTime, iptID});
			return ret;
		}
	
	//Update iptEndTime
		public int updateIPTendTime(int iptID, String iptEndTime)
		{
			int ret = temp.update("update IN_PROGRESS_TRAINING set IPT_END_TIME=? where IPT_ID=?",
					new Object[]{iptEndTime, iptID});
			return ret;
		}
	
	//Update iptTechnology
		public int updateIPTtechnology(int iptID, String iptTechnology)
		{
			int ret = temp.update("update IN_PROGRESS_TRAINING set IPT_TECHNOLOGY=? where IPT_ID=?",
					new Object[]{iptTechnology, iptID});
			return ret;
		}
		
	//Update iptTrainingObj
		public int updateIPTtrainingObj(int iptID, String iptTrainingObj)
		{
			int ret = temp.update("update IN_PROGRESS_TRAINING set IPT_TRAINING_OBJECTIVES=? where IPT_ID=?",
					new Object[]{iptTrainingObj, iptID});
			return ret;
		}
	
	//Update iptLocation
		public int updateIPTlocation(int iptID, String iptLocation)
		{
			int ret = temp.update("update IN_PROGRESS_TRAINING set IPT_LOCATION=? where IPT_ID=?",
					new Object[]{iptLocation, iptID});
			return ret;
		}
	
	//Update iptNomFile
		public int updateIPTstartTimeomFile(int iptID, String iptNomFile)
		{
			int ret = temp.update("update IN_PROGRESS_TRAINING set IPT_NOMINATION_FILE=? where IPT_ID=?",
					new Object[]{iptNomFile, iptID});
			return ret;
		}


	//Delete
	public int deleteIPT(int iptID)
	{
		int ret =  temp.update("delete from IN_PROGRESS_TRAINING where IPT_ID=?",
				new Object[]{iptID});
		return ret;
	}
	
	//Get a Confirmed Training object
		public InProgressTraining getIPT(int iptID)
		{
			InProgressTraining ipt = (InProgressTraining)temp.queryForObject("select * from IN_PROGRESS_TRAINING where IPT_ID=?", 
					new Object[]{iptID}, new InProgressTrainingMapper());
			return ipt;
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
