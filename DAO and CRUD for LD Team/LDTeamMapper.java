package ldteam.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class LDTeamMapper implements RowMapper<LDTeam>{

	@Override
	public LDTeam mapRow(ResultSet results, int arg1) throws SQLException {
		LDTeam ldt = new LDTeam();
		ldt.setLdUserEmail(results.getString(1));
		ldt.setLdVerRep(results.getInt(2));
		ldt.setUrID(results.getInt(3));
		ldt.setLdUserName(results.getString(4));
		ldt.setLdUserPhone(results.getString(5));
		ldt.setLdUserPassword(results.getString(6));
		
		return ldt;
	}
	

}
