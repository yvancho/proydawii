package com.proydawii.model;

import java.util.*;

import javax.persistence.*;
import javax.validation.constraints.*;

import org.openxava.annotations.*;

import com.proydawii.util.*;

/**
 * The persistent class for the repartidor database table.
 * 
 */
@Entity
@Views({
	@View(name="Simple",
		  members="id,nombre,apellido,loginuser")
})
public class Repartidor extends Identificable {

	@Required
	@Column(nullable = false, length = 20, unique = true)
	private String loginuser;
	
	@Required
	@Stereotype("PASSWORD")
	private String loginpassword;
	
	@Required
	@Column(length = 45, unique = false, nullable = false)
	private String nombre;
	
	@Required
	@Column(length = 45, unique = false, nullable = false)
	private String apellido;
	
	@Required
	// @NoCreate
	@NoModify
	@ManyToOne
	@DescriptionsList
	private Tipodocumento tipodocumento;
	
	@Column(length = 20, nullable = false, unique = true)
	@Required
	private String numeroDocumentoIdentidad;
	
	// bi-directional many-to-one association to Tienda
	@ManyToOne(fetch = FetchType.LAZY)
	@DescriptionsList
	private Tienda tienda;
	
	@Required
	// @NoCreate
	@NoModify
	@ManyToOne
	@DescriptionsList
	private Generopersona genero;
	
	@Required
	@NoFrame
	@Embedded
	private Direccion direccion;
	
	@Required
	@Stereotype("TELEPHONE")
	@Column(length = 9, nullable = true)
	@Size(min = 9, message = "Ingrese un nro. de celular válido por favor.")
	private String telefonoCelular;
	
	@Stereotype("TELEPHONE")
	@Column(length = 10, nullable = true)
	@Size(min = 6, max = 10, message = "Ingrese un nro. de teléfono válido por favor.")
	private String telefonoPrincipal;
	
	@Required
	@Column(nullable = false, length = 50, unique = true)
	@Stereotype("EMAIL")
	private String email;
	
	@Stereotype("FOTO")
	private byte[] foto;

	@OneToMany(mappedBy="repartidor")
	private Collection<Detallepedido> detallepedidos = new ArrayList<Detallepedido>();			
	
	public Tienda getTienda() {
		return tienda;
	}

	public void setTienda(Tienda tienda) {
		this.tienda = tienda;
	}

	public String getLoginuser() {
		return loginuser;
	}

	public void setLoginuser(String loginuser) {
		this.loginuser = loginuser;
	}

	public String getLoginpassword() {
		return loginpassword;
	}

	public void setLoginpassword(String loginpassword) {
		this.loginpassword = loginpassword;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Tipodocumento getTipodocumento() {
		return tipodocumento;
	}

	public void setTipodocumento(Tipodocumento tipodocumento) {
		this.tipodocumento = tipodocumento;
	}

	public String getNumeroDocumentoIdentidad() {
		return numeroDocumentoIdentidad;
	}

	public void setNumeroDocumentoIdentidad(String numeroDocumentoIdentidad) {
		this.numeroDocumentoIdentidad = numeroDocumentoIdentidad;
	}

	public Generopersona getGenero() {
		return genero;
	}

	public void setGenero(Generopersona genero) {
		this.genero = genero;
	}

	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	public String getTelefonoCelular() {
		return telefonoCelular;
	}

	public void setTelefonoCelular(String telefonoCelular) {
		this.telefonoCelular = telefonoCelular;
	}

	public String getTelefonoPrincipal() {
		return telefonoPrincipal;
	}

	public void setTelefonoPrincipal(String telefonoPrincipal) {
		this.telefonoPrincipal = telefonoPrincipal;
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

	public Collection<Detallepedido> getDetallepedidos() {
		return detallepedidos;
	}

	public void setDetallepedidos(Collection<Detallepedido> detallepedidos) {
		this.detallepedidos = detallepedidos;
	}

	
	
}