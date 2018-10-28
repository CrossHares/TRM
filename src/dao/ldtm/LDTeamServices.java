package dao.ldtm;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class LDTeamServices {
JdbcTemplate template = (JdbcTemplate) new ClassPathXmlApplicationContext("spring-config.xml").getBean("jt");
	
	// Select All LD Training Members
	public List<LDTeam> showAllTrainingMemberService()
	{
		JdbcTemplate temp = MyJDBCTemplate.getJdbcTemplate();
		List<LDTeam> list = temp.query("SELECT * FROM LD_TRAINING_MEMBER", new LDTeamMapper());
		return list;
	}
	
	
	// Insert New LD Training Member
	public int insertNewTrainingMemberService(String ldtmName, String ldtmLocation, String ldtmEmail, String ldtmPhone, String techSpecialty)
	{
		int checkEmail= template.update("SELECT LDTM_EMAIL FROM LD_TRAINING_MEMBER WHERE LDTM_EMAIL = ?",
				new Object[]{ldtmEmail});
		if(checkEmail > 0)
		{
			return 0;
		}
		else
		{
			int ret = template.update("INSERT INTO LD_TRAINING_MEMBER VALUES (gLdtmId.nextval,?,?,?,?,?)", 
					new Object[]{ldtmName, ldtmLocation, ldtmEmail, ldtmPhone, techSpecialty});
			return ret;
		}
	}
	
	
	// Delete LD Training Member
	public int deleteTrainingMemberService(int ldtmId)
	{
		int ret = template.update("DELETE FROM LD_TRAINING_MEMBER WHERE LDTM_ID = ?", 
				new Object[]{ldtmId});
		return ret;
	}
	
	
	// Update Training Member
	public int updateTrainingMemberService(int ldtmId, String ldtmName, String ldtmLocation, String ldtmEmail, String ldtmPhone, String techSpecialty)
	{
		int ret = template.update("UPDATE LD_TRAINING_MEMBER SET LDTM_NAME = ?, LDTM_LOCATION = ?, LDTM_EMAIL = ?, LDTM_PHONE = ?,"
				+ "LDTM_TECH_SPECIALTY = ? WHERE LDTM_ID = ?", 
				new Object[]{ldtmName, ldtmLocation, ldtmEmail, ldtmPhone, techSpecialty, ldtmId});
		return ret;
	}
	
	
	// Get Training Member
	public LDTeam getTrainingMember(int ldtmId)
	{
		LDTeam ldt = (LDTeam)template.queryForObject("SELECT * FROM LD_TRAINING_MEMBER WHERE LDTM_ID = ?", new Object[]{ldtmId}, new LDTeamMapper());
		return ldt;
	}
}
