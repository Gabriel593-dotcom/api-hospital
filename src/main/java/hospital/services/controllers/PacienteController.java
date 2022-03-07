package hospital.services.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hospital.entities.Paciente;
import hospital.entities.DTO.PacienteDTO;
import hospital.services.PacienteService;

@RestController
@RequestMapping("/api/pacientes")
public class PacienteController {

	@Autowired
	private PacienteService pacienteService;

	@GetMapping
	public ResponseEntity<List<PacienteDTO>> findAll() {
		List<PacienteDTO> pacientesDTO = pacienteService.findAll().stream().map(paciente -> new PacienteDTO(paciente))
				.collect(Collectors.toList());
		return ResponseEntity.ok().body(pacientesDTO);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Paciente> findById(@PathVariable Integer id) {
		Paciente paciente = pacienteService.findById(id);
		return ResponseEntity.ok().body(paciente);
	}

	@GetMapping(value = "/page")
	public ResponseEntity<Page<PacienteDTO>> findPage(@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "size", defaultValue = "24") Integer size,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction,
			@RequestParam(value = "orderBy", defaultValue = "nome") String orderBy) {
		Page<PacienteDTO> pageListDTO = pacienteService.findPage(page, size, direction, orderBy)
				.map(paciente -> new PacienteDTO(paciente));
		return ResponseEntity.ok().body(pageListDTO);
	}

}
