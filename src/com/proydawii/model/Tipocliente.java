package com.proydawii.model;

import javax.persistence.*;

import org.openxava.annotations.*;

@Entity
public class Tipocliente extends Identificable {

	@Column(length = 50)
	@Required
	private String descripcion;

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
		
}
