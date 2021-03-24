package com.ehm.ReadingCMS.Repository;

import java.awt.print.Pageable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ehm.ReadingCMS.Model.UsuarioMetadata;

@Repository
public class UsuarioMetadataRepository implements UsuarioMetadataRep {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public boolean save(UsuarioMetadata usuarioMetadata) {
		try {
			String sql = String.format(
					"INSERT INTO usuario_metadata (IdUsuarioMetadata,Idusuario, Clave,Valor,Tipo) VALUES('%d','%d','%s','%s','%d')",
					usuarioMetadata.getIdUsuarioMetadata(), usuarioMetadata.getIdUsuario(), usuarioMetadata.getClave(),
					usuarioMetadata.getValor(), usuarioMetadata.getTipo());
			jdbcTemplate.execute(sql);
		} catch (Exception e) {

			return true;
		}
		return false;
	}

	@Override
	public boolean update(UsuarioMetadata usuarioMetadata) {
		if (usuarioMetadata.getIdUsuarioMetadata() != 0) {
			String sql = String.format(
					"UPDATE usuario_metadata SET IdUsuarioMetadata='%d',Idusuario='%d', Clave='%s',Valor='%s',Tipo='%s'"
							+ "WHERE IdUsuarioMetadata='%d'",
					usuarioMetadata.getIdUsuarioMetadata(), usuarioMetadata.getIdUsuario(), usuarioMetadata.getClave(),
					usuarioMetadata.getValor(), usuarioMetadata.getTipo());
			jdbcTemplate.execute(sql);
			return true;
		}
		return false;
	}

	@Override
	public List<UsuarioMetadata> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UsuarioMetadata finById(int Id) {
		// TODO Auto-generated method stub
		return null;
	}
}
