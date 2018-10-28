package dao.dashboard_firstTable;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;






public class FirstTableService {
	JdbcTemplate template = (JdbcTemplate) new ClassPathXmlApplicationContext("spring-config.xml").getBean("jt");
	
	public List<FirstTable> getFirstTableData(){
		List<FirstTable> firstTabledata = template.query("select * from TRAINING_REQUEST_FORM", new FirstTableMapper());
		return firstTabledata;
	}
	
	public int deleteFromTable(int trfID){
		int ret = template.update("update TRAINING_REQUEST_FORM set TRF_HIDE_STATUS=2 where TRF_ID=?", new Object[]{trfID});
		return ret;
	}
	
	public int deleteFromSecondTable(int trfID){
		int ret = template.update("update in_progress_training set IPT_HIDE_STATUS=2 where TRF_ID=?", new Object[]{trfID});
		return ret;
	}
	
	public int createSecondTable(int trfID){
		int ret = template.update("insert into IN_PROGRESS_TRAINING select * from TRAINING_REQUEST_FORM where TRF_ID=?", new Object[]{trfID});
		template.update("update IN_PROGRESS_TRAINING set IPT_BUTTON_COUNT=1 where TRF_ID=?", new Object[]{trfID});
		template.update("update IN_PROGRESS_TRAINING set OS_ID=2 where TRF_ID=?", new Object[]{trfID});
		return ret;
	}
	
	
	public List<SecondTable> getSecondTableData(){
		List<SecondTable> secondTabledata = template.query("select * from IN_PROGRESS_TRAINING", new SecondTableMapper());
		return secondTabledata;
	}
	
	public SecondTable getSecondTableDataByTRFID(int trfID){
		SecondTable secondTabledata = (SecondTable) template.queryForObject("select * from IN_PROGRESS_TRAINING where TRF_ID = ?",new Object[]{trfID}, new SecondTableMapper());
		return secondTabledata;
	}
	
	public int enterform1(int trfID){
		int ret = template.update("update IN_PROGRESS_TRAINING set TS_TRAINING_SOURCE=1,OS_ID=2 where trf_id=?", new Object[]{trfID});
		template.update("update IN_PROGRESS_TRAINING set IPT_BUTTON_COUNT=2 where TRF_ID=?", new Object[]{trfID});
		return ret;
	}
	public int enterform2(int trfID, Date startdate, Date enddate, String location, String starttime, String endtime, String objective){
		  String oracleSD = new SimpleDateFormat("dd/MMM/yyyy").format(startdate);
		  String oracleED = new SimpleDateFormat("dd/MMM/yyyy").format(enddate);
		  int ret = template.update("update IN_PROGRESS_TRAINING set IPT_PROPOSED_START_DATE=?, IPT_PROPOSED_END_DATE=?,IPT_PROPOSED_LOCATION=?, IPT_PROPOSED_START_TIME=?, IPT_PROPOSED_END_TIME=?,IPT_TRAINING_OBJECTIVES=? where TRF_ID=?", new Object[]{oracleSD, oracleED, location, starttime, endtime, objective, trfID});
		  template.update("update IN_PROGRESS_TRAINING set IPT_BUTTON_COUNT=3 where TRF_ID=?", new Object[]{trfID});
		  return ret;
		 }
	public List<Executives> getAllExecutiveService()
	{
		List<Executives> allExecutives=null;
		allExecutives = template.query("SELECT LT.LD_USER_NAME FROM LD_TEAM LT JOIN USER_ROLE UR ON LT.UR_ID = UR.UR_ID WHERE UR_NAME = 'EXECUTOR'", new ExecutivesMapper());
		return allExecutives;
	}
	
	public int enterform3(int trfID, String executivename){
		  int ret = template.update("update IN_PROGRESS_TRAINING set IPT_ASSIGNED_EXEC=? where TRF_ID=?", new Object[]{executivename, trfID});
		  
		  return ret;
		 }
	
	public int updateconfirmedtraining(int trfid)
	{
		int ret1 = template.update("insert into confirmed_training select * from IN_PROGRESS_TRAINING where trf_id=?",new Object[]{trfid});
		template.update("update confirmed_training set OS_ID=6 where TRF_ID=?", new Object[]{trfid});
		return ret1;
	}
	
	public List<SecondTable> getThirdTableData(){
		List<SecondTable> thirdTabledata = template.query("select * from confirmed_training", new SecondTableMapper());
		return thirdTabledata;
	}
}