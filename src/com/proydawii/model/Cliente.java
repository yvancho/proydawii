package com.proydawii.model;

import javax.persistence.*;

import org.openxava.annotations.*;

@Entity
public class Cliente extends Usuario {

	@Required
	@ManyToOne(fetch=FetchType.LAZY)
	@DescriptionsList
	private Tipocliente tipo;
	
	public Tipocliente getTipo() {
		return tipo;
	}

	public void setTipo(Tipocliente tipo) {
		this.tipo = tipo;
	}
	
	
}
