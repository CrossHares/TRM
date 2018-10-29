package ct.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class TrfMapper implements RowMapper<Trf>{

	@Override
	public Trf mapRow(ResultSet result, int arg1) throws SQLException {
		Trf obj = new Trf();
		obj.setTrfid(result.getInt(1));
		return obj;
	}

}
