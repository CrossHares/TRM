package trainingtype.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;


import trf.dao.MyJDBCTemplate;

public class TrainingTypeServices {
	JdbcTemplate temp = MyJDBCTemplate.getJdbcTemplate();
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
//Create
public int createTT(int ttID, String ttDesc)
{
	int ret = temp.update("insert into OVERALL_STATUS values(?,?)",
		new Object[]{ttID, ttDesc});
	return ret;
}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//Read
public List<TrainingType> readTT()
{
	List<TrainingType> list = temp.query("select * from TRAINING_TYPE", new TrainingTypeMapper());
	return list;
}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//Update
//Update All
public int updateTT(int ttID, String ttDesc)
{
	int ret = temp.update("update TRAINING_TYPE set TT_DESC=? where TT_ID=?",
			new Object[]{ttDesc, ttID});
	return ret;
}


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//Delete
public int deleteTT(int ttID)
{
	int ret = temp.update("delete from TRAINING_TYPE where TT_ID=?",
			new Object[]{ttID});
	return ret;
}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//Fetch
public TrainingType getTT(int ttID)
{
	TrainingType tt = (TrainingType)temp.queryForObject("select * from TRAINING_TYPE where TT_ID=?", 
			new Object[]{ttID}, new TrainingTypeMapper());
	return tt;
}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


public static void main(String[] args) {
	TrainingTypeServices obj = new TrainingTypeServices();
	System.out.println(obj.readTT().size());
	//obj.createTT(4, "testing");
	//System.out.println(obj.readTT().size());
	System.out.println(obj.getTT(3).getTtDesc());
	obj.updateTT(2, "testing 2");
	System.out.println(obj.readTT().size());
	System.out.println(obj.getTT(2).getTtDesc());
	obj.deleteTT(2);
	System.out.println(obj.readTT().size());
}


}

