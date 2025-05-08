# Usamos una imagen base con Maven y OpenJDK
FROM maven:3.8.4-openjdk-17-slim AS build

# Directorio de trabajo en el contenedor
WORKDIR /app

# Copiar el código fuente al contenedor
COPY . .

# Ejecutar Maven para compilar y empaquetar el proyecto
RUN mvn clean package -DskipTests

# Usamos una imagen más liviana para el runtime
FROM openjdk:17-jdk-slim

# Directorio donde se copiará el JAR empaquetado
WORKDIR /app

# Copiar el archivo JAR desde la etapa de construcción
COPY --from=build /app/target/tu-aplicacion.jar /app/tu-aplicacion.jar

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "/app/tu-aplicacion.jar"]

# Exponer el puerto en el que Spring Boot estará escuchando
EXPOSE 8080