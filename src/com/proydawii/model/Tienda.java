package com.proydawii.model;

import javax.persistence.*;

import org.openxava.annotations.*;

import java.util.*;


/**
 * The persistent class for the tienda database table.
 * 
 */
@Entity
public class Tienda extends Identificable {
	
	@Column(length=50,nullable=false,unique=true)
	private String descripcion;

	@Required
	@NoFrame @Embedded
	private Direccion direccion;
	
	@Required
	@Stereotype("TELEFONO")
	private String telefono;

	//bi-directional many-to-one association to Productotienda
	@OneToMany(mappedBy="tienda", cascade=CascadeType.ALL)
	private Collection<Productotienda> productotiendas = new ArrayList<Productotienda>();

	//bi-directional many-to-one association to Repartidor
	@OneToMany(mappedBy="tienda", cascade=CascadeType.ALL)
	private Collection<Repartidor> repartidores = new ArrayList<Repartidor>();

	//bi-directional many-to-one association to Pedido
	@OneToMany(mappedBy="tienda", cascade=CascadeType.ALL)
	private Collection<Pedido> pedidos=new ArrayList<Pedido>();

	//bi-directional many-to-one association to Empresa
	@ManyToOne(fetch=FetchType.LAZY)
	private Empresa empresa;

	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	public Collection<Productotienda> getProductotiendas() {
		return productotiendas;
	}

	public void setProductotiendas(Collection<Productotienda> productotiendas) {
		this.productotiendas = productotiendas;
	}

	public Collection<Repartidor> getRepartidores() {
		return repartidores;
	}

	public void setRepartidores(Collection<Repartidor> repartidores) {
		this.repartidores = repartidores;
	}

	public Collection<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(Collection<Pedido> pedidos) {
		this.pedidos = pedidos;
	}
/*
	public String getCalle() {
		return this.calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}
*/
	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Empresa getEmpresa() {
		return this.empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

}