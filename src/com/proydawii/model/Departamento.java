package com.proydawii.model;

import javax.persistence.*;


/**
 * The persistent class for the departamento database table.
 * 
 */
@Entity
public class Departamento extends Identificable {

	private String descripcion;

	//bi-directional many-to-one association to Provincia
	//@OneToMany(mappedBy="departamento")
	//private List<Provincia> provincias;

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/*public List<Provincia> getProvincias() {
		return this.provincias;
	}

	public void setProvincias(List<Provincia> provincias) {
		this.provincias = provincias;
	}
*/
}