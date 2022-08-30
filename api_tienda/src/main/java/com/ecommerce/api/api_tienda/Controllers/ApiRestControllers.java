package com.ecommerce.api.api_tienda.Controllers;

import com.ecommerce.api.api_tienda.ApiTiendaApplication;
import com.ecommerce.api.api_tienda.entity.EmailDetails;
import com.ecommerce.api.api_tienda.entity.Usuario;
import com.ecommerce.api.api_tienda.entity.Producto;
import com.ecommerce.api.api_tienda.repository.ProductoRepository;
import com.ecommerce.api.api_tienda.repository.UserRepository;
import com.ecommerce.api.api_tienda.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private EmailService emailService;


    public ApiRestControllers(Producto producto, ApiTiendaApplication apiTiendaApplication, UserRepository userRepository, ProductoRepository productoRepository) {
        this.producto = producto;
        this.apiTiendaApplication = apiTiendaApplication;
        this.userRepository = userRepository;
        this.productoRepository = productoRepository;
    }

    @GetMapping("/producto")
    public List<Producto> listaProducto() {
        List<Producto> listita = new ArrayList<>();
        listita.add(new Producto("memoria ram", "3000", "3", "intel i7", "5"));
        for (Producto producto : productoRepository.findAll()
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
    public List<Usuario> litUser() {
        return userRepository.findAll();
    }

    @PostMapping(path = "/usuario_registro", produces = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public ResponseEntity<String> registerBody(String nombre, String email, String pass) {
        List<Usuario> listaUsuarios = userRepository.findByusremail(email);
        if (!listaUsuarios.isEmpty()) {
            return new ResponseEntity<>("El email ya esta registrado", HttpStatus.UNAUTHORIZED);
        }
        Usuario usuario = new Usuario(nombre, email, pass, LocalDate.now());
        userRepository.save(usuario);

        //preparamos el email de confirmacion de usuario
        EmailDetails emailDetails = new EmailDetails();
        emailDetails.setRecipient(usuario.getUsremail());
        //dentro del body se puede mandar un html
        emailDetails.setMsgBody("hola: " + usuario.getUsr_nombre() + " te registraste satisfactoriamente. http://localhost:8080/app/validacion/" + email);
        emailDetails.setSubject("registro usuario");
        String status = emailService.sendSimpleMail(emailDetails);

        if (status.equals("ok")) {
            return new ResponseEntity<>("Registro exitoso", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Error al registrar el usuario", HttpStatus.UNAUTHORIZED);
        }
    }

    @GetMapping("/validacion/{email}")
    public ResponseEntity<Usuario> validacionUser(@PathVariable("email") String email) {
        Usuario user = null;
        List<Usuario> listaUsuarios = userRepository.findByusremail(email);
        System.out.println("el email es: " + email);
        if (listaUsuarios.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        user = listaUsuarios.get(0);
        user.setActivo(1);
        System.out.println("el email es: " + email);
        userRepository.save(user);
        return new ResponseEntity<Usuario>(user, HttpStatus.ALREADY_REPORTED);
    }

    //    @PostMapping(path = "/login", produces = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @PostMapping("/login")
    public ResponseEntity<Usuario> loginUsuario(String usr_email, String password) {
        Usuario user = null;
        List<Usuario> listaUsuarios = userRepository.findByusremail(usr_email);
        if (!listaUsuarios.isEmpty() && listaUsuarios.stream().count() == 1) {
            user = listaUsuarios.get(0);
            System.out.println("entro al primer if: " + listaUsuarios.get(0));
        } else {
            System.out.println("entro al primer else");
//            return new ResponseEntity<Usuario>(user, HttpStatus.ALREADY_REPORTED);
        }
        if (user.getUsr_password().equals(password)) {
            System.out.println("user.getUsr_password: " + user.getUsr_password() + " password: " + password);
            System.out.println("entro al segundo if");
            System.out.println("retorno un nuevo responseEntty");
            return new ResponseEntity<Usuario>(user, null, HttpStatus.OK);
        }
//        System.out.println("retorno un nuevo responseEntty");
//        return new ResponseEntity<Usuario>(user, null, HttpStatus.OK);
        return new ResponseEntity<Usuario>(user, HttpStatus.ALREADY_REPORTED);
    }

    @GetMapping("/recuperarPassword/{email}")
    public ResponseEntity<String> recuperarPassword(@PathVariable("email") String email) {
        List<Usuario> listaUsuarios = userRepository.findByusremail(email);
        if (listaUsuarios.isEmpty()) {
            return new ResponseEntity<>("El email no esta registrado", HttpStatus.UNAUTHORIZED);
        }
        Usuario usuario = new Usuario();
        usuario = listaUsuarios.get(0);
        EmailDetails emailDetails = new EmailDetails();
        emailDetails.setRecipient(usuario.getUsremail());
        //dentro del body se puede mandar un html
        emailDetails.setMsgBody("hola: " + usuario.getUsr_nombre() +
                " para recuperar la contraseña entra al siguiente enlace. http://localhost:8080/app/recuperandoPassword/" + email);
        emailDetails.setSubject("registro usuario");
        String status = emailService.sendSimpleMail(emailDetails);

        return new ResponseEntity<>("Se envio el email con exito", HttpStatus.OK);
    }

    //para el front
    @GetMapping("/recuperandoPassword/{email}")
    public ResponseEntity<Usuario> recuperandoPassword(@PathVariable("email") String email) {
        List<Usuario> listaUsuarios = userRepository.findByusremail(email);
        Usuario usuario = new Usuario();
        usuario.setUsr_password("");
        usuario = listaUsuarios.get(0);
        usuario.setUsr_password("");
        return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
    }

    @PostMapping("/guardarPassword")
    public ResponseEntity<String> guardarPassword(String password1, String password2, String email) {
        if (!password1.equals(password2)) {
            return new ResponseEntity<>("Las contraseñas no coinciden", HttpStatus.UNAUTHORIZED);
        }
        List<Usuario> listaUsuarios = userRepository.findByusremail(email);
        Usuario usuario = new Usuario();
        usuario = listaUsuarios.get(0);
        usuario.setUsr_password(password1);
        userRepository.save(usuario);

        return new ResponseEntity<>("Se guardo la contraseña", HttpStatus.OK);
    }


}


