package Mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ehm.ReadingCMS.Model.GrupoPermiso;

public class GrupoPermisoMapper implements RowMapper<GrupoPermiso> {

	@Override
	public GrupoPermiso mapRow(ResultSet rs, int rowNum) throws SQLException {
		GrupoPermiso grupoPermiso = new GrupoPermiso();
		grupoPermiso.setIdPermiso(rs.getInt("GrupoPermiso"));
		return null;
	}

}
