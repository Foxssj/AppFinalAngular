package com.example.demo.Entidades;

import java.util.List;

import jakarta.persistence.Id;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Restaurante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Basic
	@Column(nullable = false)
	@NotBlank
    private String nombre;
    
    @Basic
	@Column(nullable = false)
	@NotBlank
    private String direccion;
    
    @OneToMany(mappedBy = "restaurante")
    private List<Pedido> pedidos;
}
