package com.proydawii.model;

import javax.persistence.*;

import org.openxava.annotations.*;

@Embeddable
public class Direccion {

	@Required
	@ManyToOne(fetch = FetchType.LAZY)
	@DescriptionsList
	private Distrito distrito;
	
	@Column(length=50)
	private String calle;

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public Distrito getDistrito() {
		return distrito;
	}

	public void setDistrito(Distrito distrito) {
		this.distrito = distrito;
	}
	
	
}
