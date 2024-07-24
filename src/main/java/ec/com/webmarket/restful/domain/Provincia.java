package ec.com.webmarket.restful.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

//En el .domain se encuentran las ENTIDADES (Pais, provincia)

@Getter // definir los getters de la clase (anotación de lombok)
@Setter // definir los setters de la clase (anotación de lombok)
@Entity // definir los getters de la clase (anotación de lombok)

public class Provincia {

	@Id // Indica que este campo es la clave primaria de la entidad.
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Especifica que el valor de este campo será generado automáticamente por la base de datos
	@Column(updatable = false, nullable = false)
	private Long id;

	@Column(nullable = false, unique = true)
	private String nombre;

	@ManyToOne // Relación de muchos a uno entre Provincia y Pais
	@JoinColumn(name = "pais_id") // especifica la columna de unión en la tabla de la base de datos
	private Pais pais;
	// especifica el nombre de la columna en la tabla de Provincia que se utiliza para la clave 
	// foránea que apunta a la clave primaria de la entidad Pais.
}
