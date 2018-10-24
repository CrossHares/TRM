package ipt.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import trf.dao.MyJDBCTemplate;

public class InProgressTrainingServices {
	
	JdbcTemplate temp = MyJDBCTemplate.getJdbcTemplate();
	
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//Create
	public int createNewIPT(int verID, int venID, int ttID, int trfID, int osID, String iptProjectID, String iptTechnology, String iptTrainingObj, 
			String iptDateRequested, String iptProposedStartDate, String iptProposedEndDate, String iptProjTrainSpoc, int iptAppxEmployees, 
			String iptRequestorID, String iptApprovedFileLoc, int iptTrainingSource, String iptProposedLoc, String iptProposedStartTime, 
			String iptProposedEndTime)
	{
		int ret = temp.update("insert into IN_PROGRESS_TRAINING values(gIPTNo.nextval,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)",
				new Object[]{verID, venID, ttID, trfID, osID, iptProjectID, iptTechnology, iptTrainingObj, iptDateRequested, iptProposedStartDate, 
						iptProposedEndDate, iptProjTrainSpoc, iptAppxEmployees, iptRequestorID, iptApprovedFileLoc, iptTrainingSource, iptProposedLoc, 
						iptProposedStartTime, iptProposedEndTime});
		return ret;
	}
	
	//Read
	public List<InProgressTraining> readIPT()
	{
		List<InProgressTraining> list = temp.query("select * from IN_PROGRESS_TRAINING", new InProgressTrainingMapper());
		return list;
	}
	
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	//Update
	//Update won't allow the user to change the TRF_ID that is linked in order to maintain the data integrity
	public int updateIPT(int iptID, int verID, int venID, int ttID, int trfID, int osID, String iptProjectID, String iptTechnology, String iptTrainingObj, 
			String iptDateRequested, String iptProposedStartDate, String iptProposedEndDate, String iptProjTrainSpoc, int iptAppxEmployees, 
			String iptRequestorID, String iptApprovedFileLoc, int iptTrainingSource, String iptProposedLoc, String iptProposedStartTime, 
			String iptProposedEndTime)
	{
		int ret = temp.update("update IN_PROGRESS_TRAINING set IPT_ID=?, VER_ID=?, TT_ID=?, TRF_ID=?, OS_ID=?, IPT_PROJECT_ID=?, IPT_TECHNOLOGY=?, IPT_TRAINING_OBJECTIVES=?, IPT_DATE_REQUESTED=?, IPT_PROPOSED_START_DATE=?, IPT_PROPOSED_END_DATE=?, IPT_PROJECT__TRAINING_SPOC=?, IPT_APPROX_NO_EMPLOYEES=?, IPT_REQUESTOR_EMPLOYEE_ID=?, IPT_APPROVED_FILE_LOCATION=?, IPT_TRAINING_SOURCE=?, IPT_PROPOSED_LOCATION=?, IPT_PROPOSED_START_TIME=?, IPT_PROPOSED_END_TIME=?  where IPT_ID=?",
				new Object[]{iptID, verID, venID, ttID, trfID, osID, iptProjectID, iptTechnology, iptTrainingObj, iptDateRequested, iptProposedStartDate,
						iptProposedEndDate, iptProjTrainSpoc, iptAppxEmployees, iptRequestorID, iptApprovedFileLoc, iptTrainingSource, iptProposedLoc, 
						iptProposedStartTime, iptProposedEndTime});
		return ret;
	}
	
	//What follows is additional update functions, designed to update one attribute at a time.
	
	//Update verID
			public int updateIPTverID(int iptID, int verID)
			{
				int ret = temp.update("update IN_PROGRESS_TRAINING set VER_ID=? where IPT_ID=?",
						new Object[]{verID, iptID});
				return ret;
			}
	//Update venID
			public int updateIPTvenID(int iptID, int venID)
			{
				int ret = temp.update("update IN_PROGRESS_TRAINING set VEN_ID=? where IPT_ID=?",
						new Object[]{venID, iptID});
				return ret;
			}
			
	//Update ttID
		public int updateIPTttID(int iptID, int ttID)
		{
			int ret = temp.update("update IN_PROGRESS_TRAINING set TT_ID=? where IPT_ID=?",
					new Object[]{ttID, iptID});
			return ret;
		}

	//Update trfID
		public int updateIPTtrfID(int iptID, int trfID)
		{
			int ret = temp.update("update IN_PROGRESS_TRAINING set TRF_ID=? where IPT_ID=?",
					new Object[]{trfID, iptID});
			return ret;
		}
	
