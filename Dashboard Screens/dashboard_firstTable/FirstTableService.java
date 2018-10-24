package dao.dashboard_firstTable;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import dao.dashboard_firstTable.*;


public class FirstTableService {
	JdbcTemplate template = (JdbcTemplate) new ClassPathXmlApplicationContext("spring-config.xml").getBean("jt");
	
	public List<FirstTable> getFirstTableData(){
		List<FirstTable> firstTabledata = template.query("select * from TRAINING_REQUEST_FORM order by TRF_DATE_REQUESTED ASC", new FirstTableMapper());
		return firstTabledata;
	}
	
	public int deleteFromFirstTable(int trfID){
		int ret = template.update("delete from TRAINING_REQUEST_FORM where TRF_ID=?", new Object[]{trfID});
		return ret;
	}
	
	public int createSecondTable(int trfID){
		int ret = template.update("insert into secondtable select * from TRAINING_REQUEST_FORM where TRF_ID=?", new Object[]{trfID});
		return ret;
	}
	
	public List<SecondTable> getSecondTableData(){
		List<SecondTable> secondTabledata = template.query("select * from secondtable", new SecondTableMapper());
		return secondTabledata;
	}
}