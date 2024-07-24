package ec.com.webmarket.restful.common;

public class ApiException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	// Es una excepción personalizada que extiende a RuntimeException, 
	// permitiendo que se lance excepciones con mensajes específicos que describan los problemas encontrados. 
	public ApiException(String message) {
		super(message);
	}
}
