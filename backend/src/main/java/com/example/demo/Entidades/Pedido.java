package com.example.demo.Entidades;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Pedido {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPedido;
    
    private LocalDateTime fecha;
    
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
    
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "restaurante_id")
    private Restaurante restaurante;
    
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "repartidor_id")
    private Repartidor repartidor;
}