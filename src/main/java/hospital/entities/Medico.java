package hospital.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Medico extends Pessoa {
	private static final long serialVersionUID = 1L;

	private String especialidade;

	@OneToMany(mappedBy = "medico")
	private List<Telefone> telefones = new ArrayList<>();

	@OneToMany(mappedBy = "medico")
	private List<Consulta> consultas = new ArrayList<>();
	
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

	public List<Telefone> getTelefones() {
		return this.telefones;
	}
	
	public List<Consulta> getConsultas(){
		return this.consultas;
	}

	@Override
	public String toString() {
		return "Medico [especialidade=" + especialidade + ", telefones=" + telefones + "]";
	}

}
