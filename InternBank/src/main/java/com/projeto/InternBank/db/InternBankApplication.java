package com.projeto.InternBank.db;
 
import java.util.Optional;
import java.util.Scanner;
 
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
 

import com.projeto.InternBank.db.models.Admin;
import com.projeto.InternBank.db.models.Usuario;
import com.projeto.InternBank.db.repositories.AdminRepository;
import com.projeto.InternBank.db.repositories.UsuarioRepository;
 
import org.springframework.boot.SpringApplication;
 
    	import org.springframework.boot.autoconfigure.SpringBootApplication;
 
    	import org.springframework.context.annotation.Bean;
 
 
    	@SpringBootApplication
    	public class InternBankApplication {

    	    private static final Integer ADMIN_ID = 1;

    	    public static void main(String[] args) {
    	        SpringApplication.run(InternBankApplication.class, args);
    	    }

    	    @Bean
    	    CommandLineRunner initAdmin(AdminRepository adminRepository) {
    	        return args -> {
    	            Optional<Admin> adminOptional = adminRepository.findById(ADMIN_ID);

    	            if (adminOptional.isEmpty()) {
    	                Admin newAdmin = new Admin();
    	                newAdmin.setAdminId(ADMIN_ID);
    	                adminRepository.save(newAdmin);
    	                System.out.println("Admin created with ID: " + ADMIN_ID);
    	            } else {
    	                System.out.println("Admin already exists with ID: " + ADMIN_ID);
    	            }
    	        };
    	    }

    	    @Bean
    	    CommandLineRunner initUser(UsuarioRepository usuarioRepository) {
    	        return args -> {
    	            Optional<Usuario> userOptional = usuarioRepository.findByEmail("usuario");

    	            if (userOptional.isEmpty()) {
    	                Usuario newUser = new Usuario();
    	                newUser.setEmail("usuario");
    	                usuarioRepository.save(newUser);
    	                System.out.println("User created with email: usuario");
    	            } else {
    	                System.out.println("User already exists with email: usuario");
    	            }
    	        };
    	    }
    	}
