package dao.vendoremp;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class VendorEmpMapper implements RowMapper<VendorEmp> {

	@Override
	public VendorEmp mapRow(ResultSet result, int arg1) throws SQLException {
		// TODO Auto-generated method stub
		VendorEmp vendEmpObj = new VendorEmp();
		vendEmpObj.setvEmpId(result.getInt(1));
		vendEmpObj.setVenId(result.getInt(2));
		vendEmpObj.setvEmpName(result.getString(3));
		vendEmpObj.setvEmpEmail(result.getString(4));
		vendEmpObj.setvEmpLocation(result.getString(5));
		vendEmpObj.setvEmpAddress(result.getString(6));
		vendEmpObj.setvEmpPhone(result.getString(7));
		vendEmpObj.setvEmpSpecialty(result.getString(8));
		return vendEmpObj;
	}

}
