package com.ehm.ReadingCMS.Repository;

import java.awt.print.Pageable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ehm.ReadingCMS.Model.Contenido;

@Repository
public class ContenidoRepository implements ContenidoRep {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public boolean save(Contenido contenido) {
		try {
			String sql = String.format("INSERT INTO contenido(Tipo, Contenido,Idpost) " + " values('%s','%s','%d')",
					contenido.getTipo(), contenido.getContenido(), contenido.getIdPost());
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	@Override
	public boolean update(Contenido contenido) {
		if (contenido.getIdContenido() > 0) {
			String sql = String.format("UPDATE Contenido set Tipo='%s',Contenido='%s'" + "WHERE IdContenido='%d'",
					contenido.getTipo(), contenido.getContenido(), contenido.getIdContenido());
			jdbcTemplate.execute(sql);
			return true;
		}
		return false;
	}

	@Override
	public List<Contenido> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Contenido finById(int Id) {
		// TODO Auto-generated method stub
		return null;
	}

}
