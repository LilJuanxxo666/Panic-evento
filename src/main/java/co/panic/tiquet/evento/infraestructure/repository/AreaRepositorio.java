package co.panic.tiquet.evento.infraestructure.repository;

import co.panic.tiquet.evento.infraestructure.models.AreaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AreaRepositorio extends JpaRepository<AreaModel, UUID> {
}
