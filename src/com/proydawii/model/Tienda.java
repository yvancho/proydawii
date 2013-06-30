package com.proydawii.model;

import javax.persistence.*;
import javax.validation.constraints.*;

import org.openxava.annotations.*;

import com.proydawii.util.*;

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
	private Collection<Productotienda> productotiendas = new ArrayList<Productotienda>();

	//bi-directional many-to-one association to Repartidor
	@OneToMany(mappedBy="tienda", cascade=CascadeType.ALL)
	private Collection<Repartidor> repartidores = new ArrayList<Repartidor>();

	//bi-directional many-to-one association to Pedido
	@OneToMany(mappedBy="tienda", cascade=CascadeType.ALL)
	private Collection<Documentocomercial> doccoms=new ArrayList<Documentocomercial>();

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

	public Collection<Documentocomercial> getDoccoms() {
		return doccoms;
	}

	public void setDoccoms(Collection<Documentocomercial> doccoms) {
		this.doccoms = doccoms;
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

	public Empresa getEmpresa() {
		return this.empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

}