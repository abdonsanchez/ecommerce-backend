package com.ecommerce.api.api_tienda;

import com.ecommerce.api.api_tienda.entity.Usuario;
import com.ecommerce.api.api_tienda.pojos.*;
import com.ecommerce.api.api_tienda.repository.ProductoRepository;
import com.ecommerce.api.api_tienda.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConstructorBinding;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@ConstructorBinding

public class ApiTiendaApplication implements CommandLineRunner {

	private UserPojo userPojo;
	private Producto producto;
	private ServerPojo serverPojo;
	private UserRepository userRepository;
	private ProductoRepository productoRepository;



	public ApiTiendaApplication(Producto producto, ServerPojo serverPojo, UserPojo userPojo, UserRepository userRepository, ProductoRepository productoRepository){
		this.serverPojo = serverPojo;
		this.userPojo = userPojo;
		this.producto = producto;
		this.userRepository = userRepository;
		this.productoRepository = productoRepository;
	}

	public static void main(String[] args) {
		System.out.println("entro al main");
		SpringApplication.run(ApiTiendaApplication.class, args);
		System.out.println("salio del main");
	}

	@Override
	public void run(String... args) throws Exception {
		Usuario ususario1 = new Usuario("luis nazario", "luis@gmail.com", "123", LocalDate.now());
		Usuario ususario2 = new Usuario("denilson", "denilson@gmail.com", "456", LocalDate.now());

		List<Usuario> usuarios = Arrays.asList(ususario1, ususario2);
		usuarios.stream().forEach(userRepository::save);

		List<Usuario> usuariosRun = new ArrayList<>();
		usuariosRun.add(ususario1);
		usuariosRun.add(ususario2);

		for (Usuario usuario:usuariosRun
			 ) {
			System.out.println(usuario);

			if (usuario.getUsr_Id() == 12){
				usuario.setUsr_nombre("cocoliso");
				userRepository.save(usuario);
			}
		}

		listaProductoRun();

	}

	public List<Producto> listaProductoRun(){
		Producto producto1 = new Producto("zapatilla", "45000", "3", "air zoom", "10");
		Producto producto2 = new Producto("pantalon jeans", "20000", "1", "bensimon clasic", "3");

		List<Producto> productos = new ArrayList<>();
		productos.add(producto1);
		productos.add(producto2);

		productos.stream().forEach(productoRepository::save);
		return productos;
	}

}
