package com.main.App.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.main.App.dto.Articulo;

public interface IArticuloDAO extends JpaRepository<Articulo, Long>{
	
	public List<Articulo> findByPrecio(Double precio);

}
