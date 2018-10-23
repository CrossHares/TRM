package trf.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

public class TrainingRequestFormServices {
	JdbcTemplate temp = MyJDBCTemplate.getJdbcTemplate();
	//Create
	public int insertNewTRF(int verID, int venID, int ttID, String trfProjectID, String technology, String trainingObjectives, 
			String dateRequested, String proposedEndDate, String projectSPOC, int appxEmployees, String requestorEmpID,
			String fileLocation, int trainingSource)
	{
		int ret = temp.update("insert into TRAINING_REQUEST_FORM values(gTRFNo.nextval,?,?,?,?,?,?,?,?,?,?,?,?,?)",
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
	
	//Update
	
	//Update limits the fields that can be changed to the Vendor ID, Training Type ID< technology, objectives, end date, 
	//number of employees, file location, and training source
	public int updateTRF(int venID, int ttID, String technology, String trainingObjectives, String proposedEndDate, int appxEmployees, 
			String fileLocation, int trainingSource, int trfID)
	{
		int ret = temp.update("update TRAINING_REQUEST_FORM set VEN_ID=?, TT_ID=?, TRF_TECHNOLOGY=?, TRF_TRAINING_OBJECTIVES=?, TRF_PROPOSED_EDN_DATE=?, TRF_APPROX_NO_EMPLOYEES=?, TRF_APPROVED_FILE_LOCATION=?, TRF_TRAINING_SOURCE=? where TRF_ID=?",
				new Object[]{venID, ttID, technology, trainingObjectives, proposedEndDate, appxEmployees, fileLocation, trainingSource, trfID});
		return ret;
	}
			
	//Delete
	public int deleteTRF(int trfID)
	{
		int ret =  temp.update("delete from TRAINING_REQUEST_FORM where TRF_ID=?",
				new Object[]{trfID});
		return ret;
	}
	
	
	//Get a TRF object
	public TrainingRequestForm getTRF(int trfID)
	{
		TrainingRequestForm newTRF = (TrainingRequestForm)temp.queryForObject("select * from TRAINING_REQUEST_FORM where TRF_ID=?", 
				new Object[]{trfID}, new TrainingRequestFormMapper());
		return newTRF;
	}
	
	
	public static void main(String args[])
	{
		//TrainingRequestFormServices trfSvcs = new TrainingRequestFormServices();
		//System.out.println(trfSvcs.readTRF().size());
		//trfSvcs.insertNewTRF(1, 104, 1, "Amex-1234", "Java", "Core Java", "12-FEB-19", "13-FEB-19", "Mr. Mango Appleton", 10, "5050999", null, 2);
		//System.out.println(trfSvcs.readTRF().size());
		//System.out.println(trfSvcs.getTRF(12).toString());
		//trfSvcs.deleteTRF(14);
		//System.out.println(trfSvcs.readTRF().size());
		
	}
}

