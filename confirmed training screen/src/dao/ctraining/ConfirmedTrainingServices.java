package dao.ctraining;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import dao.ctraining.ConfirmedTraining;
import dao.ctraining.ConfirmedTrainingMapper;


public class ConfirmedTrainingServices {

	JdbcTemplate temp = (JdbcTemplate) new ClassPathXmlApplicationContext("SpringConfig.xml").getBean("jt");

	public int insert(int tt_id, String ld_user_email, String ctlocation) { 

		int ret = temp.update("insert into confirmed_training values(gctid.nextval,tt_id,ld_user_email,?,?,?,?,?,?,ctlocation,?)", 
				new Object[]{ tt_id, ld_user_email, ctlocation});
		return ret;	
	}

	public List<ConfirmedTraining> read(){

		List<ConfirmedTraining> list = temp.query("select * from confirmed_training", new ConfirmedTrainingMapper());
		return list;
	}

	public int update(int ctid,String name) { //in progress
		System.out.println("update function");	
		
		int ret = temp.update("update confirmed_training set name = ? where ct_id=?",
				new Object[] {name,ctid});
		return ret;
	}


	public int delete(int ctid) {

		int ret = temp.update("delete from confirmed_training where ct_id=?", ctid);	
		return ret;
	}
	
	public ConfirmedTraining getConfirmedTraining(int ctid){
		
		ConfirmedTraining ct = temp.queryForObject("select * from confirmed_training where ct_id=?", 
				new Object[]{ctid},
				new ConfirmedTrainingMapper());
		return ct;
	}
}
