package trf.dao;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.jdbc.core.JdbcTemplate;


public class TrainingRequestFormServices {
	JdbcTemplate temp = MyJDBCTemplate.getJdbcTemplate();
	//Create
	public int insertNewTRF(int verID, int venID, int ttID, String trfProjectID, String technology, String trainingObjectives, 
			String dateRequested, String proposedEndDate, String projectSPOC, int appxEmployees, String requestorEmpID,
			String fileLocation, int trainingSource)
	{
		int ret = temp.update("insert into TRAINING_REQUEST_FORM values(gTRFNo.nextval,?,?,?,1,?,?,?,?,NULL,?,NULL,NULL,NULL,NULL,NULL,?,?,?,?,?,NULL,NULL,NULL,NULL)",
				new Object[]{verID, venID, ttID, trfProjectID, technology, trainingObjectives, dateRequested, proposedEndDate, projectSPOC, appxEmployees,
						requestorEmpID, fileLocation, trainingSource});
		return ret;
		
	}
	
	//Read
	public List<TrainingRequestForm> readTRF() 
	{
		
		List<TrainingRequestForm> list = temp.query("select * from TRAINING_REQUEST_FORM", new TrainingRequestFormMapper());
		return list;
	}
	
	public int updateStatusInProgress(int trfID,int osID)
	{
		int ret = temp.update("update IN_PROGRESS_TRAINING set OS_ID=? where TRF_ID=?", new Object[]{osID,trfID});
		
		return ret;
	}
	
	public List<TrainingRequestForm> readTRFByRId(String requestorID) 
	{
		
		List<TrainingRequestForm> list = temp.query("select * from TRAINING_REQUEST_FORM where TRF_REQUESTOR_EMPLOYEE_ID = ?",new Object[] {requestorID},new TrainingRequestFormMapper());
		return list;
	}
	
	//Update
	
	//Update limits the fields that can be changed to the Vendor ID, Training Type ID< technology, objectives, end date, 
	//number of employees, file location, and training source
	//String dateRequested, String proposedEndDate,
	public int updateTRF (int trfID, int verID, int venID, int ttID, String trfProjectID, String technology, String trainingObjectives, Date dateRequested, Date proposedEndDate, String projectSPOC, 
			int appxEmployees, String requestorEmpID, String fileLocation, int trainingSource)
	{

		String oracleRD = new SimpleDateFormat("dd/MMM/yyyy").format(dateRequested);
		String oraclePD = new SimpleDateFormat("dd/MMM/yyyy").format(proposedEndDate);
		int ret = 0;
		ret += temp.update("update TRAINING_REQUEST_FORM set VEN_ID = ? where TRF_ID=?", new Object[]{venID, trfID});
		ret += temp.update("update TRAINING_REQUEST_FORM set TT_ID = ? where TRF_ID=?", new Object[]{ttID, trfID});
		ret += temp.update("update TRAINING_REQUEST_FORM set TRF_PROJECT_ID = ? where TRF_ID=?", new Object[]{trfProjectID, trfID});
		ret += temp.update("update TRAINING_REQUEST_FORM set TRF_TECHNOLOGY = ? where TRF_ID=?", new Object[]{technology, trfID});
		ret += temp.update("update TRAINING_REQUEST_FORM set TRF_TRAINING_OBJECTIVES = ? where TRF_ID=?", new Object[]{trainingObjectives, trfID});
		ret += temp.update("update TRAINING_REQUEST_FORM set TRF_DATE_REQUESTED = ? where TRF_ID=?", new Object[]{oracleRD, trfID});
		ret += temp.update("update TRAINING_REQUEST_FORM set TRF_PROPOSED_END_DATE = ? where TRF_ID=?", new Object[]{oraclePD, trfID});
		ret += temp.update("update TRAINING_REQUEST_FORM set TRF_PROJECT_TRAINING_SPOC = ? where TRF_ID=?", new Object[]{projectSPOC, trfID});
		ret += temp.update("update TRAINING_REQUEST_FORM set TRF_APPROX_NO_EMPLOYEES = ? where TRF_ID=?", new Object[]{appxEmployees, trfID});
		ret += temp.update("update TRAINING_REQUEST_FORM set TRF_REQUESTOR_EMPLOYEE_ID = ? where TRF_ID=?", new Object[]{requestorEmpID, trfID});
		ret += temp.update("update TRAINING_REQUEST_FORM set TRF_APPROVED_FILE_LOCATION = ? where TRF_ID=?", new Object[]{fileLocation, trfID});
		ret += temp.update("update TRAINING_REQUEST_FORM set TS_TRAINING_SOURCE = ? where TRF_ID=?", new Object[]{trainingSource, trfID});
		ret += temp.update("update TRAINING_REQUEST_FORM set TRF_HIDE_STATUS = 1 where TRF_ID=?", new Object[]{trfID});
		return ret;
	}
	
