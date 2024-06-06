# Usar una imagen base de JDK para ejecutar la aplicación
FROM openjdk:17-jdk-slim

# Crear un directorio para la aplicación
WORKDIR /app

# Copiar el archivo JAR de la aplicación al contenedor
COPY target/yimfitapp-0.0.1-SNAPSHOT.jar /app/yimfitapp.jar

# Exponer el puerto en el que se ejecutará la aplicación
EXPOSE 8080

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "/app/yimfitapp.jar"]

