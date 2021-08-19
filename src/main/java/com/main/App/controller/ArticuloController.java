package com.main.App.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.main.App.dto.Articulo;
import com.main.App.service.ArticuloServiceImpl;

@RestController
@RequestMapping("/api")
public class ArticuloController {

	@Autowired
	ArticuloServiceImpl articuloServiceImpl;

	// listar todos los articulos,
	@GetMapping("/articulos")
	public List<Articulo> listarArticulos() {

		return articuloServiceImpl.listarArticulos();
	}

	// añadir un articulo nuevo,
	@PostMapping("/articulos")
	public Articulo guardarArticulo(@RequestBody Articulo articulo) {

		return articuloServiceImpl.guardarArticulo(articulo);
	}

	// listar por el precio de artículos,
	@GetMapping("/articulos/precio/{precio}")
	public List<Articulo> listarArticuloPrecio(@PathVariable(name = "precio") Double precio) {

		return articuloServiceImpl.listarArticuloPrecio(precio);
	}

	// buscar un artículo por el codigo,
	@GetMapping("/articulos/{codigo}")
	public Articulo articuloXID(@PathVariable(name = "codigo") Long codigo) {

		Articulo articulo_xid = new Articulo();

		articulo_xid = articuloServiceImpl.articuloXID(codigo);

		System.out.println("articulo_xid: " + articulo_xid);

		return articulo_xid;
	}

	// actualizar un artículo,
	@PutMapping("/articulos/{codigo}")
	public Articulo actualizarArticulo(@PathVariable(name = "codigo") Long codigo, @RequestBody Articulo articulo) {

		Articulo articulo_seleccionado = new Articulo();
		Articulo articulo_actualizado = new Articulo();

		articulo_seleccionado = articuloServiceImpl.articuloXID(codigo);
		articulo_seleccionado.setNombre(articulo.getNombre());
		articulo_seleccionado.setPrecio(articulo.getPrecio());
		articulo_seleccionado.setFabricante(articulo.getFabricante());

		articulo_actualizado = articuloServiceImpl.actualizarArticulo(articulo_seleccionado);

		System.out.println("El articulo actualizado es: " + articulo_actualizado);
		return articulo_actualizado;
	}

	// para eliminar un artículo,
	@DeleteMapping("/articulos/{codigo}")
	public void eliminarArticulo(@PathVariable(name = "codigo") Long codigo) {

		articuloServiceImpl.eliminarArticulo(codigo);
	}
}
