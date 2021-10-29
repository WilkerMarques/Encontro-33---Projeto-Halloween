package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TB_Nomes")
public class Nomes {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Integer nomeID;

	@Column(name = "NOME")
	private String nome;

	@Column(name = "SEXO")
	private char sexo;

	public Integer getNomeID() {
		return nomeID;
	}

	public void setNomeID(Integer nomeID) {
		this.nomeID = nomeID;
	}

	public String getDescricao() {
		return nome;
	}

	public void setDescricao(String nome) {
		this.nome = nome;
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	public Nomes() {
	}

	public Nomes(Integer nomeID, String nome, char sexo) {
		super();
		this.nomeID = nomeID;
		this.nome = nome;
		this.sexo = sexo;
	}

	@Override
	public String toString() {
		return "Nomes [nomeID=" + nomeID + ", nome=" + nome + ", sexo=" + sexo + "]";
	}

}
