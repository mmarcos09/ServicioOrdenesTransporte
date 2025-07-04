# Dockerfile
FROM eclipse-temurin:21-jdk-alpine
#Carpeta de trabajo edel contenedor
WORKDIR /app
#Copia todos los archivos al contenedor
COPY . .
RUN ./mvnw clean package -DskipTests
EXPOSE 8080
CMD ["java", "-jar", "target/ServicioOrdenesTransporte-0.0.1-SNAPSHOT.jar"]

