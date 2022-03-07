package hospital.entities.DTO;

import java.util.HashSet;
import java.util.Set;

import hospital.entities.Medico;
import hospital.entities.Pessoa;
import hospital.entities.Telefone;

public class MedicoDTO extends Pessoa {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String especialidade;
	private Set<Telefone> telefones = new HashSet<>();

	public MedicoDTO() {
	}

	public MedicoDTO(Medico medico) {
		super(medico.getId(), medico.getNome(), medico.getCpf());
		this.id = medico.getId();
		this.especialidade = medico.getEspecialidade();
		this.telefones = medico.getTelefones();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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
