package ct.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import ct.dao.MyJDBCTemplate;

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

	//Update won't allow the user to change the TRF_ID that is linked in order to maintain the data integrity
	public int updateIPT(int ctID, int verID, int venID, int ttID, int trfID, int osID, String ctProjectID, String ctTechnology, String ctTrainingObj, 
			String ctDateRequested, String ctProposedStartDate, String ctProposedEndDate, String ctProjTrainSpoc, int ctAppxEmployees, 
			String ctRequestorID, String ctApprovedFileLoc, int ctTrainingSource, String ctProposedLoc, String ctProposedStartTime, 
			String ctProposedEndTime)
	{
		int ret = temp.update("update IN_PROGRESS_TRAINING set IPT_ID=?, VER_ID=?, TT_ID=?, TRF_ID=?, OS_ID=?, IPT_PROJECT_ID=?, IPT_TECHNOLOGY=?, IPT_TRAINING_OBJECTIVES=?, IPT_DATE_REQUESTED=?, IPT_PROPOSED_START_DATE=?, IPT_PROPOSED_END_DATE=?, IPT_PROJECT__TRAINING_SPOC=?, IPT_APPROX_NO_EMPLOYEES=?, IPT_REQUESTOR_EMPLOYEE_ID=?, IPT_APPROVED_FILE_LOCATION=?, IPT_TRAINING_SOURCE=?, IPT_PROPOSED_LOCATION=?, IPT_PROPOSED_START_TIME=?, IPT_PROPOSED_END_TIME=?  where IPT_ID=?",
				new Object[]{ctID, verID, venID, ttID, trfID, osID, ctProjectID, ctTechnology, ctTrainingObj, ctDateRequested, ctProposedStartDate,
						ctProposedEndDate, ctProjTrainSpoc, ctAppxEmployees, ctRequestorID, ctApprovedFileLoc, ctTrainingSource, ctProposedLoc, 
						ctProposedStartTime, ctProposedEndTime});
		return ret;
	}
	
	//What follows is additional update functions, designed to update one attribute at a time.
	
	//Update verID
			public int updateCTverID(int ctID, int verID)
			{
				int ret = temp.update("update CONFIRMED_TRAINING set VER_ID=? where CT_ID=?",
						new Object[]{verID, ctID});
				return ret;
			}
	//Update venID
			public int updateCTvenID(int ctID, int venID)
			{
				int ret = temp.update("update CONFIRMED_TRAINING set VEN_ID=? where CT_ID=?",
						new Object[]{venID, ctID});
				return ret;
			}
			
	//Update ttID
		public int updateIPTttID(int ctID, int ttID)
		{
			int ret = temp.update("update IN_PROGRESS_TRAINING set TT_ID=? where IPT_ID=?",
					new Object[]{ttID, ctID});
			return ret;
		}

	//Update trfID
		public int updateIPTtrfID(int ctID, int trfID)
		{
			int ret = temp.update("update IN_PROGRESS_TRAINING set TRF_ID=? where IPT_ID=?",
					new Object[]{trfID, ctID});
			return ret;
		}
	
	//Update osID
		public int updateIPTosID(int ctID, int osID)
		{
			int ret = temp.update("update CONFIRMED_TRAINING set OS_ID=? where IPT_ID=?",
					new Object[]{osID, ctID});
			return ret;
		}
	//Update iptProjectID
		public int updateIIPTprojectID(int ctID, String ctProjectID)
		{
			int ret = temp.update("update CONFIRMED_TRAINING set CT_PROJECT_ID=? where CT_ID=?",
					new Object[]{ctProjectID, ctID});
			return ret;
		}
		
	//Update iptTechnology
			public int updateCTtechnology(int ctID, String ctTechnology)
			{
				int ret = temp.update("update CONFIRMED_TRAINING set IPT_TECHNOLOGY=? where CT_ID=?",
						new Object[]{ctTechnology,ctID});
				return ret;
			}
		
	//Update iptTrainingObj
		public int updateCTtrainingObj(int ctID, String ctTrainingObj)
		{
			int ret = temp.update("update CONFIRMED_TRAINING set CT_TRAINING_OBJECTIVES=? where CT_ID=?",
					new Object[]{ctTrainingObj, ctID});
			return ret;
		}
	
	//Update date requested
		public int updateCPTdateRequested(int ctID, String ctDateRequested)
		{
			int ret = temp.update("update CONFIRMED_TRAINING set CT_DATE_REQUESTED=? where CT_ID=?",
					new Object[]{ctDateRequested, ctID});
			return ret;
		}
	//update proposed start date
		public int updateCTpropStartDate(int iptID, String iptProposedStartDate)
		{
			int ret=temp.update("update CONFIRMED_TRAINING set CT_PROPOSED_START_DATE=? where CT_ID=?",
					new Object[]{iptProposedStartDate, iptID});
			return ret;
		}
		
	// update proposed end date
		public int updateCPTpropEndDate(int ctID, String ctProposedEndDate)
		{
			int ret = temp.update("update CONFIRMED_TRAINING set CT_PROPOSED_END_DATE=? where CT_ID=?",
					new Object[]{ctProposedEndDate, ctID});
			return ret;
		}
	
	// update project training spoc
		public int updateCPTprojectSpoc(int ctID, String ctProjTrainSpoc)
		{
			int ret = temp.update("update CONFIRMED_TRAINING set CT_PROJECT_TRAINING_SPOC=? where CT_ID=?",
					new Object[]{ctProjTrainSpoc, ctID});
			return ret;
		}
	
	//update approx emp
		public int updateCTappxEmp(int ctID, int ctAppxEmployees)
		{
			int ret = temp.update("update CONFIRMED_TRAINING set CT_APPROX_NO_EMPLOYEES=? where CT_ID=?",
					new Object[]{ctAppxEmployees, ctID});
			return ret;
		}
	//update requestor emp id
		public int updateCPTreqEmpID(int ctID, int ctRequestorID)
		{
			int ret = temp.update("update CONFIRMED_TRAINING set CT_REQUESTOR_EMPLOYEE_ID=? where CT_ID=?",
					new Object[]{ctRequestorID, ctID});
			return ret;
		}
	
	//Update iptNomFile
		public int updateCPTfileLoc(int ctID, String ctFileLocation)
		{
			int ret = temp.update("update CONFIRMED_TRAINING set CT_APPROVED_FILE_LOCATION=? where CT_ID=?",
					new Object[]{ctFileLocation, ctID});
			return ret;
		}
	
		
	//update training source
		public int updateCPTtrainingSource(int ctID, String ctTrainingSource)
		{
			int ret = temp.update("update CONFIRMED_TRAINING set CT_TRAINING_SOURCE=? where CT_ID=?",
					new Object[]{ctTrainingSource, ctID});
			return ret;
		}
		
	//Update iptProposedLocation
		public int updateCPTproposedLocation(int ctID, String ctProposedLocation)
		{
			int ret = temp.update("update CONFIRMED_TRAINING set IPT_PROPOSED_LOCATION=? where CT_ID=?",
					new Object[]{ctProposedLocation, ctID});
			return ret;
		}

	//Update iptStartTime
		public int updateCPTproposedStartTime(int iptID, String ctProposedStartTime)
		{
			int ret = temp.update("update CONFIRMED_TRAINING set CT_PROPOSED_START_TIME=? where CT_ID=?",
					new Object[]{ctProposedStartTime, iptID});
			return ret;
		}
	
	//Update iptEndTime
		public int updateIPTproposedEndTime(int ctID, String ctProposedEndTime)
		{
			int ret = temp.update("update CONFIRMED_TRAINING set CT_PROPOSED_END_TIME=? where CT_ID=?",
					new Object[]{ctProposedEndTime, ctID});
			return ret;
		}
	
	
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	
	//Delete
	public int deleteCT(int ctID)
	{
		int ret =  temp.update("delete from CONFIRMED_TRAINING where CT_ID=?",
				new Object[]{ctID});
		return ret;
	}
	
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	//Get a Confirmed Training object
		public ConfirmedTraining getCT(int ctID)
		{
			ConfirmedTraining ipt = (ConfirmedTraining)temp.queryForObject("select * from CONFIRMED_TRAINING where CT_ID=?", 
					new Object[]{ctID}, new ConfirmedTrainingMapper());
			return ipt;
		}
	
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
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