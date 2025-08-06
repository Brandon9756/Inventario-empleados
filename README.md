# 📦 El Pollo Feliz — Sistema de Gestión de Inventario y Empleados

## 📚 Tabla de Contenidos

- [📦 El Pollo Feliz — Sistema de Gestión de Inventario y Empleados](#-el-pollo-feliz--sistema-de-gestión-de-inventario-y-empleados)
  - [📦 Resumen Ejecutivo](#-resumen-ejecutivo)
    - [📝 Descripción](#-descripción)
    - [❗ Problema Identificado](#-problema-identificado)
    - [✅ Solución Propuesta](#-solución-propuesta)
    - [🏗️ Arquitectura del Sistema](#-arquitectura-del-sistema)
    - [📁 Estructura del Proyecto](#-estructura-del-proyecto)
- [⚙️ Requerimientos del Sistema](#-requerimientos-del-sistema)
- [🛠️ Instalación y Configuración](#-instalación-y-configuración)
- [👤 Guía de Usuario](#-guía-de-usuario)
- [🛡️ Guía para Administradores](#-guía-para-administradores)
- [🚀 Contribución y Roadmap](#-contribución-y-roadmap)
- [📖 Documentación Técnica (Wiki)](https://github.com/Brandon9756/Inventario-empleados/wiki)

---

## 📦 Resumen Ejecutivo

### 📝 Descripción
*El Pollo Feliz* es un sistema modular diseñado para optimizar la gestión de inventario y empleados en negocios locales de comida rápida. El proyecto busca ofrecer una solución accesible, escalable y bien documentada que cumpla con criterios académicos y profesionales.

### ❗ Problema Identificado
Negocios como *El Pollo Feliz* enfrentan desafíos en el control de insumos, seguimiento de empleados y generación de reportes. La falta de herramientas digitales provoca errores humanos, pérdida de información y baja eficiencia operativa.

### ✅ Solución Propuesta
Se desarrolló una aplicación de escritorio en Java utilizando JavaFX, con autenticación vía OAuth (GitHub), arquitectura modular, y despliegue automatizado mediante CI/CD con Drone.io. El sistema permite:

- Registro y edición de empleados  
- Control de inventario por categoría  
- Autenticación segura  
- Interfaz amigable y responsiva  
- Documentación técnica y académica

### 🏗️ Arquitectura del Sistema
El sistema sigue una arquitectura modular basada en patrones como Singleton y Factory. Cada módulo (Inventario, Empleados, Autenticación) está desacoplado para facilitar mantenimiento y escalabilidad. Se emplea Maven para gestión de dependencias y Drone.io para integración continua.

### 📁 Estructura del Proyecto

inventario-empleados/
├── src/
│   ├── main/
│   │   ├── java/com/mycompany/inventario/empleados/
│   │   │   ├── App.java
│   │   │   ├── AppFX.java
│   │   │   ├── Launcher.java
│   │   ├── java/auth/
│   │   │   ├── CallbackServer.java
│   │   │   ├── GitHubAuthService.java
│   │   │   ├── OAuthServer.java
│   │   ├── java/controller/
│   │   │   ├── AdminController.java
│   │   │   ├── EmpleadoController.java
│   │   │   ├── InventarioController.java
│   │   │   ├── LoginController.java
│   │   ├── java/model/
│   │   │   ├── Empleado.java
│   │   │   ├── Producto.java
│   │   │   ├── Rol.java
│   │   │   ├── Usuario.java
│   │   ├── java/patterns/
│   │   │   ├── FactoryUsuario.java
│   │   │   ├── InventarioSingleton.java
│   │   │   ├── Sealed.java
│   │   ├── resources/
│   │   │   ├── fxml/login.fxml
│   │   │   ├── fxml/inventario.fxml
│   │   │   ├── fxml/empleados.fxml
│   │   │   ├── css/styles.css
│   ├── test/
│   │   ├── java/…  
├── pom.xml  
├── drone.yml  
├── LICENSE  
└── README.md  

## ⚙️ Requerimientos del Sistema

Este sistema fue desarrollado con herramientas modernas que garantizan compatibilidad, rendimiento y facilidad de mantenimiento. A continuación se detallan los requerimientos necesarios para ejecutar el proyecto correctamente:

### ☕ Entorno de Desarrollo

- **Java 24**  
  Lenguaje base del sistema. Se recomienda tenerlo instalado y configurado correctamente en el entorno local.

- **JavaFX SDK 21**  
  Utilizado para construir la interfaz gráfica. Es necesario configurar la variable `PATH_TO_FX` si se compila desde línea de comandos.

- **Maven 3.8+**  
  Herramienta de gestión de dependencias y compilación. El archivo `pom.xml` ya incluye todas las librerías necesarias.

- **Git**  
  Para clonar el repositorio y manejar el control de versiones.

- **Drone.io**  
  Integrado mediante el archivo `.drone.yml` para automatizar pruebas y despliegues.

### 🧰 Paquetes y Librerías Adicionales

Estas dependencias se instalan automáticamente al compilar con Maven:

- `ControlsFX`: Mejora visual de componentes JavaFX  
- `Gson`: Manejo de datos en formato JSON  
- `OAuth Client`: Autenticación con GitHub  
- `JUnit`: Pruebas unitarias  
- `Log4j`: Registro de eventos y errores  
- `Apache Commons`: Utilidades generales

### 🗄️ Infraestructura Requerida

Este sistema está diseñado para funcionar de forma local, sin necesidad de servidores externos:

| Componente           | Requerido | Descripción                                      |
|----------------------|-----------|--------------------------------------------------|
| Servidor de Aplicación | ❌       | No se requiere; es una aplicación de escritorio |
| Servidor Web         | ❌        | No aplica                                        |
| Base de Datos        | ❌        | No se utiliza; persistencia simulada en memoria |
| CI/CD                | ✅        | Drone.io para pruebas y despliegue automático    |

> Nota: La autenticación con GitHub requiere conexión a internet. El resto del sistema puede ejecutarse de forma local sin problemas.


## 🛠️ Instalación y Configuración

A continuación se detallan los pasos para instalar el entorno de desarrollo, ejecutar pruebas manuales y desplegar la solución en un ambiente local.

### 🧰 Instalación del Ambiente de Desarrollo

1. **Instalar Java 24**  
   Descarga e instala desde [Oracle](https://www.oracle.com/java/technologies/javase/jdk24-archive-downloads.html) o [Adoptium](https://adoptium.net).

2. **Instalar JavaFX SDK 21**  
   Descarga desde [Gluon](https://gluonhq.com/products/javafx/) y descomprime el SDK en una ruta accesible.

3. **Configurar `PATH_TO_FX`**  
   Si compilas desde terminal, agrega el siguiente argumento:

   ```bash
   --module-path "C:\ruta\a\javafx-sdk-21\lib" --add-modules javafx.controls,javafx.fxml
   - Instalar Maven 3.8+
Descarga desde Apache Maven y agrega a tu variable de entorno PATH
- Clonar el repositorio
git clone https://github.com/Brandon9756/Inventario-empleados.git
cd Inventario-empleados
Compilar el proyecto
mvn clean install
IMPORTANTE: Asegúrate de tener configurado correctamente el PATH_TO_FX si usas JavaFX fuera de un IDE.
Despliegue en Producción (Ambiente Local)Este sistema está pensado para ejecutarse directamente en máquinas locales sin necesidad de servidores externos. Para desplegarlo:- Verifica que Java y JavaFX estén correctamente instalados.
- Ejecuta el JAR desde terminal o doble clic.
- La autenticación con GitHub requiere conexión a internet.
- No se requiere base de datos ni servidor web.
El sistema puede ser distribuido como JAR ejecutable o empaquetado con herramientas como Launch4j o JPackage si se desea un instalador.

## ⚙️ Configuración

Esta sección explica cómo ajustar el sistema para que funcione correctamente en tu entorno local, incluyendo archivos de configuración y parámetros necesarios.

### 🛠️ Configuración del Producto

El sistema incluye un archivo de configuración ubicado en: src/main/resources/config.properties

Este archivo permite definir los roles disponibles y los usuarios iniciales del sistema. Ejemplo:

properties
# Roles disponibles en el sistema
roles=ADMIN,EMPLEADO

# Usuarios precargados (formato: usuario:contraseña:rol)
usuarios=admin:admin123:ADMIN,juan:1234:EMPLEADO
Puedes modificar este archivo para agregar más usuarios o cambiar contraseñas sin necesidad de recompilar el proyecto.
🧩 Configuración de los Requerimientos
Para que el sistema funcione correctamente, asegúrate de tener configurado lo siguiente:
- JavaFX SDK 21
Descargado y descomprimido. Debes configurar la variable PATH_TO_FX si compilas desde terminal:
export PATH_TO_FX=/ruta/a/javafx-sdk-21/lib

- Maven
Ya incluye todas las dependencias necesarias en el archivo pom.xml. No necesitas instalar paquetes manualmente.
- Drone.io
El archivo .drone.yml ya está configurado para ejecutar pruebas y compilar el proyecto automáticamente. Solo necesitas vincular el repositorio en la plataforma de Drone.
Si trabajas desde un IDE como IntelliJ o VS Code, asegúrate de que el SDK de Java y JavaFX estén correctamente referenciados en el proyecto


## 👤 Guía de Usuario

Esta sección sirve como referencia para los **usuarios finales** del sistema de gestión de *El Pollo Feliz*. Está diseñada para facilitar el uso cotidiano de la aplicación.

### Funcionalidades disponibles

- **Inicio de sesión**  
  Accede al sistema con tu usuario y contraseña asignados.

- **Consulta de inventario**  
  Visualiza productos disponibles, cantidades y descripciones.

- **Registro de actividad**  
  Registra acciones como ventas o movimientos de productos.

- **Visualización de perfil**  
  Consulta tu información personal y rol dentro del sistema.

> ⚠️ Los empleados no pueden modificar datos críticos ni acceder a configuraciones administrativas.

---

## 🛡️ Guía para Administradores

Esta sección está dirigida a los **usuarios con rol de administrador**, quienes tienen acceso completo al sistema.

### Funcionalidades disponibles

- **Gestión de usuarios**  
  Crear, editar o eliminar cuentas de empleados.

- **Gestión de inventario**  
  Agregar nuevos productos, actualizar cantidades, eliminar artículos obsoletos.

- **Visualización de reportes**  
  Acceder a reportes de actividad, movimientos de inventario y desempeño de empleados.

- **Configuración del sistema**  
  Modificar parámetros en el archivo `config.properties`, como roles y usuarios iniciales.

- **Supervisión de seguridad**  
  Validar accesos, revisar logs y asegurar el correcto funcionamiento del sistema.

> 🔐 Se recomienda cambiar las credenciales por defecto del administrador tras la primera ejecución.

## 🚀 Contribución y Roadmap

Esta sección está dirigida a usuarios que deseen contribuir al desarrollo del sistema de gestión de *El Pollo Feliz*. A continuación se detallan los pasos para colaborar de forma ordenada y efectiva.

---

### 🧑‍💻 Guía de Contribución

1. **Clonar el repositorio**
   bash
   git clone https://github.com/Brandon9756/Inventario-empleados.git
   cd Inventario-empleados

- Crear una nueva rama Usa un nombre descriptivo para tu rama, por ejemplo:
git checkout -b mejora-interfaz-login
 - Realizar cambios Asegúrate de seguir las convenciones del proyecto y documentar tu código si es necesario.
- Confirmar y subir cambio
 git add .
git commit -m "Mejora en la interfaz de login"
git push origin mejora-interfaz-login
- Crear un Pull Request
- Ve al repositorio en GitHub.
- Haz clic en Compare & pull request.
- Describe brevemente los cambios realizados.
- Envía el PR para revisión.
- Esperar revisión y merge El administrador del repositorio revisará tu contribución. Si todo está correcto, se hará el merge a la rama principal.
✅ Todas las contribuciones deben estar alineadas con los objetivos del proyecto y respetar la estructura modular definida.

📈 Roadmap del Proyecto
El desarrollo futuro contempla:
- [ ] Integración de reportes PDF para inventario y empleados.
- [ ] Mejora de interfaz gráfica con estilos personalizados.
- [ ] Implementación de roles adicionales (Supervisor, Auditor).
- [ ] Integración con base de datos externa (MySQL o PostgreSQL).
- [ ] Internacionalización del sistema (soporte multilenguaje).
Si tienes ideas o sugerencias, ¡no dudes en abrir un issue en el repositorio!
