package com.example.demo.Servicio;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.Entidades.Pedido;
import com.example.demo.Entidades.Usuario;
import com.example.demo.Repositorio.PedidoRepositorio;
import com.example.demo.Repositorio.UsuarioRepositorio;

@Service
public class UsuarioServicio {
    @Autowired
    private UsuarioRepositorio usuarioRepositorio;
    @Autowired
    private PedidoRepositorio pedidoRepositorio;

    public Usuario guardarUsuario(Usuario usuario) {
        return usuarioRepositorio.save(usuario);
    }

    public Usuario obtenerUsuarioPorId(Long id) {
        return usuarioRepositorio.findById(id).get();
    }
    
    public void deleteUsuario(Long id) {
		Usuario user = usuarioRepositorio.findById(id).get();
		user.setPedidos(null);
		usuarioRepositorio.save(user);
		usuarioRepositorio.deleteById(id);
	}
    

	public String updateBarco(Long id,Usuario NuevosDatos) {
		try {
			Usuario user = usuarioRepositorio.findById(id).get();
			StringBuilder datoModificado = new StringBuilder();
		if ((NuevosDatos.getDireccion()!= null)) {
			user.setDireccion(NuevosDatos.getDireccion());
			datoModificado.append("modificado numMatricula ");
			System.out.println("1");
		}
		if (!(NuevosDatos.getNombre().isEmpty() || NuevosDatos.getNombre()== null)) {
			user.setNombre(NuevosDatos.getNombre());
			datoModificado.append("modificado nombre ");
			System.out.println("2");
		}
		if (NuevosDatos.getEmail()!= null) {
			user.setEmail(NuevosDatos.getEmail());
			datoModificado.append("modificado socio ,");
			System.out.println("3");
		}
		if (NuevosDatos.getPassword()!= null) {
			user.setPassword(NuevosDatos.getPassword());
			datoModificado.append("modificado salida ");
			System.out.println("4");
		}
		
		usuarioRepositorio.save(user);
		return datoModificado.toString();
		} catch (Exception e) {
			return e.getMessage() + "error";
		}
		
	}
    
	public String agregarPedido(Long idUsuario, Long idPedido) {
		try {
			Usuario user = usuarioRepositorio.findById(idUsuario).get();
		    Pedido pedido = pedidoRepositorio.findById(idPedido).get();
		    List<Pedido> pedidos = user.getPedidos();
			pedidos.add(pedido);
			pedido.setUsuario(user);
		    user.setPedidos(pedidos);
		    usuarioRepositorio.save(user);
		    return "Se ha agregado el pedido correctamente";
		} catch (Exception e) {
			return e.getMessage();
		}
	}

}

