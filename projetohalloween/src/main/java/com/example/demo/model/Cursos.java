package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TB_Cursos")
public class Cursos {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Integer cursoID;

	@Column(name = "DESCR")
	private String descricao;

	public Integer getCursoID() {
		return cursoID;
	}

	public void setCursoID(Integer cursoID) {
		this.cursoID = cursoID;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Cursos() {
	}

	public Cursos(Integer cursoID, String descricao) {
		super();
		this.cursoID = cursoID;
		this.descricao = descricao;
	}

	@Override
	public String toString() {
		return "Cursos [cursoID=" + cursoID + ", descricao=" + descricao + "]";
	}

}
