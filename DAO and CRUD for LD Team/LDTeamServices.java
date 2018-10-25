package ldteam.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import trf.dao.MyJDBCTemplate;

public class LDTeamServices {
	
	JdbcTemplate temp = MyJDBCTemplate.getJdbcTemplate();
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
//Create
public int createLDT(String ldUserEmail, int ldVerRep, int urID, String ldUserName, String ldUserPhone, String ldUserPassword)
{
	int ret = temp.update("insert into LD_TEAM values(?,?,?,?,?,?)",
			new Object[]{ldUserEmail, ldVerRep, urID, ldUserName, ldUserPhone, ldUserPassword});
	return ret;
}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//Read
public List<LDTeam> readLDTeam()
{
	List<LDTeam> list = temp.query("select * from LD_TEAM", new LDTeamMapper());
	return list;
}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//Update
//Update All
public int updateLDT(String ldUserEmail, int ldVerRep, int urID, String ldUserName, String ldUserPhone, String ldUserPassword)
{
	int ret = temp.update("update LD_TEAM set LD_VER_REP=?. UR_ID=?, LD_USER_NAAME=?, LD_USER_PHONE=?, LD_USER_PASSWORD=? where LD_USER_EMAIL=?",
			new Object[]{ldVerRep, urID, ldUserName, ldUserPhone, ldUserPassword, ldUserEmail});
	return ret;
}

public int updateLDTvr(String ldUserEmail, int ldVerRep)
{
	int ret = temp.update("update LD_TEAM set LD_VER_REP=? where LD_USER_EMAIL=?",
			new Object[]{ldVerRep, ldUserEmail});
	return ret;
}

public int updateLDTurid(String ldUserEmail, int urID)
{
	int ret = temp.update("update LD_TEAM set UR_ID=? where LD_USER_EMAIL=?",
			new Object[]{urID, ldUserEmail});
	return ret;
}

public int updateLDTuserName(String ldUserEmail, String ldUserName)
{
	int ret = temp.update("update LD_TEAM set LD_USER_NAME=? where LD_USER_EMAIL=?",
			new Object[]{ldUserName, ldUserEmail});
	return ret;
}

public int updateLDTuserPassword(String ldUserEmail, String ldUserPassword)
{
	int ret = temp.update("update LD_TEAM set LD_USER_PASSWORD=? where LD_USER_EMAIL=?",
			new Object[]{ldUserPassword, ldUserEmail});
	return ret;
}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//Delete
public int deleteLDT(String ldUserEmail)
{
	int ret = temp.update("delete from LD_TEAM where LD_USER_EMAIL=?",
			new Object[]{ldUserEmail});
	return ret;
}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//Fetch
public LDTeam getLDT(String ldUserEmail)
{
	LDTeam ldt = (LDTeam)temp.queryForObject("select * from LD_TEAM where LD_USER_EMAIL=?", 
			new Object[]{ldUserEmail}, new LDTeamMapper());
	return ldt;
}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


public static void main(String[] args) {
	LDTeamServices obj = new LDTeamServices();
	System.out.println(obj.readLDTeam().size());
	
}
	

}
