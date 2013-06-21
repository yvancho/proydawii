package com.proydawii.model;

import javax.persistence.*;

@Entity
public class Ubigeo {

	@Id
	private int id;
	
	@Column(length=70,nullable=false)
	private String departamento;
	
	@Column(length=70,nullable=false)
	private String provincia;
	
	@Column(length=70,nullable=false,unique=true)
	private String distrito;

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getDistrito() {
		return distrito;
	}

	public void setDistrito(String distrito) {
		this.distrito = distrito;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	} 
}
