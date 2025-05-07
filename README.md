# Proyecto de PruebaTecnica Nequi - Franquicias

Este proyecto es un desarrollado con **Spring Boot**, que se conecta a una base de datos **MySQL**. El objetivo es gestionar el acceso a la información de las franquicias.

## Tecnologías

- **Spring Boot**: Framework para desarrollar aplicaciones.
- **MySQL**: Base de datos para almacenar los datos de las franquicias.
- **Docker**: Contenerización de la aplicación para facilitar el despliegue y la ejecución en cualquier entorno.

## Requisitos

1. **Java 24** (o superior)
2. **Docker** (si deseas ejecutar el proyecto en un contenedor)
3. **Maven** para la construcción de la aplicación

## Instrucciones para la construcción

1. Clona este repositorio en tu máquina local.
   ```bash
   https://github.com/AndresFC500/PruebaNequi.git
    ```
2. Compila y empaqueta el proyecto utilizando Maven.
   ```bash
   mvn clean package
    ```
## Ejecutar el contenedor con Docker 

1. Asegúrate de tener el archivo Dockerfile en la raíz de tu proyecto y ejecuta el siguiente comando en el directorio del proyecto:
   ```bash
   docker build -t miapp .
    ```   
2. Ejecuta el contenedor, mapeando el puerto y configurando la URL de la base de datos.
   ```bash
   docker run -p 8001:8001 -e SPRING_DATASOURCE_URL=jdbc:mysql://host.docker.internal:3306/franquicias_db miapp
    ```  

## Documentación API

1. La documentación de la API se encuentra disponible a través de Swagger UI:.
   ```bash
   http://localhost:8001/swagger-ui/index.html
    ```
## Contribución
Si deseas contribuir a este proyecto, sigue estos pasos:

Haz un clone del proyecto.

Crea tu rama (git checkout -b mi-rama).

Realiza tus cambios y haz un commit (git commit -am 'Añadir nueva funcionalidad').

Envía tu rama (git push origin mi-rama).

Abre un pull.
