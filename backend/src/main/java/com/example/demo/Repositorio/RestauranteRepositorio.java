package com.example.demo.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.Entidades.Restaurante;

public interface RestauranteRepositorio extends JpaRepository<RestauranteRepositorio, Long>{

    @Query("select c from Restaurante c where c.nombre = ?1")
    Restaurante getRestauranteByNombreRestaurante(String nombre);
    

}
