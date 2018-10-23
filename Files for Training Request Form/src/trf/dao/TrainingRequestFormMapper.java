package trf.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class TrainingRequestFormMapper implements RowMapper<TrainingRequestForm> {

	@Override
	public TrainingRequestForm mapRow(ResultSet result, int arg1) throws SQLException {
		TrainingRequestForm objRF = new TrainingRequestForm();
		objRF.setTrfID(result.getInt(1));
		objRF.setVerID(result.getInt(2));
		objRF.setVenID(result.getInt(3));
		objRF.setTtID(result.getInt(4));
		objRF.setTrfProjectID(result.getString(5));
		objRF.setTechnology(result.getString(6));
		objRF.setTrainingObjectives(result.getString(7));
		objRF.setDateRequested(result.getString(8));
		objRF.setProposedEndDate(result.getString(9));
		objRF.setProjectSPOC(result.getString(10));
		objRF.setAppxEmployees(result.getInt(11));
		objRF.setRequestorEmpID(result.getString(12));
		objRF.setFileLocation(result.getString(13));
		objRF.setTrainingSource(result.getInt(14));
		return objRF;
	}

}
