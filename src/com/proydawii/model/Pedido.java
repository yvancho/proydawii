package com.proydawii.model;

import javax.persistence.*;

//import org.hibernate.validator.*;
import org.openxava.annotations.*;

import com.proydawii.util.*;

import java.math.*;
import java.util.*;

/**
 * The persistent class for the pedido database table.
 * 
 */
@Entity
@Views({
@View(members = 
	"Datos Generales {# " +
					  "fechahoraregistro, tienda;" +
					  "fechahorasalida, estadopedido;" +
					  "fechahoraentrada;" +
					  "cliente;" +
					  "Ubigeo [direcciondestino;" +
					  		  "referenciadirdestino];"+
					  "porcentajeigv, monto;" +
					  "observaciones"+
					 "};" +
	"Detalle del Pedido {detallepedidos};" +
	"Facturación {facturaciones}")
})
public class Pedido extends Identificable{

	/*@Id
	@DefaultValueCalculator(value = SiguienteIdPorYearCalculator.class)
	@ReadOnly
	private int id;*/

	@Stereotype("DATETIME")
	private Date fechahoraregistro;

	@Stereotype("DATETIME")
	private Date fechahorasalida;
	
	@Stereotype("DATETIME")
	private Date fechahoraentrada;

	// bi-directional many-to-one association to Tienda
	@ManyToOne(fetch = FetchType.LAZY)
	@NoCreate @NoModify
	@DescriptionsList
	private Tienda tienda;

	// bi-directional many-to-one association to Estadoregistropedido
	@ManyToOne(fetch = FetchType.LAZY)
	@NoCreate @NoModify
	@DescriptionsList
	private Estadopedido estadopedido;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@ReferenceView("Simple")
	private Cliente cliente;

	// bi-directional many-to-one association to Detallepedido
	@OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
	//@ListProperties("productotienda.id," + "productotienda.descripcion," + "cantidad,"
		//	+ "productotienda.precio," + "importe, productotienda.tienda.descripcion")
	private Collection<Detallepedido> detallepedidos = new ArrayList<Detallepedido>();

	@OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
	private Collection<Facturacion> facturaciones = new ArrayList<Facturacion>();

	@Stereotype("DINERO")
	@Column(precision=10, scale=2)
	private BigDecimal monto;
	
	@Column(precision=10, scale=2)
	private BigDecimal porcentajeigv;

	@Hidden
	//private byte ultimopedido;
	private int ultimopedido;
	
	@Column(length=50)
	private String direcciondestino;
	
	@Column(length=100)
	private String referenciadirdestino;

	/*
	 * Por defecto 0 = activo / 1 = anulado
	 */
	@Hidden
	@Column(nullable=true, length=1)
	private String deleted;

	@Stereotype("TEXTO_GRANDE")
	private String observaciones;

	/*public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}*/

	public Date getFechahoraregistro() {
		return fechahoraregistro;
	}

	public void setFechahoraregistro(Date fechahoraregistro) {
		this.fechahoraregistro = fechahoraregistro;
	}

	public Date getFechahorasalida() {
		return fechahorasalida;
	}

	public void setFechahorasalida(Date fechahorasalida) {
		this.fechahorasalida = fechahorasalida;
	}

	public Date getFechahoraentrada() {
		return fechahoraentrada;
	}

	public void setFechahoraentrada(Date fechahoraentrada) {
		this.fechahoraentrada = fechahoraentrada;
	}

	public Tienda getTienda() {
		return tienda;
	}

	public void setTienda(Tienda tienda) {
		this.tienda = tienda;
	}

	public Estadopedido getEstadopedido() {
		return estadopedido;
	}

	public void setEstadopedido(Estadopedido estadopedido) {
		this.estadopedido = estadopedido;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Collection<Detallepedido> getDetallepedidos() {
		return detallepedidos;
	}

	public void setDetallepedidos(Collection<Detallepedido> detallepedidos) {
		this.detallepedidos = detallepedidos;
	}

	public Collection<Facturacion> getFacturaciones() {
		return facturaciones;
	}

	public void setFacturaciones(Collection<Facturacion> facturaciones) {
		this.facturaciones = facturaciones;
	}

	public BigDecimal getMonto() {
		return monto;
	}

	public void setMonto(BigDecimal monto) {
		this.monto = monto;
	}

	public BigDecimal getPorcentajeigv() {
		return porcentajeigv;
	}

	public void setPorcentajeigv(BigDecimal porcentajeigv) {
		this.porcentajeigv = porcentajeigv;
	}

	/*public byte getUltimopedido() {
		return ultimopedido;
	}

	public void setUltimopedido(byte ultimopedido) {
		this.ultimopedido = ultimopedido;
	}*/

	public int getUltimopedido() {
		return ultimopedido;
	}

	public void setUltimopedido(int ultimopedido) {
		this.ultimopedido = ultimopedido;
	}

	public String getDirecciondestino() {
		return direcciondestino;
	}

	public void setDirecciondestino(String direcciondestino) {
		this.direcciondestino = direcciondestino;
	}

	public String getReferenciadirdestino() {
		return referenciadirdestino;
	}

	public void setReferenciadirdestino(String referenciadirdestino) {
		this.referenciadirdestino = referenciadirdestino;
	}

	public String getDeleted() {
		return deleted;
	}

	public void setDeleted(String deleted) {
		this.deleted = deleted;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	
	
	//@Transient
	//private boolean removing = false;

  //@Hidden
	//private boolean deleted;


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