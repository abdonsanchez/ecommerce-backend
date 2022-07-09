package com.ecommerce.api.api_tienda.pojos;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import java.util.ArrayList;
import java.util.List;

@ConstructorBinding
@ConfigurationProperties(prefix = "producto")

public class Producto {

    private String prod_id;
    private String prod_nombre;
    private String prod_precio;
    private String prod_cantidad;
    private String prod_descripcion;
    private String prod_user_id;

    public Producto(String prod_id, String prod_nombre, String prod_precio, String prod_cantidad, String prod_descripcion, String prod_user_id) {
        System.out.println("entro al constructor de Producto");
        this.prod_id = prod_id;
        this.prod_nombre = prod_nombre;
        this.prod_precio = prod_precio;
        this.prod_cantidad = prod_cantidad;
        this.prod_descripcion = prod_descripcion;
        this.prod_user_id = prod_user_id;
    }

    public String getProd_id() {
        return prod_id;
    }

    public void setProd_id(String prod_id) {
        this.prod_id = prod_id;
    }

    public String getProd_nombre() {
        return prod_nombre;
    }

    public void setProd_nombre(String prod_nombre) {
        this.prod_nombre = prod_nombre;
    }

    public String getProd_precio() {
        return prod_precio;
    }

    public void setProd_precio(String prod_precio) {
        this.prod_precio = prod_precio;
    }

    public String getProd_cantidad() {
        return prod_cantidad;
    }

    public void setProd_cantidad(String prod_cantidad) {
        this.prod_cantidad = prod_cantidad;
    }

    public String getProd_descripcion() {
        return prod_descripcion;
    }

    public void setProd_descripcion(String prod_descripcion) {
        this.prod_descripcion = prod_descripcion;
    }

    public String getProd_user_id() {
        return prod_user_id;
    }

    public void setProd_user_id(String prod_user_id) {
        this.prod_user_id = prod_user_id;
    }


    public List<Producto> listaProductos(){
        Producto botines = new Producto("3", "botines", "30000", "3", "botines predator", "9");
        Producto guantesBox = new Producto("4", "guantes everlast", "9000", "1", "guantes de 14 onzas", "3");
        List<Producto> listaDeProductos = new ArrayList<>();
        listaDeProductos.add(botines);
        listaDeProductos.add(guantesBox);
        return listaDeProductos;
    }

}
