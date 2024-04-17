package com.example.demo.Servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entidades.Pedido;
import com.example.demo.Entidades.Restaurante;
import com.example.demo.Entidades.Repartidor;
import com.example.demo.Repositorio.PedidoRepositorio;
import com.example.demo.Repositorio.RepartidorRepositorio;
import com.example.demo.Repositorio.RestauranteRepositorio;

@Service
public class PedidoServicio {
    @Autowired
    private PedidoRepositorio pedidoRepositorio;
    
    @Autowired
    private RestauranteRepositorio restauranteRepositorio;
    
    @Autowired
    private RepartidorRepositorio repartidorRepositorio;

    public Pedido guardarPedido(Pedido pedido) {
        return pedidoRepositorio.save(pedido);
    }

    public Pedido obtenerPedidoPorId(Long id) {
        return pedidoRepositorio.findById(id).get();
    }
    
    public void borrarPedido(Long id) {
		pedidoRepositorio.deleteById(id);
	}
    
	public List<Pedido> mostrarTodo(){
		return pedidoRepositorio.findAll();
	}
    
	public String agregarARestaurante(Long idRestaurante, Long idPedido) {
		try {
			Restaurante rest = restauranteRepositorio.findById(idRestaurante).get();
		    Pedido pedido = pedidoRepositorio.findById(idPedido).get();
		    List<Pedido> pedidos = rest.getPedidos();
			pedidos.add(pedido);
			pedido.setRestaurante(rest);
		    rest.setPedidos(pedidos);
		    restauranteRepositorio.save(rest);
		    return "Se ha agregado el pedido al restaurante correctamente";
		} catch (Exception e) {
			return e.getMessage();
		}
	}
	
	public String agregarARepartidor(Long idRepartidor, Long idPedido) {
		try {
			Repartidor rep = repartidorRepositorio.findById(idRepartidor).get();
		    Pedido pedido = pedidoRepositorio.findById(idPedido).get();
		    List<Pedido> pedidos = rep.getPedidos();
			pedidos.add(pedido);
			pedido.setRepartidor(rep);
		    rep.setPedidos(pedidos);
		    repartidorRepositorio.save(rep);
		    return "Se ha agregado el pedido al restaurante correctamente";
		} catch (Exception e) {
			return e.getMessage();
		}
	}
}
