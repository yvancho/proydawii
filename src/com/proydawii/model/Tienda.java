package com.proydawii.model;

import javax.persistence.*;
import javax.validation.constraints.*;

import org.openxava.annotations.*;

import com.proydawii.util.*;

import java.math.*;
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
	@Stereotype("TELEPHONE")
	@Column(length=10,nullable=true)
	@Size(min=6,max=10,message="Ingrese un nro. de teléfono válido por favor.")
	private String nrotelefonofijo;

	//bi-directional many-to-one association to Productotienda
	@OneToMany(mappedBy="tienda", cascade=CascadeType.ALL)
	private Collection<Productotienda> productos = new ArrayList<Productotienda>();

	@Stereotype("DINERO")
	@Column(precision=10, scale=2)
	private BigDecimal porcimpconsumo;
	
	//bi-directional many-to-one association to Repartidor
	@OneToMany(mappedBy="tienda", cascade=CascadeType.ALL)
	private Collection<Repartidor> repartidores = new ArrayList<Repartidor>();

	//bi-directional many-to-one association to Pedido
	@OneToMany(mappedBy="tienda", cascade=CascadeType.ALL)
	private Collection<Pedido> pedidos=new ArrayList<Pedido>();

	//bi-directional many-to-one association to Empresa
	@ManyToOne(fetch=FetchType.LAZY)
	private Empresacomercial empresacomercial;

	public BigDecimal getPorcimpconsumo() {
		return porcimpconsumo;
	}

	public void setPorcimpconsumo(BigDecimal porcimpconsumo) {
		this.porcimpconsumo = porcimpconsumo;
	}

	public Collection<Pedido> getPedidos() {
		return pedidos;
	}

	public Collection<Productotienda> getProductos() {
		return productos;
	}

	public void setProductos(Collection<Productotienda> productos) {
		this.productos = productos;
	}

	public void setPedidos(Collection<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	

	public Collection<Repartidor> getRepartidores() {
		return repartidores;
	}

	public void setRepartidores(Collection<Repartidor> repartidores) {
		this.repartidores = repartidores;
	}

	

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}	

	public String getNrotelefonofijo() {
		return nrotelefonofijo;
	}

	public void setNrotelefonofijo(String nrotelefonofijo) {
		this.nrotelefonofijo = nrotelefonofijo;
	}

	public Empresacomercial getEmpresacomercial() {
		return empresacomercial;
	}

	public void setEmpresacomercial(Empresacomercial empresacomercial) {
		this.empresacomercial = empresacomercial;
	}

	

}