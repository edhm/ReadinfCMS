package com.ehm.ReadingCMS.Repository;

import java.awt.print.Pageable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ehm.ReadingCMS.Model.Usuario;

import Mapper.UsuarioMapper;

@Repository
public class UsuarioRepository implements UsuarioRep {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public boolean save(Usuario usuario) {
		try {
			String sql = String.format(
					"INSERT INTO usuario( Nombre, Apellido, Contrasena, Correo, IdGrupo) VALUES('%d','%s','%s','%s','%s','%d') ",
					usuario.getNombre(), usuario.getApellido(), usuario.getContrasena(), usuario.getCorreo(),
					usuario.getIdGrupo());
			jdbcTemplate.execute(sql);
		} catch (Exception e) {
			return true;
		}
		return false;
	}

	@Override
	public boolean update(Usuario usuario) {
		if (usuario.getIdUsuario() > 0) {
			String sql = String.format(
					"UPDATE usuario SET  Nombre='%s', Apellido='%s', Contrasena='%s', Correo='%s', IdGrupo='%d'"
							+ "WHERE IdUsuario='%d'",
					usuario.getNombre(), usuario.getApellido(), usuario.getContrasena(), usuario.getCorreo(),
					usuario.getIdGrupo());
			jdbcTemplate.execute(sql);
			return true;
		}
		return false;
	}

	@Override
	public List<Usuario> findAll(Pageable pageable) {
		return jdbcTemplate.query("SELECT * FROM usuario ", new UsuarioMapper());
	}

	@SuppressWarnings("deprecation")
	@Override
	public Usuario finById(int Id) {
		Object[] params = new Object[] { Id };
		return jdbcTemplate.queryForObject("SELECT * FROM usuario WHERE IdUsuario=?", params, new UsuarioMapper());
	}
}
