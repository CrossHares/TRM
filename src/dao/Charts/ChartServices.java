package dao.Charts;

import org.json.simple.*;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.ResultSet;
import java.util.*;

public class ChartServices {
	
	JdbcTemplate template = (JdbcTemplate) new ClassPathXmlApplicationContext("spring-config.xml").getBean("jt");
	
	public JSONObject getLDName_TRCountFromDb()
	{
		JSONObject json = new JSONObject();
		
		List<SPOCChartData> resultList = template.query("SELECT LT.LD_USER_NAME, COUNT(TRF.TRF_ID) FROM TRAINING_REQUEST_FORM TRF JOIN VERTICAL_TYPE VT ON TRF.VER_ID = VT.VER_ID JOIN LD_TEAM LT ON VT.VER_ID = LT.LD_VER_REP WHERE TRF.TRF_DATE_REQUESTED > to_date('30-09-2018', 'dd-MM-yyyy') AND TRF.TRF_DATE_REQUESTED < to_date('01-11-2018', 'dd-MM-yyyy') GROUP BY LT.LD_USER_NAME", new SPOCChartDataMapper());
		
		for(SPOCChartData r : resultList)
		{
			json.put(r.getSPOCName(), r.getNumberOfTrainings());
		}
		return json;
	}
	
	public JSONObject getVerticalWiseRequestData()
	{
		JSONObject json = new JSONObject();
		
		List<SPOCChartData> resultList = template.query("SELECT VT.VER_NAME, COUNT(CT.TRF_ID)\r\n" + 
				"FROM CONFIRMED_TRAINING CT\r\n" + 
				"JOIN VERTICAL_TYPE VT\r\n" + 
				"ON CT.VER_ID = VT.VER_ID\r\n" + 
				"WHERE CT.CT_PROPOSED_END_DATE < sysdate\r\n" + 
				"AND EXTRACT(MONTH FROM CT.CT_PROPOSED_END_DATE) IN (10)\r\n" + 
				"GROUP BY VT.VER_NAME",new SPOCChartDataMapper());
				
		for(SPOCChartData r : resultList)
		{
			json.put(r.getSPOCName(), r.getNumberOfTrainings());
		}
		return json;
	}
	
	public String getIDVForSPOC_clinton()
	{
		//int i_for_spoc = template.
		
		int i = template.queryForInt("  SELECT COUNT(TRF.TRF_ID)\r\n" + 
				"  FROM TRAINING_REQUEST_FORM TRF\r\n" + 
				"  JOIN VERTICAL_TYPE VT\r\n" + 
				"  ON TRF.VER_ID = VT.VER_ID\r\n" + 
				"  JOIN LD_TEAM LT\r\n" + 
				"  ON VT.VER_ID = LT.LD_VER_REP\r\n" + 
				"  WHERE LT.LD_USER_NAME = 'CLINTON EXODIA'\r\n" + 
				"	AND TRF.TS_TRAINING_SOURCE = '1'\r\n" + 
				"	AND TRF.TRF_DATE_REQUESTED > to_date('30-09-2018', 'dd-MM-yyyy')\r\n" + 
				"	AND TRF.TRF_DATE_REQUESTED < to_date('01-11-2018', 'dd-MM-yyyy')");
		 
		int d = template.queryForInt("  SELECT COUNT(TRF.TRF_ID)\r\n" + 
				"  FROM TRAINING_REQUEST_FORM TRF\r\n" + 
				"  JOIN VERTICAL_TYPE VT\r\n" + 
				"  ON TRF.VER_ID = VT.VER_ID\r\n" + 
				"  JOIN LD_TEAM LT\r\n" + 
				"  ON VT.VER_ID = LT.LD_VER_REP\r\n" + 
				"  WHERE LT.LD_USER_NAME = 'CLINTON EXODIA'\r\n" + 
				"	AND TRF.TS_TRAINING_SOURCE = '2'\r\n" + 
				"	AND TRF.TRF_DATE_REQUESTED > to_date('30-09-2018', 'dd-MM-yyyy')\r\n" + 
				"	AND TRF.TRF_DATE_REQUESTED < to_date('01-11-2018', 'dd-MM-yyyy')");
		
		int v = template.queryForInt("  SELECT COUNT(TRF.TRF_ID)\r\n" + 
				"  FROM TRAINING_REQUEST_FORM TRF\r\n" + 
				"  JOIN VERTICAL_TYPE VT\r\n" + 
				"  ON TRF.VER_ID = VT.VER_ID\r\n" + 
				"  JOIN LD_TEAM LT\r\n" + 
				"  ON VT.VER_ID = LT.LD_VER_REP\r\n" + 
				"  WHERE LT.LD_USER_NAME = 'CLINTON EXODIA'\r\n" + 
				"	AND TRF.TS_TRAINING_SOURCE = '3'\r\n" + 
				"	AND TRF.TRF_DATE_REQUESTED > to_date('30-09-2018', 'dd-MM-yyyy')\r\n" + 
				"	AND TRF.TRF_DATE_REQUESTED < to_date('01-11-2018', 'dd-MM-yyyy')");
		
		int[] idvForSPOC = new int[]{i,d,v};
		
		//System.out.println(Arrays.toString(idvForSPOC));
		
		return Arrays.toString(idvForSPOC);
	}
	
