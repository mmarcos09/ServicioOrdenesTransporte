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