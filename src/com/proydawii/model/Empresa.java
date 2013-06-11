package com.proydawii.model;

import java.util.*;

import javax.persistence.*;

import org.openxava.annotations.*;

@Entity
public class Empresa extends Identificable {
	
	@Column(length=50, nullable=false, unique=true)
	@Required
	private String nombre;
	
	@Column(length=50, nullable=false, unique=true)
	@Required
	private String nombrecomercial;
	
	@Column(length=11, nullable=false, unique=true)
	@Required
	private String ruc;
	
	@Embedded
	private Direccion domiciliofiscal;
	
	@Stereotype("TELEPHONE")
	private String telefono;
	
	@Stereotype("EMAIL")
	private String email;
	
	@Stereotype("WEBURL")
	private String weburl;
	
	@Stereotype("PHOTO")
	private byte[] photo;
	
	@Stereotype("MEMO")
	private String comentarios;
	
	@OneToMany(mappedBy="empresa",cascade = CascadeType.ALL)
	private Collection<Tienda> tienda = new ArrayList<Tienda>();

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNombrecomercial() {
		return nombrecomercial;
	}

	public void setNombrecomercial(String nombrecomercial) {
		this.nombrecomercial = nombrecomercial;
	}

	public String getRuc() {
		return ruc;
	}

	public void setRuc(String ruc) {
		this.ruc = ruc;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getWeburl() {
		return weburl;
	}

	public void setWeburl(String weburl) {
		this.weburl = weburl;
	}

	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

	public String getComentarios() {
		return comentarios;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}

	public Collection<Tienda> getTienda() {
		return tienda;
	}

	public void setTienda(Collection<Tienda> tienda) {
		this.tienda = tienda;
	}

	
	
}
