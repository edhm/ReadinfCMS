package Mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ehm.ReadingCMS.Model.Comentario;

public class ComentarioMapper implements RowMapper<Comentario> {

	@Override
	public Comentario mapRow(ResultSet rs, int rowNum) throws SQLException {

		Comentario comentario = new Comentario();
		comentario.setComentario(rs.getString("Comentario"));
		comentario.setIdCOmentario(rs.getInt("IdComentario"));
		comentario.setFecha(rs.getDate("Fecha"));
		comentario.setIdpost(rs.getInt("Idpost"));
		comentario.setIdUsuario(rs.getInt("IdUsuario"));
		comentario.setRespuesta(rs.getString("Respuesta"));

		return null;
	}

}
