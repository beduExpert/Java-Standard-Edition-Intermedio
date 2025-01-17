## Ejemplo 2

### OBJETIVO

- Crear una entidad usando el framework JPA junto con Spring Data para escribir y obtener información de una base de datos.

### REQUISITOS

- Apache Maven
- Tener instalado un manejador de base de datos, de preferencia MySQL o MariaDB
- JDK 12

### DESARROLLO

En esta ocasión crearás una entidad sencilla y su repositorio con ayuda de Spring Data.

Una entidad (_@Entity_) debe ser un **POJO** (Plain Old Java Object) con las siguietnes características:

1. Todos los accesores (**getters**).
2. Mutadores (setters) para los atributos no finales.
3. Debe [sobrecargar los métodos hashCode e equals de manera consistente](https://www.mkyong.com/java/java-how-to-overrides-equals-and-hashcode/).

Para crear el repositorio, basta con crear una **interface** que extienda **CrudRepository**.

### Procedimiento

#### Entidad
1. Crea el paquete **org.bedu.javase2.ejemplo.ejemplo1.model** y en él crea la clase **Equipo**:

   ![Clase](img/figura01.png)

2. Si analizas la descripción de la tabla equipos en la base de datos, tiene sólo un **id** (INT) y un **nombre** (varchar(45)), así que agregamos los valores correspondientes a la clase. (Nota que el **id**, aunque es entero en la base de datos, lo declaramos como **Long** en la entidad. Esto es por el tamaño (en bytes) que usa la base de datos para representar un entero).

   ![Atributos](img/figura02.png)


3. También es necesario agregar el código descrito al inicio del ejercicio. Este tipo de código es tan común que todos los IDEs tienen una opción para generarlo de forma automática, generalmente en el menú contextual.

   ![Generador de código](img/figura03.png)
   
   ![Código generado](img/figura04.png)

4. Ahora debemos anotar nuestra clase para que pueda ser mapeada a la base de datos.

   ![Anotaciones](img/figura05.png)

#### Repositorio

1. Crea el paquete **org.bedu.javase2.ejemplo.ejemplo1.persistence** y en él crea la interface **EquipoRepository**

   ![Interfaz](img/figura06.png)

2. Indica que está extendiendo la interface **CrudRepository** y define la entidad que manejará como **Equipo** y su llave primaria como **Long**.

   ![Repositorio](img/figura07.png)

#### Verificación

1. Inicia la aplicación con maven. Si todo sale bien no debería haber error alguno.



