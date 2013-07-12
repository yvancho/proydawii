package com.proydawii.model;

import javax.persistence.*;
import javax.validation.constraints.*;

import org.openxava.annotations.*;

import com.proydawii.util.*;

/**
 * The persistent class for the cliente database table.
 * 
 */
@Entity
@Views({
		@View(members=
"General [" +
		  " loginuser;" +
		  " loginpassword;" +
		  " tipocliente;" +
		 "]; "+
"Datos Personales [#" +
				   " nombre; " +
				   " apellido; " +
				   " tipodocumento;" +
				   " numeroDocumentoIdentidad; "+
				   " genero;" +
				   " empresacliente; " +
				   " foto;" +
				   " Dirección [direccion];" +				   
				   "]; " +
"Contacto [" +
		   " email; " +	   
		   " telefonocelular; " +
		   " telefonoprincipal; " +		   
		  "];"
),
		@View(name = "Simple", members = "id, nombre, apellido")
})
public class Cliente extends Identificable {

	@Required
	@Column(nullable = false, length = 20, unique = true)
	private String loginuser;

	@Required
	//@Stereotype("PASSWORD")
	private String loginpassword;

	@Required
	@Column(length = 45, unique = false, nullable = false)
	private String nombre;

	@Required
	@Column(length = 45, unique = false, nullable = false)
	private String apellido;

	@Required
	@NoCreate
	@NoModify
	@ManyToOne
	@DescriptionsList
	private Tipodocumento tipodocumento;

	@Column(length = 8, nullable = false, unique = true)
	@Required
	private String numeroDocumentoIdentidad;

	@Required
	@NoCreate
	@NoModify
	@ManyToOne
	@DescriptionsList
	private Generopersona genero;

	@Required
	@NoFrame
	@Embedded
	private Direccion direccion;

	@Required
	@Stereotype("EMAIL")
	private String email;

	@Required
	@Stereotype("TELEPHONE")
	@Column(length = 9, nullable = true)
	@Size(min = 9, max = 9, message = "Ingrese un nro. de celular válido por favor.")
	private String telefonocelular;

	//@Stereotype("TELEPHONE")
	@Column(length = 10, nullable = true)
	@Size(min = 6, max = 7, message = "Ingrese un nro. de teléfono válido por favor.")
	private String telefonoprincipal;

	// bi-directional many-to-one association to Empresacliente
	@ManyToOne(fetch = FetchType.LAZY)
	@DescriptionsList(descriptionProperties="razonsocial")
	private Empresacliente empresacliente;

	@Required
	@ManyToOne(fetch = FetchType.LAZY)
	@DescriptionsList
	private Tipocliente tipocliente;

	@Stereotype("FOTO")
	private byte[] foto;

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

	public Empresacliente getEmpresacliente() {
		return empresacliente;
	}

	public void setEmpresacliente(Empresacliente empresacliente) {
		this.empresacliente = empresacliente;
	}

	/*public String getTelefonoCelular() {
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
	}*/

	public String getNombre() {
		return nombre;
	}

	public String getTelefonocelular() {
		return telefonocelular;
	}

	public void setTelefonocelular(String telefonocelular) {
		this.telefonocelular = telefonocelular;
	}

	public String getTelefonoprincipal() {
		return telefonoprincipal;
	}

	public void setTelefonoprincipal(String telefonoprincipal) {
		this.telefonoprincipal = telefonoprincipal;
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

	public Generopersona getGenero() {
		return genero;
	}

	public void setGenero(Generopersona genero) {
		this.genero = genero;
	}

	public Direccion getDireccion() {
		return direccion;
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

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Tipocliente getTipocliente() {
		return tipocliente;
	}

	public void setTipocliente(Tipocliente tipocliente) {
		this.tipocliente = tipocliente;
	}

	public byte[] getFoto() {
		return foto;
	}

	public void setFoto(byte[] foto) {
		this.foto = foto;
	}

}