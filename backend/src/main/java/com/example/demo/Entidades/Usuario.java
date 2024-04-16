package com.example.demo.Entidades;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCliente;
	private String nombre;
	private String direccion;

	@OneToMany(mappedBy = "cliente")
	private List<Pedido> pedidos;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idAdmin;

	private String adminNombre;
	private String adminEmail;
	private String adminPassword;

	@OneToOne
	private boolean esAdmin;
}