package com.example.demo.Controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entidades.Restaurante;
import com.example.demo.Servicio.RestauranteServicio;

@RestController
@RequestMapping("/restaurant")
public class RestauranteControlador {
	@Autowired
	RestauranteServicio servicio;
	
	@GetMapping("/all")
	public List<Restaurante> allpedidos(){
		return servicio.mostrarTodo();
	}
	
	@GetMapping("/{idRestaurante}")
	public Restaurante findById(@PathVariable long idRestaurante) {
		return servicio.obtenerRestaurantePorId(idRestaurante);
	}
	
	@PostMapping()
	public Restaurante postRestaurante(@RequestBody Restaurante restaurante){
		return servicio.guardarRestaurante(restaurante);
	}
	
	@DeleteMapping("/{idRestaurante}")
	public String borrarRestaurante(@PathVariable long idRestaurante) {
		servicio.borrarRestaurante(idRestaurante);
		return "Borrado";
	}
	
	
}
