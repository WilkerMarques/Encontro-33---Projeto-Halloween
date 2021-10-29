package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TB_Pais")
public class Pais {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Integer paisID;

	@Column(name = "SIGLA_PAIS")
	private String siglaPais;

	@Column(name = "COD_IDIOMA")
	private String siglaIdioma;

	@Column(name = "DESCR")
	private String descricao;

	public Integer getPaisID() {
		return paisID;
	}

	public void setPaisID(Integer paisID) {
		this.paisID = paisID;
	}

	public String getSiglaPais() {
		return siglaPais;
	}

	public void setSiglaPais(String siglaPais) {
		this.siglaPais = siglaPais;
	}

	public String getSiglaIdioma() {
		return siglaIdioma;
	}

	public void setSiglaIdioma(String siglaIdioma) {
		this.siglaIdioma = siglaIdioma;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Pais() {
	}

	public Pais(Integer paisID, String siglaPais, String siglaIdioma, String descricao) {
		super();
		this.paisID = paisID;
		this.siglaPais = siglaPais;
		this.siglaIdioma = siglaIdioma;
		this.descricao = descricao;
	}

	@Override
	public String toString() {
		return "Pais [paisID=" + paisID + ", siglaPais=" + siglaPais + ", siglaIdioma=" + siglaIdioma + ", descricao="
				+ descricao + "]";
	}

}
