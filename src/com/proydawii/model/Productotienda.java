package com.proydawii.model;

import javax.persistence.*;

import org.openxava.annotations.*;

import com.proydawii.util.*;

import java.math.BigDecimal;

@Entity
@View(name = "Simple", 
	  members = "id, descripcion")
public class Productotienda extends Identificable {
	
	/*

	@Column(length=50,nullable=false,unique=true)
	private String descripcion;

	@Stereotype("MONEY")
	private BigDecimal precio;

	@Stereotype("FOTO")
	private byte[] foto;

	@Stereotype("IMAGES_GALLERY")
	@Column(length = 32)
	private String masFotos;
*/
	//bi-directional many-to-one association to Tienda
	@ManyToOne(fetch=FetchType.LAZY)
	@DescriptionsList
	private Tienda tienda;

	@Stereotype("MEMO")
	private String observaciones;

	/*public byte[] getFoto() {
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
*/
	public String getObservaciones() {
		return this.observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	/*public BigDecimal getPrecio() {
		return this.precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}*/

	

	public Tienda getTienda() {
		return this.tienda;
	}

	public void setTienda(Tienda tienda) {
		this.tienda = tienda;
	}

}