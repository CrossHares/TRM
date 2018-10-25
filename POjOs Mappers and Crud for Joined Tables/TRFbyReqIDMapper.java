package queries;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class TRFbyReqIDMapper implements RowMapper<TRFbyReqID>{

	@Override
	public TRFbyReqID mapRow(ResultSet results, int arg1) throws SQLException {
		TRFbyReqID objTrfReq = new TRFbyReqID();
		objTrfReq.setReqEmpID(results.getString(1));
		objTrfReq.setReqVer(results.getInt(2));
		objTrfReq.setReqName(results.getString(3));
		objTrfReq.setReqPhone(results.getString(4));
		objTrfReq.setReqPwd(results.getString(5));
		objTrfReq.setTrfVer(results.getInt(6));
		objTrfReq.setTrfID(results.getInt(7));
		
		return objTrfReq;
	}

}
