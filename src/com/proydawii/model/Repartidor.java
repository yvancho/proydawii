package com.proydawii.model;

import javax.persistence.*;

import org.openxava.annotations.*;

@Entity
public class Repartidor extends Usuario {

	@ManyToOne(fetch=FetchType.LAZY)
	@DescriptionsList
	private Tienda tienda;

	public Tienda getTienda() {
		return tienda;
	}

	public void setTienda(Tienda tienda) {
		this.tienda = tienda;
	}

		
}
