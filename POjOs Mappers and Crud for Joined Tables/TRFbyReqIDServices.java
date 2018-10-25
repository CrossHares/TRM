package queries;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import trf.dao.MyJDBCTemplate;

public class TRFbyReqIDServices {
	
	JdbcTemplate temp = MyJDBCTemplate.getJdbcTemplate();
	
	public List<TRFbyReqID> readTRFbyReqID()
	{
		List<TRFbyReqID> list = temp.query("select * from TRF_BY_REQ_ID", new TRFbyReqIDMapper());
		return list;
	}

	public TRFbyReqID getTRFbyReqID(String reqEmpID)
	{
		TRFbyReqID trfByReqID = (TRFbyReqID)temp.queryForObject("select * from TRF_BY_REQ_ID where REQ_EMP_ID=?", 
				new Object[]{reqEmpID}, new TRFbyReqIDMapper());
		return trfByReqID;
	}

}
