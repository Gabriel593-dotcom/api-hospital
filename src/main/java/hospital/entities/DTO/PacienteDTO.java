package hospital.entities.DTO;

import java.util.HashSet;
import java.util.Set;

import hospital.entities.Paciente;
import hospital.entities.Pessoa;
import hospital.entities.Telefone;

public class PacienteDTO extends Pessoa {
	private static final long serialVersionUID = 1L;

	private String convenio;
	private Set<Telefone> telefones = new HashSet<>();

	public PacienteDTO() {
	}

	public PacienteDTO(Paciente paciente) {
		super(paciente.getId(), paciente.getNome(), paciente.getCpf());
		this.convenio = paciente.getConvenio();
		this.telefones = paciente.getTelefones();
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
