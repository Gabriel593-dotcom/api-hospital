package hospital.services.exceptions;

public class SaveException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public SaveException(String mensagem) {
		super(mensagem);
	}
}
