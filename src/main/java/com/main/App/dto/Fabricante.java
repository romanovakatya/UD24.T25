package com.main.App.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="fabricantes")

public class Fabricante {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//busca ultimo valor e incrementa desde id final de db
	private Long codigo;
	
	@Column(name="NOMBRE")
	private String nombre;

	@OneToMany
	@JoinColumn(name="CODIGO")
	private List<Articulo> articulo;

	
	// constructor por defecto,
	public Fabricante() {
		super();

	}

	//constructor con todos los atributos,
	public Fabricante(Long codigo, String nombre) {

		this.codigo = codigo;
		this.nombre = nombre;

	}

	
	//los getters y setters,
	public Long getCodigo() {
		return codigo;
	}

	
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	
	public String getNombre() {
		return nombre;
	}

	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Articulo")
	public List<Articulo> getArticulo() {
		return articulo;
	}

	
	public void setArticulo(List<Articulo> articulo) {
		this.articulo = articulo;
	}

	@Override
	public String toString() {
		return "Fabricante [codigo=" + codigo + ", nombre=" + nombre + "]";
	}
	
	
}
