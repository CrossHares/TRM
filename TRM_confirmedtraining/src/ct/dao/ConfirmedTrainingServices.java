package ct.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import ct.dao.MyJDBCTemplate;

public class ConfirmedTrainingServices {

	JdbcTemplate temp = MyJDBCTemplate.getJdbcTemplate();
	
	//Create
		public int createNewCT(int VER_ID, int VEN_ID, int TT_ID, int OS_ID, 
				String CT_PROJECT_ID, String CT_TECHNOLOGY, String CT_TRAINING_OBJECTIVES, 
				String CT_DATE_REQUESTED, String CT_PROPOSED_START_DATE, String CT_PROPOSED_END_DATE, 
				String CT_PROPOSED_START_TIME, String CT_PROPOSED_END_TIME,String CT_PROPOSED_LOCATION, 
				String CT_ROOM_NO , int LDTM_ID, String CT_PROJECT_TRAINING_SPOC, int CT_APPROX_NO_EMPLOYEES, 
				String CT_REQUESTOR_EMPLOYEE_ID,String CT_APPROVED_FILE_LOCATION, int CT_TRAINING_SOURCE, 
				String CT_NOMINATION_FILE, String CT_ASSIGNED_EXEC, int CT_HIDE_STATUS, 
				int CT_BUTTON_COUNT )
		{
			int ret = temp.update("insert into CONFIRMED_TRAINING values(gTRFno.nextval,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)",
					new Object[]{VER_ID, VEN_ID, TT_ID, OS_ID, CT_PROJECT_ID,
							CT_TECHNOLOGY,CT_TRAINING_OBJECTIVES, CT_DATE_REQUESTED, CT_PROPOSED_START_DATE, 
							CT_PROPOSED_END_DATE, CT_PROPOSED_START_TIME, CT_PROPOSED_END_TIME,CT_PROPOSED_LOCATION, 
							CT_ROOM_NO, LDTM_ID, CT_PROJECT_TRAINING_SPOC,CT_APPROX_NO_EMPLOYEES, 
							CT_REQUESTOR_EMPLOYEE_ID, CT_APPROVED_FILE_LOCATION, CT_TRAINING_SOURCE,
						  CT_NOMINATION_FILE, CT_ASSIGNED_EXEC, CT_HIDE_STATUS,CT_BUTTON_COUNT });
			return ret;
		}
	
	//Read
	public List<ConfirmedTraining> readCT()
	{
		List<ConfirmedTraining> list = temp.query("select * from CONFIRMED_TRAINING", new ConfirmedTrainingMapper());
		return list;
	}

	//Update won't allow the user to change the TRF_ID that is linked in order to maintain the data integrity
	public int updateCT(int VER_ID, int VEN_ID, int TT_ID, int OS_ID, String CT_PROJECT_ID, String CT_TECHNOLOGY, String CT_TRAINING_OBJECTIVES, 
			String CT_DATE_REQUESTED, String CT_PROPOSED_START_DATE, String CT_PROPOSED_END_DATE, String CT_PROPOSED_START_TIME,
			String CT_PROPOSED_END_TIME, String CT_PROPOSED_LOCATION, String CT_PROJECT_TRAINING_SPOC, 
			int CT_APPROX_NO_EMPLOYEES,	String CT_REQUESTOR_EMPLOYEE_ID, 
			String CT_APPROVED_FILE_LOCATION, int CT_TRAINING_SOURCE, int CT_BUTTON_COUNT,int TRF_ID )
	{
		int ret = temp.update("update CONFIRMED_TRAINING set VER_ID=?, VEN_ID =?, TT_ID=?, OS_ID=?, "
				+ "CT_PROJECT_ID=?, CT_TECHNOLOGY=?, CT_TRAINING_OBJECTIVES=?, CT_DATE_REQUESTED=?, "
				+ "CT_PROPOSED_START_DATE=?, CT_PROPOSED_END_DATE=?,CT_PROPOSED_START_TIME=?,  CT_PROPOSED_END_TIME=?"
				+ "CT_PROPOSED_LOCATION=?, CT_PROJECT_TRAINING_SPOC=?, CT_APPROX_NO_EMPLOYEES=?, CT_REQUESTOR_EMPLOYEE_ID=?, "
				+ "CT_APPROVED_FILE_LOCATION=?,CT_TRAINING_SOURCE=?, where TRF_ID=?",
				
				new Object[]{VER_ID, VEN_ID, TT_ID, OS_ID, CT_PROJECT_ID, CT_TECHNOLOGY,
						CT_TRAINING_OBJECTIVES, CT_DATE_REQUESTED, CT_PROPOSED_START_DATE,
						CT_PROPOSED_END_DATE,CT_PROPOSED_START_TIME, CT_PROPOSED_END_TIME,
						CT_PROPOSED_LOCATION, CT_PROJECT_TRAINING_SPOC, CT_APPROX_NO_EMPLOYEES,
						CT_REQUESTOR_EMPLOYEE_ID, CT_APPROVED_FILE_LOCATION,CT_TRAINING_SOURCE, 
						CT_BUTTON_COUNT , TRF_ID});
		return ret;
	}
	
	//What follows is additional update functions, designed to update one attribute at a time.
	
	//Update verID
			public int updateCTverID(int ctID, int verID)
			{
				int ret = temp.update("update CONFIRMED_TRAINING set VER_ID=? where TRF_ID=?",
						new Object[]{verID, ctID});
				return ret;
			}
	//Update venID
			public int updateCTvenID(int ctID, int venID)
			{
				int ret = temp.update("update CONFIRMED_TRAINING set VEN_ID=? where TRF_ID=?",
						new Object[]{venID, ctID});
				return ret;
			}
			
