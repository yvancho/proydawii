package com.proydawii.model;

import javax.persistence.*;

import org.openxava.annotations.*;

import java.util.*;


/**
 * The persistent class for the pedido database table.
 * 
 */
@Entity
@View(members="id, fechahoraentrada;" +
		"cliente;"+"detallepedidos;" +
		"observaciones")
public class Pedido {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Stereotype("DATETIME")
	private Date fechahoraentrada;

	@Stereotype("DATETIME")
	private Date fechahorasalida;

	//bi-directional many-to-one association to Tienda
	@ManyToOne(fetch=FetchType.LAZY)
	@DescriptionsList
	private Tienda tienda;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@ReferenceView("Simple")
	private Cliente cliente;
	
	//bi-directional many-to-one association to Detallepedido
	@OneToMany(mappedBy="pedido")
	@ListProperties("producto.id," +
					"producto.descripcion," +
					"cantidad," +
					"preciounitario," +
					"importe")
	private Collection<Detallepedido> detallepedidos = new ArrayList<Detallepedido>();

	@Stereotype("TEXTO_GRANDE")
	private String observaciones;

	//bi-directional many-to-one association to Estadoregistropedido
	@ManyToOne(fetch=FetchType.LAZY)
	@DescriptionsList
	private Estadoregistropedido estadoregistropedido;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Estadoregistropedido getEstadoregistropedido() {
		return this.estadoregistropedido;
	}

	public void setEstadoregistropedido(Estadoregistropedido estadoregistropedido) {
		this.estadoregistropedido = estadoregistropedido;
	}

}