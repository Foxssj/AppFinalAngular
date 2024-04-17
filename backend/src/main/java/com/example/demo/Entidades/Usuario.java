
package com.example.demo.Entidades;
import java.util.List;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idUsuario;
	private String username;
	
	@Basic
	@Column(nullable = false)
	@NotBlank
	private String nombre;
	
	@Basic
	@Column(nullable = false)
	@NotBlank
	private String apellido;
	
	@Basic
	@Column(nullable = false)
	@NotBlank
	private String direccion;	
	
	@Basic
	@Column(nullable = false)
	@NotBlank
	private String email;
	
	@Basic
	@Column(nullable = false)
	@NotBlank
	private String password;

	@OneToMany(mappedBy = "usuario")
	private List<Pedido> pedidos;


	private boolean esAdmin;
}
