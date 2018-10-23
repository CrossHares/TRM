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
	
	
	//Delete
	public int deleteCT(int ctID)
	{
		int ret =  temp.update("delete from CONFIRMED_TRAINING where CT_ID=?",
				new Object[]{ctID});
		return ret;
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