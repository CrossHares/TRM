package dao.DashboardTables;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import dao.dashboard_firstTable.FirstTable;
import dao.dashboard_firstTable.FirstTableMapper;

public class NewRequestTableServices {
	JdbcTemplate template = (JdbcTemplate) new ClassPathXmlApplicationContext("spring-config.xml").getBean("jt");
	
	public List<NewRequestTable> getFirstTableData(String emailid){
		List<NewRequestTable> NewRequestTabledata  = template.query("SELECT * FROM TRAINING_REQUEST_FORM WHERE VER_ID = (SELECT V.VER_ID FROM VERTICAL_TYPE V JOIN LD_TEAM L ON V.VER_ID = L.LD_VER_REP WHERE LD_USER_EMAIL = ?) OR VER_ID IS NULL",new Object[]{emailid}, new NewRequestTableMapper());
		return NewRequestTabledata;
	}
	
//	public List<NewRequestTable> getFirstTableData(){
//		List<NewRequestTable> NewRequestTabledata = template.query("select * from TRAINING_REQUEST_FORM", new NewRequestTableMapper());
//		return NewRequestTabledata;
//	}
	
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
		template.update("update training_request_form set OS_ID=2 where TRF_ID=?", new Object[]{trfID});
		return ret;
	}
	
	public List<RequestInQueueTable> getSecondTableData(){
		List<RequestInQueueTable> RequestInQueuedata = template.query("select * from IN_PROGRESS_TRAINING", new RequestInQueueTableMapper());
		return RequestInQueuedata;
	}
	
	public int enterform1(int trfID){
		int ret = template.update("update IN_PROGRESS_TRAINING set TS_TRAINING_SOURCE=1,OS_ID=2 where trf_id=?", new Object[]{trfID});
		template.update("update training_request_form set TS_TRAINING_SOURCE=1,OS_ID=2 where trf_id=?", new Object[]{trfID});
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
		template.update("update training_request_form set OS_ID=6 where TRF_ID=?", new Object[]{trfid});
		template.update("update in_progress_training set OS_ID=6 where TRF_ID=?", new Object[]{trfid});
		return ret1;
	}
	
	public List<RequestInQueueTable> getThirdTableData(){
		List<RequestInQueueTable> thirdTabledata = template.query("select * from confirmed_training", new RequestInQueueTableMapper());
		return thirdTabledata;
	}
	
	public int deletebutton(int trfid){ 
		int ret = template.update("delete from training_request_form where trf_id=?",
				new Object[]{trfid}); 
		return ret; 
	}
	public int deletebutton2(int trfid){ 
		int ret = template.update("delete from in_progress_training where trf_id=?",
				new Object[]{trfid}); 
		return ret; 
	}

}
