package com.ehm.ReadingCMS.Repository;

import java.awt.print.Pageable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ehm.ReadingCMS.Model.PostMetadata;

@Repository
public class PostMetadataRepository implements PostMetadataRep {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public boolean save(PostMetadata postMetadata) {
		try {
			String sql = String.format(
					"INSERT INTO post_metadata (Clave,Valor,Tipo,IdPost) VALUES('%s','%s','%s','%d')",
					postMetadata.getClave(), postMetadata.getValor(), postMetadata.getTipo(), postMetadata.getIsPost());
			jdbcTemplate.execute(sql);
		} catch (Exception e) {
			return true;
		}
		return false;
	}

	@Override
	public boolean update(PostMetadata postMetadata) {
		if (postMetadata.getIdPostMetadata() > 0) {
			String sql = String.format(
					"UPDATE post_metadata set Clave ='%s',Valor='%s',Tipo='%s',IdPost='%d'"
							+ "WHERE IdPostMetadata='%d'",
					postMetadata.getClave(), postMetadata.getValor(), postMetadata.getTipo(), postMetadata.getIsPost());
			jdbcTemplate.execute(sql);
			return true;
		}
		return false;
	}

	@Override
	public List<PostMetadata> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PostMetadata finById(int Id) {
		// TODO Auto-generated method stub
		return null;
	}
}
