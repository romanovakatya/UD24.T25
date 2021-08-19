package com.main.App.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="articulos")

public class Articulo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//busca ultimo valor e incrementa desde id final de db
	private Long codigo;
	
	@Column(name="NOMBRE")
	private String nombre;
	
	@Column(name="PRECIO")
	private Double precio;
	
	@ManyToOne
    @JoinColumn(name="FABRICANTE")
    private Fabricante fabricante;

	
	//constructors,
	
	public Articulo() {
		
	}

	public Articulo(Long codigo, String nombre, Double precio, Fabricante fabricante) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.precio = precio;
		this.fabricante = fabricante;
	}

	
	//getters and setters
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

	
	public Double getPrecio() {
		return precio;
	}

	
	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	
	public Fabricante getFabricante() {
		return fabricante;
	}

	
	public void setFabricante(Fabricante fabricante) {
		this.fabricante = fabricante;
	}

	
	@Override
	public String toString() {
		return "Articulo [codigo=" + codigo + ", nombre=" + nombre + ", precio=" + precio + ", fabricante=" + fabricante
				+ "]";
	}

}
