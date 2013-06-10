package com.proydawii.model;

import javax.persistence.*;

import org.openxava.annotations.*;

//@Entity
public class RegistroPedido extends Identificable {

	@Stereotype("MEMO")
	private String observaciones;
	
}
