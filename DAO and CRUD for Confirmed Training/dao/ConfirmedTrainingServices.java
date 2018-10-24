package ct.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import trf.dao.MyJDBCTemplate;

public class ConfirmedTrainingServices {

	JdbcTemplate temp = MyJDBCTemplate.getJdbcTemplate();
	
	//Create
	public int createNewCT(int tsID, int ttID, String ldUserEmail, int verID, String trfIDs, String ctStartDate, String ctEndDate, 
			String ctStartTime, String ctEndTime, String ctTechnology, String ctTrainingObj, String ctLocation, String ctNomFile)
	{
		int ret = temp.update("insert into CONFIRMED_TRAINING values(gCTNo.nextval,?,?,?,?,?,?,?,?,?,?,?,?,?)",
				new Object[]{tsID, ttID, ldUserEmail, verID, trfIDs, ctStartDate, ctEndDate, ctStartTime, ctEndTime, ctTechnology, ctTrainingObj,
						ctLocation, ctNomFile});
		return ret;
	}
	
	//Read
	public List<ConfirmedTraining> readCT()
	{
		List<ConfirmedTraining> list = temp.query("select * from CONFIRMED_TRAINING", new ConfirmedTrainingMapper());
		return list;
	}
	
	//Update
	public int updateCT(int ctID, int tsID, int ttID, String ldUserEmail, int verID, String trfIDs, String ctStartDate, String ctEndDate, 
			String ctStartTime, String ctEndTime, String ctTechnology, String ctTrainingObj, String ctLocation, String ctNomFile)
	{
		int ret = temp.update("update CONFIRMED_TRAINING set TSTATUS_ID=?, TT_ID=?, LD_USER_EMAIL=?, VER_ID=?, TRF_IDS=?, CT_START_DATE=?, CT_END_DATE=?,CT_START_TIME=?,CT_END_TIME=?, CT_TECHNOLOGY=?, CT_TRAINING_OBJECTIVES=?, CT_LOCATION=?, CT_NOMINATION_FILE=?  where CT_ID=?",
				new Object[]{tsID, ttID, ldUserEmail, verID, trfIDs, ctStartDate, ctEndDate, ctStartTime, ctEndTime, ctTechnology, ctTrainingObj, ctLocation, ctNomFile});
		return ret;
	}
	
	//What follows is additional update functions, designed to update one attribute at a time.
	
		//Update tsID
		public int updateCTtsID(int ctID, int tsID)
		{
			int ret = temp.update("update CONFIRMED_TRAINING set TSTATUS_ID=? where CT_ID=?",
					new Object[]{tsID, ctID});
			return ret;
		}
		
		//Update ttID
			public int updateCTttID(int ctID, int ttID)
			{
				int ret = temp.update("update CONFIRMED_TRAINING set TT_ID=? where CT_ID=?",
						new Object[]{ttID, ctID});
				return ret;
			}

		//Update ldUserEmail
			public int updateCTldUserEmail(int ctID, String ldUserEmail)
			{
				int ret = temp.update("update CONFIRMED_TRAINING set LD_USER_EMAIL=? where CT_ID=?",
						new Object[]{ldUserEmail, ctID});
				return ret;
			}

		//Update verID
			public int updateCTverID(int ctID, int verID)
			{
				int ret = temp.update("update CONFIRMED_TRAINING set VER_ID=? where CT_ID=?",
						new Object[]{verID, ctID});
				return ret;
			}
		
		//Update trfIDs
			public int updateTRFids(int ctID, String trfIDs)
			{
				int ret = temp.update("update CONFIRMED_TRAINING set TRF_IDS=? where CT_ID=?",
						new Object[]{trfIDs, ctID});
				return ret;
			}
			
		//Update iptStartDate
			public int updateCTstartDate(int ctID, String ctStartDate)
			{
				int ret = temp.update("update CONFIRMED_TRAINING set CT_START_DATE=? where CT_ID=?",
						new Object[]{ctStartDate, ctID});
				return ret;
			}

		//Update iptEndDate
			public int updateCTendDate(int ctID, String ctEndDate)
			{
				int ret = temp.update("update CONFIRMED_TRAINING set CT_END_DATE=? where CT_ID=?",
						new Object[]{ctEndDate, ctID});
				return ret;
			}

		//Update iptStartTime
			public int updateCTstartTime(int ctID, String ctStartTime)
			{
				int ret = temp.update("update CONFIRMED_TRAINING set CT_START_TIME=? where CT_ID=?",
						new Object[]{ctStartTime, ctID});
				return ret;
			}
		
		//Update iptEndTime
			public int updateCTendTime(int ctID, String ctEndTime)
			{
				int ret = temp.update("update CONFIRMED_TRAINING set CT_END_TIME=? where CT_ID=?",
						new Object[]{ctEndTime, ctID});
				return ret;
			}
		
		//Update iptTechnology
			public int updateCTtechnology(int ctID, String ctTechnology)
			{
				int ret = temp.update("update CONFIRMED_TRAINING set CT_TECHNOLOGY=? where CT_ID=?",
						new Object[]{ctTechnology, ctID});
				return ret;
			}
			
		//Update iptTrainingObj
			public int updateCTtrainingObj(int ctID, String ctTrainingObj)
			{
				int ret = temp.update("update CONFIRMED_TRAINING set CT_TRAINING_OBJECTIVES=? where CT_ID=?",
						new Object[]{ctTrainingObj, ctID});
				return ret;
			}
		
		//Update iptLocation
			public int updateCTlocation(int ctID, String ctLocation)
			{
				int ret = temp.update("update CONFIRMED_TRAINING set CT_LOCATION=? where CT_ID=?",
						new Object[]{ctLocation, ctID});
				return ret;
			}
		
		//Update iptNomFile
			public int updateCTstartTimeomFile(int iptID, String iptNomFile)
			{
				int ret = temp.update("update IN_PROGRESS_TRAINING set CT_NOMINATION_FILE=? where CT_ID=?",
						new Object[]{iptNomFile, iptID});
				return ret;
			}
	
	//Delete
	public int deleteCT(int ctID)
	{
		int ret =  temp.update("delete from CONFIRMED_TRAINING where CT_ID=?",
				new Object[]{ctID});
		return ret;
	}
	
	//Get a Confirmed Training object
	public ConfirmedTraining getCT(int ctID)
	{
		ConfirmedTraining ct = (ConfirmedTraining)temp.queryForObject("select * from CONFIRMED_TRAINING where CT_ID=?", 
				new Object[]{ctID}, new ConfirmedTrainingMapper());
		return ct;
	}
	
	public static void main(String args[])
	{
		//ConfirmedTrainingServices ctSvcs = new ConfirmedTrainingServices();
		//System.out.println(ctSvcs.readCT().size());
		//ctSvcs.createNewCT(4, 1, "CLINTON_EXODIA@SYNTELINC.COM", 5, "11", "21-FEB-18", "15-OCT-19", "0900", "1700","C SHARP", "OOP CONCEPTS", "MEMPHIS, TENNESSEE", "T:/TRAINIEES/3D_MODELING_TRAINIESS.DOCX");
		//System.out.println(ctSvcs.readCT().size());
		//ctSvcs.deleteCT(14);
		//System.out.println(ctSvcs.readCT().size());
	
	}
}