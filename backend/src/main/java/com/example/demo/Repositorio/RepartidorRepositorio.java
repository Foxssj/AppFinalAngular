package com.example.demo.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.Entidades.Repartidor;


public interface RepartidorRepositorio extends JpaRepository<Repartidor, Long> {
	
    @Query("select c from Repartidor c where c.nombre = ?1")
    Repartidor getRepartidorByNombreRepartidor(String nombre);
    


}
