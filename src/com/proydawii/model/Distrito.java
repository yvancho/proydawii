package com.proydawii.model;

import javax.persistence.*;

import org.openxava.annotations.*;


/**
 * The persistent class for the distrito database table.
 * 
 */
@Entity
public class Distrito extends Identificable {
	
	@Column(length=70,nullable=false)
	private String descripcion;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@DescriptionsList
	private Provincia provincia;

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}