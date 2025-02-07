package com.example.demo.modelos;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Compra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private double total;
    private String fecha;

    @ManyToOne
    @JoinColumn(name = "id_usuario") // Relación 1:N con Usuario
    private Usuario usuario;

    @OneToMany(mappedBy = "compra", cascade = CascadeType.ALL)
    private List<DetalleCompra> detallesCompra;

    // Constructores, getters y setters
}
