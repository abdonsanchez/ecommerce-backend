package com.ecommerce.api.api_tienda;

import com.ecommerce.api.api_tienda.pojos.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApiTiendaApplication implements CommandLineRunner {

	private UserPojo userPojo;
	private Producto producto;
	private ServerPojo serverPojo;

	public ApiTiendaApplication(Producto producto, ServerPojo serverPojo, UserPojo userPojo){
		System.out.println("entro al constructor ApiTiendaApplicacion" + " el path: "+ serverPojo.getPath());
		this.serverPojo = serverPojo;
		this.userPojo = userPojo;
		this.producto = producto;
	}


	Canigia canigia;
	public static void main(String[] args) {
		System.out.println("entro al main");
		SpringApplication.run(ApiTiendaApplication.class, args);
		System.out.println("salio del main");
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("entro al metodo sobre escrito -run-");
		Maradona maradona = new Maradona();
		System.out.println(serverPojo.getPort());
		System.out.println("El email del usuario id: " + userPojo.getUsuarioId() + " es " + userPojo.getEmail());
		System.out.println("el id del procto es: " + producto.getProd_nombre() + " cantidad: " + (Integer.parseInt(producto.getProd_cantidad())+1));
	}

}
