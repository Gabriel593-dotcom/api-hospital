package hospital.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Paciente extends Pessoa {
	private static final long serialVersionUID = 1L;

	private String convenio;

	@OneToMany(mappedBy = "paciente")
	private Set<Telefone> telefones = new HashSet<>();
	
	@OneToMany(mappedBy = "paciente")
	private Set<Consulta> consultas = new HashSet<>();

	public Paciente() {
	}

	public Paciente(Integer id, String nome, String cpf, String convenio) {
		super(id, nome, cpf);
		this.convenio = convenio;
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
	
	public Set<Consulta> getConsultas(){
		return this.consultas;
	}

}
