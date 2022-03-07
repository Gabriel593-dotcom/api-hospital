package hospital.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import hospital.entities.Medico;
import hospital.entities.repositories.MedicoRepository;
import hospital.services.exceptions.ObjectNotFoundException;

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
}
