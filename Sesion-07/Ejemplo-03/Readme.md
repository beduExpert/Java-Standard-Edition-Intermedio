## Ejemplo 3: Usar Spring boot para crear un microservicio

### Objetivos
* Spring boot WebFlux

### Prerequisitos
* Maven
* JDK 11
* Postman

### Procedimiento

1. Crea el proyecto demo con la dependencia de spring reactive web
2. Descomprimir el proyecto
3. Abrir el proyecto con su IDE preferido y crear un paquete llamado "entity" el cual contenga la clase "Empleado" con el siguiente codigo:
```java
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public class Empleado {
        
        private String id;
        private String nombre;
    }
```
4. Crear un paquete llamado "repository" el cual contenga la clase "EmpleadoRepository" con el siguiente codigo:
```java
    @Repository
    public class EmpleadoRepository {
        static Map<String,Empleado> empleadoData;

        static
        {
            empleadoData = new HashMap<>();
            empleadoData.put("1",new Empleado("1","Empleado 1"));
            empleadoData.put("2",new Empleado("2","Empleado 2"));
            empleadoData.put("3",new Empleado("3","Empleado 3"));
            empleadoData.put("4",new Empleado("4","Empleado 4"));
            empleadoData.put("5",new Empleado("5","Empleado 5"));
            empleadoData.put("6",new Empleado("6","Empleado 6"));
            empleadoData.put("7",new Empleado("7","Empleado 7"));
            empleadoData.put("8",new Empleado("8","Empleado 8"));
            empleadoData.put("9",new Empleado("9","Empleado 9"));
            empleadoData.put("10",new Empleado("10","Empleado 10"));
            
        }
        
        public Mono<Empleado> findEmpleadoById(String id)
        {
            return Mono.just(empleadoData.get(id));
        }
        
        public Flux<Empleado> findAllEmpleados()
        {
            return Flux.fromIterable(empleadoData.values());
        }
        
        public Mono<Empleado> updateEmpleado(Empleado employee)
        {
            Empleado existeEmpleado=empleadoData.get(employee.getId());
            if(existeEmpleado!=null)
            {
                existeEmpleado.setNombre(employee.getNombre());
            }
            return Mono.just(existeEmpleado);
        }
    }
```


4. Crear un paquete llamado "controller" el cual contenga la clase "DemoController" con el siguiente codigo:
```java
    @RestController
    @RequestMapping("/empleados")
    public class DemoController {
        
        @Autowired
        private EmpleadoRepository empleadoRepository;

        @GetMapping
        private Flux<Empleado> getAllEmpleados() {
            return empleadoRepository.findAllEmpleados();
        }

    }
```

5. Una vez terminado lo ejecutamos y abrimos postman y colocamos la informacion como se ve en la imagen:

    ![Postman](img/post2.PNG)


6. Damos click en Send y se mostrara en consola la informacion que colocamos en nuestro EmpoleadoRepository
