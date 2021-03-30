package Mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ehm.ReadingCMS.Model.Contenido;

public class ContenidoMapper implements RowMapper<Contenido> {

	@Override
	public Contenido mapRow(ResultSet rs, int rowNum) throws SQLException {
		Contenido contenido = new Contenido();
		contenido.setContenido(rs.getString("Contenido"));
		contenido.setIdPost(rs.getInt("IdPost"));
		contenido.setTipo(rs.getString("Tipo"));
		return null;
	}

}
