package ec.com.webmarket.restful.domain;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

// En el .domain se encuentran las ENTIDADES (Pais, provincia)

@Getter // definir los getters de la clase (anotación de lombok)
@Setter // definir los setters de la clase (anotación de lombok)
@Entity // marca la clase como una entidad que será mapeada a una tabla en la base de datos. (anotación JPA)

// ENTIDAD JPA (clase Java que representa una tabla en una base de datos relacional)
public class Pais {

	@Id // Indica que este campo es la clave primaria de la entidad.
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Especifica que el valor de este campo será generado automáticamente por la base de datos
	@Column(updatable = false, nullable = false) // Configura la columna en la base de datos.
	// el valor no puede ser modificado una vez establecido
	// el campo no puede estar vacío.
	
	private Long id;

	@Column(nullable = false, unique = true) // los valores de la columna deben ser únicos
	private String nombre;

	@Column(nullable = false) // 
	private LocalDate fechaCreacion;
}
