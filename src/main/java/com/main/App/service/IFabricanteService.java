package com.main.App.service;

import java.util.List;

import com.main.App.dto.Fabricante;

public interface IFabricanteService {
	
	//Metodos del CRUD
		public List<Fabricante> listarFabricantes(); //Listar All 
		
		public Fabricante guardarFabricante(Fabricante fabricante);	//Guarda un Fabricante CREATE
		
		public Fabricante fabricanteXID(Long codigo); //Leer datos de un Fabricante READ
		
		public List<Fabricante> listarFabricanteNombre(String nombre);//Listar Fabricantes por campo nombre
		
		public Fabricante actualizarFabricante(Fabricante fabricante); //Actualiza datos del Fabricante UPDATE
		
		public void eliminarFabricante(Long codigo);// Elimina el fabricante DELETE

}
