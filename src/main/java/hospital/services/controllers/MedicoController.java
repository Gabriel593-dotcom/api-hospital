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

import hospital.entities.Medico;
import hospital.entities.DTO.MedicoDTO;
import hospital.services.MedicoService;

@RestController
@RequestMapping(value = "/api/medicos")
public class MedicoController {

	@Autowired
	private MedicoService medicoService;

	@GetMapping
	public ResponseEntity<List<MedicoDTO>> findAll() {
		List<MedicoDTO> medicosDTO = medicoService.findAll().stream().map(medico -> new MedicoDTO(medico))
				.collect(Collectors.toList());
		return ResponseEntity.ok().body(medicosDTO);
	}

	@GetMapping(value = "/page")
	public ResponseEntity<Page<MedicoDTO>> findPage(@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "size", defaultValue = "24") Integer size,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction,
			@RequestParam(value = "orderby", defaultValue = "nome") String orderBy) {

		Page<MedicoDTO> pageListDTO = medicoService.findPage(page, size, direction, orderBy)
				.map(medico -> new MedicoDTO(medico));
		return ResponseEntity.ok().body(pageListDTO);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Medico> findById(@PathVariable Integer id) {
		Medico medico = medicoService.findById(id);
		return ResponseEntity.ok().body(medico);
	}
}
