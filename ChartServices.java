package dao.chartdata;

import org.json.simple.*;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.ResultSet;
import java.util.*;

public class ChartServices {
	
	JdbcTemplate template = (JdbcTemplate) new ClassPathXmlApplicationContext("spring-config.xml").getBean("jt");
	
	public JSONObject getChartData()
	{
		
		//query database for json here
		JSONObject json = new JSONObject();
		json.put("Mahesh", new Integer(8));
		json.put("Michael", new Integer(5));
		json.put("Jennifer", new Integer(7));
		json.put("Abdul", new Integer(4));
		
		return json;
	}
	

	
	//made table for joses example data
	public JSONObject getSPOC_CoursesDataFromDb_2()
	{
		JSONObject json = new JSONObject();
		
		List<SPOCChartData> resultList = template.query("select * from spoc_courses_jose_1",new SPOCChartDataMapper());
		//todo: make table, insert joses data		
		
		for(SPOCChartData r : resultList)
		{
			json.put(r.getSPOCName(), r.getNumberOfTrainings());
		}
		return json;
	}
	
	//made table for joses example data
	public JSONObject getSPOC_CoursesDataFromDb_2_withMonths()
	{
		JSONObject json = new JSONObject();
		JSONObject trainings_in_month = new JSONObject();
		
		List<SPOCChartDataWithMonths> resultList = template.query("select * from spoc_courses_jose_2",new SPOCChartDataWithMonthsMapper());
		//todo: make table, insert joses data		
		
		for(SPOCChartDataWithMonths r : resultList)
		{
			trainings_in_month.put(r.getMonth(), r.getNumberOfTrainings());
			json.put(r.getSPOCName(), trainings_in_month);
		}
		return json;
	}

	
	public JSONObject getSPOC_CoursesDataFromDb()
	{
		JSONObject json = new JSONObject();
		
		List<SPOCChartData> resultList = template.query("select * from spoc_courses",new SPOCChartDataMapper());
				
		for(SPOCChartData r : resultList)
		{
			json.put(r.getSPOCName(), r.getNumberOfTrainings());
		}
		return json;
	}
	
	
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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*public static void main(String s[])
	{
		ChartServices cs = new ChartServices();
		JSONObject json = cs.getSPOC_CoursesDataFromDb_2_withMonths();
		//System.out.println(cs.getSPOC_CoursesDataFromDb());
		//System.out.println(cs.getSPOC_CoursesDataFromDb_2_withMonths());
		Set<String> keys;
		keys = json.keySet();
		/*for (String k : keys)
		{
			for(String s : json.get(k))
			{
				
			}
			System.out.println(k);
		}
		for (int i = 0; i<json.size(); i++)
		{
			
		}
		
	}*/
	
}
