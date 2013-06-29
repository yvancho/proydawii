package com.proydawii.model;

import javax.persistence.*;

import com.proydawii.util.*;


/**
 * The persistent class for the estadoregistropedido database table.
 * 
 */
@Entity
public class Estadoregistropedido extends Identificable{
	
	@Column(length=20,nullable=false,unique=true)
	private String descripcion;

	//bi-directional many-to-one association to Pedido
	/*@OneToMany(mappedBy="estadoregistropedido")
	private Collection<Pedido> pedidos = new ArrayList<Pedido>();

	public Collection<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(Collection<Pedido> pedidos) {
		this.pedidos = pedidos;
	}*/

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}