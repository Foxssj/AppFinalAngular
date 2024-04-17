package com.example.demo.Servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entidades.Repartidor;
import com.example.demo.Repositorio.RepartidorRepositorio;

@Service
public class RepartidorServicio {
	 
    @Autowired
    private RepartidorRepositorio repartidorRepositorio;


    public Repartidor guardarRestaurante(Repartidor repartidor) {
        return repartidorRepositorio.save(repartidor);
    }

    public Repartidor obtenerRestaurantePorId(Long id) {
        return repartidorRepositorio.findById(id).get();
    }
    
    public void borrarRestaurante(Long id) {
		repartidorRepositorio.deleteById(id);
	}

}
