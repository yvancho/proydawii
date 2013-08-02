package com.proydawii.model;

import javax.persistence.*;

import org.openxava.annotations.*;

import com.proydawii.util.*;

@Entity
public class Productotienda extends Identificable {
	
	@ManyToOne(fetch=FetchType.LAZY)
	@NoCreate @NoModify
	@DescriptionsList
	private Tienda tienda;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@ReferenceView("Simple") @NoCreate
	private Productoempresa productoempresa;

	@Stereotype("MEMO")
	private String observaciones;
	
	public Tienda getTienda() {
		return this.tienda;
	}

	public void setTienda(Tienda tienda) {
		this.tienda = tienda;
	}
	
	
	public Productoempresa getProductoempresa() {
		return productoempresa;
	}

	public void setProductoempresa(Productoempresa productoempresa) {
		this.productoempresa = productoempresa;
	}

	public String getObservaciones() {
		return this.observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

}