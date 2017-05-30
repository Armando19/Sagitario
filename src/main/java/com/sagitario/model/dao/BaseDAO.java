package com.sagitario.model.dao;

import java.util.List;

import com.sagitario.exception.DatabaseExceptionCO;


public interface BaseDAO<BO> {
	
	public BO save(BO boElemento) throws DatabaseExceptionCO;

	public void delete(Integer id) throws DatabaseExceptionCO;

	public BO update(BO boElemento) throws DatabaseExceptionCO;

	public BO findById(Number id);
	
	public List<BO> findAll();
	
	public boolean isDuplicado(Number pid, Object psUniqued);
	
	
}		