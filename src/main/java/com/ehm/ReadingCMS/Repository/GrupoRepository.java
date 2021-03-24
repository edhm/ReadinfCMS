package com.ehm.ReadingCMS.Repository;

import java.awt.print.Pageable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ehm.ReadingCMS.Model.Grupo;

@Repository
public class GrupoRepository implements GrupoRep {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public boolean save(Grupo grupo) {
		try {
			String sql = String.format("INSERT INTO grupo(IdGrupo,Nombre) VALUES('%d','%s')", grupo.getIdGrupo(),
					grupo.getNombre());
			jdbcTemplate.execute(sql);
		} catch (Exception e) {
			return true;
		}
		return false;

	}

	@Override
	public boolean update(Grupo grupo) {
		if (grupo.getIdGrupo() != 0) {
			String sql = String.format("UPDATE grupo set IdGrupo='%d', Nombre='%s'" + " WHERE IdGrupo='%d'",
					grupo.getIdGrupo(), grupo.getNombre());
			jdbcTemplate.execute(sql);
			return true;
		}
		return false;
	}

	@Override
	public List<Grupo> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Grupo finById(int Id) {
		// TODO Auto-generated method stub
		return null;
	}
}
