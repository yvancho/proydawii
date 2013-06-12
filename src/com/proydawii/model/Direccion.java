package com.proydawii.model;

import javax.persistence.*;

import java.util.*;


/**
 * The persistent class for the direccion database table.
 * 
 */
@Entity
public class Direccion extends Identificable {
	
	//bi-directional many-to-one association to Distrito
	@OneToMany(mappedBy="direccion")
	private Collection<Distrito> distritos = new ArrayList<Distrito>();

	private String calle;

	private String numero;

	private String urbanizacion;

	private String lote;

	//bi-directional many-to-one association to Cliente
	@ManyToOne(fetch=FetchType.LAZY)
	private Cliente cliente;

	public Collection<Distrito> getDistritos() {
		return distritos;
	}

	public void setDistritos(Collection<Distrito> distritos) {
		this.distritos = distritos;
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

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

}