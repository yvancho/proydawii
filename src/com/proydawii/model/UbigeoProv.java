package com.proydawii.model;

import java.io.Serializable;
import javax.persistence.*;

import java.util.*;


/**
 * The persistent class for the ubigeo_prov database table.
 * 
 */
@Entity
@Table(name="ubigeo_prov")
public class UbigeoProv implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private UbigeoProvPK id;

	@Column(name="up_nombre", length=200)
	private String upnombre;

	//bi-directional many-to-one association to UbigeoDist
	@OneToMany(mappedBy="ubigeoprov")
	private Collection<UbigeoDist> ubigeodists = new ArrayList<UbigeoDist>();

	//bi-directional many-to-one association to UbigeoDepa
	@ManyToOne(fetch=FetchType.LAZY)
	//@DescriptionsList
	@JoinColumn(name="ud_cod", nullable=false, insertable=false, updatable=false)
	private UbigeoDepa ubigeodepa;

	public UbigeoProvPK getId() {
		return id;
	}

	public void setId(UbigeoProvPK id) {
		this.id = id;
	}

	public String getUpnombre() {
		return upnombre;
	}

	public void setUpnombre(String upnombre) {
		this.upnombre = upnombre;
	}

	public Collection<UbigeoDist> getUbigeodists() {
		return ubigeodists;
	}

	public void setUbigeodists(Collection<UbigeoDist> ubigeodists) {
		this.ubigeodists = ubigeodists;
	}

	public UbigeoDepa getUbigeodepa() {
		return ubigeodepa;
	}

	public void setUbigeodepa(UbigeoDepa ubigeodepa) {
		this.ubigeodepa = ubigeodepa;
	}
	
	

}