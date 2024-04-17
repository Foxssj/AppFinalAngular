package com.example.demo.Controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.Entidades.Usuario;


import com.example.demo.Servicio.UsuarioServicio;
import com.fasterxml.jackson.annotation.JsonIgnore;


@RestController
@RequestMapping("/user")
public class UsuarioControlador {

	
	
	
	@Autowired
	UsuarioServicio servicio;

	
	
	@GetMapping("/all")
	public List<Usuario> allUsuarios(){
		return servicio.mostrarTodo();
	}
	
	@GetMapping("/{idUsuario}")
	public Usuario findById(@PathVariable long idUsuario) {
		return servicio.obtenerUsuarioPorId(idUsuario);
	}
	
	@PostMapping()
	public Usuario postUsuario(@RequestBody Usuario usuario){
		return servicio.guardarUsuario(usuario);
	}
	
	@DeleteMapping("/{idUsuario}")
	public String borrarUsuario(@PathVariable long idUsuario) {
		servicio.borrarUsuario(idUsuario);
		return "Borrado";
	}
	
	@JsonIgnore
	@PutMapping("/addOrder/{idUsuario}/{idPedido}")
	public String agregarPedido(@PathVariable long idUsuario , @PathVariable long idPedido) {
		return servicio.agregarPedido(idUsuario, idPedido);
	}
	
	@PutMapping("/{idUsuario}")
	public String modificarUsuario(@PathVariable long idUsuario,@RequestBody Usuario usuario) {
		return servicio.actualizarUsuario(idUsuario, usuario);
	}
	

	
}