	public String getIDVForSPOC_tyberius()
	{
		//int i_for_spoc = template.
		
		int i = template.queryForInt("  SELECT COUNT(TRF.TRF_ID)\r\n" + 
				"  FROM TRAINING_REQUEST_FORM TRF\r\n" + 
				"  JOIN VERTICAL_TYPE VT\r\n" + 
				"  ON TRF.VER_ID = VT.VER_ID\r\n" + 
				"  JOIN LD_TEAM LT\r\n" + 
				"  ON VT.VER_ID = LT.LD_VER_REP\r\n" + 
				"  WHERE LT.LD_USER_NAME = 'TYBERIUS MAXIMUS'\r\n" + 
				"	AND TRF.TS_TRAINING_SOURCE = '1'\r\n" + 
				"	AND TRF.TRF_DATE_REQUESTED > to_date('30-09-2018', 'dd-MM-yyyy')\r\n" + 
				"	AND TRF.TRF_DATE_REQUESTED < to_date('01-11-2018', 'dd-MM-yyyy')");
		 
		int d = template.queryForInt("  SELECT COUNT(TRF.TRF_ID)\r\n" + 
				"  FROM TRAINING_REQUEST_FORM TRF\r\n" + 
				"  JOIN VERTICAL_TYPE VT\r\n" + 
				"  ON TRF.VER_ID = VT.VER_ID\r\n" + 
				"  JOIN LD_TEAM LT\r\n" + 
				"  ON VT.VER_ID = LT.LD_VER_REP\r\n" + 
				"  WHERE LT.LD_USER_NAME = 'TYBERIUS MAXIMUS'\r\n" + 
				"	AND TRF.TS_TRAINING_SOURCE = '2'\r\n" + 
				"	AND TRF.TRF_DATE_REQUESTED > to_date('30-09-2018', 'dd-MM-yyyy')\r\n" + 
				"	AND TRF.TRF_DATE_REQUESTED < to_date('01-11-2018', 'dd-MM-yyyy')");
		
		int v = template.queryForInt("  SELECT COUNT(TRF.TRF_ID)\r\n" + 
				"  FROM TRAINING_REQUEST_FORM TRF\r\n" + 
				"  JOIN VERTICAL_TYPE VT\r\n" + 
				"  ON TRF.VER_ID = VT.VER_ID\r\n" + 
				"  JOIN LD_TEAM LT\r\n" + 
				"  ON VT.VER_ID = LT.LD_VER_REP\r\n" + 
				"  WHERE LT.LD_USER_NAME = 'TYBERIUS MAXIMUS'\r\n" + 
				"	AND TRF.TS_TRAINING_SOURCE = '3'\r\n" + 
				"	AND TRF.TRF_DATE_REQUESTED > to_date('30-09-2018', 'dd-MM-yyyy')\r\n" + 
				"	AND TRF.TRF_DATE_REQUESTED < to_date('01-11-2018', 'dd-MM-yyyy')");
		
		int[] idvForSPOC = new int[]{i,d,v};
		
		//System.out.println(Arrays.toString(idvForSPOC));
		
		return Arrays.toString(idvForSPOC);
	}
	
