# # Usa una imagen base de JDK
# FROM openjdk:17-jdk-slim

# # Añade un volumen apuntando a /tmp
# VOLUME /tmp

# # Copia el jar del proyecto en el contenedor
# COPY misanuncios/target/misanuncios-0.0.1-SNAPSHOT.jar app.jar

# # Expone el puerto 8080
# EXPOSE 8080

# # Ejecuta el jar
# ENTRYPOINT ["java", "-jar", "/app.jar"]


# Usa una imagen base de OpenJDK
FROM openjdk:17-jdk-slim

# Añade un volumen apuntando a /tmp
VOLUME /tmp

# Copia el JAR del proyecto en el contenedor
COPY misanuncios/target/misanuncios-0.0.1-SNAPSHOT.jar app.jar

# Expone el puerto 8080
EXPOSE 8080

# Ejecuta la aplicación como lo haces localmente
CMD ["java", "-jar", "app.jar"]
