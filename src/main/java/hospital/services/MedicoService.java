package hospital.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hospital.entities.Consulta;
import hospital.entities.Medico;
import hospital.entities.Telefone;
import hospital.entities.DTO.RespostaDTO;
import hospital.entities.repositories.ConsultaRepository;
import hospital.entities.repositories.ExameRepository;
import hospital.entities.repositories.MedicoRepository;
import hospital.entities.repositories.TelefoneRepository;
import hospital.services.exceptions.CpfValidationException;
import hospital.services.exceptions.DataException;
import hospital.services.exceptions.ObjectNotFoundException;
import hospital.services.exceptions.SaveException;
import hospital.services.utils.Utils;

@Service
public class MedicoService {

	@Autowired
	private MedicoRepository medicoRepository;

	@Autowired
	private TelefoneRepository telefoneRepository;

	@Autowired
	private ConsultaRepository consultaRepository;

	@Autowired
	private ExameRepository exameRepository;

	public List<Medico> findAll() {
		medicoRepository.findAll().forEach(System.out::println);
		return medicoRepository.findAll();
	}

	public Medico findById(Integer id) {
		Optional<Medico> medico = medicoRepository.findById(id);
		return medico.orElseThrow(() -> new ObjectNotFoundException("Registro de médico não encontrado."));
	}

	public Page<Medico> findPage(Integer page, Integer size, String direction, String orderBy) {
		PageRequest pageRequest = PageRequest.of(page, size, Direction.valueOf(direction), orderBy);
		return medicoRepository.findAll(pageRequest);
	}

	@Transactional
	public RespostaDTO insert(Medico obj) {
		String cpf = obj.getCpf();

		if (!Utils.validaCpf(cpf)) {
			throw new CpfValidationException("O cpf informado não é válido.");
		}

		for (Consulta c : obj.getConsultas()) {
			if (!Utils.validaData(c.getDataConsulta())) {
				String mensagemErroValidacao = Utils.getMensagemErroValidacaoDaData();
				Utils.setMensagemErroValidacaoDaData("");
				throw new DataException(mensagemErroValidacao);
			}
		}

		try {
			medicoRepository.save(obj);

			// salvando os telefones
			for (Telefone tel : obj.getTelefones()) {
				tel.setMedico(obj);
				telefoneRepository.save(tel);
			}

			// salvando as consultas
			for (Consulta c : obj.getConsultas()) {
				c.setMedico(obj);
				exameRepository.saveAll(c.getExames());
				consultaRepository.save(c);
			}

			return new RespostaDTO(201, "Usuário criado com sucesso.");

		} catch (Exception e) {
			throw new SaveException(
					"Houve algum erro ao tentar salvar usuário. Por favor, tente novamente mais tarde.");
		}
	}

//	public Medico fromDTO(MedicoDTO objDTO) {
//		return new Medico(objDTO);
//	}
}
