package com.ecommerce.api.api_tienda;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApiTiendaApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ApiTiendaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("hola cafe");
	}
}
