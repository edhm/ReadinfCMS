package com.ehm.ReadingCMS.Repository;

import java.awt.print.Pageable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ehm.ReadingCMS.Model.Post;

import Mapper.PostMapper;

@Repository
public class PostRepository implements PostRep {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public boolean save(Post post) {
		try {
			String sql = String.format(
					"INSERT INTO post(Titulo, Slug,Extracto,IdUsuario,Categoria,ImagenDestacada, Tipo VALUES('%s','%s','%s','%d','%s','%s')",
					post.getTitulo(), post.getSlug(), post.getExtracto(), post.getIdUsuario(), post.getCategoria(),
					post.getImagenDestacada(), post.getTipo());
			jdbcTemplate.execute(sql);
		} catch (Exception e) {
			return true;
		}
		return false;
	}

	@Override
	public boolean update(Post post) {
		if (post.getIdPost() > 0) {
			String sql = String.format(
					"UPDATE post SET Titulo='%s', Slug='%s',Extracto='%s',IdUsuario'%d',Categoria='%s',ImagenDestacada='%s', Tipo='%s'"
							+ "WHERE IdPost='%d'",
					post.getTitulo(), post.getSlug(), post.getExtracto(), post.getIdUsuario(), post.getCategoria(),
					post.getImagenDestacada(), post.getTipo());
			jdbcTemplate.execute(sql);
			return true;
		}
		return false;
	}

	@Override
	public List<Post> findAll(Pageable pageable) {
		return jdbcTemplate.query("SELECT * FROM post", new PostMapper());
	}

	@SuppressWarnings("deprecation")
	@Override
	public Post finById(int Id) {
		Object[] params = new Object[] { Id };
		return jdbcTemplate.queryForObject("SELECT * FROM post WHERE IdPost=?", params, new PostMapper());
	}
}
