package co.panic.tiquet.evento.infraestructure.repository;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.panic.tiquet.evento.infraestructure.models.DivisaModel;

@Repository
public interface DivisaRepositorio extends JpaRepository<DivisaModel, UUID>{
}
