package com.proydawii.model;

import javax.persistence.*;

import org.openxava.annotations.*;

import com.proydawii.util.*;

@Entity
@View(name="Simple",members="nompais,nomdep,nomprov,nomdist;")
//@Tab(properties="")
public class Ubigeo extends Identificable{
	
	@Column(name="cod_pais", length=3, nullable=false)
	private String codpais;
	
	@Column(name="cod_dep", length=5, nullable=false)
	private String coddep;

	@Column(name="cod_pro", length=7, nullable=false)
	private String codpro;

	@Column(name="cod_dis", length=9, nullable=false)
	private String coddis;

	@Column(name="nom_pais", length=20, nullable=false)
	private String nompais;
	
	@Column(name="nom_dep", length=20, nullable=false)
	private String nomdep;

	@Column(name="nom_prov", length=40, nullable=false)
	private String nomprov;

	@Column(name="nom_dist", length=40, nullable=false)
	private String nomdist;

	public String getCodpais() {
		return codpais;
	}

	public void setCodpais(String codpais) {
		this.codpais = codpais;
	}

	public String getNompais() {
		return nompais;
	}

	public void setNompais(String nompais) {
		this.nompais = nompais;
	}

	public String getCoddep() {
		return coddep;
	}

	public void setCoddep(String coddep) {
		this.coddep = coddep;
	}

	public String getCodpro() {
		return codpro;
	}

	public void setCodpro(String codpro) {
		this.codpro = codpro;
	}

	public String getCoddis() {
		return coddis;
	}

	public void setCoddis(String coddis) {
		this.coddis = coddis;
	}

	public String getNomdep() {
		return nomdep;
	}

	public void setNomdep(String nomdep) {
		this.nomdep = nomdep;
	}

	public String getNomdist() {
		return nomdist;
	}

	public void setNomdist(String nomdist) {
		this.nomdist = nomdist;
	}

	public String getNomprov() {
		return nomprov;
	}

	public void setNomprov(String nomprov) {
		this.nomprov = nomprov;
	}

	/*
	//bi-directional many-to-one association to Cliente
	@OneToMany(mappedBy="ubigeo")
	private Collection<Cliente> clientes = new ArrayList<Cliente>();

	//bi-directional many-to-one association to Empresa
	@OneToMany(mappedBy="ubigeo")
	private Collection<Empresa> empresas = new ArrayList<Empresa>();

	//bi-directional many-to-one association to Repartidor
	@OneToMany(mappedBy="ubigeo")
	private Collection<Repartidor> repartidores = new ArrayList<Repartidor>();

	//bi-directional many-to-one association to Tienda
	@OneToMany(mappedBy="ubigeo")
	private Collection<Tienda> tiendas = new ArrayList<Tienda>();
*/
	
/*
	public Collection<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(Collection<Cliente> clientes) {
		this.clientes = clientes;
	}

	public Collection<Empresa> getEmpresas() {
		return empresas;
	}

	public void setEmpresas(Collection<Empresa> empresas) {
		this.empresas = empresas;
	}

	public Collection<Repartidor> getRepartidores() {
		return repartidores;
	}

	public void setRepartidores(Collection<Repartidor> repartidores) {
		this.repartidores = repartidores;
	}

	public Collection<Tienda> getTiendas() {
		return tiendas;
	}

	public void setTiendas(Collection<Tienda> tiendas) {
		this.tiendas = tiendas;
	}
*/	
}