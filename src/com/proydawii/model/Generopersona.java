package com.proydawii.model;

import javax.persistence.*;

import com.proydawii.util.*;

@Entity
public class Generopersona extends Identificable {

	@Column(length=10,nullable=false)
	private String descripcion;

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}	

}
