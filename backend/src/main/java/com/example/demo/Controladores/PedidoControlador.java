package com.example.demo.Controladores;

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

import com.example.demo.Entidades.Pedido;
import com.example.demo.Servicio.PedidoServicio;

@RestController
@RequestMapping("/order")
public class PedidoControlador {
	
	@Autowired
	PedidoServicio servicio;

	
	
	@GetMapping("/all")
	public List<Pedido> allpedidos(){
		return servicio.mostrarTodo();
	}
	
	@GetMapping("/{idPedido}")
	public Pedido findById(@PathVariable long idPedido) {
		return servicio.obtenerPedidoPorId(idPedido);
	}
	
	@PostMapping()
	public Pedido postPedidos(@RequestBody Pedido pedido){
		return servicio.guardarPedido(pedido);
	}
	
	@DeleteMapping("/{idPedido}")
	public String borrarPedido(@PathVariable long idPedido) {
		servicio.borrarPedido(idPedido);
		return "Borrado";
	}
	
	@PutMapping("/addRestaurant/{idRestaurante}/{idPedido}")
	public String agregarARestaurante(@PathVariable long idRestaurante , @PathVariable long idPedido) {
		return servicio.agregarRestaurante(idRestaurante, idPedido);
	}
	
	@PutMapping("/addDelivery/{idRepartidor}/{idPedido}")
	public String agregarARepartidor(@PathVariable long idRepartidor , @PathVariable long idPedido) {
		return servicio.agregarRepartidor(idRepartidor, idPedido);
	}
	
	


}
