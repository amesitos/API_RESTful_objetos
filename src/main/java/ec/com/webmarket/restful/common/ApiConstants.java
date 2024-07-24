package ec.com.webmarket.restful.common;

public final class ApiConstants {

	// centralizar y gestionar las rutas de la API.
	private ApiConstants() {
	}

	// Representa la versión 1.0 de la API base URI.
	public static final String URI_API_V1 = "/api/v1.0/";

	public static final String URI_API_V1_PAIS = URI_API_V1 + "pais"; // Define una constante que representa la URI 
	// completa para los recursos de pais. Se concatena la base URI (URI_API_V1) con la cadena "pais".
	
	public static final String URI_API_V1_PROVINCIA = URI_API_V1 + "provincia"; // Define una constante que representa la URI 
	// completa para los recursos de pais. Se concatena la base URI (URI_API_V1) con la cadena "provincia".
}
