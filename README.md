# ServicioOrdenesTransporte

API REST para la gestion de ordenes de transporte desarrollada con Java 21 y Spring Boot.

## Tecnologías utilizadas

- Java 21
- Spring Boot 3.4.7
- Spring Data JPA
- Spring Validation
- MariaDB
- Docker & Docker Compose

## Base de datos

Este proyecto incluye un script SQL "db/ordenes_transporte.sql" con la estructura de las tablas:

- "driver":conductores con su estado activo/inactivo
- "order": órdenes de transporte con asignación opcional a conductor

## Docker Compose

El archivo "docker-compose.yml" está configurado para ejecutar ese script automáticamente al iniciar MariaDB, usando:
volumes:
- ./db:/docker-entrypoint-initdb.d

### Guía para pruebas con Postman
## Requisitos

- Proyecto compilado: mvn clean package -DskipTests
- Contenedores en ejecución: docker-compose up
- Puerto de la app expuesto: http://localhost:8080

### Endpoints:
## DriverController

### 1. Crear un conductor (POST)

- URL: http://localhost:8080/api/drivers/createDriver
- Método: POST
- Headers: Content-Type: application/json
- **Body (raw / JSON)**:

# json entrada
{
  "name": "Juan Pérez",
  "active": true
}
# Respuesta esperada (201/200)
{
  "id": 1,
  "name": "Juan Pérez",
  "active": true
}
