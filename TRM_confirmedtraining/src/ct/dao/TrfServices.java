package ct.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

public class TrfServices {

	
	public List<Trf> getAllTrf(){
		JdbcTemplate temp = MyJDBCTemplate.getJdbcTemplate();
		List<Trf> trflist = temp.query("SELECT TRF_ID FROM IN_PROGRESS_TRAINING WHERE TRF_ID NOT IN (SELECT I.TRF_ID FROM IN_PROGRESS_TRAINING I JOIN CONFIRMED_TRAINING C ON I.TRF_ID = C.TRF_ID) order by trf_id", new TrfMapper());
		return trflist;
	}
}
