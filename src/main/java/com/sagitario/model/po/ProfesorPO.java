package com.sagitario.model.po;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="profesor")
public class ProfesorPO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2702326305794210399L;

	@Id
	@Column(name="Id")
	private int id;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="ape1")
	private String apellidoPaterno;
	
	@Column(name="ape2")
	private String apellidoMaterno;
	
	
	
	public ProfesorPO(){
	}
	
	public ProfesorPO(int id, String nombre, String apellidoPaterno, String apellidoMaterno){
		this.id = id;
		this.nombre = nombre;
		this.apellidoPaterno = apellidoPaterno;
		this.apellidoMaterno = apellidoMaterno;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidoPaterno() {
		return apellidoPaterno;
	}
	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}
	public String getApellidoMaterno() {
		return apellidoMaterno;
	}
	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}
	
}
