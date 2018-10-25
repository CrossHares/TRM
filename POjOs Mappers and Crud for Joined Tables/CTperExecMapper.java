package queries;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class CTperExecMapper implements RowMapper<CTperExec>{

	@Override
	public CTperExec mapRow(ResultSet result, int arg1) throws SQLException {
		CTperExec objCtPerExec = new CTperExec();
		objCtPerExec.setCtID(result.getInt(1));
		objCtPerExec.setLdUserEmail(result.getString(2));
		objCtPerExec.setVerID(result.getInt(3));
		return objCtPerExec;
	}
	

}
