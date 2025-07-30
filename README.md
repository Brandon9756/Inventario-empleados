# Inventario-empleados
# 📦 Inventory & Employee Management System

Sistema para gestionar inventario y empleados en negocios locales. Mejora la eficiencia operativa mediante autenticación por roles, control de productos y seguimiento del personal.

## 🚀 Características principales

- Gestión de productos y control de stock
- Registro y seguimiento de empleados
- Autenticación por roles: Admin, Supervisor, Empleado
- Panel de métricas (en desarrollo)

## 🛠️ Tecnologías utilizadas

- Java 17+
- Spring Boot
- MongoDB (o base de datos relacional)
- Git + GitHub

## 📦 Instalación y ejecución

1. Clona el repositorio:

```bash
git clone https://github.com/tuusuario/inventory-system.git
cd inventory-system

- Configura las variables de entorno en application.properties o application.yml:
spring.data.mongodb.uri=mongodb://localhost:27017/inventory
server.port=8080
jwt.secret=tu_secreto


- Compila el proyecto:
./mvnw clean package


- Ejecuta el archivo .jar generado:
java -jar target/inventory-system.jar


👥 Roles y permisos
| Rol | Inventario | Empleados | Panel | 
| Admin | ✅ | ✅ | ✅ | 
| Supervisor | ✅ | ❌ | ✅ | 
| Empleado | ❌ | ❌ | ❌ | 


📄 Licencia
MIT

---
