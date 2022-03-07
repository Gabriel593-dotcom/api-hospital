package hospital.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import hospital.entities.Paciente;
import hospital.entities.repositories.PacienteRepository;
import hospital.services.exceptions.ObjectNotFoundException;

@Service
public class PacienteService {

	@Autowired
	private PacienteRepository pacienteRepository;

	public List<Paciente> findAll() {
		return pacienteRepository.findAll();
	}

	public Paciente findById(Integer id) {
		Optional<Paciente> paciente = pacienteRepository.findById(id);
		return paciente.orElseThrow(() -> new ObjectNotFoundException("Paciente não encontrado."));
	}

	public Page<Paciente> findPage(Integer page, Integer size, String direction, String orderBy) {
		PageRequest pageRequest = PageRequest.of(page, size, Direction.valueOf(direction), orderBy);
		return pacienteRepository.findAll(pageRequest);
	}
}
