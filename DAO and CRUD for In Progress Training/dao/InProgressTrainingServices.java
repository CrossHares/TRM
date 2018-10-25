package ipt.dao;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import trf.dao.MyJDBCTemplate;

public class InProgressTrainingServices {
	
	JdbcTemplate temp = MyJDBCTemplate.getJdbcTemplate();
//Date Parsing Functions
	public String convertDateReq(String iptDateRequested)
	{
		try
		{
		Date javaDateIptDateReq = new SimpleDateFormat("yyy-MM-dd").parse(iptDateRequested);
		String iptDateReq = new SimpleDateFormat("dd/MMM/yyyy").format(javaDateIptDateReq);
		return iptDateReq;
		}
		catch(Exception e)
		{
			String error = "There has been an error with the date parsing process.";
			return error;
		}
	}
	
	public String convertPropStartDate(String iptProposedStartDate)
	{
		try
		{
			Date javaDateIptPropStartDate = new SimpleDateFormat("yyy-MM-dd").parse(iptProposedStartDate);
			String iptPropStartDate = new SimpleDateFormat("dd/MMM/yyyy").format(javaDateIptPropStartDate);
			return iptPropStartDate;
		}
		catch(Exception e)
		{
			String error = "There has been an error with the date parsing process.";
			return error;
		}
	}
	
	public String convertPropEndDate(String iptProposedEndDate)
	{
		try
		{
			Date javaDateIptPropEndDate = new SimpleDateFormat("yyy-MM-dd").parse(iptProposedEndDate);
			String iptPropEndDate = new SimpleDateFormat("dd/MMM/yyyy").format(javaDateIptPropEndDate);
			return iptPropEndDate;
		}
		catch(Exception e)
		{
			String error = "There has been an error with the date parsing process.";
			return error;
		}
	}
	
	
	
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	

