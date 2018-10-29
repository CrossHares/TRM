package ct.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import ct.dao.MyJDBCTemplate;

public class ConfirmedTrainingServices {

	JdbcTemplate temp = MyJDBCTemplate.getJdbcTemplate();
	
	//Create
		public int createNewCT(int TRF_ID, int VER_ID, int VEN_ID, int TT_ID, int OS_ID, 
				String CT_PROJECT_ID, String CT_TECHNOLOGY, String CT_TRAINING_OBJECTIVES, 
				String CT_DATE_REQUESTED, String CT_PROPOSED_START_DATE, String CT_PROPOSED_END_DATE, 
				String CT_PROPOSED_START_TIME, String CT_PROPOSED_END_TIME,String CT_PROPOSED_LOCATION, 
				String CT_ROOM_NO , int LDTM_ID, String CT_PROJECT_TRAINING_SPOC, int CT_APPROX_NO_EMPLOYEES, 
				String CT_REQUESTOR_EMPLOYEE_ID,String CT_APPROVED_FILE_LOCATION, int CT_TRAINING_SOURCE, 
				String CT_NOMINATION_FILE, String CT_ASSIGNED_EXEC ) throws ParseException
		{
			//format date input
			
			Date javareq = new SimpleDateFormat("yyyy-MM-dd").parse(CT_DATE_REQUESTED);
			String oraclereq = new SimpleDateFormat("dd/MMM/yyyy").format(javareq);
			
			Date javaStartDate = new SimpleDateFormat("yyyy-MM-dd").parse(CT_PROPOSED_START_DATE);
			String oracleStartDate = new SimpleDateFormat("dd/MMM/yyyy").format(javaStartDate);
			
			Date javaEndDate = new SimpleDateFormat("yyyy-MM-dd").parse(CT_PROPOSED_END_DATE);
			String oraclEndDate = new SimpleDateFormat("dd/MMM/yyyy").format(javaEndDate);
			
			//insert into database
			int ret = temp.update("insert into CONFIRMED_TRAINING values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,null,null)",
					new Object[]{TRF_ID, VER_ID, VEN_ID, TT_ID, OS_ID, CT_PROJECT_ID,
							CT_TECHNOLOGY,CT_TRAINING_OBJECTIVES, 
							oraclereq, oracleStartDate,	oraclEndDate, 
							CT_PROPOSED_START_TIME, CT_PROPOSED_END_TIME,CT_PROPOSED_LOCATION, 
							CT_ROOM_NO, LDTM_ID, CT_PROJECT_TRAINING_SPOC,CT_APPROX_NO_EMPLOYEES, 
							CT_REQUESTOR_EMPLOYEE_ID, CT_APPROVED_FILE_LOCATION, CT_TRAINING_SOURCE,
						  CT_NOMINATION_FILE, CT_ASSIGNED_EXEC });
			return ret;
		}
	
	//Read
	public List<ConfirmedTraining> readCT()
	{
		List<ConfirmedTraining> list = temp.query("select * from CONFIRMED_TRAINING", new ConfirmedTrainingMapper());
		return list;
	}

	//Update won't allow the user to change the TRF_ID that is linked in order to maintain the data integrity
	public int updateCT(String CT_ROOM_NO, String CT_PROPOSED_LOCATION, int LDTM_ID,int TRF_ID)
	{
		int ret = temp.update("update CONFIRMED_TRAINING set CT_ROOM_NO=?,CT_PROPOSED_LOCATION=?, LDTM_ID=? where TRF_ID=?",
				
				new Object[]{CT_ROOM_NO, CT_PROPOSED_LOCATION, LDTM_ID, TRF_ID});
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
			int ret = temp.update("update CONFIRMED_TRAINING set CT_PROPOSED_LOCATION=? where TRF_ID=?",
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
		
	//get trf id numbers that aren't in confirmed training but exist in in_progress_training
	public List<String> getUnusedIDs(){
		List<String> list =(List<String>) temp.queryForList("SELECT TRF_ID FROM IN_PROGRESS_TRAINING WHERE TRF_ID NOT IN (SELECT I.TRF_ID FROM IN_PROGRESS_TRAINING I JOIN CONFIRMED_TRAINING C ON I.TRF_ID = C.TRF_ID)", String.class);		
		return list;
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
	
	public static void main(String args[]) throws ParseException
	{
		ConfirmedTrainingServices cts = new ConfirmedTrainingServices();

		System.out.println(cts.getUnusedIDs().size());
		//4 ints, 10 strings, 1 int, 1 string, 1 int, 2 strings, 1 int, 2 strings, 2 ints
		
		//cts.updateCT("32A", "Phoenix, Arizona", 3, 1);
//		cts.createNewCT(6,3,102,1,1,"w","w","w","2017-05-12","2017-05-12","2017-05-12","w","w","w","w",1,"w",1,"w","w",1,"w","w");
		
	}
}