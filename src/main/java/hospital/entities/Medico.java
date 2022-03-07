package hospital.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Medico extends Pessoa {
	private static final long serialVersionUID = 1L;

	private String especialidade;

	@OneToMany(mappedBy = "medico")
	private Set<Telefone> telefones = new HashSet<>();

	@OneToMany(mappedBy = "medico")
	private Set<Consulta> consultas = new HashSet<>();
	
	public Medico() {
	}

	public Medico(Integer id, String nome, String cpf, String especialidade) {
		super(id, nome, cpf);
		this.especialidade = especialidade;
	}

	public String getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}

	public Set<Telefone> getTelefones() {
		return this.telefones;
	}
	
	public Set<Consulta> getConsultas(){
		return this.consultas;
	}

	@Override
	public String toString() {
		return "Medico [especialidade=" + especialidade + ", telefones=" + telefones + "]";
	}

}
