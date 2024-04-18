package com.example.demo.Entidades;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Register {
	String username;
	String password;
	String firstname;
	String lastname;
	String country;
	String email;
	
	
	
}
