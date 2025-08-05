package com.mycompany.inventario.empleados.controller;

import com.mycompany.inventario.empleados.model.Empleado;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class EmpleadoManager {

    // Lista observable para JavaFX
    private static final ObservableList<Empleado> empleados = FXCollections.observableArrayList();

    // Agrega un nuevo empleado con contraseña
    public static void agregarEmpleado(String nombre, String contraseña, String rol) {
        empleados.add(new Empleado(nombre, contraseña, rol));
    }

    // Elimina un empleado por objeto (usado en JavaFX)
    public static void eliminarEmpleado(Empleado empleado) {
        empleados.remove(empleado);
    }

    // Elimina un empleado por nombre (usado en consola)
    public static void eliminarEmpleado(String nombre) {
        empleados.removeIf(e -> e.getNombre().equalsIgnoreCase(nombre));
    }

    // Devuelve la lista de empleados (usado en JavaFX)
    public static ObservableList<Empleado> obtenerEmpleados() {
        return empleados;
    }

    // Muestra empleados en consola
    public static void mostrarEmpleados() {
        if (empleados.isEmpty()) {
            System.out.println("📭 No hay empleados registrados.");
        } else {
            System.out.println("👥 Lista de empleados:");
            for (Empleado e : empleados) {
                System.out.println("- " + e.getNombre() + " (" + e.getRol() + ")");
            }
        }
    }

    // Simula registro de entrada (usado en consola)
    public static void registrarEntrada(String nombre) {
        System.out.println("📌 Entrada registrada para: " + nombre);
    }
}