package com.proydawii.model;

import java.util.*;

import javax.persistence.*;

import org.openxava.annotations.*;

@Entity
public class Provincia extends Identificable {
	
	private String descripcion;

	//bi-directional many-to-one association to Distrito
	@OneToMany(mappedBy="provincia")
	private Collection<Distrito> distritos = new ArrayList<Distrito>();

	//bi-directional many-to-one association to Departamento
	@ManyToOne(fetch=FetchType.LAZY)
	@DescriptionsList
	private Departamento departamento;

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Collection<Distrito> getDistritos() {
		return distritos;
	}

	public void setDistritos(Collection<Distrito> distritos) {
		this.distritos = distritos;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}
	
	

}