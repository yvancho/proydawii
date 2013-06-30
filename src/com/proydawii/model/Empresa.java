package com.proydawii.model;

import javax.persistence.*;
import javax.validation.constraints.*;

import org.openxava.annotations.*;

import com.proydawii.util.*;

import java.util.*;


/**
 * The persistent class for the empresa database table.
 * 
 */
@Entity
public class Empresa extends Identificable {
	
	@Column(length=50,nullable=false,unique=true)
	private String nombre;

	@Column(length=50,nullable=false,unique=true)
	private String nombrecomercial;

	@Column(length=11,nullable=false,unique=true)
	private String ruc;

	@Embedded @Required @NoFrame 	
	private Direccion direccion;
	
	@Stereotype("EMAIL")
	private String email;

	@Stereotype("FOTO")
	private byte[] foto;

	@Required
	@Stereotype("TELEPHONE")
	@Column(length=10,nullable=true)
	@Size(min=6,max=10,message="Ingrese un nro. de teléfono válido por favor.")
	private String nrotelefonofijo;
	
	@Stereotype("WEBURL")
	private String weburl;

	@Stereotype("MEMO")
	private String comentarios;

	//bi-directional many-to-one association to Tienda
	@OneToMany(mappedBy="empresa", cascade=CascadeType.ALL)
	private Collection<Tienda> tiendas = new ArrayList<Tienda>();

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

	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public byte[] getFoto() {
		return foto;
	}

	public void setFoto(byte[] foto) {
		this.foto = foto;
	}

	public String getNrotelefonofijo() {
		return nrotelefonofijo;
	}

	public void setNrotelefonofijo(String nrotelefonofijo) {
		this.nrotelefonofijo = nrotelefonofijo;
	}

	public String getWeburl() {
		return weburl;
	}

	public void setWeburl(String weburl) {
		this.weburl = weburl;
	}

	public String getComentarios() {
		return comentarios;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}

	public Collection<Tienda> getTiendas() {
		return tiendas;
	}

	public void setTiendas(Collection<Tienda> tiendas) {
		this.tiendas = tiendas;
	}
	
	

}