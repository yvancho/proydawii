package com.proydawii.model;

import javax.persistence.*;

import org.openxava.annotations.*;


/**
 * The persistent class for the direccion database table.
 * 
 */
@Embeddable
public class Direccion {
	
	//bi-directional many-to-one association to Distrito
	//@OneToMany(mappedBy="direccion")
	//private Collection<Distrito> distritos = new ArrayList<Distrito>();
	@Required
	@ManyToOne
	@DescriptionsList
	private Distrito distrito;

	private String calle;

	private String numero;

	private String urbanizacion;

	private String lote;
	

	public Distrito getDistrito() {
		return distrito;
	}

	public void setDistrito(Distrito distrito) {
		this.distrito = distrito;
	}

	public String getCalle() {
		return this.calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public String getLote() {
		return this.lote;
	}

	public void setLote(String lote) {
		this.lote = lote;
	}

	public String getNumero() {
		return this.numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getUrbanizacion() {
		return this.urbanizacion;
	}

	public void setUrbanizacion(String urbanizacion) {
		this.urbanizacion = urbanizacion;
	}

}