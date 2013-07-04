package com.proydawii.model;

import javax.persistence.*;

@Entity
public class UbigeoPais {
	@Id
	@Column(name="cod_pais", unique=true, nullable=false, length=3)
	private String codigo;
	
	@Column(name="nom_pais", length=200)
	private String nombre;
}
