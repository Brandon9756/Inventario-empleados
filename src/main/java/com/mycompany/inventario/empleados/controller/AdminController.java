package com.mycompany.inventario.empleados.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;

public class AdminController {

    @FXML private TabPane adminTabPane;

    @FXML
    public void initialize() {
        System.out.println("Número de pestañas cargadas: " + adminTabPane.getTabs().size());
        for (Tab tab : adminTabPane.getTabs()) {
            System.out.println("Pestaña: " + tab.getText());
        }
    }
}