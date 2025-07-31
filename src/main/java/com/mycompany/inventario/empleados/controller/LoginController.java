package com.mycompany.inventario.empleados.controller;

import com.mycompany.inventario.empleados.model.Usuario;
import com.mycompany.inventario.empleados.model.Rol;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LoginController {

    @FXML private TextField usuarioField;
    @FXML private PasswordField claveField;
    @FXML private Label mensajeLabel;

    private static final List<Usuario> usuarios = new ArrayList<>();

    // Precarga de usuarios ficticios
    static {
        usuarios.add(new Usuario("admin", "admin123", Rol.ADMIN));
        usuarios.add(new Usuario("juan", "1234", Rol.EMPLEADO));
        usuarios.add(new Usuario("maria", "clave456", Rol.EMPLEADO));
    }

    public void handleLogin() {
        String usuario = usuarioField.getText().trim();
        String clave = claveField.getText().trim();

        if (usuario.isEmpty() || clave.isEmpty()) {
            mensajeLabel.setText("⚠️ Por favor, llena todos los campos.");
            return;
        }

        Usuario autenticado = null;
        for (Usuario u : usuarios) {
            if (u.getNombre().equals(usuario) && u.getContrasena().equals(clave)) {
                autenticado = u;
                break;
            }
        }

        if (autenticado != null) {
            mensajeLabel.setText("");

            try {
                String fxml = autenticado.getRol() == Rol.ADMIN
                        ? "/com/mycompany/inventario/empleados/view/admin.fxml"
                        : "/com/mycompany/inventario/empleados/view/empleado.fxml";

                FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
                Parent root = loader.load();

                Stage stage = (Stage) usuarioField.getScene().getWindow();
                stage.setScene(new Scene(root));
                stage.setTitle("Panel " + autenticado.getRol().name());
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