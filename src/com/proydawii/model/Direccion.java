package com.proydawii.model;

import javax.persistence.*;

@Embeddable
public class Direccion {

	@Column(length=50)
	private String calle;

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}
}
