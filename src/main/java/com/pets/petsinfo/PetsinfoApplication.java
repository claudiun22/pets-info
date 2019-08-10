package com.pets.petsinfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;



@SpringBootApplication
public class PetsinfoApplication extends SpringBootServletInitializer{


	public static void main(String[] args) {
		SpringApplication.run(PetsinfoApplication.class, args);
	}
}
