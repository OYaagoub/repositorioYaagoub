# Utilizar una imagen de Maven para construir la aplicación
FROM maven:3.8.5-openjdk-17 as build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Utilizar una imagen de OpenJDK para ejecutar la aplicación
FROM openjdk:17-jdk-slim
WORKDIR /app
COPY --from=build /app/target/misanuncios-0.0.1-SNAPSHOT.jar app.jar

# Exponer el puerto en el que se ejecuta la aplicación Spring Boot
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]

