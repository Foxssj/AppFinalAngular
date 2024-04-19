package com.example.demo.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.Entidades.Pedido;

@Repository
public interface PedidoRepositorio extends JpaRepository<Pedido, Long>{

    @Query("select c from Pedido c where c.fecha = ?1")
    Pedido getPedidoByNombrePedido(String fecha);
    

	
}
