package hospital.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_exame")
public class Exame implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String preparo;
	
	@JsonIgnore
	@ManyToMany(mappedBy = "exames")
	private List<Consulta> consultas = new ArrayList<>();
	
	public Exame() {
	}

	public Exame(Integer id, String nome, String preparo) {
		super();
		this.id = id;
		this.nome = nome;
		this.preparo = preparo;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPreparo() {
		return preparo;
	}

	public void setPreparo(String preparo) {
		this.preparo = preparo;
	}
	
	public List<Consulta> getConsultas(){
		return this.consultas;
	}

}
