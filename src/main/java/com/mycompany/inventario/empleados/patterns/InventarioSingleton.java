package com.mycompany.inventario.empleados.patterns;

import com.mycompany.inventario.empleados.model.Producto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class InventarioSingleton {
    private static InventarioSingleton instancia;
    private final ObservableList<Producto> productos;

    private InventarioSingleton() {
        productos = FXCollections.observableArrayList();
    }

    public static InventarioSingleton obtenerInstancia() {
        if (instancia == null) {
            instancia = new InventarioSingleton();
        }
        return instancia;
    }

    public ObservableList<Producto> getProductos() {
        return productos;
    }

    public void agregarProducto(Producto producto) {
        productos.add(producto);
        System.out.println("✅ Producto agregado.");
    }

    public void eliminarProducto(String nombre) {
        boolean eliminado = productos.removeIf(p -> p.getNombre().equalsIgnoreCase(nombre));
        if (eliminado) {
            System.out.println("✅ Producto eliminado.");
        } else {
            System.out.println("❌ Producto no encontrado.");
        }
    }

    public void eliminarProducto(Producto producto) {
        productos.remove(producto);
    }

    public void mostrarInventario() {
        if (productos.isEmpty()) {
            System.out.println("📦 Inventario vacío.");
        } else {
            System.out.println("📋 Inventario:");
            for (Producto p : productos) {
                System.out.printf("- %s | Precio: $%.2f | Cantidad: %d%n",
                        p.getNombre(), p.getPrecio(), p.getCantidad());
            }
        }
    }
}