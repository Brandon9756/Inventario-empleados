package com.mycompany.inventario.empleados;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AppFX extends Application {
    @Override
    public void start(Stage stage) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/mycompany/inventario/empleados/view/login.fxml"));
            Scene scene = new Scene(loader.load());
            stage.setScene(scene);
            stage.setTitle("Inventario y Empleados");
            stage.show();
        } catch (Exception e) {
            System.err.println("❌ Error al cargar la interfaz:");
            e.printStackTrace();
        }
    }
}