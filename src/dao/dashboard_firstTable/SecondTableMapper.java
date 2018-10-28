package dao.dashboard_firstTable;


import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;


public class SecondTableMapper implements RowMapper<SecondTable>{

	@Override
	public SecondTable mapRow(ResultSet result, int arg1) throws SQLException {
		SecondTable objRF = new SecondTable();
		objRF.setTrfID(result.getInt(1));
		objRF.setVerID(result.getInt(2));
		objRF.setVenID(result.getInt(3));
		objRF.setTtID(result.getInt(4));
		objRF.setOsID(result.getInt(5));
		objRF.setTrfProjectID(result.getString(6));
		objRF.setTechnology(result.getString(7));
		objRF.setTrainingObjectives(result.getString(8));
		objRF.setDateRequested(result.getDate(9));
		objRF.setProposedStartDate(result.getDate(10));
		objRF.setProposedEndDate(result.getDate(11));
		objRF.setStartTime(result.getString(12));
		objRF.setEndTime(result.getString(13));
		objRF.setLocation(result.getString(14));
		objRF.setRoomNo(result.getString(15));
		objRF.setLdtmid(result.getInt(16));
		objRF.setProjectSPOC(result.getString(17));
		objRF.setAppxEmployees(result.getInt(18));
		objRF.setRequestorEmpID(result.getString(19));
		objRF.setFileLocation(result.getString(20));
		objRF.setTrainingSource(result.getInt(21));
		objRF.setNominationfile(result.getString(22));
		objRF.setAssignedexecutive(result.getString(23));
		objRF.setHidestatus(result.getInt(24));
		objRF.setButtoncount(result.getInt(25));
		
		return objRF;
		
	}
}
