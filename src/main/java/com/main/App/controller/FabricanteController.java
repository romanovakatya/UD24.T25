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

import com.main.App.dto.Fabricante;
import com.main.App.service.FabricanteServiceImpl;


@RestController
@RequestMapping("/api")
public class FabricanteController {

	@Autowired
	FabricanteServiceImpl fabricanteServiceImpl;

	@GetMapping("/fabricantes")
	public List<Fabricante> listarFabricantes() {

		return fabricanteServiceImpl.listarFabricantes();
	}

	// listar Fabricantes por el campo nombre
	@GetMapping("/fabricantes/nombre/{nombre}")
	public List<Fabricante> listarFabricanteNombre(@PathVariable(name = "nombre") String nombre) {

		return fabricanteServiceImpl.listarFabricanteNombre(nombre);
	}

	// añadir un fabricante nuevo,
	@PostMapping("/fabricantes")
	public Fabricante guardarFabricante(@RequestBody Fabricante fabricante) {

		return fabricanteServiceImpl.guardarFabricante(fabricante);
	}

	// buscar un fabricante por el codigo,
	@GetMapping("/fabricantes/{codigo}")
	public Fabricante fabricanteXID(@PathVariable(name = "codigo") Long codigo) {

		Fabricante fabricante_xid = new Fabricante();

		fabricante_xid = fabricanteServiceImpl.fabricanteXID(codigo);

		System.out.println("Fabricante XID: " + fabricante_xid);

		return fabricante_xid;
	}
	
	//actualizar un fabricante,
		@PutMapping("/fabricantes/{codigo}")
		public Fabricante actualizarFabricante(@PathVariable(name="codigo") Long codigo,@RequestBody Fabricante fabricante) {
			
			Fabricante fabricante_seleccionado= new Fabricante();
			Fabricante empleado_actualizado= new Fabricante();
			
			fabricante_seleccionado= fabricanteServiceImpl.fabricanteXID(codigo);
			
			fabricante_seleccionado.setNombre(fabricante.getNombre());
			
			empleado_actualizado = fabricanteServiceImpl.actualizarFabricante(fabricante_seleccionado);
			
			System.out.println("El empleado actualizado es: "+ empleado_actualizado);
			
			return empleado_actualizado;
		}
		
		//para eliminar un fabricante,
		@DeleteMapping("/fabricantes/{codigo}")
		
		public void eliminarFabricante(@PathVariable(name="codigo") Long codigo) {
			
			fabricanteServiceImpl.eliminarFabricante(codigo);
		}

}
