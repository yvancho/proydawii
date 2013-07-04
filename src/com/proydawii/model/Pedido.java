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
@View(members = "id," + "fechahoraregistro,fechahorasalida,fechahoraentrada,"
		+ "estadoregistropedido," + "tienda; " + 
		"data {cliente;detallepedidos;observaciones}")
		/*"montos[" + "porcentajeigv, " + "montoBase,"
		+ "igv," + "montoTotal" + "];"+ */
		
public class Pedido {

	@Id
	@DefaultValueCalculator(value = SiguienteIdPorYearCalculator.class)
	@ReadOnly
	private int id;

	@Hidden
	@Stereotype("DATETIME")
	private Date fechahoraregistro;

	@Stereotype("DATETIME")
	private Date fechahorasalida;
	
	@Stereotype("DATETIME")
	private Date fechahoraentrada;

	// bi-directional many-to-one association to Estadoregistropedido
	@ManyToOne(fetch = FetchType.LAZY)
	@DescriptionsList
	private Estadoregistropedido estadoregistropedido;

	// bi-directional many-to-one association to Tienda
	@ManyToOne(fetch = FetchType.LAZY)
	@DescriptionsList
	private Tienda tienda;

	// bi-directional many-to-one association to Detallepedido
	@OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
	//@ListProperties("productotienda.id," + "productotienda.descripcion," + "cantidad,"
		//	+ "productotienda.precio," + "importe, productotienda.tienda.descripcion")
	private Collection<Detallepedido> detallepedidos = new ArrayList<Detallepedido>();

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@ReferenceView("Simple")
	private Cliente cliente;
	
	@OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
	private Collection<Factura> facturas = new ArrayList<Factura>();

	@Stereotype("TEXTO_GRANDE")
	private String observaciones;	

	//@Transient
	//private boolean removing = false;

  //@Hidden
	//private boolean deleted;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
/*
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
	}*/

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

	public Date getFechahoraregistro() {
		return fechahoraregistro;
	}

	public void setFechahoraregistro(Date fechahoraregistro) {
		this.fechahoraregistro = fechahoraregistro;
	}

	public Collection<Factura> getFacturas() {
		return facturas;
	}

	public void setFacturas(Collection<Factura> facturas) {
		this.facturas = facturas;
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
	/*
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
	}*/

	// RETROLLAMADAS
/*
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
*/
}