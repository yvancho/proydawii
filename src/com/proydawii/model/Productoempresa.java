package com.proydawii.model;

import java.math.*;
import java.util.*;

import javax.persistence.*;

import org.openxava.annotations.*;
import org.openxava.model.*;

@Entity
public class Productoempresa extends Identifiable {

	@Column(length = 50, nullable = false)
	private String descripcion;

	@Stereotype("MONEY")
	private BigDecimal preciocosto;

	@Stereotype("MONEY")
	private BigDecimal precioventa;

	@Stereotype("FOTO")
	private byte[] foto;

	@Stereotype("IMAGES_GALLERY")
	@Column(length = 32)
	private String masfotos;

	@Stereotype("MEMO")
	private String observaciones;

	@ManyToOne(fetch = FetchType.LAZY)
	@DescriptionsList
	private Categoriaproducto categoria;

	@ManyToOne
	private Empresacomercial empresa;

	@OneToMany(mappedBy = "productoempresa", cascade = CascadeType.ALL)
	private Collection<Productotienda> productostienda = new ArrayList<Productotienda>();

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public BigDecimal getPreciocosto() {
		return preciocosto;
	}

	public void setPreciocosto(BigDecimal preciocosto) {
		this.preciocosto = preciocosto;
	}

	public BigDecimal getPrecioventa() {
		return precioventa;
	}

	public void setPrecioventa(BigDecimal precioventa) {
		this.precioventa = precioventa;
	}

	public byte[] getFoto() {
		return foto;
	}

	public void setFoto(byte[] foto) {
		this.foto = foto;
	}

	public String getMasfotos() {
		return masfotos;
	}

	public void setMasfotos(String masfotos) {
		this.masfotos = masfotos;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public Categoriaproducto getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoriaproducto categoria) {
		this.categoria = categoria;
	}

	public Empresacomercial getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresacomercial empresa) {
		this.empresa = empresa;
	}

	public Collection<Productotienda> getProductostienda() {
		return productostienda;
	}

	public void setProductostienda(Collection<Productotienda> productostienda) {
		this.productostienda = productostienda;
	}
	
	
}
