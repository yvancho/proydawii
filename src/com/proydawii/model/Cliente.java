package com.proydawii.model;

import javax.persistence.*;

import org.openxava.annotations.*;

import com.proydawii.util.*;


/**
 * The persistent class for the cliente database table.
 * 
 */
@Entity
@View(name="Simple",
	  members="id, nombre, apellido")
public class Cliente extends Identificable {
	
	@ManyToOne
	@DescriptionsList
	private TipoDocumento tipodocumento;
	
	@Column(length=20,nullable=false)
	@Required
	private String nrodocid;
	
	@Required
	@Column(nullable=false)
	private String nombre;

	@Required
	@Column(nullable=false)
	private String apellido;

	@Required
	@NoFrame @Embedded
	private Direccion direccion;

	@Required
	@Column(nullable=false,length=50,unique=true)
	@Stereotype("EMAIL")
	private String email;

	@Required
	@Stereotype("TELEPHONE")
	@Column(nullable=false)
	private String telefono;

	@Required
	//bi-directional many-to-one association to Tipocliente
	@ManyToOne(fetch=FetchType.LAZY)
	@DescriptionsList
	private Tipocliente tipocliente;
	
	@Stereotype("FOTO")
	private byte[] foto;

	public TipoDocumento getTipodocumento() {
		return tipodocumento;
	}

	public void setTipodocumento(TipoDocumento tipodocumento) {
		this.tipodocumento = tipodocumento;
	}

	public String getNrodocid() {
		return nrodocid;
	}

	public void setNrodocid(String nrodocid) {
		this.nrodocid = nrodocid;
	}

	public byte[] getFoto() {
		return foto;
	}

	public void setFoto(byte[] foto) {
		this.foto = foto;
	}

	public String getApellido() {
		return this.apellido;
	}

	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Tipocliente getTipocliente() {
		return this.tipocliente;
	}

	public void setTipocliente(Tipocliente tipocliente) {
		this.tipocliente = tipocliente;
	}


	
	

}