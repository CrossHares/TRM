package ct.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import trf.dao.MyJDBCTemplate;
import trf.dao.TrainingRequestForm;
import trf.dao.TrainingRequestFormMapper;

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
		List<ConfirmedTraining> list = temp.query("select * from CONFIRMED_TRAAINING", new ConfirmedTrainingMapper());
		return list;
	}
	
	//Update
	public int updateCT(int ctID, int tsID, int ttID, String ldUserEmail, int verID, String trfIDs, String ctStartDate, String ctEndDate, 
			String ctStartTime, String ctEndTime, String ctTechnology, String ctTrainingObj, String ctLocation, String ctNomFile)
	{
		int ret = temp.update("update CONFIRMED_TRAINING set TSTATUS_ID=?, TT_ID=?, LD_USER_EMAIL=?, VER_ID=?, TRF_IDS=?, CT_START_DATE=?, CT_END_DATE=?,CT_START_TIME=?,CT_END_TIME=? CT_TECHNOLOGY=?, CT_TRAINING_OBJECTIVES=?, CT_LOCATION=?, CT_NOMINATION_FILE=?  where CT_ID=?",
				new Object[]{tsID, ttID, ldUserEmail, verID, trfIDs, ctStartDate, ctEndDate, ctStartTime, ctEndTime, ctTechnology, ctTrainingObj, ctLocation, ctNomFile});
		return ret;
	}
	
	
	//Delete
	public int deleteCT(int ctID)
	{
		int ret =  temp.update("delete from CONFIRMED_TRAINING where CT_ID=?",
				new Object[]{ctID});
		return ret;
	}
	
}
