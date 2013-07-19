package com.proydawii.model;

import javax.persistence.*;

import org.openxava.annotations.*;

import com.proydawii.util.*;

/**
 * The persistent class for the categoriaproducto database table.
 * 
 */
@Entity
@Tabs({
	@Tab(properties="id,descripcion"),
	@Tab(name="Simple",properties="id,descripcion")
})
public class Categoriaproducto extends Identificable {

	@Column(length=50,nullable=false,unique=true)
	private String descripcion;
	
	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}