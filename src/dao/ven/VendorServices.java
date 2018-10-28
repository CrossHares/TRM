package dao.ven;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class VendorServices {

	JdbcTemplate template = (JdbcTemplate) new ClassPathXmlApplicationContext("spring-config.xml").getBean("jt");
	
	// Select All Vendors
	public List<Vendor> showAllVendorService()
	{
		JdbcTemplate temp = MyJDBCTemplate.getJdbcTemplate();
		List<Vendor> list = temp.query("SELECT * FROM VENDOR", new VendorMapper());
		return list;
	}
	
	
	// Insert New Vendor
	public int insertNewVendorService(String venName, String venLocation, String venAddress, String venSpoc, String venPhone, String venEmail)
	{
		int checkEmail= template.update("SELECT VEN_EMAIL FROM VENDOR WHERE VEN_EMAIL = ?",
				new Object[]{venEmail});
		if(checkEmail > 0)
		{
			return 0;
		}
		else
		{
			int ret = template.update("INSERT INTO VENDOR VALUES (gVenId.nextval,?,?,?,?,?,?)", 
					new Object[]{venName, venLocation, venAddress, venSpoc, venPhone, venEmail});
			return ret;
		}
	}
	
	
	// Delete Vendor
	public int deleteVendorService(int venId)
	{
		int ret = template.update("DELETE FROM VENDOR WHERE VEN_ID=?", 
				new Object[]{venId});
		return ret;
	}
	
	
	// Update Vendor
	public int updateVendorService(int venId, String venName, String venLocation, String venAddress, String venSpoc, String venPhone, String venEmail)
	{
		int ret = template.update("UPDATE VENDOR SET VEN_NAME = ?, VEN_LOCATION = ?, VEN_ADDRESS = ?, VEN_SPOC = ?,"
				+ "VEN_PHONE = ?, VEN_EMAIL = ? WHERE VEN_ID = ?", 
				new Object[]{venName, venLocation, venAddress, venSpoc, venPhone, venEmail, venId});
		return ret;
	}
	
	
	// Get Vendor
	public Vendor getVendor(int venId)
	{
		Vendor ven = (Vendor)template.queryForObject("SELECT * FROM VENDOR WHERE VEN_ID = ?", new Object[]{venId}, new VendorMapper());
		return ven;
	}
}
