package com.proydawii.model;

import javax.persistence.*;

import org.openxava.annotations.*;

import java.math.BigDecimal;


/**
 * The persistent class for the productotienda database table.
 * 
 */
@Entity
public class Productotienda extends Identificable {
	

	private String descripcion;

	@Stereotype("PHOTO")
	private byte[] foto;

	private String masFotos;

	private String observaciones;

	private BigDecimal precio;

	//bi-directional many-to-one association to Categoriaproducto
	@ManyToOne(fetch=FetchType.LAZY)
	private Categoriaproducto categoriaproducto;

	//bi-directional many-to-one association to Tienda
	@ManyToOne(fetch=FetchType.LAZY)
	private Tienda tienda;	

	public byte[] getFoto() {
		return foto;
	}

	public void setFoto(byte[] foto) {
		this.foto = foto;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getMasFotos() {
		return this.masFotos;
	}

	public void setMasFotos(String masFotos) {
		this.masFotos = masFotos;
	}

	public String getObservaciones() {
		return this.observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public BigDecimal getPrecio() {
		return this.precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	public Categoriaproducto getCategoriaproducto() {
		return this.categoriaproducto;
	}

	public void setCategoriaproducto(Categoriaproducto categoriaproducto) {
		this.categoriaproducto = categoriaproducto;
	}

	public Tienda getTienda() {
		return this.tienda;
	}

	public void setTienda(Tienda tienda) {
		this.tienda = tienda;
	}

}