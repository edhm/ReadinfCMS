package com.ehm.ReadingCMS.Repository;

import java.awt.print.Pageable;
import java.util.List;

public interface BaseRep<T> {
	public boolean save(T object);

	public boolean update(T object);

	public List<T> findAll(Pageable pageable);

	public T finById(int Id);
}
