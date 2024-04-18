package com.example.demo.Auth.Controlador;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.demo.Entidades.Login;
import com.example.demo.Entidades.Register;
import com.example.demo.Auth.JWT.JwsService;
import com.example.demo.Auth.User.Role;
import com.example.demo.Auth.User.User;
import com.example.demo.Auth.User.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {
 
	private final UserRepository userRepository;
    private final JwsService jwtService;
    private final BCryptPasswordEncoder passwordEncoderr;
    private final AuthenticationManager authenticationManager;

    @CrossOrigin
    public AuthResponse login(Login request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        UserDetails user=userRepository.findByUsername(request.getUsername()).orElseThrow();
        String token=jwtService.getToken(user);
        return AuthResponse.builder()
            .token(token)
            .build();

    }

    @CrossOrigin
	public AuthResponse register(Register request) {
		User user = User.builder()
				.username(request.getUsername())
				.password(passwordEncoderr.encode(request.getPassword()))
				.firstname(request.getFirstname())
				.lastname(request.getLastname())
				.country(request.getCountry())
				.email(request.getEmail())
				.role(Role.USER)
				.build();
		userRepository.save(user);
		
		return AuthResponse.builder()
				.token(jwtService.getToken(user))
				.build();
	}

}
