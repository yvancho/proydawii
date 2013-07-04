package com.proydawii.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the ubigeo_dist database table.
 * 
 */
@Embeddable
public class UbigeoDistPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="udi_cod", unique=true, nullable=false, length=5)
	private String udicod;

	@Column(name="up_cod", unique=true, nullable=false, length=5)
	private String upcod;

	@Column(name="ud_cod", unique=true, nullable=false, length=5)
	private String udcod;

	public UbigeoDistPK() {
	}

	public String getUdicod() {
		return udicod;
	}

	public void setUdicod(String udicod) {
		this.udicod = udicod;
	}

	public String getUpcod() {
		return upcod;
	}

	public void setUpcod(String upcod) {
		this.upcod = upcod;
	}

	public String getUdcod() {
		return udcod;
	}

	public void setUdcod(String udcod) {
		this.udcod = udcod;
	}
	
	
}