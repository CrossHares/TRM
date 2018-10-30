package dao.ConfirmedTraining;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class ConfirmedTrainingServices {

	ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
	JdbcTemplate template = (JdbcTemplate)context.getBean("jt");
	
	public int updateAllocationResources(int trf_id, String ct_room_no, String ct_proposed_location)
	{
		int ret = template.update("UPDATE Confirmed_Training set CT_ROOM_NO = ?, CT_PROPOSED_LOCATION = ? WHERE trf_id = ?",
				new Object[]{ct_room_no, ct_proposed_location, trf_id});
		return ret;
	}
	
	public int submitAllocationResources(int trf_id, String ct_room_no, String ct_proposed_location)
	{
		int ret = template.update("UPDATE Confirmed_Training set CT_ROOM_NO = ?, CT_PROPOSED_LOCATION = ?, OS_ID = 7 WHERE trf_id = ?",
				new Object[]{ct_room_no, ct_proposed_location, trf_id});
		return ret;
	}
	
	
	public int sendEmail(int trf_id)
	{
		int ret = template.update("UPDATE Confirmed_Training set OS_ID = 8 WHERE trf_id = ?",
				new Object[]{trf_id});
		return ret;
	}

	
	
	public int completeTraining(int trf_id)
	{
		int ret = template.update("UPDATE Confirmed_Training set CT_HIDE_STATUS = 2 WHERE trf_id = ?",
				new Object[]{trf_id});
		return ret;
	}
	
	public ConfirmedTraining getTraining(int trf_id)
	{
		ConfirmedTraining ct = (ConfirmedTraining) template.queryForObject("Select * from Confirmed_Training where trf_id = ?",
				new Object[] {trf_id},
				new ConfirmedTrainingMapper());
		return ct;
	}
	
	public List<ConfirmedTraining> getAllTrainingService()
	{
		List<ConfirmedTraining> allTrainings;
		allTrainings = template.query("select * from Confirmed_Training", 
									  new ConfirmedTrainingMapper());
		return allTrainings;
	}
	
	public int getStatus(int trf_id)
	{
		List<ConfirmedTraining> list = template.query("Select OS_ID From Confirmed_training WHERE trf_id = ?",
				new Object[]{trf_id}, new ConfirmedTrainingMapper());
		int ret = list.get(0).getOs_id();
		return ret;
	}
}
