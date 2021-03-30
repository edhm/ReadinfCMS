package Mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ehm.ReadingCMS.Model.Usuario;

public class UsuarioMapper implements RowMapper<Usuario> {

	@Override
	public Usuario mapRow(ResultSet rs, int rowNum) throws SQLException {
		Usuario usuario = new Usuario();
		usuario.setApellido(rs.getString("Aoellido"));
		usuario.setContrasena(rs.getString("Contrasena"));
		usuario.setCorreo(rs.getString("Correo"));
		usuario.setIdGrupo(rs.getInt("IdGrupo"));
		usuario.setNombre(rs.getString("Nombre"));
		return null;
	}

}
