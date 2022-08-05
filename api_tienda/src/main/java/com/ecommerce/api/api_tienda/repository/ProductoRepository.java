package com.ecommerce.api.api_tienda.repository;

import com.ecommerce.api.api_tienda.entity.Producto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoRepository extends PagingAndSortingRepository<Producto, Long> {
//public interface ProductoRepository extends CrudRepository<Producto, Long> {

    public List<Producto> findAll();

}
