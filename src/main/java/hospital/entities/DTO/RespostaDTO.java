package hospital.entities.DTO;

import java.io.Serializable;

public class RespostaDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int status;
	private String mensagem;

	public RespostaDTO(int status, String mensagem) {
		this.status = status;
		this.mensagem = mensagem;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

}
