package com.proydawii.model;

import javax.persistence.*;

import org.openxava.annotations.*;
import com.proydawii.calculators.*;
import com.proydawii.util.*;

import java.math.BigDecimal;

/**
 * The persistent class for the detallepedido database table.
 * 
 */
@Entity
@View(members = "productotienda; cantidad, preciounitario, importe; doccom")
public class Detallepedido extends Identificable {

	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	@ReferenceView("Simple")
	@NoFrame
	private Productotienda productotienda;

	@DefaultValueCalculator(value = PrecioPorUnidad.class, 
			properties = @PropertyValue(name = "productoId", from = "productotienda.id"))
	@Stereotype("DINERO")
	private BigDecimal preciounitario;

	private int cantidad;

	// bi-directional many-to-one association to Pedido
	@ManyToOne(fetch = FetchType.LAZY)
	private Documentocomercial doccom;	

	public Productotienda getProductotienda() {
		return productotienda;
	}

	public void setProductotienda(Productotienda productotienda) {
		this.productotienda = productotienda;
	}

	public BigDecimal getPreciounitario() {
		if (this.preciounitario == null) {
			return BigDecimal.ZERO;
		}
		return this.preciounitario;
	}

	public void setPreciounitario(BigDecimal preciounitario) {
		this.preciounitario = preciounitario;
	}

	public int getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public Documentocomercial getDoccom() {
		return doccom;
	}

	public void setDoccom(Documentocomercial doccom) {
		this.doccom = doccom;
	}

	// PROPIEDADES CALCULADAS

	@Stereotype("MONEY")
	@Depends("productotienda.id, cantidad")
	public BigDecimal getImporte() {
		return new BigDecimal(cantidad).multiply(productotienda.getPrecio());
	}

	// METODOS DE RETRO-LLAMADA
	@PrePersist
	private void onPersist() {
		getDoccom().getDetallepedidos().add(this);
		getDoccom().recalculateMonto();
	}

	@PreUpdate
	private void onUpdate() {
		getDoccom().recalculateMonto();
	}

	@PreRemove
	private void onRemove() {
		if (getDoccom().isRemoving()) {
			return;
		}
		getDoccom().getDetallepedidos().remove(this);
		getDoccom().recalculateMonto();
	}

}