package com.mycompany.inventario.empleados.controller;

import com.mycompany.inventario.empleados.auth.GitHubAuthService;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import java.util.Scanner;
import org.json.JSONObject;

public class LoginController {

    @FXML
    private Label lblUsuario;

    @FXML
    public void iniciarSesionGitHub() {
        try {
            GitHubAuthService auth = new GitHubAuthService();
            auth.iniciarLogin(); // Abre el navegador

            System.out.println("🔑 Pega aquí el código que obtuviste de la URL:");
            Scanner scanner = new Scanner(System.in);
            String code = scanner.nextLine();

            String token = auth.obtenerAccessToken(code);
            JSONObject user = auth.obtenerDatosUsuario(token);

            String nombreUsuario = user.getString("login");
            System.out.println("✅ Usuario autenticado: " + nombreUsuario);

            lblUsuario.setText("Bienvenido, " + nombreUsuario);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}