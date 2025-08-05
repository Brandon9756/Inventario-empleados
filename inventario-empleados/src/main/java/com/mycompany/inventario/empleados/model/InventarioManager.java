package com.mycompany.inventario.empleados.model;

import com.mycompany.inventario.empleados.patterns.InventarioSingleton;
import javafx.collections.ObservableList;

public class InventarioManager {

    private final InventarioSingleton inventario = InventarioSingleton.obtenerInstancia();

    // Devuelve la lista observable directamente para que la tabla se actualice en tiempo real
    public ObservableList<Producto> getProductos() {
        return inventario.getProductos();
    }

    // Agrega un producto al inventario
    public void agregarProducto(Producto producto) {
        inventario.agregarProducto(producto);
    }

    // Elimina un producto por instancia
    public void eliminarProducto(Producto producto) {
        inventario.eliminarProducto(producto);
    }

    // Elimina un producto por nombre
    public void eliminarProductoPorNombre(String nombre) {
        inventario.eliminarProducto(nombre);
    }

    // Muestra el inventario en consola (útil para depuración)
    public void mostrarInventario() {
        inventario.mostrarInventario();
    }
}