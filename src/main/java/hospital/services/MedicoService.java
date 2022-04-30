package hospital.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import hospital.entities.Medico;
import hospital.entities.DTO.MedicoDTO;
import hospital.entities.repositories.MedicoRepository;
import hospital.services.exceptions.CpfValidationException;
import hospital.services.exceptions.ObjectNotFoundException;
import hospital.services.utils.CpfUtils;

@Service
public class MedicoService {

	@Autowired
	private MedicoRepository medicoRepository;

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
	
	public void insert(Medico obj) {
		String cpf = obj.getCpf();
		if(CpfUtils.validaCpf(cpf)) {
			medicoRepository.save(obj);
		} else {
			throw new CpfValidationException("O cpf informado não é válido.");
		}
	}
	
//	public Medico fromDTO(MedicoDTO objDTO) {
//		return new Medico(objDTO);
//	}
}

