package com.proydawii.model;

import javax.persistence.*;

import com.proydawii.util.*;


/**
 * The persistent class for the tipocliente database table.
 * 
 */
@Entity
public class Tipocliente extends Identificable {
	
	@Column(length=20,unique=true,nullable=false)
	private String descripcion;

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}