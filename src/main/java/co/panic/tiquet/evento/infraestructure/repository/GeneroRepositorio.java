package co.panic.tiquet.evento.infraestructure.repository;

import co.panic.tiquet.evento.infraestructure.models.GeneroModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface GeneroRepositorio extends JpaRepository<GeneroModel, UUID> {
}
