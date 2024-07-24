package ec.com.webmarket.restful.api.v1;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.com.webmarket.restful.common.ApiConstants;
import ec.com.webmarket.restful.dto.v1.PaisDTO;
import ec.com.webmarket.restful.security.ApiResponseDTO;
import ec.com.webmarket.restful.service.crud.PaisService;
import jakarta.validation.Valid;

@RestController // Manejarán las solicitudes HTTP y devolverán respuestas en formato JSON o XML.
@RequestMapping(value = { ApiConstants.URI_API_V1_PAIS }) //  define la URL base para las rutas de este controlador. 
public class PaisController {

	@Autowired // Inyectar automáticamente una instancia de PaisService en el controlador. 
	private PaisService entityService;

	@GetMapping // Manejará las solicitudes HTTP GET a la URI base del controlador.
	public ResponseEntity<?> getAll() { // Llama al servicio para obtener todos los países.
		//  Envuelve la respuesta en un objeto ApiResponseDTO que contiene todos los datos
		return new ResponseEntity<>(new ApiResponseDTO<>(true, entityService.findAll(new PaisDTO())), HttpStatus.OK);
	}

	@PostMapping // Manejará las solicitudes HTTP POST a la URI base.
	public ResponseEntity<?> create(@RequestBody PaisDTO dto) { // Llama al servicio para crear un nuevo país
		return new ResponseEntity<>(new ApiResponseDTO<>(true, entityService.create(dto)), HttpStatus.CREATED);
	}

	@PutMapping // Manejará las solicitudes HTTP PUT a la URI base.
	public ResponseEntity<?> update(@RequestBody PaisDTO dto) { // deserializa el cuerpo de la solicitud en un objeto PaisDTO para actualizar.
		return new ResponseEntity<>(new ApiResponseDTO<>(true, entityService.update(dto)), HttpStatus.OK);
	}

	@GetMapping("/{id}/archivo/id") // Manejará las solicitudes HTTP GET a la URI 
	public ResponseEntity<?> getById(@Valid @PathVariable Long id) { // Extrae el valor del ID de la URI y lo pasa al método.
		PaisDTO dto = new PaisDTO(); // Se crea un nuevo PaisDTO y se establece el ID para obtener el país con ese ID.
		dto.setId(id);
		return new ResponseEntity<>(new ApiResponseDTO<>(true, entityService.find(dto)), HttpStatus.OK);
	}

	@GetMapping("/{fechaCreacion}/archivo/fecha-creacion") // Manejará las solicitudes HTTP GET a la URI 
	public ResponseEntity<?> getPaisesByFechaCreacion(@PathVariable String fechaCreacion) { // extrae la fecha de la URI y la pasa al método.
		LocalDate fecha = LocalDate.parse(fechaCreacion); // Convierte la fecha en formato String a un objeto LocalDate.
		entityService.findByFechaCreacion(fecha);
		return new ResponseEntity<>(new ApiResponseDTO<>(true, entityService.findByFechaCreacion(fecha)),
				HttpStatus.OK);
	}

}