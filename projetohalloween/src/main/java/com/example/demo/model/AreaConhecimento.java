package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "TB_AreaConhecimento")
public class AreaConhecimento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Integer areaConhecimentoID;

	@Column(name = "DESCR")
	private String descricao;

	
	public Integer getAreaConhecimentoID() {
		return areaConhecimentoID;
	}

	public void setAreaConhecimentoID(Integer areaConhecimentoID) {
		this.areaConhecimentoID = areaConhecimentoID;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public AreaConhecimento() {
	}

	public AreaConhecimento(Integer areaConhecimentoID, String descricao) {
		super();
		this.areaConhecimentoID = areaConhecimentoID;
		this.descricao = descricao;
	}

	@Override
	public String toString() {
		return "AreaConhecimento [areaConhecimentoID=" +areaConhecimentoID + ", descricao=" + descricao + "]";
	}

}