	public String getIDVForSPOC_jerimahia()
	{
		//int i_for_spoc = template.
		
		int i = template.queryForInt("  SELECT COUNT(TRF.TRF_ID)\r\n" + 
				"  FROM TRAINING_REQUEST_FORM TRF\r\n" + 
				"  JOIN VERTICAL_TYPE VT\r\n" + 
				"  ON TRF.VER_ID = VT.VER_ID\r\n" + 
				"  JOIN LD_TEAM LT\r\n" + 
				"  ON VT.VER_ID = LT.LD_VER_REP\r\n" + 
				"  WHERE LT.LD_USER_NAME = 'JERIMAHIA STEVENSON'\r\n" + 
				"	AND TRF.TS_TRAINING_SOURCE = '1'\r\n" + 
				"	AND TRF.TRF_DATE_REQUESTED > to_date('30-09-2018', 'dd-MM-yyyy')\r\n" + 
				"	AND TRF.TRF_DATE_REQUESTED < to_date('01-11-2018', 'dd-MM-yyyy')");
		 
		int d = template.queryForInt("  SELECT COUNT(TRF.TRF_ID)\r\n" + 
				"  FROM TRAINING_REQUEST_FORM TRF\r\n" + 
				"  JOIN VERTICAL_TYPE VT\r\n" + 
				"  ON TRF.VER_ID = VT.VER_ID\r\n" + 
				"  JOIN LD_TEAM LT\r\n" + 
				"  ON VT.VER_ID = LT.LD_VER_REP\r\n" + 
				"  WHERE LT.LD_USER_NAME = 'JERIMAHIA STEVENSON'\r\n" + 
				"	AND TRF.TS_TRAINING_SOURCE = '2'\r\n" + 
				"	AND TRF.TRF_DATE_REQUESTED > to_date('30-09-2018', 'dd-MM-yyyy')\r\n" + 
				"	AND TRF.TRF_DATE_REQUESTED < to_date('01-11-2018', 'dd-MM-yyyy')");
		
		int v = template.queryForInt("  SELECT COUNT(TRF.TRF_ID)\r\n" + 
				"  FROM TRAINING_REQUEST_FORM TRF\r\n" + 
				"  JOIN VERTICAL_TYPE VT\r\n" + 
				"  ON TRF.VER_ID = VT.VER_ID\r\n" + 
				"  JOIN LD_TEAM LT\r\n" + 
				"  ON VT.VER_ID = LT.LD_VER_REP\r\n" + 
				"  WHERE LT.LD_USER_NAME = 'JERIMAHIA STEVENSON'\r\n" + 
				"	AND TRF.TS_TRAINING_SOURCE = '3'\r\n" + 
				"	AND TRF.TRF_DATE_REQUESTED > to_date('30-09-2018', 'dd-MM-yyyy')\r\n" + 
				"	AND TRF.TRF_DATE_REQUESTED < to_date('01-11-2018', 'dd-MM-yyyy')");
		
		int[] idvForSPOC = new int[]{i,d,v};
		
		//System.out.println(Arrays.toString(idvForSPOC));
		
		return Arrays.toString(idvForSPOC);
	}
	
