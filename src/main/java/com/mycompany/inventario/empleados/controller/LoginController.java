package com.mycompany.inventario.empleados.controller;

import com.mycompany.inventario.empleados.model.Empleado;
import com.mycompany.inventario.empleados.controller.EmpleadoManager;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {

    @FXML private TextField usuarioField;
    @FXML private PasswordField claveField;
    @FXML private Label mensajeLabel;

    // Precarga de empleados ficticios
    static {
        EmpleadoManager.agregarEmpleado("admin", "admin123", "admin");
        EmpleadoManager.agregarEmpleado("juan", "1234", "empleado");
        EmpleadoManager.agregarEmpleado("maria", "clave456", "empleado");
    }

    public void handleLogin() {
        String usuario = usuarioField.getText().trim();
        String clave = claveField.getText().trim();

        if (usuario.isEmpty() || clave.isEmpty()) {
            mensajeLabel.setText("⚠️ Por favor, llena todos los campos.");
            return;
        }

        Empleado autenticado = null;
        for (Empleado e : EmpleadoManager.obtenerEmpleados()) {
            if (e.validarCredenciales(usuario, clave)) {
                autenticado = e;
                break;
            }
        }

        if (autenticado != null) {
            mensajeLabel.setText("");

            try {
                // 👇 Ajuste de rutas basadas en tu estructura real
                String fxml = autenticado.getRol().equals("admin")
                        ? "/com/mycompany/inventario/empleados/view/admin.fxml"
                        : "/com/mycompany/inventario/empleados/view/empleado.fxml";

                FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
                Parent root = loader.load();

                Stage stage = (Stage) usuarioField.getScene().getWindow();
                stage.setScene(new Scene(root));
                stage.setTitle("Panel " + autenticado.getRol().toUpperCase());
                stage.show();

            } catch (IOException e) {
                mensajeLabel.setText("❌ Error al cargar la interfaz.");
                System.err.println("Error cargando FXML: " + e.getMessage());
                e.printStackTrace();
            }

        } else {
            mensajeLabel.setText("❌ Credenciales incorrectas.");
        }
    }
}