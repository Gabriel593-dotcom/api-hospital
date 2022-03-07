package hospital.services.controllers.exceptions;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class Handler {
	
	private ResponseEntity<StandardError> handlerBuilder(String error, HttpStatus status, Exception e, HttpServletRequest request){
		StandardError standardError = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status.value()).body(standardError); 
	}
	
	@org.springframework.web.bind.annotation.ExceptionHandler(hospital.services.exceptions.ObjectNotFoundException.class)
	public ResponseEntity<StandardError> objectNotFound(HttpServletRequest request,
			hospital.services.exceptions.ObjectNotFoundException objectNotFoundException) {

		String error = "Objeto não encontrado.";
		HttpStatus status = HttpStatus.NOT_FOUND;
		return handlerBuilder(error, status, objectNotFoundException, request);
	}
	
	@org.springframework.web.bind.annotation.ExceptionHandler(hospital.services.exceptions.CpfValidationException.class)
	public ResponseEntity<StandardError> cpfIsNotValid(HttpServletRequest request,
			hospital.services.exceptions.CpfValidationException cpfIsNotValid) {

		String error = "Cpf inválido.";
		HttpStatus status = HttpStatus.NOT_FOUND;
		return handlerBuilder(error, status, cpfIsNotValid, request);
	}
}