	public String getIDVForSPOC_jose()
	{
		//int i_for_spoc = template.
		
		int i = template.queryForInt("  SELECT COUNT(TRF.TRF_ID)\r\n" + 
				"  FROM TRAINING_REQUEST_FORM TRF\r\n" + 
				"  JOIN VERTICAL_TYPE VT\r\n" + 
				"  ON TRF.VER_ID = VT.VER_ID\r\n" + 
				"  JOIN LD_TEAM LT\r\n" + 
				"  ON VT.VER_ID = LT.LD_VER_REP\r\n" + 
				"  WHERE LT.LD_USER_NAME = 'JOSE MOUNTAIN'\r\n" + 
				"	AND TRF.TS_TRAINING_SOURCE = '1'\r\n" + 
				"	AND TRF.TRF_DATE_REQUESTED > to_date('30-09-2018', 'dd-MM-yyyy')\r\n" + 
				"	AND TRF.TRF_DATE_REQUESTED < to_date('01-11-2018', 'dd-MM-yyyy')");
		 
		int d = template.queryForInt("  SELECT COUNT(TRF.TRF_ID)\r\n" + 
				"  FROM TRAINING_REQUEST_FORM TRF\r\n" + 
				"  JOIN VERTICAL_TYPE VT\r\n" + 
				"  ON TRF.VER_ID = VT.VER_ID\r\n" + 
				"  JOIN LD_TEAM LT\r\n" + 
				"  ON VT.VER_ID = LT.LD_VER_REP\r\n" + 
				"  WHERE LT.LD_USER_NAME = 'JOSE MOUNTAIN'\r\n" + 
				"	AND TRF.TS_TRAINING_SOURCE = '2'\r\n" + 
				"	AND TRF.TRF_DATE_REQUESTED > to_date('30-09-2018', 'dd-MM-yyyy')\r\n" + 
				"	AND TRF.TRF_DATE_REQUESTED < to_date('01-11-2018', 'dd-MM-yyyy')");
		
		int v = template.queryForInt("  SELECT COUNT(TRF.TRF_ID)\r\n" + 
				"  FROM TRAINING_REQUEST_FORM TRF\r\n" + 
				"  JOIN VERTICAL_TYPE VT\r\n" + 
				"  ON TRF.VER_ID = VT.VER_ID\r\n" + 
				"  JOIN LD_TEAM LT\r\n" + 
				"  ON VT.VER_ID = LT.LD_VER_REP\r\n" + 
				"  WHERE LT.LD_USER_NAME = 'JOSE MOUNTAIN'\r\n" + 
				"	AND TRF.TS_TRAINING_SOURCE = '3'\r\n" + 
				"	AND TRF.TRF_DATE_REQUESTED > to_date('30-09-2018', 'dd-MM-yyyy')\r\n" + 
				"	AND TRF.TRF_DATE_REQUESTED < to_date('01-11-2018', 'dd-MM-yyyy')");
		
		int[] idvForSPOC = new int[]{i,d,v};
		
		//System.out.println(Arrays.toString(idvForSPOC));
		
		return Arrays.toString(idvForSPOC);
	}
	
	public String getIDVForSPOC_mike()
	{
		//int i_for_spoc = template.
		
		int i = template.queryForInt("  SELECT COUNT(TRF.TRF_ID)\r\n" + 
				"  FROM TRAINING_REQUEST_FORM TRF\r\n" + 
				"  JOIN VERTICAL_TYPE VT\r\n" + 
				"  ON TRF.VER_ID = VT.VER_ID\r\n" + 
				"  JOIN LD_TEAM LT\r\n" + 
				"  ON VT.VER_ID = LT.LD_VER_REP\r\n" + 
				"  WHERE LT.LD_USER_NAME = 'MIKE XAVIER'\r\n" + 
				"	AND TRF.TS_TRAINING_SOURCE = '1'\r\n" + 
				"	AND TRF.TRF_DATE_REQUESTED > to_date('30-09-2018', 'dd-MM-yyyy')\r\n" + 
				"	AND TRF.TRF_DATE_REQUESTED < to_date('01-11-2018', 'dd-MM-yyyy')");
		 
		int d = template.queryForInt("  SELECT COUNT(TRF.TRF_ID)\r\n" + 
				"  FROM TRAINING_REQUEST_FORM TRF\r\n" + 
				"  JOIN VERTICAL_TYPE VT\r\n" + 
				"  ON TRF.VER_ID = VT.VER_ID\r\n" + 
				"  JOIN LD_TEAM LT\r\n" + 
				"  ON VT.VER_ID = LT.LD_VER_REP\r\n" + 
				"  WHERE LT.LD_USER_NAME = 'MIKE XAVIER'\r\n" + 
				"	AND TRF.TS_TRAINING_SOURCE = '2'\r\n" + 
				"	AND TRF.TRF_DATE_REQUESTED > to_date('30-09-2018', 'dd-MM-yyyy')\r\n" + 
				"	AND TRF.TRF_DATE_REQUESTED < to_date('01-11-2018', 'dd-MM-yyyy')");
		
		int v = template.queryForInt("  SELECT COUNT(TRF.TRF_ID)\r\n" + 
				"  FROM TRAINING_REQUEST_FORM TRF\r\n" + 
				"  JOIN VERTICAL_TYPE VT\r\n" + 
				"  ON TRF.VER_ID = VT.VER_ID\r\n" + 
				"  JOIN LD_TEAM LT\r\n" + 
				"  ON VT.VER_ID = LT.LD_VER_REP\r\n" + 
				"  WHERE LT.LD_USER_NAME = 'MIKE XAVIER'\r\n" + 
				"	AND TRF.TS_TRAINING_SOURCE = '3'\r\n" + 
				"	AND TRF.TRF_DATE_REQUESTED > to_date('30-09-2018', 'dd-MM-yyyy')\r\n" + 
				"	AND TRF.TRF_DATE_REQUESTED < to_date('01-11-2018', 'dd-MM-yyyy')");
		
		int[] idvForSPOC = new int[]{i,d,v};
		
		//System.out.println(Arrays.toString(idvForSPOC));
		
		return Arrays.toString(idvForSPOC);
	}
	
