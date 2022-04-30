package hospital.entities.DTO;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import hospital.entities.Paciente;
import hospital.entities.Telefone;

public class PacienteDTO implements Serializable{

	private static final long serialVersionUID = 1L;

	private String nome;
	private String convenio;
	private Set<Telefone> telefones = new HashSet<>();

	public PacienteDTO() {
	}

	public PacienteDTO(Paciente paciente) {
		this.nome = paciente.getNome();
		this.convenio = paciente.getConvenio();
		this.telefones = paciente.getTelefones();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getConvenio() {
		return convenio;
	}

	public void setConvenio(String convenio) {
		this.convenio = convenio;
	}

	public Set<Telefone> getTelefones() {
		return this.telefones;
	}
}
