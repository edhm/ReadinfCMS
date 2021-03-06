package com.ehm.ReadingCMS.Repository;

import java.awt.print.Pageable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ehm.ReadingCMS.Model.UsuarioMetadata;

import Mapper.UsuarioMetadataMapper;

@Repository
public class UsuarioMetadataRepository implements UsuarioMetadataRep {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public boolean save(UsuarioMetadata usuarioMetadata) {
		try {
			String sql = String.format(
					"INSERT INTO usuario_metadata (Idusuario, Clave,Valor,Tipo) VALUES('%d','%d','%s','%s','%d')",
					usuarioMetadata.getIdUsuario(), usuarioMetadata.getClave(), usuarioMetadata.getValor(),
					usuarioMetadata.getTipo());
			jdbcTemplate.execute(sql);
		} catch (Exception e) {

			return true;
		}
		return false;
	}

	@Override
	public boolean update(UsuarioMetadata usuarioMetadata) {
		if (usuarioMetadata.getIdUsuarioMetadata() > 0) {
			String sql = String.format(
					"UPDATE usuario_metadata SET Idusuario='%d', Clave='%s',Valor='%s',Tipo='%s'"
							+ "WHERE IdUsuarioMetadata='%d'",
					usuarioMetadata.getIdUsuario(), usuarioMetadata.getClave(), usuarioMetadata.getValor(),
					usuarioMetadata.getTipo());
			jdbcTemplate.execute(sql);
			return true;
		}
		return false;
	}

	@Override
	public List<UsuarioMetadata> findAll(Pageable pageable) {
		return jdbcTemplate.query("SELECT * FROM usuario_metadata", new UsuarioMetadataMapper());
	}

	@SuppressWarnings("deprecation")
	@Override
	public UsuarioMetadata finById(int Id) {
		Object[] params = new Object[] { Id };
		return jdbcTemplate.queryForObject("SELECT * FROM usuario_metadata WHERE IdUsuarioMetadata=?", params,
				new UsuarioMetadataMapper());
	}
}
