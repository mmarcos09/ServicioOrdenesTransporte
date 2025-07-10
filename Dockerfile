# Dockerfile
FROM eclipse-temurin:21-jdk-alpine
#Carpeta de trabajo edel contenedor
WORKDIR /app
#Copia todos los archivos al contenedor
COPY . .
#Compila el proyecto y generar el .jar, ingnorando los test
RUN ./mvnw clean package -DskipTests
#Usa el puerto 8080 para la app
EXPOSE 8080
#
CMD ["java", "-jar", "target/ServicioOrdenesTransporte-0.0.1-SNAPSHOT.jar"]

