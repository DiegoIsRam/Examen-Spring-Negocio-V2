# ExamenSpringV2
Para consumir el JSON creado desde Python utilizamos un Bean RestTemplate para poder obtener el JSON y convertirlo a un objeto. Hacemos esto con cada elemento dato por el JSON. 
La parte del código es la siguiente :
```java
public List<JsonPython> GetDataFromPython() {
        JsonPython[] empleadosJSON=restTemplate.getForObject(
                "http://localhost:5000/clientes",
                JsonPython[].class
        );

         List<JsonPython> listaEmpleados = Arrays.asList(empleadosJSON);
        System.out.println(listaEmpleados);
        return  listaEmpleados;
    }
 ```
## Base de Datos H2
 
 Para acceder a la base de datos se debe tomar en cuenta la siguiente configuración
 ```java
spring.datasource.url: jdbc:h2:mem:db_negocio
spring.datasource.driverClassName: org.h2.Driver
spring.datasource.username: sa
spring.datasource.password: password
 
 ```
