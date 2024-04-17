package com.example.demo.Servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entidades.Restaurante;
import com.example.demo.Repositorio.RestauranteRepositorio;

@Service
public class RestauranteServicio {

	 
    @Autowired
    private RestauranteRepositorio restauranteRepositorio;


    public Restaurante guardarRestaurante(Restaurante restaurante) {
        return restauranteRepositorio.save(restaurante);
    }

    public Restaurante obtenerRestaurantePorId(Long id) {
        return restauranteRepositorio.findById(id).get();
    }
    
    public void borrarRestaurante(Long id) {
		restauranteRepositorio.deleteById(id);
	}
	
}
