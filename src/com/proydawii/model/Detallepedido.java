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
// @View(members = "productotienda; cantidad, preciounitario, importe; pedido")
@View(members = "productotienda; cantidad; pedido")
public class Detallepedido extends Identificable {

	// bi-directional many-to-one association to Pedido
	@ManyToOne(fetch = FetchType.LAZY)
	private Pedido pedido;

	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	// @ReferenceView("Simple")
	@NoFrame
	private Productotienda productotienda;

	// @DefaultValueCalculator(value = PrecioPorUnidad.class,
	// properties = @PropertyValue(name = "productoId", from =
	// "productotienda.id"))
	@Stereotype("DINERO")
	private BigDecimal preciounitario;

	@ManyToOne
	// @DescriptionsList
	private Repartidor repartidor;

	@Required
	@Column(nullable = false, updatable = true)
	private int cantidad;

	@Column(precision = 10, scale = 2)
	private BigDecimal preciocosto;

	@Column(precision = 10, scale = 2)
	private BigDecimal ganancia;

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

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

	public Repartidor getRepartidor() {
		return repartidor;
	}

	public void setRepartidor(Repartidor repartidor) {
		this.repartidor = repartidor;
	}

	public BigDecimal getPreciocosto() {
		return preciocosto;
	}

	public void setPreciocosto(BigDecimal preciocosto) {
		this.preciocosto = preciocosto;
	}

	public BigDecimal getGanancia() {
		return ganancia;
	}

	public void setGanancia(BigDecimal ganancia) {
		this.ganancia = ganancia;
	}

	// PROPIEDADES CALCULADAS

	/*
	 * @Stereotype("MONEY")
	 * 
	 * @Depends("productotienda.id, cantidad") public BigDecimal getImporte() {
	 * return new BigDecimal(cantidad).multiply(productotienda.getPrecio()); }
	 * 
	 * // METODOS DE RETRO-LLAMADA
	 * 
	 * @PrePersist private void onPersist() {
	 * getPedido().getDetallepedidos().add(this);
	 * getPedido().recalculateMonto(); }
	 * 
	 * @PreUpdate private void onUpdate() { getPedido().recalculateMonto(); }
	 * 
	 * @PreRemove private void onRemove() { if (getPedido().isRemoving()) {
	 * return; } getPedido().getDetallepedidos().remove(this);
	 * getPedido().recalculateMonto(); }
	 */
}