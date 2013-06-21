package com.proydawii.model;

import javax.persistence.*;


/**
 * The persistent class for the provincia database table.
 * 
 */
@Entity
public class Provincia extends Identificable {
	
	private String descripcion;

	//bi-directional many-to-one association to Distrito
	/*@OneToMany(mappedBy="provincia")
	private List<Distrito> distritos;

	//bi-directional many-to-one association to Departamento
	@ManyToOne(fetch=FetchType.LAZY)
	private Departamento departamento;
*/
	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
/*
	public List<Distrito> getDistritos() {
		return this.distritos;
	}

	public void setDistritos(List<Distrito> distritos) {
		this.distritos = distritos;
	}

	public Departamento getDepartamento() {
		return this.departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}
*/
}