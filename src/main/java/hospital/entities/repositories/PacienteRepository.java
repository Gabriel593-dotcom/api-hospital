package hospital.entities.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import hospital.entities.Paciente;

public interface PacienteRepository extends JpaRepository<Paciente, Integer>{

}
