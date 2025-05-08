# Etapa de construcción
FROM maven:3.9.6-eclipse-temurin-21 AS build

# Establece directorio de trabajo
WORKDIR /app

# Copia el contenido del proyecto
COPY . .

# Empaqueta el proyecto sin ejecutar tests
RUN mvn clean package -DskipTests

# Etapa de ejecución
FROM eclipse-temurin:21-jdk

# Establece directorio de trabajo
WORKDIR /app

# Expone el puerto 8080
EXPOSE 8080

# Copia el JAR generado
COPY --from=build /app/target/*.jar app.jar

# Establece el comando para ejecutar el JAR
ENTRYPOINT ["java", "-jar", "app.jar"]