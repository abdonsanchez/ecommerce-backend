package com.ecommerce.api.api_tienda;

import com.ecommerce.api.api_tienda.entity.Usuario;
import com.ecommerce.api.api_tienda.pojos.*;
import com.ecommerce.api.api_tienda.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class ApiTiendaApplication implements CommandLineRunner {

	private UserPojo userPojo;
	private Producto producto;
	private ServerPojo serverPojo;
	private UserRepository userRepository;

	public ApiTiendaApplication(Producto producto, ServerPojo serverPojo, UserPojo userPojo, UserRepository userRepository){
		System.out.println("entro al constructor ApiTiendaApplicacion" + " el path: "+ serverPojo.getPath());
		this.serverPojo = serverPojo;
		this.userPojo = userPojo;
		this.producto = producto;
		this.userRepository = userRepository;
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

//		Date f = new Date("1988-11-23");
		Usuario ususario = new Usuario("luis nazario", "luis@gmail.com", "123", LocalDate.now());
		Usuario ususario2 = new Usuario("denilson", "denilson@gmail.com", "456", LocalDate.now());

		List<Usuario> usuarios = Arrays.asList(ususario, ususario2);
		usuarios.stream().forEach(userRepository::save);

		List<Usuario> usuarios4 = new ArrayList<>();
		usuarios4.add(ususario);
		usuarios4.add(ususario2);
		for (Usuario usuario:usuarios4
			 ) {
			System.out.println(usuario);
			if (usuario.getUsr_Id() == 12){
				usuario.setUsr_nombre("cocoliso");
				userRepository.save(usuario);
			}
		}

	}

}
