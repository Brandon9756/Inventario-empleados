package com.mycompany.inventario.empleados.controller;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.awt.Desktop;
import java.net.URI;

public class LoginController {

    @FXML
    private TextField usuarioField;

    @FXML
    private PasswordField claveField;

    @FXML
    private Label mensajeLabel;

    @FXML
    public void handleLogin() {
        // Lógica de login tradicional
        String usuario = usuarioField.getText();
        String clave = claveField.getText();

        if ("admin".equals(usuario) && "1234".equals(clave)) {
            mensajeLabel.setText("Inicio de sesión exitoso.");
        } else {
            mensajeLabel.setText("Credenciales incorrectas.");
        }
    }

    @FXML
    public void handleGitHubLogin() {
        try {
            String authUrl = "https://github.com/login/oauth/authorize?client_id=Ov23liAFt4IJlODL9Nt6&redirect_uri=http://localhost:8080/oauth/callback&scope=read:user";
            Desktop.getDesktop().browse(new URI(authUrl));
        } catch (Exception e) {
            e.printStackTrace();
            mensajeLabel.setText("Error al abrir GitHub.");
        }
    }
}