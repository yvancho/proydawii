package com.proydawii.model;

import javax.persistence.*;

import org.openxava.annotations.*;

@MappedSuperclass
public class Identificable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Hidden	
	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	} 
	
	
	
}
