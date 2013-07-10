package com.proydawii.model;

import java.math.*;

import javax.persistence.*;

import org.openxava.annotations.*;

@Entity
public class Detallefacturacion {

	@Id
	@Column(name = "detalleorden_id")
	private int detalleordenId;

	@OneToOne(fetch = FetchType.LAZY)
	private Detallepedido detallepedido;

	@ManyToOne(fetch = FetchType.LAZY)
	private Facturacion facturacion;

	@ManyToOne(fetch = FetchType.LAZY)
	private Productotienda productotienda;

	@Required
	@Column(nullable = false, updatable = true)
	private int cantidad;

	@Stereotype("DINERO")
	private BigDecimal neto;

	@Stereotype("DINERO")
	private BigDecimal impuestoigv;

	@Stereotype("DINERO")
	private BigDecimal impuestoconsumo;

	@Stereotype("DINERO")
	private BigDecimal bruto;

	@Stereotype("DINERO")
	private BigDecimal tipocambio;

	@Column(precision = 6, scale = 2)
	private BigDecimal porcentajeigv;

	@Column(precision = 6, scale = 2)
	private BigDecimal porcentajeimpuestoconsumo;

	public int getDetalleordenId() {
		return detalleordenId;
	}

	public void setDetalleordenId(int detalleordenId) {
		this.detalleordenId = detalleordenId;
	}

	public Detallepedido getDetallepedido() {
		return detallepedido;
	}

	public void setDetallepedido(Detallepedido detallepedido) {
		this.detallepedido = detallepedido;
	}

	public Facturacion getFacturacion() {
		return facturacion;
	}

	public void setFacturacion(Facturacion facturacion) {
		this.facturacion = facturacion;
	}

	public Productotienda getProductotienda() {
		return productotienda;
	}

	public void setProductotienda(Productotienda productotienda) {
		this.productotienda = productotienda;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public BigDecimal getNeto() {
		return neto;
	}

	public void setNeto(BigDecimal neto) {
		this.neto = neto;
	}

	public BigDecimal getImpuestoigv() {
		return impuestoigv;
	}

	public void setImpuestoigv(BigDecimal impuestoigv) {
		this.impuestoigv = impuestoigv;
	}

	public BigDecimal getImpuestoconsumo() {
		return impuestoconsumo;
	}

	public void setImpuestoconsumo(BigDecimal impuestoconsumo) {
		this.impuestoconsumo = impuestoconsumo;
	}

	public BigDecimal getBruto() {
		return bruto;
	}

	public void setBruto(BigDecimal bruto) {
		this.bruto = bruto;
	}

	public BigDecimal getTipocambio() {
		return tipocambio;
	}

	public void setTipocambio(BigDecimal tipocambio) {
		this.tipocambio = tipocambio;
	}

	public BigDecimal getPorcentajeigv() {
		return porcentajeigv;
	}

	public void setPorcentajeigv(BigDecimal porcentajeigv) {
		this.porcentajeigv = porcentajeigv;
	}

	public BigDecimal getPorcentajeimpuestoconsumo() {
		return porcentajeimpuestoconsumo;
	}

	public void setPorcentajeimpuestoconsumo(BigDecimal porcentajeimpuestoconsumo) {
		this.porcentajeimpuestoconsumo = porcentajeimpuestoconsumo;
	}

}
