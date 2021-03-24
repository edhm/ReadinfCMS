package com.ehm.ReadingCMS.Repository;

import java.awt.print.Pageable;
import java.util.List;

import com.ehm.ReadingCMS.Model.Categoria;

public interface CategoriaRep extends BaseRep<Categoria> {
	public boolean save(Categoria categoria);

	public boolean update(Categoria categoria);

	public List<Categoria> findAll(Pageable pageable);
}
