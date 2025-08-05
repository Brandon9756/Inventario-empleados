package com.mycompany.inventario.empleados.model;

public class Empleado {
    private String nombre;
    private String contraseña;
    private String rol; // "admin" o "empleado"

    public Empleado(String nombre, String contraseña, String rol) {
        this.nombre = nombre;
        this.contraseña = contraseña;
        this.rol = rol;
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public String getContraseña() {
        return contraseña;
    }

    public String getRol() {
        return rol;
    }

    // Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    // Método auxiliar para validar credenciales (puedes usarlo si no quieres un servicio extra)
    public boolean validarCredenciales(String nombre, String contraseña) {
        return this.nombre.equals(nombre) && this.contraseña.equals(contraseña);
    }

    @Override
    public String toString() {
        return "Empleado{" +
               "nombre='" + nombre + '\'' +
               ", rol='" + rol + '\'' +
               '}';
    }
}