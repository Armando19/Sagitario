package com.sagitario.test;

import com.sagitario.model.bo.ProfesorBO;
import com.sagitario.model.dao.ProfesorDAO;
import com.sagitario.model.dao.impl.ProfesorDAOImpl;

public class PruebaProfesor {

	private ProfesorDAO profesor;
	
	public PruebaProfesor() {
		this.profesor = new ProfesorDAOImpl();
	}


	
	public static void main(String[] args) {
		PruebaProfesor prueba = new PruebaProfesor();
		ProfesorBO profe = prueba.profesor.getProfesoresActivos(1001);
		System.out.println(profe);
	}


	public ProfesorDAO getProfesor() {
		return profesor;
	}


	public void setProfesor(ProfesorDAO profesor) {
		this.profesor = profesor;
	}

}
