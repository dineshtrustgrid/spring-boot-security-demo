package com.spring.boot.security.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.spring.boot.security.demo.service.UserServices;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		
		
	}

	
	@Bean
	CommandLineRunner createAdminUser(UserServices userServices) {
	    return args -> {
	        if (!userServices.existsByUsername("admin")) {
	            userServices.createAdmin("admin", "admin123", "admin@gmail.com");
	            System.out.println("Admin user created!");
	        }
	    };
	}
}
