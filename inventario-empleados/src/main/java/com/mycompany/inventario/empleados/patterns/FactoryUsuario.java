package com.mycompany.inventario.empleados.patterns;

import com.mycompany.inventario.empleados.model.Rol;
import com.mycompany.inventario.empleados.model.Usuario;

public class FactoryUsuario {
    public static Usuario crearUsuario(String nombre, String contrasena, Rol rol) {
        return new Usuario(nombre, contrasena, rol);
    }
}