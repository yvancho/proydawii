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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((udcod == null) ? 0 : udcod.hashCode());
		result = prime * result + ((udicod == null) ? 0 : udicod.hashCode());
		result = prime * result + ((upcod == null) ? 0 : upcod.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof UbigeoDistPK)) {
			return false;
		}
		UbigeoDistPK other = (UbigeoDistPK) obj;
		if (udcod == null) {
			if (other.udcod != null) {
				return false;
			}
		} else if (!udcod.equals(other.udcod)) {
			return false;
		}
		if (udicod == null) {
			if (other.udicod != null) {
				return false;
			}
		} else if (!udicod.equals(other.udicod)) {
			return false;
		}
		if (upcod == null) {
			if (other.upcod != null) {
				return false;
			}
		} else if (!upcod.equals(other.upcod)) {
			return false;
		}
		return true;
	}
	
	
}