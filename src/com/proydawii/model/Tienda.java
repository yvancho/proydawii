package com.proydawii.model;

import javax.persistence.*;

import org.openxava.annotations.*;

@Entity
public class Tienda extends Identificable {
	@Required
	@Column(length = 50, unique = true, nullable = false)
	private String descripcion;
	
	@Embedded
	private Direccion domiciliofiscal;
	
	@Stereotype("TELEPHONE")
	private String telefono;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private Empresa empresa;

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Direccion getDomiciliofiscal() {
		return domiciliofiscal;
	}

	public void setDomiciliofiscal(Direccion domiciliofiscal) {
		this.domiciliofiscal = domiciliofiscal;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
}
