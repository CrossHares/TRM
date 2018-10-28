package dao.ldtm;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class LDTeamMapper implements RowMapper<LDTeam> {

	@Override
	public LDTeam mapRow(ResultSet result, int arg1) throws SQLException {
		// TODO Auto-generated method stub
		LDTeam objLDTeam = new LDTeam();
		objLDTeam.setLdtmId(result.getInt(1)); 
		objLDTeam.setLdtmName(result.getString(2));
		objLDTeam.setLdtmLocation(result.getString(3)); 
		objLDTeam.setLdtmEmail(result.getString(4)); 
		objLDTeam.setLdtmPhone(result.getString(5)); 
		objLDTeam.setTechSpecialty(result.getString(6)); 
		return objLDTeam;
	}

}
