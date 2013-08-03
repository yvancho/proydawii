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

//@Views({
	//@View(members="")
//})
@Entity
public class Detallepedido extends Identificable {

	// bi-directional many-to-one association to Pedido
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@NoCreate @NoModify
	@ReferenceView("Simple")
	private Pedido pedido;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@NoCreate @NoModify
	@ReferenceView("Simple")
	private Repartidor repartidor;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@NoCreate @NoModify
	@ReferenceView("Simple")
	private Productotienda productotienda;

	@DefaultValueCalculator(
			value = PrecioPorUnidad.class,
			properties = 
				@PropertyValue(name = "productoId", 
							   from = "productotienda.id"))
	@Stereotype("DINERO")
	private BigDecimal preciounitario;

	@Stereotype("DINERO")
	private BigDecimal preciocosto;

	@Required
	@Column(nullable = false, updatable = true)
	private int cantidad;
	
	/*
	@Stereotype("DINERO")
	private BigDecimal ganancia;
*/
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

	/*
	public BigDecimal getGanancia() {
		return ganancia;
	}

	public void setGanancia(BigDecimal ganancia) {
		this.ganancia = ganancia;
	}
*/
	
	// PROPIEDADES CALCULADAS

	//IMPORTE DE LA TIENDA
	@Stereotype("MONEY")
	@Depends("productotienda.id, cantidad")
	public BigDecimal getImporteTienda() {
		return new BigDecimal(cantidad).multiply(productotienda
				.getProductoempresa().getPrecioventa());
	}
	
	//IMPORTE CON GANANCIA
	@Stereotype("MONEY")
	@Depends("productotienda.id, cantidad,preciocosto")
	public BigDecimal getImporteReal() {
		return new BigDecimal(cantidad).multiply(this.preciocosto);
	}
	
	//GANANCIA
	@Stereotype("MONEY")
	@Depends("importeTienda,importeReal")
	public BigDecimal getGananciaReal() {
		return getImporteReal().subtract(this.getImporteTienda());
	}
	
	 // METODOS DE RETRO-LLAMADA
	  
	 /* @PrePersist 
	  private void onPersist() {
		  getPedido().getDetallepedidos().add(this);
		  getPedido().recalculateMonto(); 
	  }
	  
	  @PreUpdate 
	  private void onUpdate() { 
		  getPedido().recalculateMonto(); 
	  }
	  
	 @PreRemove 
	 private void onRemove() { 
		 if (getPedido().isRemoving()) {
			 return; 
		 } 
		 getPedido().getDetallepedidos().remove(this);
		 getPedido().recalculateMonto(); 
	  }*/
	 
}