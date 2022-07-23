package com.ecommerce.api.api_tienda.Controllers;

import com.ecommerce.api.api_tienda.ApiTiendaApplication;
import com.ecommerce.api.api_tienda.entity.Usuario;
import com.ecommerce.api.api_tienda.pojos.Producto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ApiRestControllers {

    private Producto producto;
    private ApiTiendaApplication apiTiendaApplication;
    private Usuario usuario;

    public ApiRestControllers(Producto producto, ApiTiendaApplication apiTiendaApplication){
        this.producto = producto;
        this.apiTiendaApplication = apiTiendaApplication;
//        this.usuario = usuario;
    }

    @GetMapping("/producto")
    @ResponseBody
    public List<Producto> listaProducto(){
        List<Producto> listita = new ArrayList<>();
        listita.add(new Producto("pantalon", "3000", "3", "pantalon chupete", "5"));
        apiTiendaApplication.listaProductoRun();
        listita.add(producto);
        for (Producto produ:producto.listaProductos()
             ) {
            listita.add(produ);
        }
        for (Producto apiT:apiTiendaApplication.listaProductoRun()
             ) {
            listita.add(apiT);
        }
        return listita;
    }
    @GetMapping("/usuario")
    @ResponseBody
    public List<Usuario>listaUsuarios(){
        List<Usuario>listaUsu = new ArrayList<>();
        listaUsu.add(new Usuario("abdon", "abdon@gmail.com", "123", LocalDate.now()));
        listaUsu.add(new Usuario("pedro", "pedro@gmail.com", "456", LocalDate.now()));
        return listaUsu;
    }


}