	//Update ttID
		public int updateCTttID(int ctID, int ttID)
		{
			int ret = temp.update("update IN_PROGRESS_TRAINING set TT_ID=? where TRF_ID=?",
					new Object[]{ttID, ctID});
			return ret;
		}

	//Update trfID
		public int updateCTtrfID(int ctID, int trfID)
		{
			int ret = temp.update("update IN_PROGRESS_TRAINING set TRF_ID=? where TRF_ID=?",
					new Object[]{trfID, ctID});
			return ret;
		}
	
	//Update osID
		public int updateCTosID(int ctID, int osID)
		{
			int ret = temp.update("update CONFIRMED_TRAINING set OS_ID=? where TRF_ID=?",
					new Object[]{osID, ctID});
			return ret;
		}
	//Update iptProjectID
		public int updateCTprojectID(int ctID, String ctProjectID)
		{
			int ret = temp.update("update CONFIRMED_TRAINING set CT_PROJECT_ID=? where TRF_ID=?",
					new Object[]{ctProjectID, ctID});
			return ret;
		}
		
	//Update iptTechnology
			public int updateCTtechnology(int ctID, String ctTechnology)
			{
				int ret = temp.update("update CONFIRMED_TRAINING set CT_TECHNOLOGY=? where TRF_ID=?",
						new Object[]{ctTechnology,ctID});
				return ret;
			}
		
	//Update iptTrainingObj
		public int updateCTtrainingObj(int ctID, String ctTrainingObj)
		{
			int ret = temp.update("update CONFIRMED_TRAINING set CT_TRAINING_OBJECTIVES=? where TRF_ID=?",
					new Object[]{ctTrainingObj, ctID});
			return ret;
		}
	
	//Update date requested
		public int updateCPTdateRequested(int ctID, String ctDateRequested)
		{
			int ret = temp.update("update CONFIRMED_TRAINING set CT_DATE_REQUESTED=? where TRF_ID=?",
					new Object[]{ctDateRequested, ctID});
			return ret;
		}
	//update proposed start date
		public int updateCTpropStartDate(int ctID, String ctProposedStartDate)
		{
			int ret=temp.update("update CONFIRMED_TRAINING set CT_PROPOSED_START_DATE=? where TRF_ID=?",
					new Object[]{ctProposedStartDate, ctID});
			return ret;
		}
		
	// update proposed end date
		public int updateCPTpropEndDate(int ctID, String ctProposedEndDate)
		{
			int ret = temp.update("update CONFIRMED_TRAINING set CT_PROPOSED_END_DATE=? where TRF_ID=?",
					new Object[]{ctProposedEndDate, ctID});
			return ret;
		}
	
	// update project training spoc
		public int updateCTprojectSpoc(int ctID, String ctProjTrainSpoc)
		{
			int ret = temp.update("update CONFIRMED_TRAINING set CT_PROJECT_TRAINING_SPOC=? where TRF_ID=?",
					new Object[]{ctProjTrainSpoc, ctID});
			return ret;
		}
	
	//update approx emp
		public int updateCTappxEmp(int ctID, int ctAppxEmployees)
		{
			int ret = temp.update("update CONFIRMED_TRAINING set CT_APPROX_NO_EMPLOYEES=? where TRF_ID=?",
					new Object[]{ctAppxEmployees, ctID});
			return ret;
		}
	//update requestor emp id
		public int updateCTreqEmpID(int ctID, int ctRequestorID)
		{
			int ret = temp.update("update CONFIRMED_TRAINING set CT_REQUESTOR_EMPLOYEE_ID=? where TRF_ID=?",
					new Object[]{ctRequestorID, ctID});
			return ret;
		}
	
	//Update iptNomFile
		public int updateCPTfileLoc(int ctID, String ctFileLocation)
		{
			int ret = temp.update("update CONFIRMED_TRAINING set CT_APPROVED_FILE_LOCATION=? where TRF_ID=?",
					new Object[]{ctFileLocation, ctID});
			return ret;
		}
	
		
	//update training source
		public int updateCPTtrainingSource(int ctID, String ctTrainingSource)
		{
			int ret = temp.update("update CONFIRMED_TRAINING set CT_TRAINING_SOURCE=? where TRF_ID=?",
					new Object[]{ctTrainingSource, ctID});
			return ret;
		}
		
	//Update iptProposedLocation
		public int updateCTproposedLocation(int ctID, String ctProposedLocation)
		{
			int ret = temp.update("update CONFIRMED_TRAINING set IPT_PROPOSED_LOCATION=? where TRF_ID=?",
					new Object[]{ctProposedLocation, ctID});
			return ret;
		}

	//Update iptStartTime
		public int updateCTproposedStartTime(int iptID, String ctProposedStartTime)
		{
			int ret = temp.update("update CONFIRMED_TRAINING set CT_PROPOSED_START_TIME=? where TRF_ID=?",
					new Object[]{ctProposedStartTime, iptID});
			return ret;
		}
	
	//Update iptEndTime
		public int updateCTproposedEndTime(int ctID, String ctProposedEndTime)
		{
			int ret = temp.update("update CONFIRMED_TRAINING set CT_PROPOSED_END_TIME=? where TRF_ID=?",
					new Object[]{ctProposedEndTime, ctID});
			return ret;
		}
	
	
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	
	//Delete
	public int deleteCT(int ctID)
	{
		int ret =  temp.update("delete from CONFIRMED_TRAINING where TRF_ID=?",
				new Object[]{ctID});
		return ret;
	}
	
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	//Get a Confirmed Training object
		public ConfirmedTraining getCT(int ctID)
		{
			ConfirmedTraining ipt = (ConfirmedTraining)temp.queryForObject("select * from CONFIRMED_TRAINING where TRF_ID=?", 
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