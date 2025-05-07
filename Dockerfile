# Usar la imagen base oficial de OpenJDK 24
FROM openjdk:24-jdk-slim

# Establecer el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copiar el archivo JAR generado por Maven o Gradle al contenedor
COPY target/*.jar app.jar

# Exponer el puerto en el que la aplicación va a correr
EXPOSE 8001

# Comando para ejecutar el JAR
CMD ["java", "-jar", "/app/app.jar"]
