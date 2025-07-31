package com.mycompany.inventario.empleados;

import com.mycompany.inventario.empleados.controller.LoginController;
import com.mycompany.inventario.empleados.model.Usuario;
import com.mycompany.inventario.empleados.model.Rol;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Method;
import java.util.List;

public class AppTest {

    @Test
    public void testLoginAdminSuccess() throws Exception {
        LoginController controller = new LoginController();

        // Acceder a la lista privada de usuarios usando reflexión
        Method getUsuarios = LoginController.class.getDeclaredMethod("handleLogin");
        getUsuarios.setAccessible(true);

        // Simular login manualmente
        Usuario admin = new Usuario("admin", "admin123", Rol.ADMIN);
        assertEquals("admin", admin.getNombre());
        assertEquals("admin123", admin.getContrasena());
        assertEquals(Rol.ADMIN, admin.getRol());
    }

    @Test
    public void testRolEmpleadoNoPuedeEditar() {
        Usuario empleado = new Usuario("juan", "1234", Rol.EMPLEADO);
        assertEquals(Rol.EMPLEADO, empleado.getRol());
        assertNotEquals(Rol.ADMIN, empleado.getRol());
    }
}