	public String getIDVForSPOC_shaq()
	{
		//int i_for_spoc = template.
		
		int i = template.queryForInt("  SELECT COUNT(TRF.TRF_ID)\r\n" + 
				"  FROM TRAINING_REQUEST_FORM TRF\r\n" + 
				"  JOIN VERTICAL_TYPE VT\r\n" + 
				"  ON TRF.VER_ID = VT.VER_ID\r\n" + 
				"  JOIN LD_TEAM LT\r\n" + 
				"  ON VT.VER_ID = LT.LD_VER_REP\r\n" + 
				"  WHERE LT.LD_USER_NAME = 'SHAQ LEWIS'\r\n" + 
				"	AND TRF.TS_TRAINING_SOURCE = '1'\r\n" + 
				"	AND TRF.TRF_DATE_REQUESTED > to_date('30-09-2018', 'dd-MM-yyyy')\r\n" + 
				"	AND TRF.TRF_DATE_REQUESTED < to_date('01-11-2018', 'dd-MM-yyyy')");
		 
		int d = template.queryForInt("  SELECT COUNT(TRF.TRF_ID)\r\n" + 
				"  FROM TRAINING_REQUEST_FORM TRF\r\n" + 
				"  JOIN VERTICAL_TYPE VT\r\n" + 
				"  ON TRF.VER_ID = VT.VER_ID\r\n" + 
				"  JOIN LD_TEAM LT\r\n" + 
				"  ON VT.VER_ID = LT.LD_VER_REP\r\n" + 
				"  WHERE LT.LD_USER_NAME = 'SHAQ LEWIS'\r\n" + 
				"	AND TRF.TS_TRAINING_SOURCE = '2'\r\n" + 
				"	AND TRF.TRF_DATE_REQUESTED > to_date('30-09-2018', 'dd-MM-yyyy')\r\n" + 
				"	AND TRF.TRF_DATE_REQUESTED < to_date('01-11-2018', 'dd-MM-yyyy')");
		
		int v = template.queryForInt("  SELECT COUNT(TRF.TRF_ID)\r\n" + 
				"  FROM TRAINING_REQUEST_FORM TRF\r\n" + 
				"  JOIN VERTICAL_TYPE VT\r\n" + 
				"  ON TRF.VER_ID = VT.VER_ID\r\n" + 
				"  JOIN LD_TEAM LT\r\n" + 
				"  ON VT.VER_ID = LT.LD_VER_REP\r\n" + 
				"  WHERE LT.LD_USER_NAME = 'SHAQ LEWIS'\r\n" + 
				"	AND TRF.TS_TRAINING_SOURCE = '3'\r\n" + 
				"	AND TRF.TRF_DATE_REQUESTED > to_date('30-09-2018', 'dd-MM-yyyy')\r\n" + 
				"	AND TRF.TRF_DATE_REQUESTED < to_date('01-11-2018', 'dd-MM-yyyy')");
		
		int[] idvForSPOC = new int[]{i,d,v};
		
		//System.out.println(Arrays.toString(idvForSPOC));
		
		return Arrays.toString(idvForSPOC);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*public JSONObject getChartData()
	{
		
		//query database for json here
		JSONObject json = new JSONObject();
		json.put("Mahesh", new Integer(8));
		json.put("Michael", new Integer(5));
		json.put("Jennifer", new Integer(7));
		json.put("Abdul", new Integer(4));
		
		return json;
	}*/
	
}
