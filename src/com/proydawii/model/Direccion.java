package com.proydawii.model;

import javax.persistence.*;

import org.openxava.annotations.*;


/**
 * The persistent class for the direccion database table.
 * 
 */
@Embeddable
public class Direccion {
	
	
	@Required
	@NoCreate
	@ManyToOne
	private Ubigeo ubigeo;
	
	@Required
	@Column(length=100,nullable=false)
	private String direccioncompleta;

	public String getDireccioncompleta() {
		return direccioncompleta;
	}

	public void setDireccioncompleta(String direccioncompleta) {
		this.direccioncompleta = direccioncompleta;
	}

	
	public Ubigeo getUbigeo() {
		return ubigeo;
	}

	public void setUbigeo(Ubigeo ubigeo) {
		this.ubigeo = ubigeo;
	}

}