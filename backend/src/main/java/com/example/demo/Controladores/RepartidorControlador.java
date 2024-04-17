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

import com.example.demo.Entidades.Repartidor;
import com.example.demo.Servicio.RepartidorServicio;

@RestController
@RequestMapping("/delivery")
public class RepartidorControlador {

	@Autowired
	RepartidorServicio servicio;	
	
	@GetMapping("/all")
	public List<Repartidor> allpedidos(){
		return servicio.mostrarTodo();
	}
	
	@GetMapping("/{idPedido}")
	public Repartidor findById(@PathVariable long idPedido) {
		return servicio.obtenerRepartidorPorId(idPedido);
	}
	
	@PostMapping()
	public Repartidor postPedidos(@RequestBody Repartidor repartidor){
		return servicio.guardarRepartidor(repartidor);
	}
	
	@DeleteMapping("/{idPedido}")
	public String borrarPedido(@PathVariable long idRepartidor) {
		servicio.borrarRepartidor(idRepartidor);
		return "Borrado";
	}

}
