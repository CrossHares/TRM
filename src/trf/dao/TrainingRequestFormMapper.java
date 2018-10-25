package trf.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.jdbc.core.RowMapper;


public class TrainingRequestFormMapper implements RowMapper<TrainingRequestForm> {

	@Override
	public TrainingRequestForm mapRow(ResultSet result, int arg1) throws SQLException {
		TrainingRequestForm objRF = new TrainingRequestForm();
		
		objRF.setTrfID(result.getInt(1));
		objRF.setVerID(result.getInt(2));
		objRF.setVenID(result.getInt(3));
		objRF.setTtID(result.getInt(4));
		objRF.setTrfProjectID(result.getString(6));
		objRF.setTechnology(result.getString(7));
		objRF.setTrainingObjectives(result.getString(8));
		objRF.setDateRequested(result.getDate(9));
		objRF.setProposedEndDate(result.getDate(11));
		objRF.setProjectSPOC(result.getString(17));
		objRF.setAppxEmployees(result.getInt(18));
		objRF.setRequestorEmpID(result.getString(19));
		objRF.setFileLocation(result.getString(20));
		objRF.setTrainingSource(result.getInt(21));
		return objRF;
	}
}