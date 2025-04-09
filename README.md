# 🧪 Proyecto Zara - Prueba Técnica

Este proyecto es una API REST desarrollada con Spring Boot, que expone un endpoint para consultar el precio de un producto en una fecha y hora concreta, según el identificador de marca y producto.

## ✅ Requisitos

- Java 17 o superior
- Maven 3.2.1 o superior

## 🚀 Instrucciones para ejecutar el proyecto

1. Clona o descarga el proyecto en tu equipo.
2. Abre una terminal en la raíz del proyecto (carpeta Zara).
3. Ejecuta los siguientes comandos:

   ```bash
   mvn clean install
   
   mvn spring-boot\:run

El primer comando compila el proyecto y ejecuta los 5 tests unitarios exitosamente.

El segundo comando inicia la aplicación Spring Boot.

## 🔍 Acceso a Swagger (documentación de la API)
Una vez ejecutada la aplicación, accede a la documentación interactiva en Swagger:

### 👉 http://localhost:8080/swagger-ui/index.html#/

## 🧾 Formato requerido de fecha

El parámetro applyDate debe enviarse con el siguiente formato:

yyyy-MM-dd HH:mm:ss

### Ejemplo válido:

2020-06-14 10:00:00