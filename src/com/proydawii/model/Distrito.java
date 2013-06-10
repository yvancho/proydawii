package com.proydawii.model;

import javax.persistence.*;

@Entity
public class Distrito extends Identificable {
	
	@Column(length=50,unique=true)
	private String descripcion;

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
		
}
