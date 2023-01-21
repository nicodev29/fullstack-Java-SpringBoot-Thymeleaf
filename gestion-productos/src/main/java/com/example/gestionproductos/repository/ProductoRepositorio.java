package com.example.gestionproductos.repository;
import com.example.gestionproductos.models.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepositorio extends JpaRepository<Producto, Long> {

}

