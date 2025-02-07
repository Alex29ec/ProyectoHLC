package com.example.demo.modelos;
public class UsuarioDTO {

    private int id;
    private String nombre;
    private String email;

    // Constructor
    public UsuarioDTO(int i, String nombre, String email) {
        this.id = i;
        this.nombre = nombre;
        this.email = email;
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
