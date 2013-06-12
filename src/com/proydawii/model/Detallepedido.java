package com.proydawii.model;

import javax.persistence.*;

import org.openxava.annotations.*;

import java.math.BigDecimal;

/**
 * The persistent class for the detallepedido database table.
 * 
 */
@Entity
public class Detallepedido extends Identificable {

	private String producto;

	@Stereotype("DINERO")
	private BigDecimal preciounitario;

	private int cantidad;

	// bi-directional many-to-one association to Pedido
	@ManyToOne(fetch = FetchType.LAZY)
	private Pedido pedido;

	public int getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
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

	public Pedido getPedido() {
		return this.pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public String getProducto() {
		return producto;
	}

	public void setProducto(String producto) {
		this.producto = producto;
	}

}