package queries;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class VerticalSpocsMapper implements RowMapper<VerticalSpocs>{

	@Override
	public VerticalSpocs mapRow(ResultSet result, int arg1) throws SQLException {
		VerticalSpocs objVerSpoc = new VerticalSpocs();
		objVerSpoc.setVerID(result.getInt(1));
		objVerSpoc.setVerName(result.getString(2));
		objVerSpoc.setLdUserEmail(result.getString(3));
		objVerSpoc.setLdUserName(result.getString(4));
		objVerSpoc.setLdUserPhone(result.getString(5));
		objVerSpoc.setUrID(result.getInt(6));
		objVerSpoc.setUrName(result.getString(7));
		
		return objVerSpoc;
	}

}
