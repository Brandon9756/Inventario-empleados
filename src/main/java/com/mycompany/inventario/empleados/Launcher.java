package com.mycompany.inventario.empleados;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Parent;
import com.mycompany.inventario.empleados.auth.OAuthServer;

public class Launcher extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/com/mycompany/inventario/empleados/view/Login.fxml"));
        primaryStage.setTitle("Sistema de Inventario");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public static void main(String[] args) {
        // Iniciar el servidor OAuth en segundo plano
        new Thread(() -> {
            try {
                OAuthServer.startServer();
            } catch (Exception e) {
                System.err.println("Error al iniciar el servidor OAuth:");
                e.printStackTrace();
            }
        }).start();

        launch(args);
    }
}