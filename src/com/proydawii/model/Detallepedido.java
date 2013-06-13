package com.proydawii.model;

import javax.persistence.*;

import org.openxava.annotations.*;

import com.proydawii.calculators.*;

import java.math.BigDecimal;

/**
 * The persistent class for the detallepedido database table.
 * 
 */
@Entity
@View(members = "producto; cantidad, preciounitario, importe")
public class Detallepedido extends Identificable {

	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	@ReferenceView("Simple")
	@NoFrame
	private Productotienda producto;

	@DefaultValueCalculator(value = PrecioPorUnidad.class, properties = @PropertyValue(name = "productoId", from = "producto.id"))
	@Stereotype("DINERO")
	private BigDecimal preciounitario;

	private int cantidad;

	// bi-directional many-to-one association to Pedido
	@ManyToOne(fetch = FetchType.LAZY)
	private Pedido pedido;

	public Productotienda getProducto() {
		return producto;
	}

	public void setProducto(Productotienda producto) {
		this.producto = producto;
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

	public Pedido getPedido() {
		return this.pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	@Stereotype("MONEY")
	@Depends("producto.id, cantidad")
	public BigDecimal getImporte() {
		return new BigDecimal(cantidad).multiply(producto.getPrecio());
	}

}