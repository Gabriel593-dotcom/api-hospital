package hospital.services.exceptions;

public class CpfValidationException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	public CpfValidationException(String message) {
		super(message);
	}

}
