package com.ecommerce.api.api_tienda;

import com.ecommerce.api.api_tienda.pojos.ServerPojo;
import com.ecommerce.api.api_tienda.pojos.UserPojo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApiTiendaApplication implements CommandLineRunner {

	private ServerPojo serverPojo;
	private UserPojo userPojo;

	public ApiTiendaApplication(ServerPojo serverPojo, UserPojo userPojo){
		this.serverPojo = serverPojo;
		this.userPojo = userPojo;
	}

	public static void main(String[] args) {
		SpringApplication.run(ApiTiendaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("hola java 17");
		System.out.println(serverPojo.getPort());
		System.out.println("El email del usuario id: " + userPojo.getUsuarioId() + " es " + userPojo.getEmail());
	}
}
