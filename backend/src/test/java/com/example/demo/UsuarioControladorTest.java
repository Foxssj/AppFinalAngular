package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.demo.Controladores.UsuarioControlador;
import com.example.demo.Entidades.Usuario;
import com.example.demo.Servicio.UsuarioServicio;

@SpringBootTest
public class UsuarioControladorTest {

    private MockMvc mockMvc;
    
    @Mock
    private UsuarioServicio servicioMock;
    
    @InjectMocks
    private UsuarioControlador controlador;
    
//    @Test
//    public void testAllUsuarios() throws Exception {
//        Usuario usuario1 = Usuario(1, "Usuario1", "usuario1@example.com", "", "", "", "", false);
//        Usuario usuario2 = Usuario(2, "Usuario2", "usuario2@example.com");
//        List<Usuario> usuarios = Arrays.asList(usuario1, usuario2);
//        
//        when(servicioMock.mostrarTodo()).thenReturn(usuarios);
//        
//        List<Usuario> resultado = controlador.allUsuarios();
//        
//        assertEquals(2, resultado.size());
//        assertEquals(usuario1, resultado.get(0));
//        assertEquals(usuario2, resultado.get(1));
//    }
    
    
    @Test
    public void testFindById() {
    }
    
    @Test
    public void testPostUsuario() {
    }
    
    @Test
    public void testBorrarUsuario() {
    }
    
    @Test
    public void testAgregarPedido() {
    }
    
    @Test
    public void testModificarUsuario() {
    }
}