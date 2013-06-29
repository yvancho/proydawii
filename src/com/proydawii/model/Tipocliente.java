package com.proydawii.model;

import javax.persistence.*;

import com.proydawii.util.*;


/**
 * The persistent class for the tipocliente database table.
 * 
 */
@Entity
public class Tipocliente extends Identificable {
	

	private String descripcion;

	//bi-directional many-to-one association to Cliente
	/*@OneToMany(mappedBy="tipocliente")
	private Collection<Cliente> clientes = new ArrayList<Cliente>();

	public Collection<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(Collection<Cliente> clientes) {
		this.clientes = clientes;
	}
*/
	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}