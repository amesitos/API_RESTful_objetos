package ec.com.webmarket.restful.api.v1;

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
import ec.com.webmarket.restful.dto.v1.ProvinciaDTO;
import ec.com.webmarket.restful.security.ApiResponseDTO;
import ec.com.webmarket.restful.service.crud.ProvinciaService;
import jakarta.validation.Valid;

@RestController // Manejarán las solicitudes HTTP y devolverán respuestas en formato JSON o XML.
@RequestMapping(value = { ApiConstants.URI_API_V1_PROVINCIA }) // define la URL base para las rutas de este controlador. 
public class ProvinciaController { 

	@Autowired // Inyectar automáticamente una instancia de ProvinciaService en el controlador.
	private ProvinciaService entityService;

	@GetMapping
	public ResponseEntity<?> getAll() { // // Llama al servicio para obtener todos.
		// Envuelve la respuesta en un objeto ApiResponseDTO que contiene todos los datos
		return new ResponseEntity<>(new ApiResponseDTO<>(true, entityService.findAll(new ProvinciaDTO())),
				HttpStatus.OK);
	}

	@PostMapping // Manejará las solicitudes HTTP POST a la URI base.
	public ResponseEntity<?> create(@RequestBody ProvinciaDTO dto) { // Llama al servicio para crear una nueva provincia
		return new ResponseEntity<>(new ApiResponseDTO<>(true, entityService.create(dto)), HttpStatus.CREATED);
	}

	@PutMapping // Manejará las solicitudes HTTP PUT a la URI base.
	public ResponseEntity<?> update(@RequestBody ProvinciaDTO dto) { // deserializa el cuerpo de la solicitud en un objeto ProvinciaDTO para actualizar.
		return new ResponseEntity<>(new ApiResponseDTO<>(true, entityService.update(dto)), HttpStatus.OK);
	}

	@GetMapping("/{id}/archivo/id") // Manejará las solicitudes HTTP GET a la URI 
	public ResponseEntity<?> getById(@Valid @PathVariable Long id) { // Extrae el valor del ID de la URI y lo pasa al método.
		ProvinciaDTO dto = new ProvinciaDTO(); // Se crea un nuevo ProvinciaDTO y se establece el ID para obtener la provincia con ese ID.
		dto.setId(id);
		return new ResponseEntity<>(new ApiResponseDTO<>(true, entityService.find(dto)), HttpStatus.OK);
	}

	@GetMapping("/{paisId}/archivo/pais") // Manejará las solicitudes HTTP GET a la URI 
	public ResponseEntity<?> getProvinciasByPais(@PathVariable Long paisId) { // extrae el id del país y lo pasa al método.
		return new ResponseEntity<>(new ApiResponseDTO<>(true, entityService.findByPais(paisId)), HttpStatus.OK);
	}
}