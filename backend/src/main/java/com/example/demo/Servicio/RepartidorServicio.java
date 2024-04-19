package com.example.demo.Servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entidades.Repartidor;
import com.example.demo.Repositorio.RepartidorRepositorio;

@Service
public class RepartidorServicio {
	 
    @Autowired
    private RepartidorRepositorio repartidorRepositorio;


    public Repartidor guardarRepartidor(Repartidor repartidor) {
        return repartidorRepositorio.save(repartidor);
    }

    public Repartidor obtenerRepartidorPorId(Long id) {
        return repartidorRepositorio.findById(id).get();
    }
    
    public void borrarRepartidor(Long id) {
		repartidorRepositorio.deleteById(id);
	}
    
	public List<Repartidor> mostrarTodo(){
		return repartidorRepositorio.findAll();
	}

}