	//Update osID
		public int updateIPTosID(int iptID, int osID)
		{
			int ret = temp.update("update IN_PROGRESS_TRAINING set OS_ID=? where IPT_ID=?",
					new Object[]{osID, iptID});
			return ret;
		}
	//Update iptProjectID
		public int updateIIPTprojectID(int iptID, String iptProjectID)
		{
			int ret = temp.update("update IN_PROGRESS_TRAINING set IPT_PROJECT_ID=? where IPT_ID=?",
					new Object[]{iptProjectID, iptID});
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
	
	//Update date requested
		public int updateIPTdateRequested(int iptID, String iptDateRequested)
		{
			int ret = temp.update("update IN_PROGRESS_TRAINING set IPT_DATE_REQUESTED=? where IPT_ID=?",
					new Object[]{iptDateRequested, iptID});
			return ret;
		}
	//update proposed start date
		public int updateIPTpropStartDate(int iptID, String iptProposedStartDate)
		{
			int ret=temp.update("update IN_PROGRESS_TRAINING set IPT_PROPOSED_START_DATE=? where IPT_ID=?",
					new Object[]{iptProposedStartDate, iptID});
			return ret;
		}
		
	// update proposed end date
		public int updateIPTpropEndDate(int iptID, String iptProposedEndDate)
		{
			int ret = temp.update("update IN_PROGRESS_TRAINING set IPT_PROPOSED_END_DATE=? where IPT_ID=?",
					new Object[]{iptProposedEndDate, iptID});
			return ret;
		}
	
	// update project training spoc
		public int updateIPTprojectSpoc(int iptID, String iptProjTrainSpoc)
		{
			int ret = temp.update("update IN_PROGRESS_TRAINING set IPT_PROJECT_TRAINING_SPOC=? where IPT_ID=?",
					new Object[]{iptProjTrainSpoc, iptID});
			return ret;
		}
	
	//update approx emp
		public int updateIPTappxEmp(int iptID, int iptAppxEmployees)
		{
			int ret = temp.update("update IN_PROGRESS_TRAINING set IPT_APPROX_NO_EMPLOYEES=? where IPT_ID=?",
					new Object[]{iptAppxEmployees, iptID});
			return ret;
		}
	//update requestor emp id
		public int updateIPTreqEmpID(int iptID, int iptRequestorID)
		{
			int ret = temp.update("update IN_PROGRESS_TRAINING set IPT_REQUESTOR_EMPLOYEE_ID=? where IPT_ID=?",
					new Object[]{iptRequestorID, iptID});
			return ret;
		}
	
	//Update iptNomFile
		public int updateIPTfileLoc(int iptID, String iptFileLocation)
		{
			int ret = temp.update("update IN_PROGRESS_TRAINING set IPT_APPROVED_FILE_LOCATION=? where IPT_ID=?",
					new Object[]{iptFileLocation, iptID});
			return ret;
		}
	
		
	//update training source
		public int updateIPTtrainingSource(int iptID, String iptTrainingSource)
		{
			int ret = temp.update("update IN_PROGRESS_TRAINING set IPT_TRAINING_SOURCE=? where IPT_ID=?",
					new Object[]{iptTrainingSource, iptID});
			return ret;
		}
		
	//Update iptProposedLocation
		public int updateIPTproposedLocation(int iptID, String iptProposedLocation)
		{
			int ret = temp.update("update IN_PROGRESS_TRAINING set IPT_PROPOSED_LOCATION=? where IPT_ID=?",
					new Object[]{iptProposedLocation, iptID});
			return ret;
		}

	//Update iptStartTime
		public int updateIPTproposedStartTime(int iptID, String iptProposedStartTime)
		{
			int ret = temp.update("update IN_PROGRESS_TRAINING set IPT_PROPOSED_START_TIME=? where IPT_ID=?",
					new Object[]{iptProposedStartTime, iptID});
			return ret;
		}
	
	//Update iptEndTime
		public int updateIPTproposedEndTime(int iptID, String iptProposedEndTime)
		{
			int ret = temp.update("update IN_PROGRESS_TRAINING set IPT_PROPOSED_END_TIME=? where IPT_ID=?",
					new Object[]{iptProposedEndTime, iptID});
			return ret;
		}
	
	
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	
	//Delete
	public int deleteIPT(int iptID)
	{
		int ret =  temp.update("delete from IN_PROGRESS_TRAINING where IPT_ID=?",
				new Object[]{iptID});
		return ret;
	}
	
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	//Get a Confirmed Training object
		public InProgressTraining getIPT(int iptID)
		{
			InProgressTraining ipt = (InProgressTraining)temp.queryForObject("select * from IN_PROGRESS_TRAINING where IPT_ID=?", 
					new Object[]{iptID}, new InProgressTrainingMapper());
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
