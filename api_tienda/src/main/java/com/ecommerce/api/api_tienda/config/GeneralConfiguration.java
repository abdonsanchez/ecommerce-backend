package com.ecommerce.api.api_tienda.config;


import com.ecommerce.api.api_tienda.ApiTiendaApplication;
import com.ecommerce.api.api_tienda.pojos.Producto;
import com.ecommerce.api.api_tienda.pojos.ServerPojo;
import com.ecommerce.api.api_tienda.pojos.UserPojo;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties({ServerPojo.class, UserPojo.class, Producto.class})
public class GeneralConfiguration {

    public GeneralConfiguration(){
        System.out.println("constructor GeneralConfiguration");
    }

}
