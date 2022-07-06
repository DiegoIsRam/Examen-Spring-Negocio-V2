# ExamenSpringV2
Para consumir el JSON creado desde Python utilizamos un Bean RestTemplate para poder obtener el JSON y convertirlo a un objeto. 
La parte del código es la siguiente 
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
