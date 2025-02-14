package com.example.demo.modelos;

import jakarta.persistence.*;

@Entity
@Table(name = "productos")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "INT(11)")
    private int id;  

    private String nombre;
    private double precio;
    private String imagen;

    public Producto() {}

    public Producto(String nombre, double precio, String imagen) {
        this.nombre = nombre;
        this.precio = precio;
        this.imagen = imagen;
    }

    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public double getPrecio() { return precio; }
    public String getImagen() { return imagen; }

    public void setId(int id) { this.id = id; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setPrecio(double precio) { this.precio = precio; }
    public void setImagen(String imagen) { this.imagen = imagen; }
}
