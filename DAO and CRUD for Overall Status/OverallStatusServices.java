package overallstatus.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import ipt.dao.InProgressTraining;
import ipt.dao.InProgressTrainingMapper;
import trf.dao.MyJDBCTemplate;

public class OverallStatusServices {
	
	JdbcTemplate temp = MyJDBCTemplate.getJdbcTemplate();
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	//Create
	public int createOS(int osID, String osName)
	{
		int ret = temp.update("insert into OVERALL_STATUS values(?,?)",
				new Object[]{osID, osName});
		return ret;
	}
	
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//Read
	public List<OverallStatus> readOS()
	{
		List<OverallStatus> list = temp.query("select * from OVERALL_STATUS", new OverallStatusMapper());
		return list;
	}
	
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//Update
	//Update All
	public int updateOS(int osID, String osName)
	{
		int ret = temp.update("update OVERALL_STATUS set OS_NAME=? where OS_ID=?",
				new Object[]{osName, osID});
		return ret;
	}
	
	
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//Delete
	public int deleteOS(int osID)
	{
		int ret = temp.update("delete from OVERALL_STATUS where OS_ID=?",
				new Object[]{osID});
		return ret;
	}
	
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//Fetch
	public OverallStatus getOS(int osID)
	{
		OverallStatus os = (OverallStatus)temp.queryForObject("select * from OVERALL_STATUS where OS_ID=?", 
				new Object[]{osID}, new OverallStatusMapper());
		return os;
	}
	
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	public static void main(String[] args) {
		OverallStatusServices obj = new OverallStatusServices();
		System.out.println(obj.readOS().size());
		obj.createOS(10, "testing");
		System.out.println(obj.readOS().size());
		System.out.println(obj.getOS(10).getOsName());
		obj.updateOS(10, "testing 2");
		System.out.println(obj.readOS().size());
		obj.deleteOS(10);
		System.out.println(obj.readOS().size());
	}
	

}
