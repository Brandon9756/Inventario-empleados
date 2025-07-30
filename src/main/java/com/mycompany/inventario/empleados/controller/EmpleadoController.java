package com.mycompany.inventario.empleados.controller;

import com.mycompany.inventario.empleados.model.Empleado;
import com.mycompany.inventario.empleados.controller.EmpleadoManager;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class EmpleadoController {

    @FXML
    private TextField nombreField;

    @FXML
    private TextField contraseñaField;

    @FXML
    private ComboBox<String> rolCombo;

    @FXML
    private TableView<Empleado> tablaEmpleados;

    @FXML
    private TableColumn<Empleado, String> colNombre;

    @FXML
    private TableColumn<Empleado, String> colRol;

    @FXML
    private TableColumn<Empleado, Void> colAccion;

    @FXML
    public void initialize() {
        rolCombo.getItems().addAll("admin", "empleado");

        colNombre.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getNombre()));
        colRol.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getRol()));

        tablaEmpleados.setItems(EmpleadoManager.obtenerEmpleados());

        agregarBotonEliminar();
    }

    @FXML
    private void registrarEmpleado() {
        String nombre = nombreField.getText();
        String contraseña = contraseñaField.getText();
        String rol = rolCombo.getValue();

        if (nombre == null || nombre.trim().isEmpty() ||
            rol == null || contraseña == null || contraseña.trim().isEmpty()) {
            mostrarAlerta("⚠️ Por favor, completa todos los campos.");
            return;
        }

        EmpleadoManager.agregarEmpleado(nombre, contraseña, rol);
        mostrarAlerta("✅ Empleado registrado exitosamente.");

        nombreField.clear();
        contraseñaField.clear();
        rolCombo.setValue(null);
    }

    private void mostrarAlerta(String mensaje) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Registro");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    private void agregarBotonEliminar() {
        colAccion.setCellFactory(col -> new TableCell<>() {
            private final Button btn = new Button("Eliminar");

            {
                btn.setOnAction(e -> {
                    Empleado empleado = getTableView().getItems().get(getIndex());
                    EmpleadoManager.eliminarEmpleado(empleado.getNombre());
                    tablaEmpleados.setItems(EmpleadoManager.obtenerEmpleados());
                });
            }

            @Override
            protected void updateItem(Void item, boolean empty) {
                super.updateItem(item, empty);
                setGraphic(empty ? null : btn);
            }
        });
    }
}