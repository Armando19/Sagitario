package com.sagitario.model.dao.impl;

import com.sagitario.model.bo.ProfesorBO;
import com.sagitario.model.builder.ProfesorBuilder;
import com.sagitario.model.dao.ProfesorDAO;
import com.sagitario.model.po.ProfesorPO;

public class ProfesorDAOImpl  extends BaseDAOImpl<ProfesorBO, ProfesorPO> implements ProfesorDAO {

	public ProfesorDAOImpl(){
		super(ProfesorPO.class, "id");
	}

	@Override
	public ProfesorBO getProfesoresActivos(int getId) {
		return super.findById(getId);
	}

	@Override
	public boolean isDuplicado(Number pid, Object psUniqued) {
		return false;
	}

	@Override
	protected ProfesorPO crearPO(ProfesorBO pboElemento) {
		return ProfesorBuilder.crearProfesorPO(pboElemento);
	}

	@Override
	protected ProfesorBO crearBO(ProfesorPO ppoElemento) {
		return ProfesorBuilder.crearProfesorBO(ppoElemento);
	}

}
