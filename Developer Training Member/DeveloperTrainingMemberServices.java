package mypro;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

public class DeveloperTrainingMemberServices {
	JdbcTemplate temp = MyJDBCTemplate.getJdbcTemplate();
	public List<DeveloperTrainingMember> getDtmList()
	{
		
		List<DeveloperTrainingMember> toReturn = temp.query("select * from developer_training_member", new DeveloperTrainingMemberMapper());
		return toReturn;
	}
	public int deleteDtmMember(int memid)
	{
		return temp.update("Delete from developer_training_member where dtm_id=?",new Object[]{memid});
		
	}
	public int updateDtmMember(int memid,String name,String phone, String email)
	{
		
		return temp.update("Update developer_training_member set dtm_name=?,dtm_phone=?,dtm_email=? where dtm_id=?",new Object[]{name,phone,email,memid});
	}
	public DeveloperTrainingMember getMember(int memid)
	{
		return temp.queryForObject("select * from developer_training_member where dtm_id=?",new Object[]{memid},new DeveloperTrainingMemberMapper());
	}

}
