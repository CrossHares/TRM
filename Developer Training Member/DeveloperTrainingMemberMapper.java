package mypro;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;


public class DeveloperTrainingMemberMapper implements RowMapper<DeveloperTrainingMember>{
	@Override
	public DeveloperTrainingMember mapRow(ResultSet result,int arg1) throws SQLException
	{
		DeveloperTrainingMember obj = new DeveloperTrainingMember();
		obj.setDtmId(result.getInt(1));
		obj.setVerId(result.getString(2));
		obj.setDtmName(result.getString(3));
		obj.setDtmPhone(result.getString(4));
		obj.setDtmEmail(result.getString(5));
		obj.setDtmEmployeeId(result.getString(6));
		return obj;
	}
}
