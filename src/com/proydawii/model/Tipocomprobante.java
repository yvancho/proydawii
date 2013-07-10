package com.proydawii.model;

import javax.persistence.*;

import com.proydawii.util.*;

@Entity
public class Tipocomprobante extends Identificable {
	
	@Column(nullable=false, length=45)
	private String descripcion;

	//bi-directional many-to-one association to Facturacion
	//@OneToMany(mappedBy="tipocomprobante")
	//private Collection<Facturacion> facturaciones = new ArrayList<Facturacion>();

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
/*
	public Collection<Facturacion> getFacturaciones() {
		return facturaciones;
	}

	public void setFacturaciones(Collection<Facturacion> facturaciones) {
		this.facturaciones = facturaciones;
	}
	*/	

}