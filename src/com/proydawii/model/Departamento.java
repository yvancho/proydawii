package com.proydawii.model;

import java.util.*;

import javax.persistence.*;


/**
 * The persistent class for the departamento database table.
 * 
 */
@Entity
public class Departamento extends Identificable {

	private String descripcion;

	//bi-directional many-to-one association to Provincia
	@OneToMany(mappedBy="departamento")
	private Collection<Provincia> provincias = new ArrayList<Provincia>();

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Collection<Provincia> getProvincias() {
		return provincias;
	}

	public void setProvincias(Collection<Provincia> provincias) {
		this.provincias = provincias;
	}


}