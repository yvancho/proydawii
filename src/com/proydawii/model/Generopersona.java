package com.proydawii.model;

import javax.persistence.*;

import org.openxava.model.*;

@Entity
public class Generopersona extends Identifiable {

	@Column(length=10,nullable=false)
	private String descripcion;

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}	

}
