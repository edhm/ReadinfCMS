package com.ehm.ReadingCMS.Repository;

import java.awt.print.Pageable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ehm.ReadingCMS.Model.GrupoPermiso;

import Mapper.GrupoPermisoMapper;

@Repository
public class GrupoPermisoRepository implements GrupoPermisoRep {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public boolean save(GrupoPermiso grupoPermiso) {
		try {
			String sql = String.format("INSERT INTO grupo_permiso(IdGrupo,Idpermiso) VALUES('%d','%d')",
					grupoPermiso.getIdGrupo(), grupoPermiso.getIdPermiso());
			jdbcTemplate.execute(sql);
		} catch (Exception e) {
			return true;
		}
		return false;

	}

	@Override
	public boolean update(GrupoPermiso grupoPermiso) {
		if (grupoPermiso.getIdGrupo() != 0) {
			String sql = String.format("UPDATE grupo_permiso set IdGrupo='%d', IdPermiso='%d'" + " WHERE IdGrupo='%d'",
					grupoPermiso.getIdGrupo(), grupoPermiso.getIdPermiso());
			jdbcTemplate.execute(sql);
			return true;
		}
		return false;
	}

	@Override
	public List<GrupoPermiso> findAll(Pageable pageable) {
		return jdbcTemplate.query("SELECT * grupo_permiso", new GrupoPermisoMapper());
	}

	@SuppressWarnings("deprecation")
	@Override
	public GrupoPermiso finById(int Id) {
		Object[] params = new Object[] { Id };
		return jdbcTemplate.queryForObject("SELECT * FROM grupo_permiso WHERE IdGrupo=?", params,
				new GrupoPermisoMapper());
	}
}
