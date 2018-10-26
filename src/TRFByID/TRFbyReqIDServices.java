package TRFByID;

import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import trf.dao.MyJDBCTemplate;

public class TRFbyReqIDServices {
	
	JdbcTemplate temp = MyJDBCTemplate.getJdbcTemplate();
	List<TRFbyReqID> tRFsForReq = new ArrayList<TRFbyReqID>();
	
	
	public int getTrfbyReqIDCount(String reqEmpID)
	{
		//String select_count = "SELECT COUNT(*) FROM TRF_BY_REQ_ID WHERE REQ_EMP_ID= ?";
		//SqlParameterSource namedParameters = new MapSqlParameterSource("?", reqEmpID);
		return temp.queryForInt("SELECT COUNT(*) FROM TRF_BY_REQ_ID WHERE REQ_EMP_ID= ?", new Object[]{reqEmpID});
	}
	
	public List<TRFbyReqID> readTRFbyReqID()
	{
		List<TRFbyReqID> list = temp.query("select * from TRF_BY_REQ_ID", new TRFbyReqIDMapper());
		return list;
	}

	public List<TRFbyReqID> getTRFbyReqID(String reqEmpID)
	{
		int numTRF = getTrfbyReqIDCount(reqEmpID);
		
		while(numTRF>0)
		{
			TRFbyReqID trfByReqID = (TRFbyReqID)temp.queryForObject("select * from TRF_BY_REQ_ID where REQ_EMP_ID=?", 
					new Object[]{reqEmpID}, new TRFbyReqIDMapper());
			tRFsForReq.add(trfByReqID);
			numTRF = numTRF-1;
		}
		
		return tRFsForReq;
	}
	
	
	
	public static void main(String args[]){
		TRFbyReqIDServices obj = new TRFbyReqIDServices();
		System.out.println(obj.getTrfbyReqIDCount("DL88272"));
		System.out.println(obj.getTRFbyReqID("DL88272").size());
		
	}
	

}



