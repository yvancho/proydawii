package com.proydawii.model;

import javax.persistence.*;


/**
 * The persistent class for the distrito database table.
 * 
 */
@Entity
public class Distrito extends Identificable {
	
	@Column(length=70,nullable=false)
	private String descripcion;

	/*
	@OneToMany(mappedBy="distrito")
	private Collection<Tienda> tiendas = new ArrayList<Tienda>();

	public Collection<Tienda> getTiendas() {
		return tiendas;
	}

	public void setTiendas(Collection<Tienda> tiendas) {
		this.tiendas = tiendas;
	}
*/
	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}