package com.ehm.ReadingCMS.Repository;

import java.awt.print.Pageable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ehm.ReadingCMS.Model.Permiso;

import Mapper.PermisoMapper;

@Repository
public class PermisoRepository implements PermisoRep {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public boolean save(Permiso permiso) {
		try {
			String sql = String.format("INSERT INTO permiso( Nombre) VALUES('%s')", permiso.getNombre());
			jdbcTemplate.execute(sql);
		} catch (Exception e) {
			return true;
		}
		return false;
	}

	@Override
	public boolean update(Permiso permiso) {
		if (permiso.getIdPermiso() > 0) {
			String sql = String.format("UPDATE permiso set  Nombre='%s'" + "WHERE IdPermiso='%d'", permiso.getNombre());
			jdbcTemplate.execute(sql);
			return true;
		}
		return false;
	}

	@Override
	public List<Permiso> findAll(Pageable pageable) {
		return jdbcTemplate.query("SELECT * FROM permiso", new PermisoMapper());
	}

	@SuppressWarnings("deprecation")
	@Override
	public Permiso finById(int Id) {
		Object[] params = new Object[] { Id };
		return jdbcTemplate.queryForObject("SELECt * FROM permiso WHERE IdPermiso=?", params, new PermisoMapper());
	}
}
