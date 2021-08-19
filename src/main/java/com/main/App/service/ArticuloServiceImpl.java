package com.main.App.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.App.dao.IArticuloDAO;
import com.main.App.dto.Articulo;

@Service
public class ArticuloServiceImpl implements IArticuloService{

	@Autowired
	IArticuloDAO iArticuloDAO;
	
	
	@Override
	public List<Articulo> listarArticulos() {
		
		return iArticuloDAO.findAll();
	}

	
	@Override
	public Articulo guardarArticulo(Articulo articulo) {
		
		return iArticuloDAO.save(articulo);
	}

	
	@Override
	public Articulo articuloXID(Long codigo) {
		
		return iArticuloDAO.findById(codigo).get();
	}

	
	@Override
	public List<Articulo> listarArticuloPrecio(Double precio) {
		
		return iArticuloDAO.findByPrecio(precio);
	}

	
	@Override
	public Articulo actualizarArticulo(Articulo articulo) {
		
		return iArticuloDAO.save(articulo);
	}

	
	@Override
	public void eliminarArticulo(Long codigo) {
		
		iArticuloDAO.deleteById(codigo);
	}

}
