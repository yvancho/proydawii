package com.proydawii.model;

import java.util.*;

import javax.persistence.*;

import org.openxava.annotations.*;
import org.openxava.model.*;

@Entity
public class Factura extends Identifiable {

	@Stereotype("DATETIME")
	private Date fechahoraregistro;
	
	@Required
	@ManyToOne(fetch=FetchType.LAZY)
	private Pedido pedido;
	
	@Stereotype("TEXTO_GRANDE")
	private String observaciones;

	public Date getFechahoraregistro() {
		return fechahoraregistro;
	}

	public void setFechahoraregistro(Date fechahoraregistro) {
		this.fechahoraregistro = fechahoraregistro;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	
	
}
