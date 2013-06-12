package com.proydawii.model;

import javax.persistence.*;

import java.util.*;


/**
 * The persistent class for the distrito database table.
 * 
 */
@Entity
public class Distrito extends Identificable {
	
	
	private String descripcion;

	//bi-directional many-to-one association to Tienda
	@OneToMany(mappedBy="distrito")
	private Collection<Tienda> tiendas = new ArrayList<Tienda>();

	//bi-directional many-to-one association to Direccion
	@ManyToOne(fetch=FetchType.LAZY)
	private Direccion direccion;

	public Collection<Tienda> getTiendas() {
		return tiendas;
	}

	public void setTiendas(Collection<Tienda> tiendas) {
		this.tiendas = tiendas;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Direccion getDireccion() {
		return this.direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

}