package com.proydawii.model;

import javax.persistence.*;


/**
 * The persistent class for the ubigeo_dist database table.
 * 
 */
@Entity
@Table(name="ubigeo_dist")
public class UbigeoDist {


	@EmbeddedId
	private UbigeoDistPK id;

	@Column(name="udi_nombre", length=200)
	private String udinombre;

	//bi-directional many-to-one association to UbigeoProv
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name="up_cod", referencedColumnName="up_cod", nullable=false, insertable=false, updatable=false),
		@JoinColumn(name="ud_cod", referencedColumnName="ud_cod", nullable=false, insertable=false, updatable=false)
		})
	private UbigeoProv ubigeoprov;

	public UbigeoDist() {
	}

	public UbigeoDistPK getId() {
		return id;
	}

	public void setId(UbigeoDistPK id) {
		this.id = id;
	}

	public String getUdinombre() {
		return udinombre;
	}

	public void setUdinombre(String udinombre) {
		this.udinombre = udinombre;
	}

	public UbigeoProv getUbigeoprov() {
		return ubigeoprov;
	}

	public void setUbigeoprov(UbigeoProv ubigeoprov) {
		this.ubigeoprov = ubigeoprov;
	}

	

}