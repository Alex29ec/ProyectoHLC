package com.example.demo.repositorios;

import com.example.demo.modelos.Compra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompraRepository extends JpaRepository<Compra, Integer> {
    // Puedes añadir métodos personalizados si es necesario
}
