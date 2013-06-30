package com.proydawii.model;

import javax.persistence.*;
import javax.validation.constraints.*;

import org.hibernate.validator.Min;
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
	
	@Column(length=20,nullable=false,unique=true)
	@Required
	private String nrodocid;
	
	@Required
	@Column(length=45,unique=false,nullable=false)
	private String nombre;

	@Required
	@Column(length=45,unique=false,nullable=false)
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
	@Column(length=10,nullable=true)
	@Size(min=6,max=10,message="Ingrese un nro. de teléfono válido por favor.")
	private String nrotelefonofijo;
	
	@Required
	@Stereotype("TELEPHONE")
	@Column(length=9,nullable=true)
	@Size(min=9,message="Ingrese un nro. de celular válido por favor.")
	private String nrocelular;

	@Required
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

	public String getNrotelefonofijo() {
		return nrotelefonofijo;
	}

	public void setNrotelefonofijo(String nrotelefonofijo) {
		this.nrotelefonofijo = nrotelefonofijo;
	}

	public String getNrocelular() {
		return nrocelular;
	}

	public void setNrocelular(String nrocelular) {
		this.nrocelular = nrocelular;
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