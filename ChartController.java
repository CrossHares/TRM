package chart.controller;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import dao.chartdata.ChartServices;

@Controller
public class ChartController {
	
	@RequestMapping(value="/")
	public String welcomeService()
	{
		return "welcome";
	}
	
	@RequestMapping(value="/showchartsview")
	public String viewChartsService(ModelMap SPOCChartDataMap)
	{
		ChartServices chartServices = new ChartServices();
		JSONObject chartData = chartServices.getChartData();
		SPOCChartDataMap.addAttribute(chartData);
		
		return "chartsview";
	}
	
	@RequestMapping(value="/showmodelmapview")
	public String modelMapTestService(ModelMap SPOCChartDataMap)
	{
		ChartServices chartServices = new ChartServices();
		JSONObject chartData = chartServices.getChartData();
		SPOCChartDataMap.addAttribute("spocChartData",chartData);
		System.out.println(SPOCChartDataMap);
		
		return "modelmaptest";
	}
	
	@RequestMapping(value="/showchartsfromjsonview")
	public String viewChartsFromJsonService(ModelMap SPOCChartDataMap)
	{
		ChartServices chartServices = new ChartServices();
		JSONObject chartData = chartServices.getSPOC_CoursesDataFromDb();
		SPOCChartDataMap.addAttribute("spocChartData",chartData);
		
		return "chartsfromjsonview";
	}

	@RequestMapping(value="/showspocrequestsreportview")
	public String viewSpocRequestsReportService(ModelMap SPOCChartDataMap)
	{
		ChartServices chartServices = new ChartServices();
		JSONObject chartData = chartServices.getLDName_TRCountFromDb();
		SPOCChartDataMap.addAttribute("spoc_requests_data", chartData);
		
		return "firstReport";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@RequestMapping(value="/showinteractivechartfromjsonview")
	public String viewInteractiveChartsFromJsonService(ModelMap SPOCChartDataMap)
	{
		ChartServices chartServices = new ChartServices();
		JSONObject chartData_1 = chartServices.getSPOC_CoursesDataFromDb_2();
		JSONObject chartData_2 = chartServices.getSPOC_CoursesDataFromDb_2_withMonths();
		
		//create and also send key set as list
		List<String> keysList = new ArrayList<String>();
		keysList.addAll(chartData_2.keySet());
		
		/*System.out.println(chartData_2.keySet());
		System.out.println(keysList);
		for (String k : keysList)
		{
			System.out.println(k);
		}
		
		
		String s[] = new String[keysList.size()*12];
		for (int i = 0; i<keysList.size(); i++)
		{
		//	s[i] =);
		}
		//System.out.println(s);*/
		
		
		SPOCChartDataMap.addAttribute("spocChartData_1",chartData_1);
		SPOCChartDataMap.addAttribute("spocChartData_2",chartData_2);
		SPOCChartDataMap.addAttribute("keysList", keysList);
		
		return "interactivechartview";
	}
	/*public static void main(String s[])
	{
		ChartController cc = new ChartController();
		cc.viewInteractiveChartsFromJsonService(null);
	}*/
}
