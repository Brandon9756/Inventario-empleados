 Inventario y Gestión de Empleados – El Pollo Feliz
Este proyecto es una aplicación de escritorio desarrollada en JavaFX para la gestión de inventario y empleados en El Pollo Feliz. Incluye autenticación por roles, control de productos, y una interfaz gráfica moderna, todo integrado con buenas prácticas de arquitectura y automatización.

📁 Estructura del Proyecto
src/
├── com.mycompany.inventario.empleados/
│   ├── App.java
│   ├── AppFX.java
│   ├── Launcher.java
│
├── auth/
│   ├── CallbackServer.java
│   ├── GitHubAuthService.java
│   ├── OAuthServer.java
│
├── controller/
│   ├── AdminController.java
│   ├── EmpleadoController.java
│   ├── EmpleadoManager.java
│   ├── InventarioController.java
│   ├── LoginController.java
│
├── model/
│   ├── Empleado.java
│   ├── EmpleadoManager.java
│   ├── Producto.java
│   ├── Rol.java
│   ├── Usuario.java
│
├── patterns/
│   ├── FactoryUsuario.java
│   ├── InventarioSingleton.java
│   ├── Sealed.java
│
├── view/
│   ├── EmpleadoAppFX.java
│
resources/
├── fxml/
│   ├── login.fxml
│   ├── inventario.fxml
│   ├── empleados.fxml
│
├── css/
│   ├── styles.css
│
pom.xml
drone.yml



🚀 Cómo Ejecutar
- Clona el repositorio:
git clone https://github.com/tu-usuario/inventario-empleados.git
cd inventario-empleados
- Compila y ejecuta con Maven:
mvn clean javafx:run



🔐 Autenticación
- Implementación de OAuth con GitHub
- Servidor de callbacks para autenticación segura
- Roles definidos: ADMIN, EMPLEADO

🧪 Pruebas
Las pruebas unitarias están organizadas en el paquete test, enfocadas en servicios y lógica de negocio.
mvn test



🧰 Tecnologías
| Herramienta | Uso | 
| Java & JavaFX | Backend + GUI | 
| Maven | Gestión de dependencias | 
| JUnit | Pruebas automatizadas | 
| Drone.io | CI/CD | 
| FXML & CSS | Diseño de interfaz | 
| GitHub OAuth | Autenticación de usuarios | 



📌 Patrones de Diseño
- Singleton para el inventario
- Factory para creación de usuarios
- Sealed Classes para control de herencia

📈 Próximas Funcionalidades
- Dashboard con métricas visuales
- Exportación de reportes
- Integración con base de datos externa
- Modo oscuro y personalización de temas

🤝 Contribuciones
Este proyecto está abierto a mejoras. Si deseas colaborar, puedes abrir un issue o enviar un pull request.
