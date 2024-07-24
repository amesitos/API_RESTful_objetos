package ec.com.webmarket.restful;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// PAQUETE RAÍZ DEL PROYECTO

@SpringBootApplication
public class ApiResTfulExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiResTfulExampleApplication.class, args);
	}

}

// CONCEPTO APIREST 
// (Representational State Transfer): conjunto de reglas y convenciones para crear y usar servicios web

// API RESTful
// Permiten la comunicación entre un cliente (como una aplicación móvil o web) 
// y un servidor a través de la red, generalmente usando el protocolo HTTP.

// MÉTODOS HTTP PARA OPERACIONES CRUD (Create, Read, Update, Delete) 
// GET: Recupera información de un recurso (objetos que pueden representarse con URLs).
// POST: Crea un nuevo recurso.
// PUT: Actualiza un recurso existente.
// DELETE: Elimina un recurso.

// GET /tareas        - Recupera todas las tareas
// POST /tareas       - Crea una nueva tarea
// GET /tareas/1      - Recupera la tarea con ID 1
// PUT /tareas/1      - Actualiza la tarea con ID 1
// DELETE /tareas/1   - Elimina la tarea con ID 1

//  ENTIDAD: Objeto o una "cosa" con propiedades que se mapea a una tabla en una base de datos.

