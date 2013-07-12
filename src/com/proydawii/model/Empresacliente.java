package com.proydawii.model;

import javax.persistence.*;

import com.proydawii.util.*;

import java.util.*;

@Entity
public class Empresacliente extends Identificable {
	
	@Column(length=200)
	private String razonsocial;

	@Column(length=11)
	private String ruc;

	//bi-directional many-to-one association to Cliente
	@OneToMany(mappedBy="empresacliente", cascade=CascadeType.ALL)
	private Collection<Cliente> clientes = new ArrayList<Cliente>();

	public String getRazonsocial() {
		return razonsocial;
	}

	public void setRazonsocial(String razonsocial) {
		this.razonsocial = razonsocial;
	}

	public String getRuc() {
		return ruc;
	}

	public void setRuc(String ruc) {
		this.ruc = ruc;
	}

	public Collection<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(Collection<Cliente> clientes) {
		this.clientes = clientes;
	}

	
}