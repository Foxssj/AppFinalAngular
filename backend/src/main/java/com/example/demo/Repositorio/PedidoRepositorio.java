package com.example.demo.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.Entidades.Pedido;

public interface PedidoRepositorio extends JpaRepository<PedidoRepositorio, Long>{

    @Query("select c from Pedido c where c.nombre = ?1")
    Pedido getPedidoByNombrePedido(String nombre);
    

	
}
