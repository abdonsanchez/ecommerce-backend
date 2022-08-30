package com.ecommerce.api.api_tienda.repository;

import com.ecommerce.api.api_tienda.entity.Usuario;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends PagingAndSortingRepository<Usuario, Long> {

    public List<Usuario> findAll();

    List<Usuario> findByusremail(String usr_email);

    @Modifying
    @Query("SELECT u FROM Usuario u WHERE u.usremail=?1")
    public Optional<Usuario> updateByEmail(String email);


}
