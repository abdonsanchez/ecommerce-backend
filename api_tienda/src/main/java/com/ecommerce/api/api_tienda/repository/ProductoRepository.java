package com.ecommerce.api.api_tienda.repository;

import com.ecommerce.api.api_tienda.pojos.Producto;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductoRepository extends CrudRepository<Producto, Long> {

    public List<Producto> findAll();

}
