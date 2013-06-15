package com.proydawii.model;

import javax.persistence.*;

import org.hibernate.validator.*;
//import org.hibernate.validator.*;
import org.openxava.annotations.*;
import com.proydawii.calculators.*;

import java.math.*;
import java.util.*;

/**
 * The persistent class for the pedido database table.
 * 
 */
@Entity
@View(members = "id," + "fechahoraentrada," + "fechahorasalida,"
		+ "estadoregistropedido," + "tienda; " + "data {" + "cliente;"
		+ "detallepedidos;" + "montos[" + "porcentajeigv, " + "montoBase,"
		+ "igv," + "montoTotal" + "];" + "observaciones" + "}")
public class Pedido {

	@Id
	@DefaultValueCalculator(value = SiguienteIdPorYearCalculator.class)
	@ReadOnly
	private int id;

	@Stereotype("DATETIME")
	private Date fechahoraentrada;

	@Stereotype("DATETIME")
	private Date fechahorasalida;

	// bi-directional many-to-one association to Tienda
	@ManyToOne(fetch = FetchType.LAZY)
	@DescriptionsList
	private Tienda tienda;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@ReferenceView("Simple")
	private Cliente cliente;

	@Digits(integerDigits = 2, fractionalDigits = 0)
	@Required
	@DefaultValueCalculator(PorcentajeIgvCalculator.class)
	private BigDecimal porcentajeigv;

	@Stereotype("MONEY")
	private BigDecimal monto;

	// bi-directional many-to-one association to Detallepedido
	@OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
	@ListProperties("producto.id," + "producto.descripcion," + "cantidad,"
			+ "producto.precio," + "importe,producto.tienda.descripcion")
	private Collection<Detallepedido> detallepedidos = new ArrayList<Detallepedido>();

	@Stereotype("TEXTO_GRANDE")
	private String observaciones;

	// bi-directional many-to-one association to Estadoregistropedido
	@ManyToOne(fetch = FetchType.LAZY)
	@DescriptionsList
	private Estadoregistropedido estadoregistropedido;

	@Transient
	private boolean removing = false;

	@Hidden
	private boolean deleted;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public BigDecimal getPorcentajeigv() {
		if (porcentajeigv == null) {
			return BigDecimal.ZERO;
		}
		return porcentajeigv;
	}

	public void setPorcentajeigv(BigDecimal porcentajeigv) {
		this.porcentajeigv = porcentajeigv;
	}

	public BigDecimal getMonto() {
		return monto;
	}

	public void setMonto(BigDecimal monto) {
		this.monto = monto;
	}

	public Collection<Detallepedido> getDetallepedidos() {
		return detallepedidos;
	}

	public void setDetallepedidos(Collection<Detallepedido> detallepedidos) {
		this.detallepedidos = detallepedidos;
	}

	public Date getFechahoraentrada() {
		return this.fechahoraentrada;
	}

	public void setFechahoraentrada(Date fechahoraentrada) {
		this.fechahoraentrada = fechahoraentrada;
	}

	public Date getFechahorasalida() {
		return this.fechahorasalida;
	}

	public void setFechahorasalida(Date fechahorasalida) {
		this.fechahorasalida = fechahorasalida;
	}

	public String getObservaciones() {
		return this.observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public Tienda getTienda() {
		return this.tienda;
	}

	public void setTienda(Tienda tienda) {
		this.tienda = tienda;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Estadoregistropedido getEstadoregistropedido() {
		return this.estadoregistropedido;
	}

	public void setEstadoregistropedido(
			Estadoregistropedido estadoregistropedido) {
		this.estadoregistropedido = estadoregistropedido;
	}

	// MONTOS CALCULADOS

	// Monto base
	@Stereotype("MONEY")
	public BigDecimal getMontoBase() {
		BigDecimal resultado = new BigDecimal("0.00");
		for (Detallepedido detalle : getDetallepedidos()) {
			resultado = resultado.add(detalle.getImporte());
		}
		return resultado;
	}

	// IGV
	@Stereotype("MONEY")
	@Depends("porcentajeigv")
	public BigDecimal getIgv() {
		return getMontoBase().multiply(getPorcentajeigv()).divide(
				new BigDecimal("100"));
	}

	// TOTAL
	@Stereotype("MONEY")
	@Depends("montoBase, igv")
	public BigDecimal getMontoTotal() {
		return getMontoBase().add(getIgv());
	}

	public void recalculateMonto() {
		setMonto(getMontoTotal());
	}

	// RETROLLAMADAS

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	boolean isRemoving() {
		return removing;
	}

	@PreRemove
	private void markRemoving() {
		this.removing = true;
	}

	@PostRemove
	private void unmarkRemoving() {
		this.removing = false;
	}

}