package Mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ehm.ReadingCMS.Model.Permiso;

public class PermisoMapper implements RowMapper<Permiso> {

	@Override
	public Permiso mapRow(ResultSet rs, int rowNum) throws SQLException {
		Permiso permiso = new Permiso();
		permiso.setNombre(rs.getString("Permiso"));
		return null;
	}

}
