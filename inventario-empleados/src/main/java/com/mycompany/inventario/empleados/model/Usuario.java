package com.mycompany.inventario.empleados.model;

public class Usuario {
    private final String nombre;
    private final String contrasena;
    private final Rol rol;

    public Usuario(String nombre, String contrasena, Rol rol) {
        this.nombre = nombre;
        this.contrasena = contrasena;
        this.rol = rol;
    }

    public String getNombre() {
        return nombre;
    }

    public String getContrasena() {
        return contrasena;
    }

    public Rol getRol() {
        return rol;
    }
}