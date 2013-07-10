package com.proydawii.model;

import javax.persistence.*;

import com.proydawii.util.*;


/**
 * The persistent class for the estadoregistropedido database table.
 * 
 */
@Entity
public class Estadopedido extends Identificable{
	
	@Column(length=20,nullable=false,unique=true)
	private String descripcion;

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}