package com.proydawii.model;

import javax.persistence.*;
import javax.validation.constraints.*;

import org.openxava.annotations.*;

import com.proydawii.util.*;

import java.math.*;
import java.util.*;


/**
 * The persistent class for the empresa database table.
 * 
 */
@Entity
public class Empresacomercial extends Identificable {
	
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

	@Required
	@Stereotype("TELEPHONE")
	@Column(length=10,nullable=true)
	@Size(min=6,max=10,message="Ingrese un nro. de teléfono válido por favor.")
	private String nrotelefonofijo;
	
	@Stereotype("FOTO")
	private byte[] foto;

	//bi-directional many-to-one association to Tienda
	@OneToMany(mappedBy="empresacomercial", cascade=CascadeType.ALL)
	private Collection<Tienda> tiendas = new ArrayList<Tienda>();

	@Stereotype("DINERO")
	@Column(precision=10, scale=2)
	private BigDecimal porcimpconsumo;
	
	@Stereotype("WEBURL")
	private String weburl;

	@Stereotype("MEMO")
	private String observaciones;

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public BigDecimal getPorcimpconsumo() {
		return porcimpconsumo;
	}

	public void setPorcimpconsumo(BigDecimal porcimpconsumo) {
		this.porcimpconsumo = porcimpconsumo;
	}

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
	

	public Collection<Tienda> getTiendas() {
		return tiendas;
	}

	public void setTiendas(Collection<Tienda> tiendas) {
		this.tiendas = tiendas;
	}
	
	

}