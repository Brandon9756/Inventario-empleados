package com.mycompany.inventario.empleados;

import com.mycompany.inventario.empleados.controller.EmpleadoManager;
import com.mycompany.inventario.empleados.model.Empleado;
import com.mycompany.inventario.empleados.model.Producto;
import com.mycompany.inventario.empleados.patterns.InventarioSingleton;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        InventarioSingleton inventario = InventarioSingleton.obtenerInstancia();

        // 👉 Simulación: carga algunos empleados registrados
        EmpleadoManager.agregarEmpleado("admin", "admin123", "admin");
        EmpleadoManager.agregarEmpleado("juan", "1234", "empleado");
        EmpleadoManager.agregarEmpleado("maria", "clave456", "empleado");

        System.out.println("🔐 Bienvenido al sistema");
        System.out.print("Usuario: ");
        String nombre = scanner.nextLine().trim();

        System.out.print("Contraseña: ");
        String clave = scanner.nextLine().trim();

        Empleado autenticado = null;
        for (Empleado e : EmpleadoManager.obtenerEmpleados()) {
            if (e.validarCredenciales(nombre, clave)) {
                autenticado = e;
                break;
            }
        }

        if (autenticado != null) {
            System.out.println("✅ Acceso concedido. Rol: " + autenticado.getRol());

            if (autenticado.getRol().equalsIgnoreCase("admin")) {
                mostrarMenuAdmin(scanner, inventario);
            } else if (autenticado.getRol().equalsIgnoreCase("empleado")) {
                EmpleadoManager.registrarEntrada(autenticado.getNombre());
                mostrarMenuEmpleado(scanner, inventario);
            } else {
                System.out.println("❌ Rol no reconocido.");
            }
        } else {
            System.out.println("❌ Credenciales incorrectas.");
        }

        scanner.close();
    }

    // Menús idénticos a tu estructura actual
    public static void mostrarMenuAdmin(Scanner scanner, InventarioSingleton inventario) {
        boolean activo = true;
        while (activo) {
            System.out.println("\n📦 MENÚ ADMIN");
            System.out.println("1. Agregar producto");
            System.out.println("2. Eliminar producto");
            System.out.println("3. Ver inventario");
            System.out.println("4. Agregar empleado");
            System.out.println("5. Eliminar empleado");
            System.out.println("6. Ver empleados");
            System.out.println("7. Salir");
            System.out.print("Selecciona una opción: ");
            String opcion = scanner.nextLine();

            switch (opcion) {
                case "1" -> {
                    System.out.print("Nombre del producto: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Cantidad: ");
                    int cantidad = Integer.parseInt(scanner.nextLine());
                    System.out.print("Precio: ");
                    double precio = Double.parseDouble(scanner.nextLine());
                    inventario.agregarProducto(new Producto(nombre, cantidad, precio));
                }
                case "2" -> {
                    System.out.print("Nombre del producto a eliminar: ");
                    String nombre = scanner.nextLine();
                    inventario.eliminarProducto(nombre);
                }
                case "3" -> inventario.mostrarInventario();
                case "4" -> {
                    System.out.print("Nombre: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Contraseña: ");
                    String clave = scanner.nextLine();
                    System.out.print("Rol (admin/empleado): ");
                    String rol = scanner.nextLine().trim().toLowerCase();
                    EmpleadoManager.agregarEmpleado(nombre, clave, rol);
                }
                case "5" -> {
                    System.out.print("Nombre del empleado a eliminar: ");
                    String nombre = scanner.nextLine();
                    EmpleadoManager.eliminarEmpleado(nombre);
                }
                case "6" -> EmpleadoManager.mostrarEmpleados();
                case "7" -> {
                    System.out.println("👋 Saliendo...");
                    activo = false;
                }
                default -> System.out.println("❌ Opción inválida.");
            }
        }
    }

    public static void mostrarMenuEmpleado(Scanner scanner, InventarioSingleton inventario) {
        boolean activo = true;
        while (activo) {
            System.out.println("\n📋 MENÚ EMPLEADO");
            System.out.println("1. Ver inventario");
            System.out.println("2. Salir");
            System.out.print("Selecciona una opción: ");
            String opcion = scanner.nextLine();

            switch (opcion) {
                case "1" -> inventario.mostrarInventario();
                case "2" -> {
                    System.out.println("👋 Saliendo...");
                    activo = false;
                }
                default -> System.out.println("❌ Opción inválida.");
            }
        }
    }
}