package com.proydawii.model;

import javax.persistence.*;

import org.openxava.annotations.*;

@Embeddable
public class Direccion {
		
	@Required
	@NoCreate
	@ManyToOne
	private Ubigeo ubigeo;
	
	@Required
	@Column(length=200)
	private String direccion;
	
	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Ubigeo getUbigeo() {
		return ubigeo;
	}

	public void setUbigeo(Ubigeo ubigeo) {
		this.ubigeo = ubigeo;
	}

}