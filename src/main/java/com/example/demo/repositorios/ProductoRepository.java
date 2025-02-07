package com.example.demo.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.modelos.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Integer> {
}
