package hospital.entities.DTO;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import hospital.entities.Medico;
import hospital.entities.Telefone;

public class MedicoDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private String nome;
	private String especialidade;
	private Set<Telefone> telefones = new HashSet<>();

	public MedicoDTO() {
	}

	public MedicoDTO(Medico medico) {
		this.nome = medico.getNome();
		this.especialidade = medico.getEspecialidade();
		this.telefones = medico.getTelefones();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}

	public Set<Telefone> getTelefones() {
		return telefones;
	}
}
