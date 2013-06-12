package com.proydawii.model;

import javax.persistence.*;

import java.util.*;

/**
 * The persistent class for the categoriaproducto database table.
 * 
 */
@Entity
public class Categoriaproducto extends Identificable {

	private String descripcion;

	// bi-directional many-to-one association to Productotienda
	@OneToMany(mappedBy = "categoriaproducto")
	private Collection<Productotienda> productotiendas = new ArrayList<Productotienda>();

	public Collection<Productotienda> getProductotiendas() {
		return productotiendas;
	}

	public void setProductotiendas(Collection<Productotienda> productotiendas) {
		this.productotiendas = productotiendas;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}