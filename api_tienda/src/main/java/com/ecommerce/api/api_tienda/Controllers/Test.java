package com.ecommerce.api.api_tienda.Controllers;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Test {

    @RequestMapping // Para generar una api
    @ResponseBody
    public ResponseEntity<String> function(){
        return new ResponseEntity<>("hello trolo", HttpStatus.OK);
    }

}
