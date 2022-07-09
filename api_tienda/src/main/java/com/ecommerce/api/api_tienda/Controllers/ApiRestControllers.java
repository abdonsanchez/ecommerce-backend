package com.ecommerce.api.api_tienda.Controllers;

import com.ecommerce.api.api_tienda.pojos.Producto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Controller
//@RequestMapping("/producto")
public class ApiRestControllers {

    private Producto producto;


    public ApiRestControllers(Producto producto){
        this.producto = producto;

    }

    @GetMapping("/producto")
    @ResponseBody
    public List<Producto> listaProducto(){
        List<Producto> listita = new ArrayList<>();
        listita.add(new Producto("2","pantalon", "3000", "3", "pantalos chupin", "5"));
        listita.add(producto);
        for (Producto produ:producto.listaProductos()
             ) {
            listita.add(produ);
        }
        return listita;
    }

}


