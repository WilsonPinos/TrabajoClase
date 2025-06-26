# Usar una imagen base de OpenJDK 17
FROM openjdk:17-jdk-slim

# Información del mantenedor
LABEL maintainer="trabajoclase@email.com"
LABEL description="Sistema de Facturación API REST"
LABEL version="1.0"

# Crear directorio de trabajo
WORKDIR /app

# Copiar el archivo JAR generado por Maven
COPY target/TrabajoClase-0.0.1-SNAPSHOT.jar app.jar

# Exponer el puerto 8080
EXPOSE 8080

# Variables de entorno para la base de datos
ENV SPRING_DATASOURCE_URL=jdbc:postgresql://postgres:5432/bd_sistema_facturacion
ENV SPRING_DATASOURCE_USERNAME=postgres
ENV SPRING_DATASOURCE_PASSWORD=1234
ENV SPRING_JPA_HIBERNATE_DDL_AUTO=update

# Ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]
