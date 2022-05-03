package hospital.services.exceptions;

public class DataException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public DataException(String mensagem) {
		super(mensagem);
	}
}
