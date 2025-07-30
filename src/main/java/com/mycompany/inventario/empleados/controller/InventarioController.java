package com.mycompany.inventario.empleados.controller;

import com.mycompany.inventario.empleados.model.Producto;
import com.mycompany.inventario.empleados.model.InventarioManager;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;

public class InventarioController {

    @FXML private TextField nombreField;
    @FXML private TextField categoriaField;
    @FXML private TextField cantidadField;
    @FXML private TextField precioField;

    @FXML private TableView<Producto> tablaProductos;
    @FXML private TableColumn<Producto, String> colNombre;
    @FXML private TableColumn<Producto, String> colCategoria;
    @FXML private TableColumn<Producto, Integer> colCantidad;
    @FXML private TableColumn<Producto, Double> colPrecio;
    @FXML private TableColumn<Producto, Void> colAccion;

    private InventarioManager inventarioManager = new InventarioManager();

    @FXML
    public void initialize() {
        // Configurar columnas
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colCategoria.setCellValueFactory(new PropertyValueFactory<>("categoria"));
        colCantidad.setCellValueFactory(new PropertyValueFactory<>("cantidad"));
        colPrecio.setCellValueFactory(new PropertyValueFactory<>("precio"));

        // Agregar botón de eliminación
        agregarBotonEliminar();

        // Cargar productos en la tabla
        tablaProductos.setItems(inventarioManager.getProductos());

        // Mensaje de depuración
        System.out.println("InventarioController inicializado correctamente.");
    }

    @FXML
    private void registrarProducto() {
        try {
            String nombre = nombreField.getText().trim();
            String categoria = categoriaField.getText().trim();
            int cantidad = Integer.parseInt(cantidadField.getText().trim());
            double precio = Double.parseDouble(precioField.getText().trim());

            if (nombre.isEmpty() || categoria.isEmpty()) {
                mostrarAlerta("Campos vacíos", "Por favor completa todos los campos.");
                return;
            }

            Producto producto = new Producto(nombre, categoria, cantidad, precio);
            inventarioManager.agregarProducto(producto);
            limpiarCampos();

        } catch (NumberFormatException e) {
            mostrarAlerta("Error de entrada", "Cantidad y precio deben ser numéricos.");
        }
    }

    private void agregarBotonEliminar() {
        colAccion.setCellFactory(param -> new TableCell<>() {
            private final Button btnEliminar = new Button("Eliminar");

            {
                btnEliminar.setOnAction(event -> {
                    Producto producto = getTableView().getItems().get(getIndex());
                    inventarioManager.eliminarProducto(producto);
                });
            }

            @Override
            protected void updateItem(Void item, boolean empty) {
                super.updateItem(item, empty);
                if (empty) {
                    setGraphic(null);
                } else {
                    setGraphic(new HBox(btnEliminar));
                }
            }
        });
    }

    private void limpiarCampos() {
        nombreField.clear();
        categoriaField.clear();
        cantidadField.clear();
        precioField.clear();
    }

    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}