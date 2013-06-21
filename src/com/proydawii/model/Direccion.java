package com.proydawii.model;

import javax.persistence.*;


/**
 * The persistent class for the direccion database table.
 * 
 */
@Embeddable
public class Direccion {
	/*
	@Required
	@ManyToOne
	@DescriptionsList
	private Distrito distrito;
*/
	//@Required
	@ManyToOne
	private Ubigeo ubigeo;
	
	@Column(length=100,nullable=false)
	private String direccioncompleta;
/*
	public Distrito getDistrito() {
		return distrito;
	}

	public void setDistrito(Distrito distrito) {
		this.distrito = distrito;
	}
*/
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