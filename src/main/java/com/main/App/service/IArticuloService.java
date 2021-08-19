package com.main.App.service;

import java.util.List;

import com.main.App.dto.Articulo;


public interface IArticuloService {
	
	//Metodos del CRUD
			public List<Articulo> listarArticulos(); //Listar All 
			
			public Articulo guardarArticulo(Articulo articulo);	//Guarda un articulo CREATE
			
			public Articulo articuloXID(Long codigo); //Leer datos de un articulo READ
			
			public List<Articulo> listarArticuloPrecio(Double precio);//Listar articulo por campo precio
			
			public Articulo actualizarArticulo(Articulo articulo); //Actualiza datos del articulo UPDATE
			
			public void eliminarArticulo(Long codigo);// Elimina el articulo DELETE

}
