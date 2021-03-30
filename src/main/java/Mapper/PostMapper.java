package Mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ehm.ReadingCMS.Model.Post;

public class PostMapper implements RowMapper<Post> {

	@Override
	public Post mapRow(ResultSet rs, int rowNum) throws SQLException {
		Post post = new Post();
		post.setCategoria(rs.getInt("Categoria"));
		post.setExtracto(rs.getString("Extracto"));
		post.setIdUsuario(rs.getInt("IdUsuario"));
		post.setImagenDestacada(rs.getString("ImagenDestacada"));
		post.setSlug(rs.getString("Slug"));
		post.setTipo(rs.getString("Tipo"));
		post.setTitulo(rs.getString("Titulo"));
		return null;
	}

}
