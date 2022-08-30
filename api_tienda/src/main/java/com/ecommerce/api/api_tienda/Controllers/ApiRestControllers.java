package com.ecommerce.api.api_tienda.Controllers;

import com.ecommerce.api.api_tienda.ApiTiendaApplication;
import com.ecommerce.api.api_tienda.entity.Usuario;
import com.ecommerce.api.api_tienda.entity.Producto;
import com.ecommerce.api.api_tienda.repository.ProductoRepository;
import com.ecommerce.api.api_tienda.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

//@Controller
@RestController
public class ApiRestControllers {

    private Producto producto;
    private ApiTiendaApplication apiTiendaApplication;
    private Usuario usuario;
    private UserRepository userRepository;
    private ProductoRepository productoRepository;

    public ApiRestControllers(Producto producto, ApiTiendaApplication apiTiendaApplication, UserRepository userRepository, ProductoRepository productoRepository){
        this.producto = producto;
        this.apiTiendaApplication = apiTiendaApplication;
        this.userRepository = userRepository;
        this.productoRepository = productoRepository;
    }

    @GetMapping("/producto")
    public List<Producto> listaProducto(){
        List<Producto> listita = new ArrayList<>();
        listita.add(new Producto("memoria ram", "3000", "3", "intel i7", "5"));
        for (Producto producto:productoRepository.findAll()
             ) {
            listita.add(producto);
        }
//        for (Producto produ:producto.listaProductos()
//             ) {
//            listita.add(produ);
//        }
        return listita;
    }
    @GetMapping("/usuario")
    public List<Usuario> litUser(){
        return userRepository.findAll();
    }

    @PostMapping(path = "/usuario_registro", produces = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public void registerBody(String nombre,  String email, String pass){
        Usuario usuario = new Usuario(nombre, email, pass, LocalDate.now());
        userRepository.save(usuario);
    }

//    @PostMapping(path = "/login", produces = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @RequestMapping("/login")
    public ResponseEntity<Usuario> loginUsuario(String usr_email, String password){
        Usuario user = null;
        List<Usuario> listaUsuarios = userRepository.findByusremail(usr_email);
        if (!listaUsuarios.isEmpty() && listaUsuarios.stream().count()==1){
            user = listaUsuarios.get(0);
            System.out.println("entro al primer if: " + listaUsuarios.get(0));
        }else {
            System.out.println("entro al primer else");
//            return new ResponseEntity<Usuario>(user, HttpStatus.ALREADY_REPORTED);
        }
        if (user.getUsr_password().equals(password)){
            System.out.println("user.getUsr_password: " + user.getUsr_password() + " password: " + password);
            System.out.println("entro al segundo if");
        }
        System.out.println("retorno un nuevo responseEntty");
        return new ResponseEntity<Usuario>(user, null, HttpStatus.OK);
    }


}


