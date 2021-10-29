package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TB_Municipio")
public class Municipio {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Integer municipioID;

	@Column(name = "DESCR")
	private String descricao;

	@Column(name = "SiglaUF")
	private String siglaUF;

	public Integer getMunicipioID() {
		return municipioID;
	}

	public void setMunicipioID(Integer municipioID) {
		this.municipioID = municipioID;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getSiglaUF() {
		return siglaUF;
	}

	public void setSiglaUF(String siglaUF) {
		this.siglaUF = siglaUF;
	}

	public Municipio() {
	}

	public Municipio(Integer municipioID, String descricao, String siglaUF) {
		super();
		this.municipioID = municipioID;
		this.descricao = descricao;
		this.siglaUF = siglaUF;
	}

	@Override
	public String toString() {
		return "Municipio [municipioID=" + municipioID + ", descricao=" + descricao + ", siglaUF=" + siglaUF + "]";
	}

}
