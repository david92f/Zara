Para probar el proyecto:

- Descargar el proyecto
- Tener instalado Maven 3.2.1 o superior y Java 17 o superior
- Ejecutar el terminal en la raiz de proyecto Zara
- Ejecutar siguientes comandos:
  - mvn clean install
  - mvn spring-boot:run
- Con el primer comando se puede ver que pasa los 5 test creados y con el segundo ejecutas la aplicación Spring Boot y prueba el endpoint REST con swagger en el enlace:
  - http://localhost:8080/swagger-ui/index.html#/
