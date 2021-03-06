package com.ehm.ReadingCMS.Repository;

import java.awt.print.Pageable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ehm.ReadingCMS.Model.Comentario;

import Mapper.CategoriaMapper;
import Mapper.ComentarioMapper;

@Repository
public class ComentarioRepository implements ComentarioRep {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public boolean save(Comentario comentario) {
		try {
			String sql = String.format(
					"INSERT INTO comentario(Comentario, IdPost, IdUsuario, Respuesta)"
							+ "values('%s', '%d', '%d', '%s')",
					comentario.getComentario(), comentario.getIdpost(), comentario.getIdUsuario(),
					comentario.getRespuesta());
			jdbcTemplate.execute(sql);
			return true;

		} catch (Exception e) {
			return false;
		}

	}

	@Override
	public boolean update(Comentario comentario) {
		if (comentario.getIdCOmentario() > 0) {
			String sql = String.format(
					"update Comentario set Comentario='%s', IdPost='%d', IdUsuario='%d', Respuesta='%s'"
							+ "where IdCOmentario='%d'",
					comentario.getComentario(), comentario.getIdpost(), comentario.getIdUsuario(),
					comentario.getRespuesta());

			jdbcTemplate.execute(sql);
			return true;
		}
		return false;
	}

	@Override
	public List<Comentario> findAll(Pageable pageable) {

		return jdbcTemplate.query("SELECT * FROM Comentario", new ComentarioMapper());
	}

	@SuppressWarnings("deprecation")
	@Override
	public Comentario finById(int Id) {
		Object[] params = new Object[] { Id };
		return jdbcTemplate.queryForObject("SELECT * FROM Comentario WHERE IdComentario= ?", params,
				new ComentarioMapper());
	}
}
