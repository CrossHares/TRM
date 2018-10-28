package dao.vendor;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class VendorMapper implements RowMapper<Vendor> {

	@Override
	public Vendor mapRow(ResultSet result, int arg1) throws SQLException {
		// TODO Auto-generated method stub
		Vendor objVendor = new  Vendor();
		objVendor.setVenId(result.getInt(1));
		objVendor.setVenName(result.getString(2));
		objVendor.setVenLocation(result.getString(3));
		objVendor.setVenAddress(result.getString(4));
		objVendor.setVenSpoc(result.getString(5));
		objVendor.setVenPhone(result.getString(6));
		objVendor.setVenEmail(result.getString(7));
		return objVendor;
	}
}
