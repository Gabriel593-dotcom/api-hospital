package hospital.test;

import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import hospital.entities.Consulta;
import hospital.entities.Exame;
import hospital.entities.Medico;
import hospital.entities.Paciente;
import hospital.entities.Telefone;
import hospital.entities.repositories.ConsultaRepository;
import hospital.entities.repositories.ExameRepository;
import hospital.entities.repositories.MedicoRepository;
import hospital.entities.repositories.PacienteRepository;
import hospital.entities.repositories.TelefoneRepository;

@Configuration
@Profile("dev")
public class TestDb implements CommandLineRunner {

	@Autowired
	private MedicoRepository medicoRepository;

	@Autowired
	private PacienteRepository pacienteRepository;

	@Autowired
	private TelefoneRepository telefoneRepository;

	@Autowired
	private ConsultaRepository consultaRepository;
	
	@Autowired
	private ExameRepository exameRepository;

	@Override
	public void run(String... args) throws Exception {
		Paciente paciente1 = new Paciente(null, "Gabriel", "63355785067", "Amil");
		Paciente paciente2 = new Paciente(null, "Ana Cláudia", "08340178067", "Sompo");

		Medico medico1 = new Medico(null, "Odair", "04629227075", "Ortopedista");
		Medico medico2 = new Medico(null, "Otávio Nogueira", "15221616009", "Oncologista");
		Medico medico3 = new Medico(null, "Robério Alencar", "53546273036", "Pediatra");

		pacienteRepository.saveAll(Arrays.asList(paciente1, paciente2));
		medicoRepository.saveAll(Arrays.asList(medico1, medico2, medico3));

		Telefone tel1 = new Telefone(null, 11, "971276935", null, paciente1);
		Telefone tel2 = new Telefone(null, 11, "910855265", medico1, null);

		telefoneRepository.saveAll(Arrays.asList(tel1, tel2));

		Consulta consulta1 = new Consulta(null, new Date(), "10:20", medico1, paciente2);
		Consulta consulta2 = new Consulta(null, new Date(), "12:20", medico1, paciente1);

		consultaRepository.saveAll(Arrays.asList(consulta1, consulta2));
		
		Exame exame1 = new Exame(null, "Ultrason", "Lorem ipsum dolor sit amet, consectetur adipisicing elit. Nulla explicabo optio, odio excepturi odit adipisci.");
		Exame exame2 = new Exame(null, "Radiografia", "Lorem ipsum dolor sit amet, consectetur adipisicing elit. Nulla explicabo optio, odio excepturi odit adipisci.");
		
		exameRepository.saveAll(Arrays.asList(exame1, exame2));
		
		consulta1.getExames().add(exame2);
		consulta2.getExames().add(exame2);
		consulta2.getExames().add(exame1);

		consultaRepository.saveAll(Arrays.asList(consulta1, consulta2));
	}

}
