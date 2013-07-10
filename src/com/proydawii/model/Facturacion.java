package com.proydawii.model;

import java.util.*;

import javax.persistence.*;

import org.openxava.annotations.*;
import org.openxava.model.*;

@Entity
public class Facturacion extends Identifiable {

	@Stereotype("DATETIME")
	private Date fechafacturacion;
	
	@Column(length=50)
	private String razonsocial;
	
	@Column(length=11)
	private String numerodoc;
	
	@Required
	@ManyToOne(fetch=FetchType.LAZY)
	private Pedido pedido;
	
	@Required @ManyToOne
	@DescriptionsList
	private Tipocomprobante tipocomprobante;
	
	@OneToMany(mappedBy="facturacion", cascade = CascadeType.ALL)
	private Collection<Detallefacturacion> detallefacturacion = new ArrayList<Detallefacturacion>();
	
	@Stereotype("TEXTO_GRANDE")
	private String observaciones;
	
	@Column(length=1)
	private String deleted;

	public Collection<Detallefacturacion> getDetallefacturacion() {
		return detallefacturacion;
	}

	public void setDetallefacturacion(
			Collection<Detallefacturacion> detallefacturacion) {
		this.detallefacturacion = detallefacturacion;
	}

	public Date getFechafacturacion() {
		return fechafacturacion;
	}

	public void setFechafacturacion(Date fechafacturacion) {
		this.fechafacturacion = fechafacturacion;
	}

	public String getRazonsocial() {
		return razonsocial;
	}

	public void setRazonsocial(String razonsocial) {
		this.razonsocial = razonsocial;
	}

	public String getNumerodoc() {
		return numerodoc;
	}

	public void setNumerodoc(String numerodoc) {
		this.numerodoc = numerodoc;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public Tipocomprobante getTipocomprobante() {
		return tipocomprobante;
	}

	public void setTipocomprobante(Tipocomprobante tipocomprobante) {
		this.tipocomprobante = tipocomprobante;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public String getDeleted() {
		return deleted;
	}

	public void setDeleted(String deleted) {
		this.deleted = deleted;
	}
	
	
	
}
