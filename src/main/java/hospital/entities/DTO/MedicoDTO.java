package hospital.entities.DTO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import hospital.entities.Medico;
import hospital.entities.Telefone;

public class MedicoDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private String nome;
	private String especialidade;
	private List<Telefone> telefones = new ArrayList<>();

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

	public List<Telefone> getTelefones() {
		return telefones;
	}
}
