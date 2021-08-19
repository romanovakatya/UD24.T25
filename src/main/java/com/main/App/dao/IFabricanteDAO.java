package com.main.App.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.main.App.dto.Fabricante;

public interface IFabricanteDAO extends JpaRepository<Fabricante, Long> {

	// listar fabricantes por el trabajo
	public List<Fabricante> findByNombre(String nombre);
}