	//Create
	

	
	public int createNewIPT(int verID, int venID, int ttID, int trfID, int osID, String iptProjectID, String iptTechnology, String iptTrainingObj, 
			String iptDateRequested, String iptProposedStartDate, String iptProposedEndDate, String iptProjTrainSpoc, int iptAppxEmployees, 
			String iptRequestorID, String iptApprovedFileLoc, int iptTrainingSource, String iptProposedLoc, String iptProposedStartTime, 
			String iptProposedEndTime, int LDTM_ID, String iptAssignedExec, int iptHideStatus, String iptNomFile, String iptRoomNo, int iptButtonCount)
	{
		
		String iptDateReq = convertDateReq(iptDateRequested);
		String iptPropStartDate = convertPropStartDate(iptProposedStartDate);
		String iptPropEndDate = convertPropEndDate(iptProposedEndDate);
		
			int ret = temp.update("insert into IN_PROGRESS_TRAINING values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)",
					new Object[]{verID, venID, ttID, trfID, osID, iptProjectID, iptTechnology, iptTrainingObj, iptDateReq, iptPropStartDate, 
							iptPropEndDate, iptProjTrainSpoc, iptAppxEmployees, iptRequestorID, iptApprovedFileLoc, iptTrainingSource, iptProposedLoc, 
							iptProposedStartTime, iptProposedEndTime, LDTM_ID, iptAssignedExec, iptHideStatus, iptNomFile, iptRoomNo, iptButtonCount});
			return ret;
				
	}
	
	
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
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
			String iptProposedEndTime, int LDTM_ID, String iptAssignedExec, int iptHideStatus, String iptNomFile, String iptRoomNo, int iptButtonCount)
	{
		String iptDateReq = convertDateReq(iptDateRequested);
		String iptPropStartDate = convertPropStartDate(iptProposedStartDate);
		String iptPropEndDate = convertPropEndDate(iptProposedEndDate);
		
		int ret = temp.update("update IN_PROGRESS_TRAINING set IPT_ID=?, VER_ID=?, TT_ID=?, TRF_ID=?, OS_ID=?, IPT_PROJECT_ID=?, IPT_TECHNOLOGY=?, IPT_TRAINING_OBJECTIVES=?, IPT_DATE_REQUESTED=?, IPT_PROPOSED_START_DATE=?, IPT_PROPOSED_END_DATE=?, IPT_PROJECT__TRAINING_SPOC=?, IPT_APPROX_NO_EMPLOYEES=?, IPT_REQUESTOR_EMPLOYEE_ID=?, IPT_APPROVED_FILE_LOCATION=?, TS_TRAINING_SOURCE=?, IPT_PROPOSED_LOCATION=?, IPT_PROPOSED_START_TIME=?, IPT_PROPOSED_END_TIME=?, LDTM_ID=?, IPT_ASSIGNED_EXEC=?, IPT_HIDE_STATUS=?, IPT_NOMINATION_FILE=?, IPT_ROOM_NO=?, IPT_BUTTON_COUNT=? where IPT_ID=?",
			new Object[]{iptID, verID, venID, ttID, trfID, osID, iptProjectID, iptTechnology, iptTrainingObj, iptDateReq, iptPropStartDate,
					iptPropEndDate, iptProjTrainSpoc, iptAppxEmployees, iptRequestorID, iptApprovedFileLoc, iptTrainingSource, iptProposedLoc, 
					iptProposedStartTime, iptProposedEndTime, LDTM_ID, iptAssignedExec, iptHideStatus, iptNomFile, iptRoomNo, iptButtonCount});
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
				String iptDateReq = convertDateReq(iptDateRequested);
				int ret = temp.update("update IN_PROGRESS_TRAINING set IPT_DATE_REQUESTED=? where IPT_ID=?",
					new Object[]{iptDateReq, iptID});
				return ret;
			
		}
	//update proposed start date
		public int updateIPTpropStartDate(int iptID, String iptProposedStartDate)
		{
			String iptPropStartDate = convertPropStartDate(iptProposedStartDate);
			int ret=temp.update("update IN_PROGRESS_TRAINING set IPT_PROPOSED_START_DATE=? where IPT_ID=?",
					new Object[]{iptPropStartDate, iptID});
			return ret;
			
		}
		
		
	// update proposed end date
		public int updateIPTpropEndDate(int iptID, String iptProposedEndDate)
		{
			String iptPropEndDate = convertPropEndDate(iptProposedEndDate);
			int ret = temp.update("update IN_PROGRESS_TRAINING set IPT_PROPOSED_END_DATE=? where IPT_ID=?",
					new Object[]{iptPropEndDate, iptID});
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
		public int updateIPTtrainingSource(int iptID, int iptTrainingSource)
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
		
	//Update LDTM_ID
		public int updateIPTlDTM_ID(int iptID, int LDTM_ID)
		{
			int ret = temp.update("update IN_PROGRESS_TRAINING set LDTM_ID=? where IPT_ID=?",
					new Object[]{LDTM_ID, iptID});
			return ret;
		}
	
	//update iptAssignedExec
		public int updateIptAssignedExec(int iptID, String iptAssignedExec)
		{
			int ret = temp.update("update IN_PROGRESS_TRAINING set IPT_ASSIGNED_EXEC=? where IPT_ID=?",
					new Object[]{iptAssignedExec, iptID});
			return ret;
		}
	
	//update iptHideStatus
		public int updateIptHideStatus(int iptID, int iptHideStatus)
		{
			int ret = temp.update("update IN_PROGRESS_TRAINING set IPT_HIDE_STATUS=? where IPT_ID=?",
					new Object[]{iptHideStatus, iptID});
			return ret;
		}
		
	//update iptNominationFile
		public int updateIptNomFile(int iptID, String iptNomFile)
		{
			int ret = temp.update("update IN_PROGRESS_TRAINING set IPT_NOMINATION_FILE=? where IPT_ID=?",
					new Object[]{iptNomFile, iptID});
			return ret;
		}
		
	//update iptRoomNo
		public int updateIptRoomNo(int iptID, String iptRoomNo)
		{
			int ret = temp.update("update IN_PROGRESS_TRAINING set IPT_ROOM_NO=? where IPT_ID=?",
					new Object[]{iptRoomNo, iptID});
			return ret;
		}
	
	//update iptButtonCount
		public int updateIptButtonCount(int iptID, int iptButtonCount)
		{
			int ret = temp.update("update IN_PROGRESS_TRAINING set IPT_BUTTON_COUNT=? where IPT_ID=?", 
					new Object[]{iptButtonCount, iptID});
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
		InProgressTrainingServices iptSvcs = new InProgressTrainingServices();
		System.out.println(iptSvcs.readIPT().size());
		//iptSvcs.updateIPTdateRequested(4, "12-Feb-2019");
		//System.out.println(iptSvcs.getIPT(9).getIptDateReq());
		//System.out.println(iptSvcs.readIPT().size());
		//iptSvcs.deleteIPT(12);
		//System.out.println(iptSvcs.readIPT().size());
	
	}
	

}
