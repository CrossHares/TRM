package dao.vendoremp;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class VendorEmpServices {

	JdbcTemplate template = (JdbcTemplate) new ClassPathXmlApplicationContext("spring-config.xml").getBean("jt");
	
	// Select All Vendor Employees
		public List<VendorEmp> showAllVendorEmployeeService()
		{
			JdbcTemplate temp = MyJDBCTemplate.getJdbcTemplate();
			List<VendorEmp> list = temp.query("SELECT * FROM VENDOR_EMPLOYEE", new VendorEmpMapper());
			return list;
		}
		
		// Insert New Vendor Employee
		public int insertNewVendorEmployeeService(int venId, String vEmpName, String vEmpEmail, String vEmpLocation, String vEmpAddress, String vEmpPhone, String vEmpSpecialty)
		{
			int checkEmail= template.update("SELECT VE_EMAIL FROM VENDOR_EMPLOYEE WHERE VE_EMAIL = ?",
					new Object[]{vEmpEmail});
			if(checkEmail > 0)
			{
				return 0;
			}
			else
			{
				int ret = template.update("INSERT INTO VENDOR_EMPLOYEE VALUES (gVenEmpId.nextval,?,?,?,?,?,?,?)", 
						new Object[]{venId, vEmpName, vEmpEmail, vEmpLocation, vEmpAddress, vEmpPhone, vEmpSpecialty});
				return ret;
			}
		}
		

		
		// Delete Vendor Employee
		public int deleteVendorEmployeeService(int vEmpId)
		{
			int ret = template.update("DELETE FROM VENDOR_EMPLOYEE WHERE VE_ID=?", 
					new Object[]{vEmpId});
			return ret;
		}
		
		
		// Update Vendor Employee
		public int updateVendorEmployeeService(int vEmpId, int venId, String vEmpName, String vEmpEmail, String vEmpLocation, String vEmpAddress, String vEmpPhone, String vEmpSpecialty)
		{
			int ret = template.update("UPDATE VENDOR_EMPLOYEE SET VEN_ID = ?, VE_NAME = ?, VE_EMAIL = ?, VE_LOCATION = ?, VE_ADDRESS = ?,"
					+ " VE_PHONE = ?, VE_TECH_SPECIALTY = ? WHERE VE_ID = ?",
					new Object[]{venId, vEmpName, vEmpEmail, vEmpLocation, vEmpAddress, vEmpPhone, vEmpSpecialty, vEmpId});
			return ret;
		}
		
		
		// Get Vendor Employee
		public VendorEmp getVendorEmployee(int vEmpId)
		{
			VendorEmp venEmp = (VendorEmp)template.queryForObject("SELECT * FROM VENDOR_EMPLOYEE WHERE VE_ID = ?", new Object[]{vEmpId}, new VendorEmpMapper());
			return venEmp;
		}
	}