	public int updateTRF (int trfID, int verID, int ttID, String trfProjectID, String technology, String trainingObjectives, Date dateRequested, Date proposedEndDate, String projectSPOC, 
			int appxEmployees, String requestorEmpID, String fileLocation, int trainingSource)
	{

		String oracleRD = new SimpleDateFormat("dd/MMM/yyyy").format(dateRequested);
		String oraclePD = new SimpleDateFormat("dd/MMM/yyyy").format(proposedEndDate);
		int ret = 0;
		ret += temp.update("update TRAINING_REQUEST_FORM set TT_ID = ? where TRF_ID=?", new Object[]{ttID, trfID});
		ret += temp.update("update TRAINING_REQUEST_FORM set TRF_PROJECT_ID = ? where TRF_ID=?", new Object[]{trfProjectID, trfID});
		ret += temp.update("update TRAINING_REQUEST_FORM set TRF_TECHNOLOGY = ? where TRF_ID=?", new Object[]{technology, trfID});
		ret += temp.update("update TRAINING_REQUEST_FORM set TRF_TRAINING_OBJECTIVES = ? where TRF_ID=?", new Object[]{trainingObjectives, trfID});
		ret += temp.update("update TRAINING_REQUEST_FORM set TRF_DATE_REQUESTED = ? where TRF_ID=?", new Object[]{oracleRD, trfID});
		ret += temp.update("update TRAINING_REQUEST_FORM set TRF_PROPOSED_END_DATE = ? where TRF_ID=?", new Object[]{oraclePD, trfID});
		ret += temp.update("update TRAINING_REQUEST_FORM set TRF_PROJECT_TRAINING_SPOC = ? where TRF_ID=?", new Object[]{projectSPOC, trfID});
		ret += temp.update("update TRAINING_REQUEST_FORM set TRF_APPROX_NO_EMPLOYEES = ? where TRF_ID=?", new Object[]{appxEmployees, trfID});
		ret += temp.update("update TRAINING_REQUEST_FORM set TRF_REQUESTOR_EMPLOYEE_ID = ? where TRF_ID=?", new Object[]{requestorEmpID, trfID});
		ret += temp.update("update TRAINING_REQUEST_FORM set TRF_APPROVED_FILE_LOCATION = ? where TRF_ID=?", new Object[]{fileLocation, trfID});
		ret += temp.update("update TRAINING_REQUEST_FORM set TS_TRAINING_SOURCE = ? where TRF_ID=?", new Object[]{trainingSource, trfID});
		ret += temp.update("update TRAINING_REQUEST_FORM set TRF_HIDE_STATUS = 1 where TRF_ID=?", new Object[]{trfID});
		return ret;
	}
	
	public TrainingRequestForm fetchTrainingRequest(int trfID) {
		TrainingRequestForm obj = (TrainingRequestForm) temp.queryForObject("select * from TRAINING_REQUEST_FORM where TRF_ID=?", new Object[]{trfID}, new TrainingRequestFormMapper());
		return obj;
	}
	
	//Delete
	public int deleteTRF(int trfID)
	{
		int ret =  temp.update("delete from TRAINING_REQUEST_FORM where TRF_ID=?", new Object[]{trfID});
		return ret;
	}	
	

	
	public static void main(String args[])
	{
		//TrainingRequestFormServices trfSvcs = new TrainingRequestFormServices();
		//System.out.println(trfSvcs.readTRF().size());
		//trfSvcs.insertNewTRF(1, 104, 1, "Amex-1234", "Java", "Core Java", "12-FEB-19", "13-FEB-19", "Mr. Mango Appleton", 10, "5050999", null, 2);
		//System.out.println(trfSvcs.readTRF().size());
		//System.out.println(trfSvcs.getTRF(12).toString());
		//System.out.println(trfSvcs.deleteTRF(12));
		//System.out.println(trfSvcs.readTRF().size());
		
	}
}

