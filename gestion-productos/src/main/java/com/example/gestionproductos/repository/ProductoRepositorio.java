package com.example.gestionproductos.repository;
import com.example.gestionproductos.models.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductoRepositorio extends JpaRepository<Producto, Long> {

    @Query("SELECT p FROM Producto p WHERE"
            + " CONCAT(p.id,p.nombre, p.marca, p.hechoEn,p.precio)"
            + " LIKE %?1%")
    List<Producto> findAll(String palabraClave);


}

