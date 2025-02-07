package com.example.demo.modelos;

public class ProductoDTO {
    private int id;  // Ahora es int en vez de Long
    private String nombre;
    private double precio;
    private String imagen;

    public ProductoDTO() {}

    public ProductoDTO(int id, String nombre, double precio, String imagen) {
        this.id = id;
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
