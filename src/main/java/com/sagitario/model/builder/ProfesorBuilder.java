package com.sagitario.model.builder;

import com.sagitario.model.bo.ProfesorBO;
import com.sagitario.model.po.ProfesorPO;

public class ProfesorBuilder {

	public ProfesorBuilder() {
		super();
	}

	public static ProfesorBO crearProfesorBO(ProfesorPO ppoProfesor) {

		ProfesorBO pboProfesor = new ProfesorBO();
		if (ppoProfesor.getId() >= 0) {
			pboProfesor.setId(ppoProfesor.getId());
		}
		pboProfesor.setNombre(ppoProfesor.getNombre());
		pboProfesor.setApellidoPaterno(ppoProfesor.getApellidoPaterno());
		pboProfesor.setApellidoMaterno(ppoProfesor.getApellidoMaterno());
//		pboProfesor.setTipoFuncionario(ppoProfesor.getTipoFuncionario());

		return pboProfesor;

	}

	public static ProfesorPO crearProfesorPO(ProfesorBO pboProfesor) {
		ProfesorPO ppoProfesor = new ProfesorPO();
		if (pboProfesor.getId() >= 0) {
			ppoProfesor.setId(pboProfesor.getId());
		}
		ppoProfesor.setNombre(pboProfesor.getNombre());
		ppoProfesor.setApellidoPaterno(pboProfesor.getApellidoPaterno());
		ppoProfesor.setApellidoMaterno(pboProfesor.getApellidoMaterno());
//		ppoProfesor.setTipoFuncionario(pboProfesor.getTipoFuncionario());

		return ppoProfesor;
	}

}
