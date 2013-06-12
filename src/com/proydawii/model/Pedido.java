package com.proydawii.model;

import javax.persistence.*;

import org.openxava.annotations.*;

import java.util.*;


/**
 * The persistent class for the pedido database table.
 * 
 */
@Entity
public class Pedido extends Identificable {

	
	@Stereotype("DATETIME")
	private Date fechahoraentrada;

	@Stereotype("DATETIME")
	private Date fechahorasalida;

	@Stereotype("TEXTO_GRANDE")
	private String observaciones;

	//bi-directional many-to-one association to Detallepedido
	@OneToMany(mappedBy="pedido")
	private Collection<Detallepedido> detallepedidos = new ArrayList<Detallepedido>();

	//bi-directional many-to-one association to Tienda
	@ManyToOne(fetch=FetchType.LAZY)
	private Tienda tienda;

	//bi-directional many-to-one association to Estadoregistropedido
	@ManyToOne(fetch=FetchType.LAZY)
	private Estadoregistropedido estadoregistropedido;

	public Collection<Detallepedido> getDetallepedidos() {
		return detallepedidos;
	}

	public void setDetallepedidos(Collection<Detallepedido> detallepedidos) {
		this.detallepedidos = detallepedidos;
	}

	public Date getFechahoraentrada() {
		return this.fechahoraentrada;
	}

	public void setFechahoraentrada(Date fechahoraentrada) {
		this.fechahoraentrada = fechahoraentrada;
	}

	public Date getFechahorasalida() {
		return this.fechahorasalida;
	}

	public void setFechahorasalida(Date fechahorasalida) {
		this.fechahorasalida = fechahorasalida;
	}

	public String getObservaciones() {
		return this.observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public Tienda getTienda() {
		return this.tienda;
	}

	public void setTienda(Tienda tienda) {
		this.tienda = tienda;
	}

	public Estadoregistropedido getEstadoregistropedido() {
		return this.estadoregistropedido;
	}

	public void setEstadoregistropedido(Estadoregistropedido estadoregistropedido) {
		this.estadoregistropedido = estadoregistropedido;
	}

}