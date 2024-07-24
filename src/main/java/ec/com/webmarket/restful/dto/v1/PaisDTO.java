package ec.com.webmarket.restful.dto.v1;

import java.time.LocalDate;

import lombok.Data;

@Data

// proporcionada por Lombok y combina varias anotaciones en una sola: @Getter,
// @Setter, @ToString, @EqualsAndHashCode, y @RequiredArgsConstructor
public class PaisDTO {

	private Long id;
	private String nombre;
	private LocalDate fechaCreacion;

}
