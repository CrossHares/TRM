package dao.Charts;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;


public class SPOCChartDataMapper implements RowMapper<SPOCChartData> 
{
	@Override
	public SPOCChartData mapRow(ResultSet arg0, int arg1) throws SQLException {

		SPOCChartData spocChartData = new SPOCChartData();
		spocChartData.setSPOCName(arg0.getString(1));
		spocChartData.setNumberOfTrainings(arg0.getInt(2));

		return spocChartData;
	}
}
