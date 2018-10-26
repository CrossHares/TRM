package TRFByID;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class TRFbyReqIDMapper implements RowMapper<TRFbyReqID>{

	@Override
	public TRFbyReqID mapRow(ResultSet results, int arg1) throws SQLException {
		TRFbyReqID objTrfReq = new TRFbyReqID();
		objTrfReq.setReqEmail(results.getString(1));
		objTrfReq.setReqEmpID(results.getString(2));
		objTrfReq.setReqVer(results.getInt(3));
		objTrfReq.setReqName(results.getString(4));
		objTrfReq.setReqPhone(results.getString(5));
		objTrfReq.setReqPwd(results.getString(6));
		objTrfReq.setTrfVer(results.getInt(7));
		objTrfReq.setTrfID(results.getInt(8));
		
		return objTrfReq;
	}

}
